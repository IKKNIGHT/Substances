package org.example.ikknight.templatep.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.example.ikknight.templatep.Main;
import org.example.ikknight.templatep.utils.Constants;

import static org.example.ikknight.templatep.utils.BasicUtils.getPrefix;
import static org.example.ikknight.templatep.utils.BasicUtils.setPrefix;

public class Reloadtp implements CommandExecutor {
    Main m;
    public Reloadtp(Main main){
        m=main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.isOp()){
            commandSender.sendMessage(getPrefix()+ChatColor.YELLOW+"Starting reload please stand by...");
            m.reloadConfiguration();
            m.reloadConfig();
            setPrefix(m.getConfig().get(Constants.YAML.PREFIX_PATH));
            commandSender.sendMessage(getPrefix()+ChatColor.GREEN+"Reload Successful!");
        }else{
            commandSender.sendMessage(getPrefix()+ChatColor.RED+"You do not have permission to run this command!");
        }
        return true;
    }
}
