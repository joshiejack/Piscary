package uk.joshiejack.piscary.tile;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import uk.joshiejack.penguinlib.data.database.registries.TimeUnitRegistry;
import uk.joshiejack.penguinlib.tile.inventory.AbstractInventoryTileEntity;
import uk.joshiejack.penguinlib.util.helpers.minecraft.TerrainHelper;
import uk.joshiejack.piscary.block.FishTrapBlock;
import uk.joshiejack.piscary.crafting.BaitRegistry;

import javax.annotation.Nonnull;

@SuppressWarnings("ConstantConditions")
public class FishTrapTileEntity extends AbstractInventoryTileEntity {
    private long timeCaught = 0;
    
    public FishTrapTileEntity() {
        super(PiscaryTileEntities.FISH_TRAP.get(), 1);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public void setItem(int slot, @Nonnull ItemStack stack) {
        if (BaitRegistry.isBait(stack)) {
            level.setBlock(worldPosition, level.getBlockState(worldPosition).setValue(FishTrapBlock.TRAP_STATE, FishTrapBlock.FishTrapState.BAITED), 3);
            level.getBlockTicks().scheduleTick(worldPosition, getBlockState().getBlock(), getTimeUnit());
        } else
            level.setBlock(worldPosition, level.getBlockState(worldPosition).setValue(FishTrapBlock.TRAP_STATE, FishTrapBlock.FishTrapState.EMPTY), 3);
        super.setItem(slot, stack);
    }

    public int getTimeUnit() {
        return (int) TimeUnitRegistry.get("half_hour") +
                (level.random.nextInt((int) TimeUnitRegistry.get("hour"))) * (1 + level.random.nextInt(3));
    }

    @Override
    public boolean canPlaceItem(int slot, @Nonnull ItemStack stack) {
        return items.get(slot).isEmpty() && BaitRegistry.isBait(stack);
    }

    @Nonnull
    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (BaitRegistry.isBait(items.get(0)) || items.get(0).isEmpty())
            return ItemStack.EMPTY;
        else {
            if (shouldTrapBreak())
                level.destroyBlock(worldPosition, false);
            return super.removeItem(slot, amount);
        }
    }

    @SuppressWarnings("ConstantConditions")
    private boolean shouldTrapBreak() {
        long difference = level.getDayTime() - timeCaught; //Always break after two hours, 50% between 30 minutes and 2 hours, 20% otherwise,
        return difference >= 2000 || (difference < 500 && level.random.nextInt(5) <= 1) || (difference >= 500 && level.random.nextInt(2) == 0);
    }

    public boolean isBaited() {
        return BaitRegistry.isBait(items.get(0));
    }

    public void setTimeCaught(long timeCaught) {
        this.timeCaught = timeCaught;
        this.setChanged();
    }

    public boolean isSurroundedByWater() {
        return TerrainHelper.isWater(level, worldPosition.east(), worldPosition.west(), worldPosition.south(), worldPosition.north(), worldPosition.above());
    }

    @Override
    public void load(@Nonnull BlockState state, @Nonnull CompoundNBT nbt) {
        super.load(state, nbt);
        timeCaught = nbt.getLong("TimeCaught");
    }

    @Override
    @Nonnull
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putLong("TimeCaught", timeCaught);
        return super.save(nbt);
    }
}
