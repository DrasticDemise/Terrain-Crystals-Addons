package com.drasticdemise.TCaddons.common.items;

import java.util.HashSet;
import java.util.Random;

import com.DrasticDemise.TerrainCrystals.Items.TerrainCrystalAbstract;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.block.BlockBOPLog;
import biomesoplenty.common.enums.BOPWoods;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class BOPTerrainCrystalAbstract extends TerrainCrystalAbstract{
	
	public static void initInvalidBOPSpaces(){
		//The nuclear option
		
		//Saplings
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.sapling_0.getDefaultState());
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.sapling_1.getDefaultState());
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.sapling_2.getDefaultState());
		for(int i = 0; i < 8; i++){
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.sapling_0.getStateFromMeta(i));
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.sapling_1.getStateFromMeta(i));
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.sapling_2.getStateFromMeta(i));
		}
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_0.getDefaultState());
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_1.getDefaultState());
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_2.getDefaultState());
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_3.getDefaultState());
		TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_4.getDefaultState());
		for(int i = 0; i < 16; i++){
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_0.getStateFromMeta(i));
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_1.getStateFromMeta(i));
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_2.getStateFromMeta(i));
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_3.getStateFromMeta(i));
			TerrainCrystalAbstract.invalidSpaces.add(BOPBlocks.log_4.getStateFromMeta(i));
		}
		TerrainCrystalAbstract.invalidSpaces.add(BlockBOPLog.paging.getVariantState(BOPWoods.GIANT_FLOWER));
	}
	
	/**
	 * Generates common BOP Flower Variants
	 * @param worldIn world
	 * @param pos position
	 */
	public void genFlowers(World worldIn, BlockPos pos){
		double num = Math.random();
		if(num < 0.11){
			//Pink Daffodil
			worldIn.setBlockState(pos.up(), BOPBlocks.flower_0.getStateFromMeta(6));
		}else if(num < 0.22){
			//White Anemone
			worldIn.setBlockState(pos.up(), BOPBlocks.flower_0.getStateFromMeta(9));
		}else if(num < 0.33){
			//Clover
			worldIn.setBlockState(pos.up(), BOPBlocks.flower_0.getStateFromMeta(0));
		}else if(num < 0.44){
			//Glow flower
			worldIn.setBlockState(pos.up(), BOPBlocks.flower_0.getStateFromMeta(3));
		}else if(num < 0.55){
			//Oxeye daisy
			worldIn.setBlockState(pos.up(), Blocks.red_flower.getStateFromMeta(8));
		}else if (num < 0.66){
			//Houstonia/Azure Blast
			worldIn.setBlockState(pos.up(), Blocks.red_flower.getStateFromMeta(3));
		}else if(num < 0.77){
			//Blue Hydrangea
			worldIn.setBlockState(pos.up(), BOPBlocks.flower_0.getStateFromMeta(4));
		}else if(num < .88){
			//Poppy
			worldIn.setBlockState(pos.up(), Blocks.red_flower.getDefaultState());
		}else{
			//Dandelion
			worldIn.setBlockState(pos.up(), Blocks.yellow_flower.getDefaultState());
		}
	}
	/**
	 * Generates grass from common BOP variants
	 * @param worldIn World
	 * @param pos Position
	 */
	public void genGrass(World worldIn, BlockPos pos){
		double num = Math.random();
		if(num < 0.2){
			//Minecraft Grass
			worldIn.setBlockState(pos.up(), Blocks.tallgrass.getStateFromMeta(1));
		}else if(num < .4){
			//BOP Short Grass
			worldIn.setBlockState(pos.up(), BOPBlocks.plant_0.getDefaultState());
		}else if(num < 0.6){
			//BOP Medium Grass
			worldIn.setBlockState(pos.up(), BOPBlocks.plant_0.getStateFromMeta(1));
		}else if(num < 0.8){
			//BOP WheatGrass
			worldIn.setBlockState(pos.up(), BOPBlocks.plant_0.getStateFromMeta(7));
		}else{
			//BOP Damp Grass
			worldIn.setBlockState(pos.up(), BOPBlocks.plant_0.getStateFromMeta(8));
		}
	}
	public abstract void growTree(World worldIn, BlockPos pos);
}
