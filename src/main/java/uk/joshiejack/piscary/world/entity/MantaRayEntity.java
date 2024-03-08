package uk.joshiejack.piscary.world.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MantaRayEntity extends SolitaryFishEntity {
    public MantaRayEntity(EntityType<? extends MantaRayEntity> type, Level world) {
        super(type, world);
    }

    @Override
    protected boolean canRide(@NotNull Entity entity) {
        return true;
    }
}
