package ljx.msa.block;

import java.util.Random;

import ljx.msa.MSA;
import ljx.msa.item.ItemLoader;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLitObsidian extends BlockObsidian{
	public final static String name="litobsidian";
	//public final static BlockLitObsidian LitObsidian= new BlockLitObsidian();
	//public final static Item IBLitObsidian = new ItemBlock(LitObsidian).setUnlocalizedName(name);
	public BlockLitObsidian() {
		super();
		this.setRegistryName(name).setUnlocalizedName(name).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setSoundType(SoundType.STONE).setLightLevel(1).setHardness(1200).setHarvestLevel("pickaxe", 3);
		ItemLoader.items.add(new ItemBlock(this).setRegistryName(name));
		BlockLoader.blocks.add(this);
		MSA.LOG.info("BlockLitObsidian");
		}
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.BLACK;
    }
}
