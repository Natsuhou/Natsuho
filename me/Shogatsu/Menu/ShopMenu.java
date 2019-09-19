package me.Shogatsu.Menu;

import me.Shogatsu.Managers.GameManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class ShopMenu {
    private EmbedBuilder builder;
    private User user;
    private MessageChannel channel;
    public ShopMenu(User u, MessageChannel c) {
        //Color Theme: White
        this.builder = new EmbedBuilder().setColor(Color.white);
        this.user = u;
        this.channel = c;
    }
    public EmbedBuilder shopMenu() {
        GameManager manager = new GameManager();
        String balance = Integer.toString(manager.getCurrency(user, channel));
        return builder
                .setTitle(":egg: Egg Exchange")
                .setAuthor(user.getName(), user.getAvatarUrl())
                .setDescription("Buy something using your eggs")
                .addField(":hatching_chick: Hatchery", "+", true)
                .addField(":truck: Delivery", "+60 productivity", true)
                .setFooter("Balance: $" + balance, "https://i.imgur.com/6HZJuZ5.png");
    }
    public EmbedBuilder endPurchase(String purchaseName, int amount) {
        GameManager manager = new GameManager();
        String balance = Integer.toString(manager.getCurrency(user, channel));
        return builder
                .setTitle(":shopping_cart: " + purchaseName + " has been bought")
                .setAuthor(user.getName(), user.getAvatarUrl())
                .setFooter("Balance: $" + balance, "https://i.imgur.com/6HZJuZ5.png");
    }
    public EmbedBuilder confirmPurchase() {
        return builder
                .setTitle(":egg: Egg Exchange")
                .setDescription("Confirm your purchase by reacting with a checkmark")
                .setAuthor(user.getName(), user.getAvatarUrl());
    }
}
