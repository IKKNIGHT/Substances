package org.example.ikknight.templatep.utils;

import org.bukkit.ChatColor;

public class BasicUtils {
    private static String Suffix = "";
    public static String getPrefix(){
        return Suffix;
    }
    public static void setPrefix(Object newSuffix){
        Suffix = (String) newSuffix;
    }

    public static String color (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
