package eu.spartan-mc.acapi;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class zScr1ptCommand implements CommandExecutor
{
    private acapi plugin;

    public zScr1ptCommand() {
        this.plugin = acpi.getInstance();
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!cmd.getName().equalsIgnoreCase("zscriptcode")) {
            return false;
        }
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player p = (Player)sender;
        if (args.length == 0) {
            if (!p.hasPermission("acapizscript.admin")) {
                this.plugin.sms(p, "&8&m-------&f &8[&3✦&8] &8&m---&f &3API-Creator &8&m---&f &8[&3✦&8] &8&m-------&f ");
                this.plugin.sms(p, "&3ACAPI &7v&f" + this.plugin.getDescription().getVersion());
                this.plugin.sms(p, "&7By: &azScr1ptCode_");
                this.plugin.sms(p, "&8&m----------------&f &8[&3✦&8] &8&m-----------------&f ");
                return true;
            }
            this.plugin.sms(p, "&8&m-------&f &8[&3✦&8] &8&m---&f &3API-MENU &8&m---&f &8[&3✦&8] &8&m-------&f ");
            this.plugin.sms(p, "&3ACAPI");
            this.plugin.sms(p, "&a/acapi help - &fDisplays this help message");
            this.plugin.sms(p, "&a/acapi reload - &fReloads the plugin");
            this.plugin.sms(p, "&8&m----------------&f &8[&3✦&8] &8&m-----------------&f ");
            return true;
        }
        else if (args.length == 1) {
            if (!p.hasPermission("acapizscript.admin")) {
                this.plugin.sms(p, "&cYou do not have permission to execute this command");
                return true;
            }
            if (args[0].equalsIgnoreCase("help")) {
                this.plugin.sms(p, "&8&m-------&f &8[&3✦&8] &8&m---&f &3API-MENU &8&m---&f &8[&3✦&8] &8&m-------&f ");
                this.plugin.sms(p, "&3ACAPI");
                this.plugin.sms(p, "&a/acapi help - &fDisplays this help message");
                this.plugin.sms(p, "&a/acapi reload - &fReloads the plugin");
                this.plugin.sms(p, "&8&m----------------&f &8[&3✦&8] &8&m-----------------&f ");
                return false;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                this.plugin.reload();
                this.plugin.sms(p, "&8&m----------------&f &8[&3✦&8] &8&m-----------------&f ");
                this.plugin.sms(p, "&3ACAPI &7has been reloaded!");
                this.plugin.sms(p, "&8&m----------------&f &8[&3✦&8] &8&m-----------------&f ");
                return false;
            }
            this.plugin.sms(p, "&cUnkown command, use &3/acapi help");
            return true;
        }
        else {
            if (!p.hasPermission("acapizscript.admin")) {
                this.plugin.sms(p, "&cYou do not have permission to execute this command");
                return true;
            }
            this.plugin.sms(p, "&cUnkown command, use /acapi help");
            return false;
        }
    }
}