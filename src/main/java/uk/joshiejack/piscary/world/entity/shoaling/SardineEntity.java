package uk.joshiejack.piscary.world.entity.shoaling;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SardineEntity extends ShoalingFishEntity {
    public SardineEntity(EntityType<? extends ShoalingFishEntity> entity, Level world) {
        super(entity, world);
    }

    @Override
    public int getMaxSchoolSize() {
        return 16;
    }
}
