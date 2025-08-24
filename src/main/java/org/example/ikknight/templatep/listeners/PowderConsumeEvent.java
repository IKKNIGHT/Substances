package org.example.ikknight.templatep.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class PowderConsumeEvent implements Listener {
    @EventHandler
    public void playerItemConsumeEvent(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        //player.sendMessage("Event Registered!, bool item.getItemMeta().getDisplayName().equals(\"Crystallized Methamphetamine\") : "+item.getItemMeta().getDisplayName().equals("Crystallized Methamphetamine"));
        if(item.getItemMeta().getDisplayName().equals("Crystallized Methamphetamine")){
                  // we have consumed the powder
                  Random random = new Random();
                  int seed = random.nextInt(100)+1;
                  //player.sendMessage("current Seed : "+seed);
                  if(seed <= 80){ // 80% chance event A
                     player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA,200,2));
                  }
                  seed = random.nextInt(100)+1;
                  //player.sendMessage("current Seed : "+seed);
                  if(seed <=80){ // 80% chance event B
                      player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,200,2));
                  } // P(A) U P(B) = 64%
                  double strengthSeed = Math.random();
                  //player.sendMessage("StrengthSeed : "+strengthSeed);
                  if(strengthSeed <=0.001){ // 0.1% chance event C
                      player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 12000,5));
                  } // P(A) U P(B) U P(C) 0.064%
        }

    }

}
