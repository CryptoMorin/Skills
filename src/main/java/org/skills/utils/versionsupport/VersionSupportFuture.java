package org.skills.utils.versionsupport;

import com.cryptomorin.xseries.XAttribute;
import com.cryptomorin.xseries.particles.ParticleDisplay;
import com.cryptomorin.xseries.particles.XParticle;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.awt.*;
import java.util.UUID;

public class VersionSupportFuture {
    private static final UUID ATTRIBUTE_MODIFIER_ID = UUID.randomUUID();
    private static final String ATTRIBUTE_MODIFIER_NAME = "SkillsPro Class Max HP";

    public static void spawnColouredDust(Location loc) {
        spawnColouredDust(loc, Color.CYAN);
    }

    public static void spawnColouredDust(Location loc, java.awt.Color color) {
        ParticleDisplay.of(XParticle.DUST).withLocation(loc).withColor(color, 2f).spawn();
    }

    public static boolean isPassenger(Entity e, Entity pass) {
        return e.getPassengers().contains(pass);
    }

    public static double getMaxHealth(LivingEntity e) {
        return e.getAttribute(XAttribute.MAX_HEALTH.get()).getValue();
    }

    public static void setMaxHealth(LivingEntity e, double amount) {
        AttributeInstance attr = e.getAttribute(XAttribute.MAX_HEALTH.get());
        attr.setBaseValue(amount);
    }

    public static boolean isCropFullyGrown(Block crop) {
        BlockData bdata = crop.getBlockData();
        if (bdata instanceof Ageable) {
            Ageable age = (Ageable) bdata;
            return age.getAge() == age.getMaximumAge();
        }
        return false;
    }
}

