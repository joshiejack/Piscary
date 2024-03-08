package uk.joshiejack.piscary.world.entity.shoaling;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.piscary.Piscary;

import javax.annotation.Nonnull;

public class ShoalingFishEntity extends AbstractSchoolingFish {
    public ShoalingFishEntity(EntityType<? extends ShoalingFishEntity> entity, Level world) {
        super(entity, world);
    }

    @Nonnull
    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(Piscary.MODID, BuiltInRegistries.ENTITY_TYPE.getKey(getType()).getPath() + "_bucket")));
    }

    @Nonnull
    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public @NotNull EntityDimensions getDimensions(@NotNull Pose pose) {
        return EntityDimensions.scalable(0.7F, 0.4F);
    }
}
