package ljx.msa.item;

import java.util.ArrayList;
import java.util.List;

import ljx.msa.MSA;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "msa")
public class ItemLoader {
	public static final List<Item> items = new ArrayList<Item>();
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event)
	{
		MSA.LOG.info("Reging item start");
		event.getRegistry().registerAll(
		ItemLoader.items.toArray(new Item[0])
		);
		MSA.LOG.info("Reging item end");
	}
}
