package me.Shogatsu.Menu;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class UpdateMenu {
    private EmbedBuilder builder;
    private String userName;
    private String userURL;

    public UpdateMenu(CommandEvent e) {
        this.builder = new EmbedBuilder();
        this.userName = e.getAuthor().getName();
        this.userURL = e.getAuthor().getAvatarUrl();
    }
    public EmbedBuilder updateDescriptionMenu() {
        return builder
                .setColor(Color.yellow)
                .setTitle("Account Update")
                .setAuthor(userName, null, userURL)
                .setDescription("User description has been updated");
    }
    public EmbedBuilder updateCurrencyMenu(int amount) {
        return builder
                .setColor(Color.orange)
                .setTitle(":peanuts: Peanut Harvester")
                .setAuthor( amount + " peanuts have been harvested!", null, userURL)
                .setThumbnail("https://i.imgur.com/yZS5RyO.png");
    }
    public EmbedBuilder removeCurrencyMenu(int amount) {
        return builder
                .setColor(Color.orange)
                .setTitle(":peanuts: Item Successfully Purchased")
                .setAuthor(amount + " peanuts has been removed from your account", null, userURL);
    }
}
