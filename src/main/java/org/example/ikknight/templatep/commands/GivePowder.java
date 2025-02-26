package org.example.ikknight.templatep.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.ikknight.templatep.Main;

public class GivePowder implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only Players are allowed to run this command!");
            return false;
        }
        Player executor = (Player) commandSender;
        if(!executor.isOp()) {
            executor.sendMessage(ChatColor.RED+"You have to be oped for this command!");
            return false;
        }
        if(strings.length == 1){
            // find target
            Player target = Bukkit.getPlayer(strings[0]);
            if(target!=null && target.isOnline()){
                target.getInventory().addItem(Main.getPowder());
                return true;
            }else{
                executor.sendMessage(ChatColor.RED+"Player doesn't exist or isn't online!");
                return false;
            }
        }else if (strings.length == 0){
            executor.getInventory().addItem(Main.getPowder());
            executor.sendMessage(ChatColor.YELLOW+"You have been given meth!");
            return true;
        }else{
            executor.sendMessage(ChatColor.RED+"Usage /<cmd> or /<cmd> <player>");
            return false;
        }
    }
}
