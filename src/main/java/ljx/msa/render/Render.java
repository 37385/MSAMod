package ljx.msa.render;

import ljx.msa.EarlyLoader;
import ljx.msa.MSA;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

//@Mod.EventBusSubscriber(value = Side.CLIENT,modid = "msmod")
@Mod.EventBusSubscriber(Side.CLIENT)
public class Render {
	@SubscribeEvent
	public static void regModels(ModelRegistryEvent event) {
		MSA.LOG.info("Render start");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(EarlyLoader.LitObsidian) ,0, new ModelResourceLocation(EarlyLoader.LitObsidian.getRegistryName(), "inventory"));
//		ModelLoader.setCustomModelResourceLocation(EarlyLoader.MSBow ,0, new ModelResourceLocation(ItemMSBow.name, "inventory"));
		ModelLoader.setCustomModelResourceLocation(EarlyLoader.MSSword ,0, new ModelResourceLocation(EarlyLoader.MSSword.getRegistryName(), "inventory"));
		MSA.LOG.info("Render end");
	}
}
