package uk.joshiejack.piscary.world.block.entity;

import joptsimple.internal.Strings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.penguinlib.data.TimeUnitRegistry;
import uk.joshiejack.penguinlib.network.PenguinNetwork;
import uk.joshiejack.penguinlib.util.helper.MathHelper;
import uk.joshiejack.penguinlib.world.block.entity.PenguinBlockEntity;
import uk.joshiejack.piscary.client.renderer.HatcheryFishRender;
import uk.joshiejack.piscary.network.SyncHatcheryPacket;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("ConstantConditions")
public class HatcheryBlockEntity extends PenguinBlockEntity {
    private EntityType<?> entityType = null;
    private int count = 0;
    private int ticksPassed = 0;
    private int breakChance = 125;

    public HatcheryBlockEntity(BlockPos pos, BlockState state) {
        super(PiscaryBlockEntities.HATCHERY.get(), pos, state);
    }

    public boolean isEmpty() {
        return entityType == null || count <= 0;
    }

    public void setEntityTypeAndCount(EntityType<?> type, int count) {
        this.entityType = type;
        this.count = count;
        this.markUpdated();
        if (!level.isClientSide)
            PenguinNetwork.sendToNearby(this, new SyncHatcheryPacket(worldPosition, entityType, count));
        else
            getRenderer().reloadFish(entityType, count, level.random);
    }

    public static void serverTick(Level level, BlockPos pos, HatcheryBlockEntity entity) {
        if (entity.getEntityType() == null) return;
        if (level.isClientSide)
            entity.getRenderer().updateFish();
        if (level.getGameTime() % 100 == 0 && entity.count < 10) {
            int ticksRequired = (int) (PiscaryRegistries.getCycles(entity.getEntityType()) * TimeUnitRegistry.get(BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(entity.getType()).toString()));
            if (ticksRequired >= 1) {
                entity.ticksPassed += 100;
                if (entity.ticksPassed >= ticksRequired) {
                    entity.ticksPassed = 0; //Reset
                    entity.count++;
                    entity.setEntityTypeAndCount(entity.entityType, entity.count);
                }
            }
        }
    }

    public LivingEntity extractFish(boolean adjustCount) {
        Entity entity = entityType.spawn((ServerLevel) level, ItemStack.EMPTY, null, worldPosition, MobSpawnType.BUCKET, true, false);
        if (entity != null) {
            ((Bucketable) entity).setFromBucket(true);
        }

        //Helper boys
        if (adjustCount) {
            count--;
            setEntityTypeAndCount(entityType, count);
        }

        return (LivingEntity) entity;
    }

    public void spawnFish(int count) {
        if (entityType != null) {
            for (int i = 0; i < count; i++) {
                extractFish(false);
            }
        }
    }

    public void removeFish() {
        count--;
        if (level.random.nextInt(100) > breakChance) {
            BlockState state = level.getBlockState(worldPosition);
            level.setBlock(worldPosition, Blocks.WATER.defaultBlockState(), 2);
            level.levelEvent(null, 2001, worldPosition, Block.getId(state));
            spawnFish(count);
            return;
        } else breakChance -= 25;

        breakChance = MathHelper.constrainToRangeInt(breakChance, 0, 100);
        markUpdated(); //Resync the count data
    }

    private HatcheryFishRender renderer;

    public HatcheryFishRender getRenderer() {
        if (renderer == null)
            renderer = new HatcheryFishRender(this);
        return renderer;
    }

    @Nullable
    public EntityType<?> getEntityType() {
        return entityType;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void onDataPacket(@NotNull Connection net, @NotNull ClientboundBlockEntityDataPacket packet) {
        super.onDataPacket(net, packet);
        if (level.isClientSide)
            getRenderer().reloadFish(entityType, count, level.random);
    }

    @Override
    public void load( @Nonnull CompoundTag nbt) {
        super.load(nbt);
        String internal = nbt.getString("Entity");
        entityType = Strings.isNullOrEmpty(internal) ? null : BuiltInRegistries.ENTITY_TYPE.get(new ResourceLocation(internal));
        count = nbt.getByte("Count");
        ticksPassed = nbt.getInt("TicksPassed");
        breakChance = nbt.getByte("TimesPulled");
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        nbt.putString("Entity", entityType == null ? "" : BuiltInRegistries.ENTITY_TYPE.getKey(entityType).toString());
        nbt.putByte("Count", (byte) count);
        nbt.putInt("TicksPassed", ticksPassed);
        nbt.putByte("TimesPulled", (byte) breakChance);
        super.saveAdditional(nbt);
    }
}
