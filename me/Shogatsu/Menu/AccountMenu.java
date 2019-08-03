package me.Shogatsu.Menu;

import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Managers.AccountManager;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;

public class AccountMenu {
    private AccountManager manager;
    private EmbedBuilder builder;
    private User user;
    private MessageChannel channel;
    public AccountMenu(User user, MessageChannel messageChannel) {
        manager = new AccountManager();
        builder = new EmbedBuilder();
        this.user = user;
        this.channel = messageChannel;
    }
    public EmbedBuilder createAccountMenu() {
        return builder
                .setColor(Color.green)
                .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                .setAuthor("Account has been successfully created!", null, user.getAvatarUrl())
                .setDescription("Please have fun and don't forget to vote for free rewards!")
                .setFooter("Need some help? Do 'help for more info!", null);
    }
    public EmbedBuilder accountMenu() {
        String currency = Integer.toString(manager.getCurrency(user, channel));
        return builder
                .setColor(Color.yellow)
                .setTitle("Account Profile")
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setDescription(manager.getDescription(user, channel))
                .addField(":peanuts:  " + currency, "", true)
                .addField(":coffee:  " + "amount", "",true)
                .setFooter("ID: " + user.getAsTag(), null);
    }
    public EmbedBuilder shopMenu(CommandEvent e) {
        return builder;
    }
}
