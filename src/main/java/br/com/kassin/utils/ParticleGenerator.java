package br.com.kassin.utils;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

public final class ParticleGenerator {
    public static void spawn(final Player player,final Particle particleType) {
        double radius = 1; // Raio da aura
        double heightOffset = 0.3; // Ajuste da altura da aura
        double particleCount = 15;

        for (int i = 0; i < particleCount; i++) {
            double angle = 2 * Math.PI * i / particleCount;
            double x = player.getLocation().getX() + radius * Math.cos(angle);
            double z = player.getLocation().getZ() + radius * Math.sin(angle);
            double y = player.getLocation().getY() + heightOffset;

            player.getWorld().spawnParticle(particleType, x, y, z, 0);
        }
    }
}
