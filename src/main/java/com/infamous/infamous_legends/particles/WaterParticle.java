package com.infamous.infamous_legends.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WaterParticle extends TextureSheetParticle {
	
	private final SpriteSet sprites;
	
    protected WaterParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                               SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.sprites = spriteSet;

        this.quadSize *= 3.5F;
        this.lifetime = 10;
        this.hasPhysics = true;
        this.gravity = 1.0F;
        this.pickSprite(spriteSet);
        
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
        
        this.setAlpha(0.75F);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new WaterParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
