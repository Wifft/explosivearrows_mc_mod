package dev.wifft.explosivearrows.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.User;

public class UserHelper
{
    public static boolean isDev()
    {
        User user = Minecraft.getInstance().getUser();

        String userName = user.getName();
        return userName.equals("Wifft") || userName.equals("Dev");
    } 
}
