package org.polaris2023.wild_wind.client;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.polaris2023.annotation.language.I18n;
import org.polaris2023.wild_wind.WildWindMod;
import org.polaris2023.wild_wind.common.init.ModComponents;

import java.util.Locale;
import java.util.function.Supplier;

public enum ModTranslateKey implements Supplier<TranslatableContents> {
    @I18n(en_us = "Nutrition: ", zh_cn = "饥饿值：", zh_tw = "饑餓值：")
    NUTRITION("wild","wind","nutrition"),
    @I18n(en_us = "Saturation: ", zh_cn = "饱食度：", zh_tw = "飽食度：")
    SATURATION("wild","wind","saturation"),
    @I18n(en_us = "effect: ", zh_cn = "效果：", zh_tw = "效果：")
    EFFECT("wild", "wind", "effects"),
    @I18n(en_us = "Trigger probability", zh_cn = "概率触发", zh_tw = "概率觸發")
    TRIGGER_PROBABILITY,
    @I18n(en_us = "Duration", zh_cn = "持续时间", zh_tw = "持續時間")
    DURATION("wild","wind","duration"),
    @I18n(en_us = "Meat: ", zh_cn = "肉值：", zh_tw = "肉值：")
    MEAT_VALUE(ModComponents.MEAT_VALUE),
    @I18n(en_us = "Vegetable: ", zh_cn = "菜值：", zh_tw = "菜值：")
    VEGETABLE_VALUE(ModComponents.VEGETABLE_VALUE),
    @I18n(en_us = "Fruit: ", zh_cn = "果值：", zh_tw = "果值：")
    FRUIT_VALUE(ModComponents.FRUIT_VALUE),
    @I18n(en_us = "Protein: ", zh_cn = "蛋值：", zh_tw = "蛋值：")
    PROTEIN_VALUE(ModComponents.PROTEIN_VALUE),
    @I18n(en_us = "Fish: ", zh_cn = "鱼值：", zh_tw = "魚值：")
    FISH_VALUE(ModComponents.FISH_VALUE),
    @I18n(en_us = "Monster: ", zh_cn = "怪值：", zh_tw = "怪值：")
    MONSTER_VALUE(ModComponents.MONSTER_VALUE),
    @I18n(en_us = "Sweet: ", zh_cn = "甜值：", zh_tw = "甜值：")
    SWEET_VALUE(ModComponents.SWEET_VALUE),
    @I18n(en_us = "cooking pot", zh_cn = "烹饪锅", zh_tw = "烹飪鍋")
    COOKIN_POT("gui", WildWindMod.MOD_ID, "cooking_pot"),
    @I18n(en_us = "Cow intolerance", zh_tw = "奶牛不耐受", zh_cn = "奶牛不耐受")
    COW_INTOLERANCE("cow", "intolerance"),
    @I18n(en_us = "Goat intolerance", zh_tw = "山羊不耐受", zh_cn = "山羊不耐受")
    GOAT_INTOLERANCE("cow", "intolerance"),
    @I18n(en_us = "Ribbon Color: ", zh_tw = "丝带色：", zh_cn = "絲帶色：")
    PRESENT_COLOR_TOOLTIP_RIBBON("present", "color", "tooltip", "ribbon"),
    @I18n(en_us = "Color: ", zh_tw = "本色：", zh_cn = "本色：")
    PRESENT_COLOR_TOOLTIP_BOX("present", "color", "tooltip", "box"),
    @I18n(en_us = "Max Stack Size: ", zh_tw = "最大堆叠：", zh_cn = "最大堆叠：")
    MAX_STACK_SIZE("max", "stack", "size"),
    @I18n(en_us = "ID: ", zh_tw = "ID：", zh_cn = "ID：")
    BLOCK_ID("block", "id"),
    @I18n(en_us = "Hardness: ", zh_tw = "硬度：", zh_cn = "硬度：")
    HARDNESS("hardness"),
    @I18n(en_us = "Blast Resistance: ", zh_tw = "爆炸抗性：", zh_cn = "爆炸抗性：")
    BLAST_RESISTANCE("blast", "resistance"),
    @I18n(en_us = "Flame Odds: ", zh_tw = "引燃几率：", zh_cn = "引燃几率：")
    FLAME_ODDS("flame", "odds"),
    @I18n(en_us = "Burn Odds: ", zh_tw = "烧毁几率：", zh_cn = "烧毁几率：")
    BURN_ODDS("burn", "odds"),
    @I18n(en_us = "Lava Flammable: ", zh_tw = "熔巖可燃性：", zh_cn = "熔岩可燃性：")
    LAVA_FLAMMABLE("lava", "flammable"),
    @I18n(en_us = "Suffocating Block: ", zh_tw = "窒息生物：", zh_cn = "窒息生物：")
    SUFFOCATING_BLOCK("suffocating", "block"),
    @I18n(en_us = "Redstone Conducting: ", zh_tw = "红石导体：", zh_cn = "红石导体：")
    REDSTONE_CONDUCTING("redstone", "conducting"),
    @I18n(en_us = "Solid: ", zh_tw = "固体方块：", zh_cn = "固体方块：")
    SOLID("solid"),
    @I18n(en_us = "Push Reaction: ", zh_tw = "活塞推動行為：", zh_cn = "活塞推动行为：")
    PUSH_REACTION("push", "reaction"),
    @I18n(en_us = "Block Light:  ", zh_tw = "方块光照：", zh_cn = "方块光照：")
    BLOCK_LIGHT("block", "light"),
    @I18n(en_us = "Composting Chance: ", zh_tw = "堆肥几率：", zh_cn = "堆肥几率：")
    COMPOSTING_CHANCE("composting", "chance"),
    @I18n(en_us = "Burn Time: ", zh_tw = "燃烧时间：", zh_cn = "燃烧时间：")
    BURN_TIME("burn", "time"),
    @I18n(en_us = "%s suffocated in quicksand", zh_tw = "%s在流沙里窒息而亡", zh_cn = "%s在流沙里窒息而亡")
    QUICKSAND_DEATH("death", "attack", "wild_wind", "quicksand_damage"),
    @I18n(en_us = "%s suffocated in silt", zh_tw = "%s在淤泥里窒息而亡", zh_cn = "%s在淤泥里窒息而亡")
    SILT_DEATH("death", "attack", "wild_wind", "silt_damage"),

    ;

    final MutableComponent translatable;
    ModTranslateKey(String key) {
        translatable = Component.translatable(key);
    }

    ModTranslateKey(String... keys) {
        StringBuilder key = new StringBuilder();
        if(keys.length != 0) {
            key.append(keys[0]);
            for (int i = 1; i < keys.length; i++) {
                key.append(".").append(keys[i]);
            }
        }
        translatable = Component.translatable(key.toString());
    }

    <T> ModTranslateKey(DeferredHolder<DataComponentType<?>, DataComponentType<T>> holder) {
        translatable = Component.translatable("component." + holder.getId().toString().replace(":", "."));
    }

    ModTranslateKey() {
        translatable = Component.translatable(name().toLowerCase(Locale.ROOT).replace("_", ".").replace("$", "."));
    }

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public TranslatableContents get() {
        return (TranslatableContents) translatable.getContents();
    }

    public MutableComponent translatable() {
        return translatable;
    }
}
