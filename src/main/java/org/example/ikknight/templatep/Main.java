package org.example.ikknight.templatep;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.example.ikknight.templatep.commands.Reloadtp;
import org.example.ikknight.templatep.utils.Constants;
import org.example.ikknight.templatep.utils.BasicUtils;

import java.util.ArrayList;
import java.util.List;

import static org.example.ikknight.templatep.utils.BasicUtils.setPrefix;

public final class Main extends JavaPlugin {

    PluginDescriptionFile pdfFile; // plugin.yml

    public PluginDescriptionFile getPdfFile() {
        return pdfFile;
    }



    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        this.pdfFile = getDescription();

        reloadConfiguration();
        setPrefix(getConfig().get(Constants.YAML.PREFIX_PATH));

        // recipe
        registerPowderRecipie();
        // init command

        this.getCommand("reloadtp").setExecutor(new Reloadtp(this));

        // init listeners

        this.getLogger()
                .info(this.pdfFile.getName() + " - Version " + this.pdfFile.getVersion() + " - has been enabled!");


    }
    public void configureFile(){
        // configures config.yml
        getConfig().addDefault(Constants.YAML.PREFIX_PATH,Constants.DEFAULT_SUFFIX_VALUE);
    }
    public void reloadConfiguration(){
        configureFile();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    private void registerPowderRecipie(){
        ItemStack powder = new ItemStack(Material.PHANTOM_MEMBRANE);
        ItemMeta meta = powder.getItemMeta();

        meta.setDisplayName("Crystallized Methamphetamine");
        List<String> lore = new ArrayList<>();
        lore.add(BasicUtils.color("&7\"The good stuff\"."));
        lore.add(BasicUtils.color("&bMade in Mexico, transported by the cartel."));
        meta.setLore(lore);

        FoodComponent powderFood = meta.getFood();
        powderFood.setCanAlwaysEat(true);
        powderFood.addEffect(new PotionEffect(PotionEffectType.NAUSEA,200,2),1.0f);
        meta.setFood(powderFood);
        powder.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(
                new NamespacedKey(this,"powder"),
                powder
        );

        recipe.shape("SPR");

        recipe.setIngredient('S', Material.SUGAR);
        recipe.setIngredient('P', Material.PHANTOM_MEMBRANE);
        recipe.setIngredient('R', Material.REDSTONE);



        Bukkit.addRecipe(recipe);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
