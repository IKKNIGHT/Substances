package org.example.ikknight.templatep.utils;

public class BasicUtils {
    private static String Suffix = "";
    public static String getPrefix(){
        return Suffix;
    }
    public static void setPrefix(Object newSuffix){
        Suffix = (String) newSuffix;
    }
}
