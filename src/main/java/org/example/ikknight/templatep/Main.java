package org.example.ikknight.templatep;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.inventory.meta.components.consumable.ConsumableComponent;
import org.bukkit.inventory.meta.components.consumable.effects.ConsumableApplyEffects;
import org.bukkit.inventory.meta.components.consumable.effects.ConsumableEffect;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.example.ikknight.templatep.commands.GivePowder;
import org.example.ikknight.templatep.commands.Reloadtp;
import org.example.ikknight.templatep.listeners.PowderConsumeEvent;
import org.example.ikknight.templatep.utils.Constants;
import org.example.ikknight.templatep.utils.BasicUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        this.getCommand("reloadsubstance").setExecutor(new Reloadtp(this));
        this.getCommand("givepowder").setExecutor(new GivePowder());
        getServer().getPluginManager().registerEvents(new PowderConsumeEvent(), this); // effect handling

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
        ItemStack powder = getPowder();

        ShapedRecipe recipe = new ShapedRecipe(
                new NamespacedKey(this,"powder"),
                powder
        );

        recipe.shape("SPG");

        recipe.setIngredient('S', Material.SUGAR);
        recipe.setIngredient('P', Material.PHANTOM_MEMBRANE);
        recipe.setIngredient('G', Material.GLOWSTONE_DUST);

        Bukkit.addRecipe(recipe);
    }

    public static ItemStack getPowder(){
        ItemStack powder = new ItemStack(Material.PHANTOM_MEMBRANE);
        ItemMeta meta = powder.getItemMeta();

        meta.setDisplayName("Crystallized Methamphetamine");
        List<String> lore = new ArrayList<>();
        lore.add(BasicUtils.color("&a"+"\"The good stuff\""));
        lore.add(BasicUtils.color("&bMade in Mexico, transported by the cartel"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        FoodComponent powderFood = meta.getFood();
        ConsumableComponent powderConsume = meta.getConsumable();
        powderFood.setCanAlwaysEat(true);
        powderFood.setNutrition(1);
        powderFood.setSaturation(1);
        powderConsume.setConsumeSeconds(1);
        powderConsume.setAnimation(ConsumableComponent.Animation.BRUSH);
        meta.setFood(powderFood);
        meta.setConsumable(powderConsume);
        // effects are handled using PowderConsumeEvent

        powder.setItemMeta(meta);
        return powder;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
