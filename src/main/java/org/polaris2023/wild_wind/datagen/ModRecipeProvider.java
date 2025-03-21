package org.polaris2023.wild_wind.datagen;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.fluids.FluidStack;
import org.polaris2023.wild_wind.common.init.ModBlocks;
import org.polaris2023.wild_wind.common.init.ModItems;
import org.polaris2023.wild_wind.common.init.items.ModBaseItems;
import org.polaris2023.wild_wind.common.init.items.entity.ModBoats;
import org.polaris2023.wild_wind.common.init.items.foods.ModBaseFoods;
import org.polaris2023.wild_wind.datagen.custom.recipe.CookingPotRecipeBuilder;
import org.polaris2023.wild_wind.util.Helpers;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public final Map<ResourceLocation, RecipeBuilder> list = new HashMap<>();


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        addDyedRecipe();
        addStonecuttingRecipes();
        addSmeltingRecipes();
        addShapedRecipe();
        addShapelessRecipe();
        addCookingPotRecipes();
        list.forEach((s, b) -> {
            b.save(recipeOutput, s);
        });
    }

    protected void addCookingPotRecipes() {

    }

    public void simpleCookingPot(RecipeCategory category, ItemLike result, FluidStack stack, Consumer<CookingPotRecipeBuilder> consumer) {
        CookingPotRecipeBuilder cooking = CookingPotRecipeBuilder
                .cooking(category, result);
        consumer.accept(cooking);
        add(
                "cooking_pot/",
                cooking
                        .stack(stack));
    }

    public static final Block[] GLAZED_TERRACOTTA_BLOCK = {
            Blocks.BLACK_GLAZED_TERRACOTTA,
            Blocks.BLUE_GLAZED_TERRACOTTA,
            Blocks.BROWN_GLAZED_TERRACOTTA,
            Blocks.GRAY_GLAZED_TERRACOTTA,
            Blocks.GREEN_GLAZED_TERRACOTTA,
            Blocks.CYAN_GLAZED_TERRACOTTA,
            Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA,
            Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
            Blocks.LIME_GLAZED_TERRACOTTA,
            Blocks.MAGENTA_GLAZED_TERRACOTTA,
            Blocks.ORANGE_GLAZED_TERRACOTTA,
            Blocks.PINK_GLAZED_TERRACOTTA,
            Blocks.PURPLE_GLAZED_TERRACOTTA,
            Blocks.RED_GLAZED_TERRACOTTA,
            Blocks.WHITE_GLAZED_TERRACOTTA,
            Blocks.YELLOW_GLAZED_TERRACOTTA
    };

    public static final Block[] CARPET_BLOCK = {
            Blocks.BLACK_CARPET,
            Blocks.BLUE_CARPET,
            Blocks.BROWN_CARPET,
            Blocks.GRAY_CARPET,
            Blocks.GREEN_CARPET,
            Blocks.CYAN_CARPET,
            Blocks.LIGHT_BLUE_CARPET,
            Blocks.LIGHT_GRAY_CARPET,
            Blocks.LIME_CARPET,
            Blocks.MAGENTA_CARPET,
            Blocks.ORANGE_CARPET,
            Blocks.PINK_CARPET,
            Blocks.PURPLE_CARPET,
            Blocks.RED_CARPET,
            Blocks.WHITE_CARPET,
            Blocks.YELLOW_CARPET
    };

    public static Block[] WOOL_BLOCK = {
            Blocks.BLACK_WOOL,
            Blocks.BLUE_WOOL,
            Blocks.BROWN_WOOL,
            Blocks.GRAY_WOOL,
            Blocks.GREEN_WOOL,
            Blocks.CYAN_WOOL,
            Blocks.LIGHT_BLUE_WOOL,
            Blocks.LIGHT_GRAY_WOOL,
            Blocks.LIME_WOOL,
            Blocks.MAGENTA_WOOL,
            Blocks.ORANGE_WOOL,
            Blocks.PINK_WOOL,
            Blocks.PURPLE_WOOL,
            Blocks.RED_WOOL,
            Blocks.WHITE_WOOL,
            Blocks.YELLOW_WOOL
    };

    public static final Block[] CONCRETE_BLOCK = {
            Blocks.BLACK_CONCRETE,
            Blocks.BLUE_CONCRETE,
            Blocks.BROWN_CONCRETE,
            Blocks.GRAY_CONCRETE,
            Blocks.GREEN_CONCRETE,
            Blocks.CYAN_CONCRETE,
            Blocks.LIGHT_BLUE_CONCRETE,
            Blocks.LIGHT_GRAY_CONCRETE,
            Blocks.LIME_CONCRETE,
            Blocks.MAGENTA_CONCRETE,
            Blocks.ORANGE_CONCRETE,
            Blocks.PINK_CONCRETE,
            Blocks.PURPLE_CONCRETE,
            Blocks.RED_CONCRETE,
            Blocks.WHITE_CONCRETE,
            Blocks.YELLOW_CONCRETE
    };

    public static final Block[] CONCRETE_POWDER_BLOCK = {
            Blocks.BLACK_CONCRETE_POWDER,
            Blocks.BLUE_CONCRETE_POWDER,
            Blocks.BROWN_CONCRETE_POWDER,
            Blocks.GRAY_CONCRETE_POWDER,
            Blocks.GREEN_CONCRETE_POWDER,
            Blocks.CYAN_CONCRETE_POWDER,
            Blocks.LIGHT_BLUE_CONCRETE_POWDER,
            Blocks.LIGHT_GRAY_CONCRETE_POWDER,
            Blocks.LIME_CONCRETE_POWDER,
            Blocks.MAGENTA_CONCRETE_POWDER,
            Blocks.ORANGE_CONCRETE_POWDER,
            Blocks.PINK_CONCRETE_POWDER,
            Blocks.PURPLE_CONCRETE_POWDER,
            Blocks.RED_CONCRETE_POWDER,
            Blocks.WHITE_CONCRETE_POWDER,
            Blocks.YELLOW_CONCRETE_POWDER
    };

    public static final Item[] DYE = {
            Items.BLACK_DYE,
            Items.BLUE_DYE,
            Items.BROWN_DYE,
            Items.GRAY_DYE,
            Items.GREEN_DYE,
            Items.CYAN_DYE,
            Items.LIGHT_BLUE_DYE,
            Items.LIGHT_GRAY_DYE,
            Items.LIME_DYE,
            Items.MAGENTA_DYE,
            Items.ORANGE_DYE,
            Items.PINK_DYE,
            Items.PURPLE_DYE,
            Items.RED_DYE,
            Items.WHITE_DYE,
            Items.YELLOW_DYE
    };

    public void addDyedRecipe() {
        for(int i = 0; i < DYE.length; i++) {
            int finalI = i;
            add(shapeless(RecipeCategory.BUILDING_BLOCKS, GLAZED_TERRACOTTA_BLOCK[i], 1, glazed_terracotta -> {
                unlockedBy(glazed_terracotta, ModBlocks.GLAZED_TERRACOTTA, DYE[finalI]);
                glazed_terracotta
                        .requires(ModBlocks.GLAZED_TERRACOTTA)
                        .requires(DYE[finalI]);
            }));
            add(shapeless(RecipeCategory.MISC, CARPET_BLOCK[i], 1, carpet -> {
                unlockedBy(carpet, ModBlocks.CARPET, DYE[finalI]);
                carpet
                        .requires(DYE[finalI])
                        .requires(ModBlocks.CARPET);
            }));
            add(shapeless(RecipeCategory.MISC, WOOL_BLOCK[i], 1, wool -> {
                unlockedBy(wool, ModBlocks.WOOL, DYE[finalI]);
                wool
                        .requires(DYE[finalI])
                        .requires(ModBlocks.WOOL);
            }));
            add(shapeless(RecipeCategory.MISC, CONCRETE_BLOCK[i], 1, concrete -> {
                unlockedBy(concrete, ModBlocks.CONCRETE, DYE[finalI]);
                concrete
                        .requires(DYE[finalI])
                        .requires(ModBlocks.CONCRETE);
            }));
            add(shapeless(RecipeCategory.MISC, CONCRETE_POWDER_BLOCK[i], 1, concrete_powder -> {
                unlockedBy(concrete_powder, ModBlocks.CONCRETE_POWDER, DYE[finalI]);
                concrete_powder
                        .requires(DYE[finalI])
                        .requires(ModBlocks.CONCRETE_POWDER);
            }));
        }
    }

    protected void addStonecuttingRecipes() {
        add(stonecutting(Ingredient.of(Items.STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_WALL, 1), "stonecutting/");
        add(stonecutting(Ingredient.of(ModBlocks.POLISHED_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_WALL, 1), "stonecutting/");
        add(stonecutting(Ingredient.of(ModBlocks.POLISHED_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_STAIRS, 1), "stonecutting/");
        add(stonecutting(Ingredient.of(ModBlocks.POLISHED_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_SLAB, 2), "stonecutting/");
    }

    protected void addSmeltingRecipes() {
        smeltingSmokingAndCampfire(ModBaseFoods.RAW_TROUT.get(), RecipeCategory.FOOD, ModBaseFoods.COOKED_TROUT.get(), 0.35F);
        smeltingSmokingAndCampfire(ModItems.LIVING_TUBER, RecipeCategory.FOOD, ModBaseFoods.BAKED_LIVING_TUBER.get(), 0.35F);
        smeltingSmokingAndCampfire(ModBaseFoods.DOUGH.get(), RecipeCategory.FOOD, Items.BREAD, 0.35F);// input category result exp
        smeltingSmokingAndCampfire(Items.CARROT, RecipeCategory.FOOD, ModBaseFoods.BAKED_CARROT.get(), 0.35F);
        smeltingSmokingAndCampfire(Items.BEETROOT, RecipeCategory.FOOD, ModBaseFoods.BAKED_BEETROOT.get(), 0.35F);
        smeltingSmokingAndCampfire(Ingredient.of(Items.EGG, Items.TURTLE_EGG), RecipeCategory.FOOD, ModBaseFoods.COOKED_EGG.get(), 0.35F);
        smeltingSmokingAndCampfire(Ingredient.of(Items.WHEAT_SEEDS, Items.PUMPKIN_SEEDS, Items.MELON_SEEDS, Items.BEETROOT_SEEDS,
                Items.TORCHFLOWER_SEEDS, Items.PITCHER_POD, ModBlocks.GLAREFLOWER_SEEDS), RecipeCategory.FOOD, ModBaseFoods.BAKED_SEEDS.get(), 0.35F);
        smeltingSmokingAndCampfire(Ingredient.of(Items.SWEET_BERRIES, Items.GLOW_BERRIES), RecipeCategory.FOOD, ModBaseFoods.BAKED_BERRIES.get(), 0.35F);
        smeltingSmokingAndCampfire(ModBaseFoods.PUMPKIN_SLICE, RecipeCategory.FOOD, ModBaseFoods.BAKED_PUMPKIN_SLICE.get(), 0.35F);
        smeltingSmokingAndCampfire(Items.MELON_SLICE, RecipeCategory.FOOD, ModBaseFoods.BAKED_MELON_SLICE.get(), 0.35F);
        smeltingSmokingAndCampfire(Items.APPLE, RecipeCategory.FOOD, ModBaseFoods.BAKED_APPLE.get(), 0.35F);
        smeltingSmokingAndCampfire(Ingredient.of(Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS),
                RecipeCategory.FOOD, ModBaseFoods.BAKED_MUSHROOM, 0.35F);
        smeltingSmokingAndCampfire(ModBaseFoods.RAW_FROG_LEG, RecipeCategory.FOOD, ModBaseFoods.COOKED_FROG_LEG, 0.35F);
        smeltingSmokingAndCampfire(ModBaseFoods.RAW_PIRANHA, RecipeCategory.FOOD, ModBaseFoods.COOKED_PIRANHA, 0.35F);

        add(smelting(ModBlocks.PALM_CROWN, RecipeCategory.MISC, Items.CHARCOAL, 0.35F));

        // add(smelting(ModBlocks.PALM_LEAVES, RecipeCategory.MISC, Items.LEAF_LITTER, 0.35F));
        // add(smelting(ModBlocks.BAOBAB_LEAVES, RecipeCategory.MISC, Items.LEAF_LITTER, 0.35F));

        SimpleCookingRecipeBuilder smelting = smelting(Items.TERRACOTTA, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLAZED_TERRACOTTA.get(),0.35F);
        add(smelting);

        smeltingAndBlasting(Ingredient.of(ModBlocks.SALT_ORE_ITEM.get(), ModBlocks.DEEPSLATE_SALT_ORE_ITEM.get()), RecipeCategory.MISC, ModBaseItems.SALT.get(), 0.7F);
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike... likes) {
        return inventoryTrigger(ItemPredicate.Builder
                .item()
                .of(likes).build());
    }

    protected void addShapedRecipe() {
        add(shaped(RecipeCategory.BUILDING_BLOCKS, Items.ICE, 1, builder -> {
            unlockedBy(builder, ModBlocks.BRITTLE_ICE_ITEM);
            builder
                    .pattern("III")
                    .pattern("III")
                    .pattern("III")
                    .group("ice")
                    .define('I', ModBlocks.BRITTLE_ICE_ITEM);
        }), Helpers.location("ice_from_brittle_ice"));
        add(shaped(RecipeCategory.MISC, ModItems.MAGIC_FLUTE, 1, builder -> {
            unlockedBy(builder, Items.BONE);
            unlockedBy(builder, ModItems.LIVING_TUBER);
            builder
                    .pattern("BRB")
                    .group("magic_flute")
                    .define('B', Items.BONE)
                    .define('R', ModItems.LIVING_TUBER);
        }));
        add(shaped(RecipeCategory.MISC, ModBlocks.COOKING_POT_ITEM.get(), 1,
                builder -> {
            unlockedBy(builder, Items.IRON_INGOT);
            unlockedBy(builder, ItemTags.LOGS);
            unlockedBy(builder, ItemTags.COALS);
            builder
                    .pattern("I I")
                    .pattern("III")
                    .pattern("PCP")
                    .group("cooking_pot")
                    .define('I', Items.IRON_INGOT)
                    .define('P', ItemTags.LOGS)
                    .define('C', ItemTags.COALS);
        }));

        add(shaped(RecipeCategory.MISC, ModBlocks.WOOL.get(), 1,
                builder -> {
            unlockedBy(builder, Items.STRING);
            builder
                    .pattern("SS ")
                    .pattern("SS ")
                    .pattern("   ")
                    .group("wool")
                    .define('S', Items.STRING);
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.CARPET.get(), 3,
                builder -> {
            unlockedBy(builder, ModBlocks.WOOL.get());
            builder
                    .pattern("SS ")
                    .pattern("   ")
                    .pattern("   ")
                    .group("carpet")
                    .define('S', ModBlocks.WOOL.get());
                }));

        add(shaped(RecipeCategory.MISC, ModBlocks.GLOW_MUCUS.get(), 1,
                builder -> {
            unlockedBy(builder, ModItems.GLOW_POWDER);
            unlockedBy(builder, ModItems.ASH_DUST);
            unlockedBy(builder, Items.SLIME_BALL);
            builder
                    .pattern("IWI")
                    .pattern("WSW")
                    .pattern("IWI")
                    .group("glow_mucus")
                    .define('I', ModItems.ASH_DUST)
                    .define('W', ModItems.GLOW_POWDER)
                    .define('S', Items.SLIME_BALL);
                }));

        add(shaped(RecipeCategory.MISC, ModBlocks.ASH_BLOCK.get(), 1,
                        builder -> {
            unlockedBy(builder, ModItems.ASH_DUST);
            builder
                    .pattern("AA")
                    .pattern("AA")
                    .group("ash_block")
                    .define('A', ModItems.ASH_DUST);
                }));

        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_SLAB.get(), 6,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            builder
                    .pattern(("SSS"))
                    .group("wooden_slab")
                    .define('S', ModBlocks.AZALEA_PLANKS.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.AZALEA_PRESSURE_PLATE.get(), 1,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            builder
                    .pattern(("SS"))
                    .group("wooden_pressure_plate")
                    .define('S', ModBlocks.AZALEA_PLANKS.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_AZALEA_WOOD.get(), 3,
                builder -> {
            unlockedBy(builder, ModBlocks.STRIPPED_AZALEA_LOG.get());
            builder
                    .pattern(("SS"))
                    .pattern(("SS"))
                    .group("bark")
                    .define('S', ModBlocks.STRIPPED_AZALEA_LOG.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_WOOD.get(), 3,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_LOG.get());
            builder
                    .pattern(("SS"))
                    .pattern(("SS"))
                    .group("bark")
                    .define('S', ModBlocks.AZALEA_LOG.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.AZALEA_FENCE_GATE.get(), 1,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            unlockedBy(builder, Items.STICK);
            builder
                    .pattern(("PSP"))
                    .pattern(("PSP"))
                    .group("wooden_fence_gate")
                    .define('S', ModBlocks.AZALEA_PLANKS.get())
                    .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.AZALEA_FENCE.get(), 3,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            unlockedBy(builder, Items.STICK);
            builder
                    .pattern(("SPS"))
                    .pattern(("SPS"))
                    .group("wooden_fence")
                    .define('S', ModBlocks.AZALEA_PLANKS.get())
                    .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.AZALEA_DOOR.get(), 3,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            builder
                    .pattern(("SS"))
                    .pattern(("SS"))
                    .pattern(("SS"))
                    .group("wooden_door")
                    .define('S', ModBlocks.AZALEA_PLANKS.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.AZALEA_TRAPDOOR.get(), 2,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            builder
                    .pattern(("SSS"))
                    .pattern(("SSS"))
                    .group("wooden_trapdoor")
                    .define('S', ModBlocks.AZALEA_PLANKS.get());
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.AZALEA_SIGN.get(), 3,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            unlockedBy(builder, Items.STICK);
            builder
                    .pattern(("SSS"))
                    .pattern(("SSS"))
                    .pattern((" P "))
                    .group("wooden_sign")
                    .define('S', ModBlocks.AZALEA_PLANKS.get())
                    .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_STAIRS.get(), 4,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            builder
                    .pattern(("S  "))
                    .pattern(("SS "))
                    .pattern(("SSS"))
                    .group("wooden_stairs")
                    .define('S', ModBlocks.AZALEA_PLANKS.get());
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.AZALEA_HANGING_SIGN.get(), 6,
                builder -> {
            unlockedBy(builder, ModBlocks.STRIPPED_AZALEA_LOG.get());
            unlockedBy(builder, Blocks.CHAIN);
            builder
                    .pattern(("I I"))
                    .pattern(("SSS"))
                    .pattern(("SSS"))
                    .group("hanging_sign")
                    .define('S', ModBlocks.STRIPPED_AZALEA_LOG.get())
                    .define('I', Blocks.CHAIN);
                }));
        add(shaped(RecipeCategory.MISC, ModBoats.AZALEA_BOAT.get(), 1,
                builder -> {
            unlockedBy(builder, ModBlocks.AZALEA_PLANKS.get());
            builder
                    .pattern(("S S"))
                    .pattern(("SSS"))
                    .group("boat")
                    .define('S', ModBlocks.AZALEA_PLANKS.get());
                }));

        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_SLAB.get(), 6,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    builder
                            .pattern(("SSS"))
                            .group("wooden_slab")
                            .define('S', ModBlocks.PALM_PLANKS.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.PALM_PRESSURE_PLATE.get(), 1,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    builder
                            .pattern(("SS"))
                            .group("wooden_pressure_plate")
                            .define('S', ModBlocks.PALM_PLANKS.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PALM_WOOD.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.STRIPPED_PALM_LOG.get());
                    builder
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .group("bark")
                            .define('S', ModBlocks.STRIPPED_PALM_LOG.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_WOOD.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_LOG.get());
                    builder
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .group("bark")
                            .define('S', ModBlocks.PALM_LOG.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.PALM_FENCE_GATE.get(), 1,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    unlockedBy(builder, Items.STICK);
                    builder
                            .pattern(("PSP"))
                            .pattern(("PSP"))
                            .group("wooden_fence_gate")
                            .define('S', ModBlocks.PALM_PLANKS.get())
                            .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.PALM_FENCE.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    unlockedBy(builder, Items.STICK);
                    builder
                            .pattern(("SPS"))
                            .pattern(("SPS"))
                            .group("wooden_fence")
                            .define('S', ModBlocks.PALM_PLANKS.get())
                            .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.PALM_DOOR.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    builder
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .group("wooden_door")
                            .define('S', ModBlocks.PALM_PLANKS.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.PALM_TRAPDOOR.get(), 2,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    builder
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .group("wooden_trapdoor")
                            .define('S', ModBlocks.PALM_PLANKS.get());
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.PALM_SIGN.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    unlockedBy(builder, Items.STICK);
                    builder
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .pattern((" P "))
                            .group("wooden_sign")
                            .define('S', ModBlocks.PALM_PLANKS.get())
                            .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_STAIRS.get(), 4,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    builder
                            .pattern(("S  "))
                            .pattern(("SS "))
                            .pattern(("SSS"))
                            .group("wooden_stairs")
                            .define('S', ModBlocks.PALM_PLANKS.get());
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.PALM_HANGING_SIGN.get(), 6,
                builder -> {
                    unlockedBy(builder, ModBlocks.STRIPPED_PALM_LOG.get());
                    unlockedBy(builder, Blocks.CHAIN);
                    builder
                            .pattern(("I I"))
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .group("hanging_sign")
                            .define('S', ModBlocks.STRIPPED_PALM_LOG.get())
                            .define('I', Blocks.CHAIN);
                }));
        add(shaped(RecipeCategory.MISC, ModBoats.PALM_BOAT.get(), 1,
                builder -> {
                    unlockedBy(builder, ModBlocks.PALM_PLANKS.get());
                    builder
                            .pattern(("S S"))
                            .pattern(("SSS"))
                            .group("boat")
                            .define('S', ModBlocks.PALM_PLANKS.get());
                }));

        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAOBAB_SLAB.get(), 6,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    builder
                            .pattern(("SSS"))
                            .group("wooden_slab")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.BAOBAB_PRESSURE_PLATE.get(), 1,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    builder
                            .pattern(("SS"))
                            .group("wooden_pressure_plate")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_BAOBAB_WOOD.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.STRIPPED_BAOBAB_LOG.get());
                    builder
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .group("bark")
                            .define('S', ModBlocks.STRIPPED_BAOBAB_LOG.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAOBAB_WOOD.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_LOG.get());
                    builder
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .group("bark")
                            .define('S', ModBlocks.BAOBAB_LOG.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.BAOBAB_FENCE_GATE.get(), 1,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    unlockedBy(builder, Items.STICK);
                    builder
                            .pattern(("PSP"))
                            .pattern(("PSP"))
                            .group("wooden_fence_gate")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get())
                            .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.BAOBAB_FENCE.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    unlockedBy(builder, Items.STICK);
                    builder
                            .pattern(("SPS"))
                            .pattern(("SPS"))
                            .group("wooden_fence")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get())
                            .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.BAOBAB_DOOR.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    builder
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .pattern(("SS"))
                            .group("wooden_door")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get());
                }));
        add(shaped(RecipeCategory.REDSTONE, ModBlocks.BAOBAB_TRAPDOOR.get(), 2,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    builder
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .group("wooden_trapdoor")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get());
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.BAOBAB_SIGN.get(), 3,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    unlockedBy(builder, Items.STICK);
                    builder
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .pattern((" P "))
                            .group("wooden_sign")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get())
                            .define('P', Items.STICK);
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAOBAB_STAIRS.get(), 4,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    builder
                            .pattern(("S  "))
                            .pattern(("SS "))
                            .pattern(("SSS"))
                            .group("wooden_stairs")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get());
                }));
        add(shaped(RecipeCategory.MISC, ModBlocks.BAOBAB_HANGING_SIGN.get(), 6,
                builder -> {
                    unlockedBy(builder, ModBlocks.STRIPPED_BAOBAB_LOG.get());
                    unlockedBy(builder, Blocks.CHAIN);
                    builder
                            .pattern(("I I"))
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .group("hanging_sign")
                            .define('S', ModBlocks.STRIPPED_BAOBAB_LOG.get())
                            .define('I', Blocks.CHAIN);
                }));
        add(shaped(RecipeCategory.MISC, ModBoats.BAOBAB_BOAT.get(), 1,
                builder -> {
                    unlockedBy(builder, ModBlocks.BAOBAB_PLANKS.get());
                    builder
                            .pattern(("S S"))
                            .pattern(("SSS"))
                            .group("boat")
                            .define('S', ModBlocks.BAOBAB_PLANKS.get());
                }));

        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_SLAB.get(), 6,
                builder -> {
                    unlockedBy(builder, ModBlocks.POLISHED_STONE.get());
                    builder
                            .pattern(("SSS"))
                            .define('S', ModBlocks.POLISHED_STONE.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_STAIRS.get(), 4,
                builder -> {
                    unlockedBy(builder, ModBlocks.POLISHED_STONE.get());
                    builder
                            .pattern(("S  "))
                            .pattern(("SS "))
                            .pattern(("SSS"))
                            .define('S', ModBlocks.POLISHED_STONE.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_WALL.get(), 6,
                builder -> {
                    unlockedBy(builder, ModBlocks.POLISHED_STONE.get());
                    builder
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .define('S', ModBlocks.POLISHED_STONE.get());
                }));
        add(shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_WALL.get(), 6,
                builder -> {
                    unlockedBy(builder, Blocks.STONE);
                    builder
                            .pattern(("SSS"))
                            .pattern(("SSS"))
                            .define('S', Blocks.STONE);
                }));
    }

    protected static <T extends RecipeBuilder> void unlockedBy(T t, ItemLike... likes) {
        StringBuilder sb = new StringBuilder("has");
        switch (likes.length) {
            case 0 -> {
            }
            case 1 -> {
                ItemLike like = likes[0];
                t.unlockedBy(sb.append("_").append(BuiltInRegistries.ITEM.getKey(like.asItem())).toString().toLowerCase(Locale.ROOT), has(like));
            }
            default -> {
                for (ItemLike like : likes) {
                    ResourceLocation key = BuiltInRegistries.ITEM.getKey(like.asItem());
                    sb.append("_").append(key);
                }
                t.unlockedBy(sb.toString().toLowerCase(Locale.ROOT), has(likes));
            }
        }

    }

    protected static <T extends RecipeBuilder> void unlockedBy(T t, TagKey<Item> tag) {
        t.unlockedBy(("has" + "_" + tag.location()).toLowerCase(Locale.ROOT), has(tag));
    }

    protected void addShapelessRecipe() {
        add(shapeless(RecipeCategory.FOOD, ModBaseFoods.FISH_CHOWDER.get(), 1, fish_chowder -> {
            unlockedBy(fish_chowder, ModBaseFoods.RAW_TROUT.get(), Items.COD, Items.SALMON);
            unlockedBy(fish_chowder, Items.BROWN_MUSHROOM, Items.RED_MUSHROOM);
            unlockedBy(fish_chowder, Items.KELP);
            unlockedBy(fish_chowder, Items.BOWL);
            fish_chowder
                    .requires(Ingredient.of(Items.COD, Items.SALMON, ModBaseFoods.RAW_TROUT.get()))
                    .requires(Items.KELP)
                    .requires(Ingredient.of(Items.BROWN_MUSHROOM, Items.RED_MUSHROOM))
                    .requires(Items.BOWL);
        }));
        add(shapeless(RecipeCategory.FOOD, ModItems.CHEESE, 1, cheese -> {
            unlockedBy(cheese,Items.BROWN_MUSHROOM);
            unlockedBy(cheese,Items.SUGAR);
            unlockedBy(cheese,Items.MILK_BUCKET);
            cheese
                    .requires(Items.BROWN_MUSHROOM)
                    .requires(Items.SUGAR)
                    .requires(Items.MILK_BUCKET);
        }));
        add(shapeless(RecipeCategory.FOOD, ModItems.RUSSIAN_SOUP, 1, russian_soup -> {
            unlockedBy(russian_soup, ModItems.CHEESE);
            unlockedBy(russian_soup, Items.BEETROOT);
            unlockedBy(russian_soup, Items.POTATO);
            unlockedBy(russian_soup, Items.BEEF);
            unlockedBy(russian_soup, Items.BOWL);
            russian_soup
                    .requires(Items.BEETROOT)
                    .requires(Items.POTATO)
                    .requires(Items.BEEF)
                    .requires(ModItems.CHEESE)
                    .requires(Items.BOWL);
        }));
        add(shapeless(RecipeCategory.FOOD, ModBaseItems.CHEESE_PUMPKIN_SOUP.get(), 1, cheese_pumpkin_soup -> {
            unlockedBy(cheese_pumpkin_soup, ModItems.CHEESE);
            unlockedBy(cheese_pumpkin_soup, Items.PUMPKIN);
            unlockedBy(cheese_pumpkin_soup, Items.BOWL);
            cheese_pumpkin_soup
                    .requires(Items.PUMPKIN)
                    .requires(Items.BOWL)
                    .requires(ModItems.CHEESE);
        }));
        add(shapeless(RecipeCategory.MISC, ModBaseFoods.FLOUR, 1, flour -> {
            unlockedBy(flour, Items.WHEAT);
            flour
                    .requires(Items.WHEAT);
        }));
        add(shapeless(RecipeCategory.MISC, ModBaseFoods.DOUGH.get(), 1, dough -> {
            unlockedBy(dough, ModBaseFoods.FLOUR);
            unlockedBy(dough, Items.WATER_BUCKET);
            dough
                    .requires(ModBaseFoods.FLOUR, 3)
                    .requires(Items.WATER_BUCKET);
        }));
        add(shapeless(RecipeCategory.FOOD, ModBaseItems.CANDY.get(), 1, candy -> {
            unlockedBy(candy, Items.SUGAR);
            unlockedBy(candy, Items.HONEY_BOTTLE);
            unlockedBy(candy, Items.GLOW_BERRIES, Items.APPLE, Items.SWEET_BERRIES);
            candy
                    .requires(Items.HONEY_BOTTLE)
                    .requires(Items.SUGAR)
                    .requires(Ingredient
                            .of(
                                    new ItemStack(Items.GLOW_BERRIES),
                                    new ItemStack(Items.APPLE),
                                    new ItemStack(Items.SWEET_BERRIES, 2)));
        }));
        add(shapeless(RecipeCategory.FOOD, ModBaseItems.BERRY_CAKE.get(), 1, berry_cake -> {
            unlockedBy(berry_cake, Items.SWEET_BERRIES);
            unlockedBy(berry_cake, Items.GLOW_BERRIES);
            unlockedBy(berry_cake, Items.SUGAR);
            unlockedBy(berry_cake, Items.EGG);
            berry_cake
                    .requires(Items.SWEET_BERRIES, 2)
                    .requires(Items.GLOW_BERRIES)
                    .requires(Items.SUGAR)
                    .requires(Items.EGG);
        }));
        add(shapeless(RecipeCategory.FOOD, ModBaseItems.APPLE_CAKE.get(), 1, apple_cake -> {
            unlockedBy(apple_cake, Items.APPLE);
            unlockedBy(apple_cake, Items.SUGAR);
            unlockedBy(apple_cake, Items.EGG);
            apple_cake
                    .requires(Items.APPLE)
                    .requires(Items.SUGAR)
                    .requires(Items.EGG);
        }));
        add(shapeless(RecipeCategory.MISC, Items.STRING, 4, wool ->{
            unlockedBy(wool, ItemTags.WOOL);
            wool
                    .requires(ItemTags.WOOL);
        }));
        add(shapeless(RecipeCategory.MISC, ModBlocks.SALT_BLOCK_ITEM, 1, salt_block -> {
            unlockedBy(salt_block, ModBaseItems.SALT);
            salt_block.requires(ModBaseItems.SALT, 9);
        }));
        add(shapeless(RecipeCategory.MISC, ModBaseItems.SALT, 9, salt -> {
            unlockedBy(salt, ModBlocks.SALT_BLOCK_ITEM);
            salt.requires(ModBlocks.SALT_BLOCK_ITEM);
        }));

        add(shapeless(RecipeCategory.MISC, Blocks.PUMPKIN, 1, pumpkin -> {
            unlockedBy(pumpkin, ModBaseFoods.PUMPKIN_SLICE);
            pumpkin.requires(ModBaseFoods.PUMPKIN_SLICE, 9);
        }));
        add(shapeless(RecipeCategory.MISC, ModBlocks.GLISTERING_MELON, 1, glistering_melon -> {
            unlockedBy(glistering_melon, Items.GLISTERING_MELON_SLICE);
            glistering_melon
                    .requires(Items.GLISTERING_MELON_SLICE, 9);
        }));
        add(shapeless(RecipeCategory.MISC, Items.PUMPKIN_SEEDS, 1, pumpkin_seeds -> {
            unlockedBy(pumpkin_seeds, ModBaseFoods.PUMPKIN_SLICE);
            pumpkin_seeds.requires(ModBaseFoods.PUMPKIN_SLICE);
        }));

        add(shapeless(RecipeCategory.MISC, Items.GLOWSTONE_DUST, 1, glowstone_dust -> {
            unlockedBy(glowstone_dust, ModItems.GLOW_POWDER);
            unlockedBy(glowstone_dust, ModItems.ASH_DUST);
            glowstone_dust
                    .requires(ModItems.GLOW_POWDER)
                    .requires(ModItems.ASH_DUST);
        }));

        add(shapeless(RecipeCategory.MISC, Items.GLOW_INK_SAC, 1, glow_ink_sac -> {
            unlockedBy(glow_ink_sac, Items.INK_SAC);
            unlockedBy(glow_ink_sac, ModItems.GLOW_POWDER);
            glow_ink_sac
                    .requires(ModItems.GLOW_POWDER)
                    .requires(Items.INK_SAC);

        }));

        add(shapeless(RecipeCategory.MISC, ModBlocks.AZALEA_PLANKS, 4, azalea_planks -> {
            unlockedBy(azalea_planks, ModBlocks.AZALEA_WOOD, ModBlocks.AZALEA_LOG, ModBlocks.STRIPPED_AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_LOG);
            azalea_planks.requires(Ingredient.of(ModBlocks.AZALEA_WOOD, ModBlocks.AZALEA_LOG, ModBlocks.STRIPPED_AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_LOG));
        }));
        add(shapeless(RecipeCategory.MISC, ModBlocks.AZALEA_BUTTON, 1, azalea_button -> {
            unlockedBy(azalea_button, ModBlocks.AZALEA_PLANKS);
            azalea_button.requires(Ingredient.of(ModBlocks.AZALEA_PLANKS))
                    .group("wooden_button");
        }));
        add(shapeless(RecipeCategory.MISC, ModBoats.AZALEA_CHEST_BOAT, 1, azalea_chest_boat -> {
            unlockedBy(azalea_chest_boat, ModBoats.AZALEA_BOAT);
            unlockedBy(azalea_chest_boat, Blocks.CHEST);
            azalea_chest_boat
                    .requires(Blocks.CHEST)
                    .requires(ModBoats.AZALEA_BOAT)
                    .group("chest_boat");
        }));

        add(shapeless(RecipeCategory.MISC, ModBlocks.PALM_PLANKS, 4, palm_planks -> {
            unlockedBy(palm_planks, ModBlocks.PALM_WOOD, ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_WOOD, ModBlocks.STRIPPED_PALM_LOG, ModBlocks.PALM_CROWN);
            palm_planks.requires(Ingredient.of(ModBlocks.PALM_WOOD, ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_WOOD, ModBlocks.STRIPPED_PALM_LOG, ModBlocks.PALM_CROWN));
        }));
        add(shapeless(RecipeCategory.MISC, ModBlocks.PALM_BUTTON, 1, palm_button -> {
            unlockedBy(palm_button, ModBlocks.PALM_PLANKS);
            palm_button.requires(Ingredient.of(ModBlocks.PALM_PLANKS))
                    .group("wooden_button");
        }));
        add(shapeless(RecipeCategory.MISC, ModBoats.PALM_CHEST_BOAT, 1, palm_boat -> {
            unlockedBy(palm_boat, ModBoats.PALM_BOAT);
            unlockedBy(palm_boat, Blocks.CHEST);
            palm_boat
                    .requires(Blocks.CHEST)
                    .requires(ModBoats.PALM_BOAT)
                    .group("chest_boat");
        }));

        add(shapeless(RecipeCategory.MISC, ModBlocks.BAOBAB_PLANKS, 4, baobab_planks -> {
            unlockedBy(baobab_planks, ModBlocks.BAOBAB_WOOD, ModBlocks.BAOBAB_LOG, ModBlocks.STRIPPED_BAOBAB_WOOD, ModBlocks.STRIPPED_BAOBAB_LOG);
            baobab_planks.requires(Ingredient.of(ModBlocks.BAOBAB_WOOD, ModBlocks.BAOBAB_LOG, ModBlocks.STRIPPED_BAOBAB_WOOD, ModBlocks.STRIPPED_BAOBAB_LOG));
        }));
        add(shapeless(RecipeCategory.MISC, ModBlocks.BAOBAB_BUTTON, 1, baobab_button -> {
            unlockedBy(baobab_button, ModBlocks.BAOBAB_PLANKS);
            baobab_button.requires(Ingredient.of(ModBlocks.BAOBAB_PLANKS))
                    .group("wooden_button");
        }));
        add(shapeless(RecipeCategory.MISC, ModBoats.BAOBAB_CHEST_BOAT, 1, baobab_chest_boat -> {
            unlockedBy(baobab_chest_boat, ModBoats.BAOBAB_BOAT);
            unlockedBy(baobab_chest_boat, Blocks.CHEST);
            baobab_chest_boat
                    .requires(Blocks.CHEST)
                    .requires(ModBoats.BAOBAB_BOAT)
                    .group("chest_boat");
        }));
        add(shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CONCRETE_POWDER, 8, concrete_powder -> {
            unlockedBy(concrete_powder, Blocks.SAND);
            unlockedBy(concrete_powder, Blocks.GRAVEL);
            concrete_powder
                    .requires(Blocks.SAND, 4)
                    .requires(Blocks.GRAVEL, 4);
        }));
    }

    public static ShapedRecipeBuilder shaped(
            RecipeCategory category, ItemLike result, int count, Consumer<ShapedRecipeBuilder> consumer
    ) {
        ShapedRecipeBuilder shaped = ShapedRecipeBuilder.shaped(category, result, count);
        consumer.accept(shaped);
        return shaped;
    }

    public static ShapelessRecipeBuilder shapeless(RecipeCategory category, ItemStack result, Consumer<ShapelessRecipeBuilder> consumer) {
        ShapelessRecipeBuilder shapeless = ShapelessRecipeBuilder.shapeless(category, result);
        consumer.accept(shapeless);
        return shapeless;
    }

    public static ShapelessRecipeBuilder shapeless(RecipeCategory category, ItemLike result, int count, Consumer<ShapelessRecipeBuilder> consumer) {
        ShapelessRecipeBuilder shapeless = ShapelessRecipeBuilder.shapeless(category, result, count);
        consumer.accept(shapeless);
        return shapeless;
    }

    public static SingleItemRecipeBuilder stonecutting(
            Ingredient input, RecipeCategory category, ItemLike result, int count
    ) {
        ItemStack[] items = input.getItems();
        Item item = items[0].getItem();
        return SingleItemRecipeBuilder.stonecutting(input, category, result, count)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(item).toString(), has(item));
    }

    public static SimpleCookingRecipeBuilder smelting(
            Ingredient input, RecipeCategory category, ItemLike result, float exp, int cookingTime
    ) {
        ItemStack[] items = input.getItems();
        Item item = items[0].getItem();
        return SimpleCookingRecipeBuilder.smelting(input, category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(item).toString(), has(item));
    }

    public static SimpleCookingRecipeBuilder blasting(
            Ingredient input, RecipeCategory category, ItemLike result, float exp, int cookingTime
    ) {
        ItemStack[] items = input.getItems();
        Item item = items[0].getItem();
        return SimpleCookingRecipeBuilder.blasting(input, category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(item).toString(), has(item));
    }

    public static SimpleCookingRecipeBuilder smoking(
            Ingredient input, RecipeCategory category, ItemLike result, float exp, int cookingTime
    ) {
        ItemStack[] items = input.getItems();
        Item item = items[0].getItem();
        return SimpleCookingRecipeBuilder.smoking(input, category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(item).toString(), has(item));
    }

    public static SimpleCookingRecipeBuilder campfire(
            Ingredient input, RecipeCategory category, ItemLike result, float exp, int cookingTime
    ) {
        ItemStack[] items = input.getItems();
        Item item = items[0].getItem();
        return SimpleCookingRecipeBuilder.campfireCooking(input, category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(item).toString(), has(item));
    }

    public static SimpleCookingRecipeBuilder campfire(
            Ingredient input, RecipeCategory category, ItemLike result, float exp
    ) {
        return  campfire(input, category, result, exp, 200);
    }

    public static SimpleCookingRecipeBuilder campfire(
            ItemLike input, RecipeCategory category, ItemLike result, float exp, int cookingTime
    ) {
        return SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(input.asItem()).toString(), has(input));
    }

    public static SimpleCookingRecipeBuilder campfire(
            ItemLike input, RecipeCategory category, ItemLike result, float exp
    ) {
        return campfire(input, category, result, exp,200);
    }

    public static SimpleCookingRecipeBuilder smelting(
            ItemLike input, RecipeCategory category, ItemLike result, float exp, int cookingTime
    ) {
        return SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(input.asItem()).toString(), has(input));
    }

    public static SimpleCookingRecipeBuilder blasting(
            ItemLike input, RecipeCategory category, ItemLike result, float exp, int cookingTime) {
        return SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(input.asItem()).toString(), has(input));
    }

    public static SimpleCookingRecipeBuilder smoking(
            ItemLike input, RecipeCategory category, ItemLike result, float exp, int cookingTime) {
        return SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), category, result, exp, cookingTime)
                .unlockedBy(BuiltInRegistries.ITEM.getKey(input.asItem()).toString(), has(input));
    }

    public void smeltingAndBlasting(Ingredient input, RecipeCategory category, ItemLike result, float exp) {
        add(smelting(input, category, result, exp));
        add(blasting(input, category, result, exp), "blasting/");
    }

    public void smeltingAndSmoking(Ingredient input, RecipeCategory category, ItemLike result, float exp) {
        add(smelting(input, category, result, exp));
        add(smoking(input, category, result, exp), "smoking/");
    }

    public void smeltingSmokingAndCampfire(Ingredient input, RecipeCategory category, ItemLike result, float exp) {
        add(smelting(input, category, result, exp));
        add(smoking(input, category, result, exp), "smoking/");
        add(campfire(input, category, result, exp), "campfire/");
    }

    public static SimpleCookingRecipeBuilder smelting(
            Ingredient input, RecipeCategory category, ItemLike result, float exp
    ) {
        return  smelting(input, category, result, exp, 200);
    }

    public static SimpleCookingRecipeBuilder smoking(
            Ingredient input, RecipeCategory category, ItemLike result, float exp
    ) {
        return  smoking(input, category, result, exp, 200);
    }

    public static SimpleCookingRecipeBuilder blasting(
            Ingredient input, RecipeCategory category, ItemLike result, float exp
    ) {
        return  blasting(input, category, result, exp, 200);
    }

    public void smeltingAndSmoking(
            ItemLike input, RecipeCategory category, ItemLike result, float exp
    ) {
        add(smelting(input, category, result, exp));
        add(smoking(input, category, result, exp), "smoking/");
    }

    public void smeltingAndBlasting(
            ItemLike input, RecipeCategory category, ItemLike result, float exp
    ) {
        add(smelting(input, category, result, exp));
        add(blasting(input, category, result, exp), "blasting/");
    }

    public void smeltingSmokingAndCampfire(ItemLike input, RecipeCategory category, ItemLike result, float exp) {
        add(smelting(input, category, result, exp));
        add(smoking(input, category, result, exp), "smoking/");
        add(campfire(input, category, result, exp), "campfire/");
    }

    public static SimpleCookingRecipeBuilder smelting(
            ItemLike input, RecipeCategory category, ItemLike result, float exp
    ) {
        return smelting(input, category, result, exp,200);
    }

    public static SimpleCookingRecipeBuilder smoking(
            ItemLike input, RecipeCategory category, ItemLike result, float exp
    ) {
        return smoking(input, category, result, exp, 200);
    }

    public static SimpleCookingRecipeBuilder blasting(
            ItemLike input, RecipeCategory category, ItemLike result, float exp
    ) {
        return blasting(input, category, result, exp, 200);
    }

    public void add(RecipeBuilder builder) {
        list.put(BuiltInRegistries.ITEM.getKey(builder.getResult()), builder);
    }
    public void add(RecipeBuilder builder, ResourceLocation name) {
        list.put(name, builder);
    }

    public void add(RecipeBuilder builder, String prePath) {
        list.put(BuiltInRegistries.ITEM.getKey(builder.getResult()).withPrefix(prePath), builder);
    }

    public void add(RecipeBuilder builder, String prePath, String sufPath) {
        list.put(BuiltInRegistries.ITEM.getKey(builder.getResult()).withPrefix(prePath).withSuffix(sufPath), builder);
    }

    public void add(String prePath,RecipeBuilder builder) {
        list.put(BuiltInRegistries.ITEM.getKey(builder.getResult()).withPrefix(prePath), builder);
    }
}