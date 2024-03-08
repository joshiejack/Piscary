package uk.joshiejack.piscary.world.entity;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.tuple.Pair;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.entity.shoaling.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Piscary.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PiscaryEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Piscary.MODID);
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registries.PAINTING_VARIANT, Piscary.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Piscary.MODID);
    private static List<Pair<String, Supplier<SpawnEggItem>>> SPAWN_EGGS = new ArrayList<>(); //Temporary Pairings, to ensure all buckets and eggs appear in order
    public static final DeferredHolder<EntityType<?>, EntityType<AnchovyEntity>> ANCHOVY = register("anchovy", AnchovyEntity::new, 0.5F, 0.3F, 0xDBE4DF, 0x507853);
    public static final DeferredHolder<EntityType<?>, EntityType<AngelfishEntity>> ANGELFISH = register("angelfish", AngelfishEntity::new, 0.5F, 0.5F, 0xF2F2F2, 0xECE43E);
    public static final DeferredHolder<EntityType<?>, EntityType<AnglerfishEntity>> ANGLERFISH = register("anglerfish", AnglerfishEntity::new, 0.7F, 0.6F, 0x5A4229, 0x271C0F);
    public static final DeferredHolder<EntityType<?>, EntityType<BassEntity>> BASS = register("bass", BassEntity::new, 0.7F, 0.5F, 0xA39F6F, 0x3E3E1C);
    public static final DeferredHolder<EntityType<?>, EntityType<BlueTangEntity>> BLUE_TANG = register("blue_tang", BlueTangEntity::new, 0.5F, 0.3F, 0x5070D4, 0xFFFF10);
    public static final DeferredHolder<EntityType<?>, EntityType<BowfinEntity>> BOWFIN = register("bowfin", BowfinEntity::new, 0.9F, 0.3F, 0x8B7B40, 0x343523);
    public static final DeferredHolder<EntityType<?>, EntityType<ButterflyfishEntity>> BUTTERFLYFISH = register("butterflyfish", ButterflyfishEntity::new, 0.5F, 0.3F, 0xF2A905, 0x282828);
    public static final DeferredHolder<EntityType<?>, EntityType<CarpEntity>> CARP = register("carp", CarpEntity::new, 0.7F, 0.5F, 0xB99366, 0x5A2C1D);
    public static final DeferredHolder<EntityType<?>, EntityType<SolitaryFishEntity>> CATFISH = register("catfish", SolitaryFishEntity::new, 0.9F, 0.3F, 0xCCCC99, 0x524941);
    public static final DeferredHolder<EntityType<?>, EntityType<ChubEntity>> CHUB = register("chub", ChubEntity::new, 0.7F, 0.4F, 0xE9BE89, 0x4E5F93);
    public static final DeferredHolder<EntityType<?>, EntityType<DamselfishEntity>> DAMSELFISH = register("damselfish", DamselfishEntity::new, 0.5F, 0.5F, 0xA8DAF4, 0x0F1338);
    public static final DeferredHolder<EntityType<?>, EntityType<ElectricRayEntity>> ELECTRIC_RAY = register("electric_ray", ElectricRayEntity::new, 0.7F, 0.4F, 0xDBAD70, 0x8A6D56);
    public static final DeferredHolder<EntityType<?>, EntityType<SolitaryFishEntity>> GOLDFISH = register("goldfish", SolitaryFishEntity::new, 0.5F, 0.3F, 0xFDB609, 0xE37802);
    public static final DeferredHolder<EntityType<?>, EntityType<SolitaryFishEntity>> KOI = register("koi", SolitaryFishEntity::new, 0.7F, 0.5F, 0xE2DDDA, 0xEB4132);
    public static final DeferredHolder<EntityType<?>, EntityType<SolitaryFishEntity>> LAMPREY = register("lamprey", SolitaryFishEntity::new, 1F, 0.2F, 0x84736F, 0x262120);
    public static final DeferredHolder<EntityType<?>, EntityType<SolitaryFishEntity>> LUNGFISH = register("lungfish", SolitaryFishEntity::new, 0.7F, 0.4F, 0x8A8168, 0x564739);
    public static final DeferredHolder<EntityType<?>, EntityType<MantaRayEntity>> MANTA_RAY = register("manta_ray", MantaRayEntity::new, 3.5F, 0.5F, 0x314563, 0xD2DAE7);
    public static final DeferredHolder<EntityType<?>, EntityType<MinnowEntity>> MINNOW = register("minnow", MinnowEntity::new, 0.5F, 0.3F, 0xA4A750, 0xD8BC5D);
    public static final DeferredHolder<EntityType<?>, EntityType<NeonTetraEntity>> NEON_TETRA = register("neon_tetra", NeonTetraEntity::new, 0.5F, 0.3F, 0x14CED5, 0xA41904);
    public static final DeferredHolder<EntityType<?>, EntityType<NorthernPikeEntity>> NORTHERN_PIKE = register("northern_pike", NorthernPikeEntity::new, 0.7F, 0.4F, 0xA4A07D, 0x5A513A);
    public static final DeferredHolder<EntityType<?>, EntityType<PerchEntity>> PERCH = register("perch", PerchEntity::new, 0.7F, 0.5F, 0x342822, 0xCEB14A);
    public static final DeferredHolder<EntityType<?>, EntityType<PickerelEntity>> PICKEREL = register("pickerel", PickerelEntity::new, 0.7F, 0.5F, 0x7B8240, 0xB96F4A);
    public static final DeferredHolder<EntityType<?>, EntityType<PiranhaEntity>> PIRANHA = register("piranha", PiranhaEntity::new, 0.7F, 0.4F, 0x20323E, 0x9E1B00);
    public static final DeferredHolder<EntityType<?>, EntityType<PupfishEntity>> PUPFISH = register("pupfish", PupfishEntity::new, 0.5F, 0.3F, 0x87A3CF, 0x7454A0);
    public static final DeferredHolder<EntityType<?>, EntityType<SardineEntity>> SARDINE = register("sardine", SardineEntity::new, 0.5F, 0.3F, 0xE0DDE1, 0x2C345A);
    public static final DeferredHolder<EntityType<?>, EntityType<SolitaryFishEntity>> SIAMESE_FIGHTING_FISH = register("siamese_fighting_fish", SolitaryFishEntity::new, 0.5F, 0.3F, 0x593E83, 0x266FCB);
    public static final DeferredHolder<EntityType<?>, EntityType<FloordwellingFishEntity>> WHITEMARGIN_STARGAZER = register("whitemargin_stargazer", FloordwellingFishEntity::new, 0.7F, 0.5F, 0x72513D, 0x4382A9);
    public static final DeferredHolder<EntityType<?>, EntityType<StingRayEntity>> STINGRAY = register("stingray", StingRayEntity::new, 0.7F, 0.4F, 0x779974, 0x1B281F);
    public static final DeferredHolder<EntityType<?>, EntityType<SolitaryFishEntity>> SILVER_STRIPE_BLAASOP = register("silver_stripe_blaasop", SolitaryFishEntity::new, 0.7F, 0.4F, 0x727E6A, 0x2F3D40);
    public static final DeferredHolder<EntityType<?>, EntityType<TroutEntity>> TROUT = register("trout", TroutEntity::new, 0.7F, 0.4F, 0xC5929D, 0x6D5635);
    public static final DeferredHolder<EntityType<?>, EntityType<TunaEntity>> TUNA = register("tuna", TunaEntity::new, 0.7F, 0.5F, 0x93A097, 0x4A576F);
    public static final DeferredHolder<EntityType<?>, EntityType<WalleyeEntity>> WALLEYE = register("walleye", WalleyeEntity::new, 0.7F, 0.4F, 0xE2BD65, 0x363932);
    public static final Holder<PaintingVariant> ALBATROSS = PAINTINGS.register("albatross", () -> new PaintingVariant(16, 16));
    public static final Holder<PaintingVariant> BOATS = PAINTINGS.register("boats", () -> new PaintingVariant(16, 16));
    public static final Holder<PaintingVariant> LIGHTHOUSE = PAINTINGS.register("lighthouse", () -> new PaintingVariant(32, 16));
    public static final Holder<PaintingVariant> SUNSET = PAINTINGS.register("sunset", () -> new PaintingVariant(16, 16));
    public static final Holder<PaintingVariant> WINDOW = PAINTINGS.register("window", () -> new PaintingVariant(32, 16));

    @SuppressWarnings("unchecked, deprecation")
    private static <T extends AbstractFish> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.EntityFactory<T> factory, float width, float height, int colorPrimary, int colorSecondary) {
        EntityType.Builder<T> builder = EntityType.Builder.of(factory,
                        name.equals("piranha") ? MobCategory.MONSTER : name.equals("manta_ray") ? MobCategory.WATER_CREATURE : MobCategory.WATER_AMBIENT)
                .sized(width, height).clientTrackingRange(4);
        DeferredHolder<EntityType<?>, EntityType<T>> holder = ENTITIES.register(name, () -> builder.build(new ResourceLocation(Piscary.MODID, name).toString()));
        ITEMS.register(name + "_bucket", () -> new MobBucketItem(holder, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
        SPAWN_EGGS.add(Pair.of(name + "_spawn_egg", () -> new SpawnEggItem(holder.get(), colorPrimary, colorSecondary, new Item.Properties())));
        if (name.equals("walleye")) {
            SPAWN_EGGS.forEach(pair -> ITEMS.register(pair.getLeft(), pair.getRight()));
            SPAWN_EGGS = null; //Clear out the registry, no longer needed!
        }

        return holder;
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void addFishEntity0Attributes(EntityAttributeCreationEvent event) {
        Map<String, Supplier<AttributeSupplier.Builder>> map = new HashMap<>();
        put(map, () -> Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10D).add(Attributes.MOVEMENT_SPEED, 0.5F), "stingray");
        put(map, () -> Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10D).add(Attributes.MOVEMENT_SPEED, 0.5F), "electric_ray");
        put(map, () -> Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20D).add(Attributes.MOVEMENT_SPEED, 0.4F), "manta_ray");
        put(map, () -> Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8D).add(Attributes.MOVEMENT_SPEED, 1.2F).add(Attributes.ATTACK_DAMAGE, 4.0D), "piranha");
        put(map, () -> Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D), "bass", "carp", "koi", "perch", "stargazer");
        put(map, () -> Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D), "anglerfish", "tuna", "bowfin", "lungfish", "catfish");

        ENTITIES.getEntries().forEach(fish -> {
            if (map.containsKey(fish.getId().getPath()))
                event.put((EntityType<? extends LivingEntity>) fish.get(), map.get(fish.getId().getPath()).get().build());
            else
                event.put((EntityType<? extends LivingEntity>) fish.get(), AbstractFish.createAttributes().build());
        });
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void spawnPlacementRegistry(SpawnPlacementRegisterEvent event) {
        ENTITIES.getEntries().forEach(fish -> {
            event.register((EntityType<AbstractFish>) fish.value(),
                    SpawnPlacements.Type.IN_WATER, 
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    AbstractFish::checkSurfaceWaterAnimalSpawnRules,
                    SpawnPlacementRegisterEvent.Operation.AND);
        });
    }

    private static void put(Map<String, Supplier<AttributeSupplier.Builder>> map, Supplier<AttributeSupplier.Builder> supplier, String... obj) {
        for (String str : obj)
            map.put(str, supplier);
    }
}
