package com.drasticdemise.TCaddons.common.items;

import java.util.Random;

import com.DrasticDemise.TerrainCrystals.Items.TerrainCrystalAbstract;

import biomesoplenty.api.biome.BOPBiomes;
import biomesoplenty.api.block.BOPBlocks;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemMysticGrove extends BOPTerrainCrystalAbstract{
	
	public ItemMysticGrove(){
		setUnlocalizedName("itemMysticGrove");
		setRegistryName("itemMysticGrove");
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("stone", 0);
		setMaxStackSize(1);
		//setMaxDamage
		setMaxDamage(7000);
        GameRegistry.register(this);
	}

	@Override
	public ActionResult<ItemStack> func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		super.gatherBlockGenList(itemStackIn, worldIn, playerIn, 11, BOPBiomes.mystic_grove.get(), true);
		return new ActionResult(EnumActionResult.PASS, itemStackIn);
	}

	@Override
	protected int generateBlocksInWorld(BlockPos pos, World worldIn, EntityPlayer playerIn, int blocksGenerated,
			BiomeGenBase desiredBiome, boolean changeBiome) {
		
		if(eligibleStateLocation(worldIn, pos)){
			int posY = MathHelper.floor_double(playerIn.posY);
			if(posY - pos.getY() == 1){
				super.setBiome(worldIn, pos, desiredBiome, changeBiome);
				worldIn.setBlockState(pos, Blocks.grass.getDefaultState());
				decoratePlatform(worldIn, pos);
			}else{
				worldIn.setBlockState(pos, Blocks.dirt.getDefaultState());
			}
			blocksGenerated++;
		}
		return blocksGenerated;
	}

	@Override
	protected void decoratePlatform(World worldIn, BlockPos pos) {
		//Grass
		double num = Math.random();
		if(num < .5){
			genGrass(worldIn, pos);
			if(Math.random() <= 0.05){
				genFlowers(worldIn, pos);
			}
		}
		if(Math.random() < 0.03 && spacedFarEnough(worldIn, pos.up())){
			growTree(worldIn, pos);
		}
		
	}

	@Override
	public void growTree(World worldIn, BlockPos pos) {
		//sapling_01 5,6
		//sapling_0  3
		//default oak
		double num = Math.random();
		if(num < 0.25){
			//Fl;owering oak
			worldIn.setBlockState(pos.up(), BOPBlocks.sapling_1.getStateFromMeta(5));
		}else if(num < .50){
			//Jacandara
			worldIn.setBlockState(pos.up(), BOPBlocks.sapling_1.getStateFromMeta(6));
		}else if(num < 0.75){
			//Magic
			worldIn.setBlockState(pos.up(), BOPBlocks.sapling_0.getStateFromMeta(3));
		}else{
			//Oak
			worldIn.setBlockState(pos.up(), Blocks.sapling.getDefaultState());
		}
		try{
			IGrowable growable = (IGrowable) worldIn.getBlockState(pos.up()).getBlock();
			int attemptCap = 0;
			Random rand = new Random();
			while((worldIn.getBlockState(pos.up()) != Blocks.log.getDefaultState()) && attemptCap < 10){
				growable.grow(worldIn, rand, pos.up(), worldIn.getBlockState(pos.up()));
				attemptCap++;
			}
			//Delete spare saplings
			if(attemptCap > 9 && (worldIn.getBlockState(pos.up()).equals(BOPBlocks.sapling_1.getStateFromMeta(2)) || worldIn.getBlockState(pos.up()).equals(BOPBlocks.sapling_1.getStateFromMeta(1)))){
				worldIn.setBlockState(pos.up(), Blocks.air.getDefaultState());
			}
		}catch(Exception e){}
	}
}

