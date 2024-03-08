package uk.joshiejack.piscary.world.entity.shoaling;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class TroutEntity extends ShoalingFishEntity {
    public TroutEntity(EntityType<? extends ShoalingFishEntity> entity, Level world) {
        super(entity, world);
    }
}
