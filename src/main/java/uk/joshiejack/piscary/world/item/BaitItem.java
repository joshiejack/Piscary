package uk.joshiejack.piscary.world.item;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nonnull;

public class BaitItem extends Item {
    public BaitItem() {
        super(new Item.Properties());
    }

    @Override
    @Nonnull
    public InteractionResultHolder<ItemStack> use(@Nonnull Level worldIn, Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int slot = getSlotStackIsIn(player.getInventory().items, stack);
        if (slot != -1) {
            ItemStack rod = getClosest(player.getInventory().items, slot);
            if (rod != null && addBait(rod, stack)) {
                stack.setCount(0); //Clear it out
                return InteractionResultHolder.success(stack);
            }
        }

        return InteractionResultHolder.pass(stack);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean addBait(ItemStack rod, ItemStack bait) {
        CompoundTag tag = rod.hasTag() ? rod.getTag() : new CompoundTag();
        ItemStack stack = ItemStack.of(tag);
        if (!stack.isEmpty() && !ItemStack.isSameItem(stack, bait)) return false;
        int existing = tag.getInt("Bait");
        if (existing + bait.getCount() > 999) return false;
        else {
            ItemStack baitSaveStack = bait.copy();
            baitSaveStack.setCount(1);
            tag.put("Stack", baitSaveStack.save(new CompoundTag()));
            tag.putInt("Bait", existing + bait.getCount());
            rod.setTag(tag); //Reset the tag
            return true;
        }
    }

    private int getSlotStackIsIn(NonNullList<ItemStack> mainInventory, ItemStack stack) {
        for (int i = 0; i < 9; i++) {
            if (mainInventory.get(i) == stack) return i;
        }

        return -1;
    }

    private ItemStack getClosest(NonNullList<ItemStack> mainInventory, int slot) {
        //Check to the right first
        int check = slot == 8 ? 0 : slot + 1;
        ItemStack stack = mainInventory.get(check);
        if (stack.is(Tags.Items.TOOLS_FISHING_RODS)) return stack;
        else {
            check = slot == 0 ? 8 : slot + -1;
            stack = mainInventory.get(check);
            if (stack.is(Tags.Items.TOOLS_FISHING_RODS)) return stack;
            else return null;
        }
    }
}
