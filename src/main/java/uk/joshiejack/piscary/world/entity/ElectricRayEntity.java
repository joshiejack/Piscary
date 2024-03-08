package uk.joshiejack.piscary.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ElectricRayEntity extends FloordwellingFishEntity {
    public ElectricRayEntity(EntityType<? extends ElectricRayEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public void playerTouch(@NotNull Player player) {
        if (random.nextFloat() < 0.05F)
            player.hurt(damageSources().lightningBolt(), 3F);
    }
}
