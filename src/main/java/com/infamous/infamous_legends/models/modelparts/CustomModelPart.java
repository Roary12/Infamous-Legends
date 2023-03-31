package com.infamous.infamous_legends.models.modelparts;

import java.util.List;
import java.util.Map;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;

public class CustomModelPart extends ModelPart {

	public PoseStack stack;
	
	public CustomModelPart(List<Cube> p_171306_, Map<String, ModelPart> p_171307_) {
		super(p_171306_, p_171307_);
	}
	
	@Override
	public void render(PoseStack p_104307_, VertexConsumer p_104308_, int p_104309_, int p_104310_, float p_104311_,
			float p_104312_, float p_104313_, float p_104314_) {
		super.render(p_104307_, p_104308_, p_104309_, p_104310_, p_104311_, p_104312_, p_104313_, p_104314_);
		this.stack = p_104307_;
	}

}
