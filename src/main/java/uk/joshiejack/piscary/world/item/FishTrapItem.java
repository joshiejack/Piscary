package uk.joshiejack.piscary.world.item;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class FishTrapItem extends BlockItem {
    public FishTrapItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext ctx, @Nonnull BlockState state) {
        return ctx.getLevel().getBlockState(ctx.getClickedPos()).getFluidState().is(FluidTags.WATER)
                && super.placeBlock(ctx, state);
    }
}
