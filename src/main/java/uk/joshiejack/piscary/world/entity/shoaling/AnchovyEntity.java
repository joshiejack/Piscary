package uk.joshiejack.piscary.world.entity.shoaling;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class AnchovyEntity extends ShoalingFishEntity {
    public AnchovyEntity(EntityType<? extends ShoalingFishEntity> entity, Level world) {
        super(entity, world);
    }

    @Override
    public int getMaxSchoolSize() {
        return 24;
    }
}
