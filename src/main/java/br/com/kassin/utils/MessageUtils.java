package br.com.kassin.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageUtils {

    public static void send(Player player, String strings) {
        String coloredMessage = ChatColor.translateAlternateColorCodes('&', strings);
        player.sendMessage(coloredMessage);
    }

}
