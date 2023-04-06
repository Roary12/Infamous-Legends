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

public class SparkParticle extends TextureSheetParticle {
	
	private final SpriteSet sprites;
	
    protected SparkParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                               SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.sprites = spriteSet;
        
        this.xd = xd - 0.1 + this.random.nextFloat() * 0.2;
        this.yd = yd + this.random.nextFloat() * 0.25;
        this.zd = zd - 0.1 + this.random.nextFloat() * 0.2;
        this.quadSize *= 1.75F;
        this.lifetime = 10;
        this.hasPhysics = true;
        this.gravity = 1.0F;
        this.pickSprite(spriteSet);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        this.roll = this.roll + 0.1F;
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
            return new SparkParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
