package org.polaris2023.wild_wind.client;

import net.minecraft.util.FastColor;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.polaris2023.wild_wind.client.entity.firefly.FireflyModel;
import org.polaris2023.wild_wind.client.entity.firefly.FireflyRenderer;
import org.polaris2023.wild_wind.client.entity.piranha.PiranhaModel;
import org.polaris2023.wild_wind.client.entity.piranha.PiranhaRenderer;
import org.polaris2023.wild_wind.client.entity.trout.TroutModel;
import org.polaris2023.wild_wind.client.entity.trout.TroutRenderer;
import org.polaris2023.wild_wind.common.init.ModComponents;
import org.polaris2023.wild_wind.common.init.ModEntities;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WildWindClientEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerSlimeColor(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) ->
                FastColor.ARGB32.opaque(stack.getOrDefault(ModComponents.SLIME_COLOR, 0)), Items.SLIME_BALL);
    }

    @SubscribeEvent
    public static void registerRender(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.FIREFLY.get(), FireflyRenderer::new);
        event.registerEntityRenderer(ModEntities.TROUT.get(), TroutRenderer::new);
        event.registerEntityRenderer(ModEntities.PIRANHA.get(), PiranhaRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FireflyModel.LAYER_LOCATION, FireflyModel::createBodyLayer);
        event.registerLayerDefinition(TroutModel.LAYER_LOCATION, TroutModel::createBodyLayer);
        event.registerLayerDefinition(PiranhaModel.LAYER_LOCATION, PiranhaModel::createBodyLayer);
    }
}
