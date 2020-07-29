package ljx.msa.block;

import java.util.ArrayList;
import java.util.List;

import ljx.msa.MSA;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "msa")
public class BlockLoader {
	public static final List<Block> blocks = new ArrayList<Block>();
	
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event)
	{
		MSA.LOG.info("Reging block start");
		event.getRegistry().registerAll(
		BlockLoader.blocks.toArray(new Block[0])
		);
		MSA.LOG.info("Reging block end");
	}
}
