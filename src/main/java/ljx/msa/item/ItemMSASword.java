package ljx.msa.item;



import java.util.List;

import ljx.msa.MSA;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemMSASword extends ItemSword{
	private final static ToolMaterial TOOL_MATERIAL=EnumHelper.addToolMaterial("MS", 32, 99999, 99999F, 99999F, 99);
	public final static int DEEP=10000;
	public final static int HarvestLevel=10;
	public static final String name="msasword";
	public ItemMSASword() {
	super(TOOL_MATERIAL);
	this.setRegistryName(name).setUnlocalizedName(name).setCreativeTab(CreativeTabs.COMBAT);
	this.setHarvestLevel("pickaxel", HarvestLevel);
	this.setHarvestLevel("axe", HarvestLevel);
	this.setHarvestLevel("sword", HarvestLevel);
	MSA.LOG.info("ItemMSASword");
	ItemLoader.items.add(this);
	}
	@Override
    public float getAttackDamage()
    {
        return Float.MAX_VALUE;
    }
	
	@Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        return false;
    }

	@Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Block block = state.getBlock();

        if (block == Blocks.WEB)
        {
            return 15.0F;
        }
        else
        {
            return 10F;
        }
    }	
	
	@Override
	public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
		return true;
	}
    
	@Override
    public boolean isDamageable()
    {
        return false;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
	@Override
	public void setDamage(ItemStack stack, int damage) {
		super.setDamage(stack, 0);
	}
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	//MSA.LOG.info("EnumActionResult onItemUse");
        return EnumActionResult.PASS;
    }
	@Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand)
    {
		//MSA.LOG.info("EnumActionResult onItemUseFirst");
        return EnumActionResult.PASS;
    }
	
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		killer(target);
        return true;	
    }
	
	
	@Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		killer(entity);
        return true;
    }

	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		BlockPos playerpos = playerIn.getPosition();
        int playerX = playerpos.getX();
        int playerY = playerpos.getY();
        int playerZ = playerpos.getZ();
        AxisAlignedBB bb =new AxisAlignedBB(playerX-10,playerY-10,playerZ-10,playerX+10,playerY+10,playerZ+10);
        List<Entity> Entities =worldIn.getEntitiesWithinAABBExcludingEntity(playerIn,bb);
        boolean killall = true;
        for (Entity entity : Entities) {
			if (entity instanceof EntityLivingBase) {
				killer((EntityLivingBase) entity);
				killall=false;
				}
			}
        if (killall) {
        	for (Entity entity : Entities) { 
				killer(entity);
				}
		}
        
    	//MSA.LOG.info("ActionResult<ItemStack> onItemRightClick");
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

	protected final static void killer(Entity entity) {
		//if (attacker instanceof EntityPlayer) {((EntityPlayer)attacker).attackTargetEntityWithCurrentItem(entity);}
		entity.setFire(20);
		entity.setInvisible(false);
		if (entity instanceof EntityLivingBase ) {
			EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
			entityLivingBase.stopActiveHand();
			entityLivingBase.setAIMoveSpeed(0);
			entityLivingBase.setAbsorptionAmount(0);
			entityLivingBase.deathTime=20;
			entityLivingBase.onDeath(new EntityDamageSource("MS",entity ));
			entityLivingBase.setHealth(0);
			}
		entity.setDead();
		entity.onKillCommand();
		entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.MAGIC,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.ANVIL,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.ON_FIRE,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.LAVA,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.IN_WALL,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.CRAMMING,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.DROWN,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.STARVE,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.CACTUS,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.FALL,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.GENERIC,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.WITHER,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.DRAGON_BREATH,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.FALLING_BLOCK,Float.MAX_VALUE);
		entity.attackEntityFrom(DamageSource.FIREWORKS,Float.MAX_VALUE);
		try {
			entity.performHurtAnimation();
			} catch (Exception e) {
			MSA.LOG.info(e);}
		try {
		if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_LSHIFT)) {
			if (entity instanceof EntityPlayerMP) {
				EntityPlayerMP entityPlayerMP = (EntityPlayerMP) entity;
				switch(entityPlayerMP.interactionManager.getGameType()) {
				case CREATIVE:
					entityPlayerMP.setGameType(GameType.SURVIVAL);
					break;
				case SURVIVAL:
					entityPlayerMP.setGameType(GameType.ADVENTURE);
					break;	
				case ADVENTURE:
					entityPlayerMP.setGameType(GameType.SPECTATOR);
					break;
				case SPECTATOR:
					break;
				case NOT_SET:
					break;	
				}
				
			}
    		
		BlockPos entitypos = entity.getPosition();
		int entityX = entitypos.getX();
		int entityZ = entitypos.getZ();
		MSA.LOG.info("Remove entity to {},{},{}",entityX,-DEEP,entityZ);
		entity.setPosition(entityX, -DEEP, entityZ);
		entity.setLocationAndAngles(entityX,-DEEP,entityZ,90F,90F);
		entity.setPositionAndRotationDirect(entityX, -DEEP, entityZ, 1, 1, 1, false);
		entity.onRemovedFromWorld();

		entity.move(MoverType.SHULKER_BOX, entityX, -DEEP, entityZ);
		entity.move(MoverType.PISTON, entityX, -DEEP, entityZ);
		entity.move(MoverType.PLAYER, entityX, -DEEP, entityZ);
		entity.move(MoverType.SELF, entityX, -DEEP, entityZ);
		entity.move(MoverType.SHULKER, entityX, -DEEP, entityZ);
		 		}
		if ((org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_LCONTROL))&&(entity instanceof EntityPlayer)) {
			EntityPlayer entityPlayer = (EntityPlayer) entity;
			entityPlayer.setDead();
			if (entityPlayer instanceof EntityPlayerMP) {
				EntityPlayerMP entityPlayerMP = (EntityPlayerMP) entity;
				entityPlayerMP.onDeath(new EntityDamageSource("MS",entity ));
				entityPlayerMP.connection.disconnect(null);
				}
			}
		} catch (Exception e) {
			MSA.LOG.info(e);
		}	
	}
}
