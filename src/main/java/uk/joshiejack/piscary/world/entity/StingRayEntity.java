package uk.joshiejack.piscary.world.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StingRayEntity extends FloordwellingFishEntity {
    public StingRayEntity(EntityType<? extends StingRayEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public void playerTouch(@NotNull Player player) {
        if (random.nextFloat() < 0.1F && !player.hasEffect(MobEffects.POISON))
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 300));
    }
}
