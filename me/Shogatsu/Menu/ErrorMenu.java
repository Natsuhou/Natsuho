package me.Shogatsu.Menu;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;

public class ErrorMenu {
    private EmbedBuilder builder;
    private MessageChannel channel;
    private User user;
    public ErrorMenu(User user, MessageChannel channel) {
        this.builder = new EmbedBuilder();
        this.user = user;
        this.channel = channel;
    }
    public EmbedBuilder invalidAccount() {
        return builder
                .setColor(Color.red)
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setTitle("Invalid Account!")
                .setDescription("Account is either a fake account or is a bot");
    }
    public EmbedBuilder noArgs(String args) {
        return builder
                .setColor(Color.red)
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setTitle("Invalid Arguements!")
                .setDescription(args);
    }
    public EmbedBuilder notEnoughCurrency() {
        return builder
                .setColor(Color.red)
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setTitle(":peanuts: Not Enough Peanuts!")
                .setDescription("This purchase requires more peanuts!");
    }
    public EmbedBuilder userDoesNotExist() {
        return builder
                .setColor(Color.red)
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setTitle(":x: User Does Not Exist!")
                .setDescription(user.getName() + " does not have an account!");
    }
}
