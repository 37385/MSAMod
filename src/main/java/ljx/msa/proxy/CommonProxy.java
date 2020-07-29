package ljx.msa.proxy;

import ljx.msa.EarlyLoader;
import ljx.msa.MSA;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
        MSA.LOG.info("FMLPreInitializationEvent");
        EarlyLoader.load();
	}
	
	public void init(FMLInitializationEvent event) {
		MSA.LOG.info("FMLInitializationEvent");
	}

}
