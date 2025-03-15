package org.polaris2023.wild_wind.common.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import org.polaris2023.wild_wind.common.init.items.foods.ModBaseFoods;
import org.polaris2023.wild_wind.datagen.ModBlockFamilies;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static glitchcore.util.BlockHelper.*;

public class ModVanillaCompat{
    public static void register(final IEventBus bus) {
        bus.addListener(ModVanillaCompat::registerFuels);
    }

    private static void registerFuels(final FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().is(ModBlocks.PALM_CROWN.get().asItem())) {
            event.setBurnTime(300);
        }
    }

    public static final Map<ItemLike, Float> compostables = new HashMap<>();

    public static void setup(BiConsumer<ResourceLocation, Item> func) {
        ModBlockFamilies.AZALEA_PLANKS.generateFlammable();
        ModBlockFamilies.BAOBAB_PLANKS.generateFlammable();
        ModBlockFamilies.PALM_PLANKS.generateFlammable();
        registerFlammable(ModBlocks.BAOBAB_LEAVES.get(), 30, 60);
        registerFlammable(ModBlocks.PALM_LEAVES.get(), 30, 60);
        registerFlammable(ModBlocks.PALM_CROWN.get(), 5, 5);
        registerFlammable(ModBlocks.AZALEA_WOOD.get(), 5, 5);
        registerFlammable(ModBlocks.BAOBAB_WOOD.get(), 5, 5);
        registerFlammable(ModBlocks.PALM_WOOD.get(), 5, 5);
        registerFlammable(ModBlocks.AZALEA_LOG.get(), 5, 5);
        registerFlammable(ModBlocks.BAOBAB_LOG.get(), 5, 5);
        registerFlammable(ModBlocks.PALM_LOG.get(), 5, 5);
        registerFlammable(ModBlocks.STRIPPED_AZALEA_WOOD.get(), 5, 5);
        registerFlammable(ModBlocks.STRIPPED_BAOBAB_WOOD.get(), 5, 5);
        registerFlammable(ModBlocks.STRIPPED_PALM_WOOD.get(), 5, 5);
        registerFlammable(ModBlocks.STRIPPED_AZALEA_LOG.get(), 5, 5);
        registerFlammable(ModBlocks.STRIPPED_BAOBAB_LOG.get(), 5, 5);
        registerFlammable(ModBlocks.STRIPPED_PALM_LOG.get(), 5, 5);

        registerStrippable(ModBlocks.AZALEA_LOG.get(), ModBlocks.STRIPPED_AZALEA_LOG.get());
        registerStrippable(ModBlocks.BAOBAB_LOG.get(), ModBlocks.STRIPPED_BAOBAB_LOG.get());
        registerStrippable(ModBlocks.PALM_LOG.get(), ModBlocks.STRIPPED_PALM_LOG.get());
        registerStrippable(ModBlocks.AZALEA_WOOD.get(), ModBlocks.STRIPPED_AZALEA_WOOD.get());
        registerStrippable(ModBlocks.BAOBAB_WOOD.get(), ModBlocks.STRIPPED_BAOBAB_WOOD.get());
        registerStrippable(ModBlocks.PALM_WOOD.get(), ModBlocks.STRIPPED_PALM_WOOD.get());

        registerCompostable(0.85F, ModBaseFoods.BAKED_BEETROOT.entry);
        registerCompostable(0.85F, ModBaseFoods.BAKED_CARROT.entry);
        registerCompostable(0.85F, ModBaseFoods.BAKED_MUSHROOM.entry);
        registerCompostable(0.85F, ModBaseFoods.BAKED_APPLE.entry);
        registerCompostable(0.85F, ModBaseFoods.DOUGH.entry);

        registerCompostable(0.65F, ModBaseFoods.BAKED_PUMPKIN_SLICE.entry);
        registerCompostable(0.65F, ModBaseFoods.BAKED_MELON_SLICE.entry);
        registerCompostable(0.65F, ModBaseFoods.BAKED_BERRIES.entry);
        registerCompostable(0.65F, ModBaseFoods.FLOUR.entry);

        registerCompostable(0.5F, ModBaseFoods.BAKED_SEEDS.entry);
        registerCompostable(0.5F, ModBaseFoods.BAKED_SEEDS.entry);

        registerCompostable(0.3F, ModBlocks.BAOBAB_LEAVES);
        registerCompostable(0.3F, ModBlocks.PALM_LEAVES);
        registerCompostable(0.3F, ModBlocks.BAOBAB_SAPLING);
        registerCompostable(0.3F, ModBlocks.PALM_SAPLING);
    }

    private static void registerCompostable(float chance, ItemLike item) {
        compostables.put(item, chance);
    }
}