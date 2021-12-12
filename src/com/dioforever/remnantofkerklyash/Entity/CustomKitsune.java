package com.dioforever.remnantofkerklyash.Entity;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import java.lang.reflect.Field;

import static com.dioforever.remnantofkerklyash.Utils.*;
import static com.dioforever.remnantofkerklyash.Utils.color;

public class CustomKitsune extends EntityFox {

    public CustomKitsune(Location loc) {
        super(EntityTypes.FOX, ((CraftWorld) loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new ChatComponentText(color("&6Kitsune")));
        this.setCustomNameVisible(true);
        this.setHealth(50);

        this.goalSelector.a(0, new PathfinderGoalAvoidTarget<EntityPlayer>(this, EntityPlayer.class, 15, 1.0D, 1.0D ));
        ;

        this.goalSelector.a(1, new PathfinderGoalPanic(this, 2.0D));
        this.goalSelector.a(2, new PathfinderGoalRandomStrollLand(this, 0.6D));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));


    }
    public static Object getPrivateField(String fieldName, Class clazz, Object object)
    {
        Field field;
        Object o = null;

        try
        {
            field = clazz.getDeclaredField(fieldName);

            field.setAccessible(true);

            o = field.get(object);
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return o;
    }
}
