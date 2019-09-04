package me.Shogatsu.Menu;

import me.Shogatsu.Managers.GameManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;


public class GameMenu {
    private GameManager manager;
    private EmbedBuilder builder;
    private User user;
    private MessageChannel channel;
    public GameMenu(User u, MessageChannel c) {
        //Color Theme: Green
        this.builder = new EmbedBuilder().setColor(Color.green);
        this.user = u;
        this.channel = c;
    }
    //Used when user creates a new account
    public EmbedBuilder createAccountMenu() {
        return builder
                .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                .setAuthor("Account has been created!", null, user.getAvatarUrl())
                .setDescription("Please have fun and have a good day!")
                .setFooter("Need some help? Do 'help for more info!", null);
    }
    //Displays user profile
    public EmbedBuilder accountMenu() {
        manager = new GameManager();
        String currency = Integer.toString(manager.getCurrency(user, channel));
        //String farmValue = Integer.toString(manager.getFarmValue(user, channel));
        //String tokens = Integer.toString(manager.getTokens(user, channel));

        return builder
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setTitle("Player Profile")
                .setDescription(manager.getDescription(user, channel))
                .addField(":large_orange_diamond:Tokens", "15", true)
                .setFooter("Balance: $" + currency, "https://i.imgur.com/6HZJuZ5.png");
    }
    //Executed when user changes their profile description
    public EmbedBuilder setDescriptionMenu() {
        return builder
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setTitle(":bulb:Account Update")
                .setDescription("User description has been updated");
    }
    //Executed when user gets obtains currency
    public EmbedBuilder updateEggMenu(int amount) {
        manager = new GameManager();
        String currency = Integer.toString(manager.getCurrency(user, channel));
        return builder
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setTitle(":bulb:Account Update")
                .setDescription(":egg: " + amount + " has been added to your account")
                .setFooter("Balance: $" + currency, "https://i.imgur.com/6HZJuZ5.png");
    }
    //Displays users current farm
    public EmbedBuilder farmMenu() {
        manager = new GameManager();
        return builder
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setImage("")
                .setFooter("Total Farm Value: " + "50000", null);
    }
}
