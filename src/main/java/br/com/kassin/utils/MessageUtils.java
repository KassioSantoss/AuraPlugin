package br.com.kassin.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class MessageUtils {

    public static void send(final Player player, final String strings) {
        String coloredMessage = ChatColor.translateAlternateColorCodes('&', strings);
        player.sendMessage(coloredMessage);
    }

}
