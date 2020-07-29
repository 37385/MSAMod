package ljx.msa;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ljx.msa.proxy.*;

@Mod(modid = MSA.MODID, name = MSA.NAME, version = MSA.VERSION , useMetadata = true, acceptedMinecraftVersions="[1.12.2]")
public class MSA
{
    public static final String MODID = "msa";
    public static final String NAME = "Minecraft Simple Addition";
    public static final String VERSION = "0.0.2";
    public static final Logger LOG = LogManager.getLogger("MSA");
    
    @SidedProxy(serverSide = "ljx.msa.proxy.CommonProxy", clientSide = "ljx.msa.proxy.ClientProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static MSA instance;
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    	
    }
}
