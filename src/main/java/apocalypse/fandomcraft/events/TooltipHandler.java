package apocalypse.fandomcraft.events;

import apocalypse.fandomcraft.main.Main;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class TooltipHandler
{
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event)
    {
        if (event.itemStack == null)
        {
            return;
        }

        GameRegistry.UniqueIdentifier id = GameRegistry.findUniqueIdentifierFor(event.itemStack.getItem());

        if (id == null)
        {
            return;
        }

        if (!Main.MODID.equals(id.modId))
        {
            return;
        }

        String defaultLine = EnumChatFormatting.BLUE + Main.NAME;

        event.toolTip.remove(defaultLine);
        event.toolTip.add(EnumChatFormatting.RED + Main.NAME
        );
    }
}