package net.alminoris.arborealnature.entity.client.projectile;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.projectile.SilentArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.util.Identifier;

public class SilentArrowRenderer extends ProjectileEntityRenderer<SilentArrowEntity>
{
    public static final Identifier TEXTURE = Identifier.of(ArborealNature.MOD_ID, "textures/entity/projectiles/silent_arrow.png");

    public SilentArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(SilentArrowEntity entity)
    {
        return TEXTURE;
    }
}
