package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;

public class TagInit {
	
    public static class EntityTypes {
    	public static final TagKey<EntityType<?>> PIGLIN_ALLIES = tag("piglin_allies");  	
    	public static final TagKey<EntityType<?>> LEGENDS_PIGLIN_NEMESES = tag("legends_piglin_nemeses");  
    	
    	   private static TagKey<EntityType<?>> tag(String p_203849_) {
    		      return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(InfamousLegends.MOD_ID, p_203849_));
    	   }
    }
    
    public static class Blocks {
    	public static final TagKey<Block> UNBREAKABLE = tag("unbreakable");  	
    	
    	   private static TagKey<Block> tag(String p_203849_) {
    		      return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(InfamousLegends.MOD_ID, p_203849_));
    	   }
    }
}
