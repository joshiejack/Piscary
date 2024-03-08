package uk.joshiejack.piscary.world.block;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.joshiejack.penguinlib.world.block.entity.inventory.InventoryBlockEntity;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.block.entity.PiscaryBlockEntities;

@Mod.EventBusSubscriber(modid = Piscary.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("unused")
public class PiscaryBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Piscary.MODID);
    public static final DeferredBlock<Block> FISH_TRAP = BLOCKS.register("fish_trap", FishTrapBlock::new);
    public static final DeferredBlock<Block> HATCHERY = BLOCKS.register("hatchery", HatcheryBlock::new);
    public static final DeferredBlock<Block> RECYCLER = BLOCKS.register("recycler", RecyclerBlock::new);

    @SubscribeEvent
    public static void registerHandlers(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PiscaryBlockEntities.FISH_TRAP.get(), InventoryBlockEntity.getItemProvider());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PiscaryBlockEntities.RECYCLER.get(), InventoryBlockEntity.getItemProvider());
    }
}
