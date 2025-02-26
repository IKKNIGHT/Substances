package org.example.ikknight.templatep.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static org.example.ikknight.templatep.utils.BasicUtils.getPrefix;

public class Say implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            commandSender.sendMessage(getPrefix() + ChatColor.DARK_RED + "You cannot run this command from the console!");
            return false;
        }
        Player player = (Player) commandSender;

        if (strings.length == 1) {
            player.sendMessage(getPrefix() + ChatColor.GREEN + strings[1]);
        }else{
            player.sendMessage(getPrefix() + ChatColor.RED + "Wrong Usage! Use /say <something>");
        }
        return false;
    }
}
