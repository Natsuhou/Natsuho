package me.Shogatsu.Menu;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import org.jetbrains.annotations.Contract;
import java.awt.*;

public class ErrorMenu {
    private EmbedBuilder builder;
    private User user;
    @Contract(pure = true)
    public ErrorMenu(User u) {
        //Color Theme: Red
        this.user = u;
        this.builder = new EmbedBuilder()
                .setColor(Color.red)
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setFooter("Type 'help for more info!", null);
    }
    public EmbedBuilder invalidAccount() {
        return builder
                .setTitle(":x: Invalid Account!")
                .setDescription("Account is either a fake account or is a bot");
    }
    public EmbedBuilder noArgs(String args) {
        return builder
                .setTitle(":x: Invalid Arguments!")
                .setDescription(args);
    }
    public EmbedBuilder notEnoughCurrency(String currencyName) {
        return builder
                .setTitle(":x: Insufficient " + currencyName)
                .setDescription("Purchase requires more " + currencyName);
    }
    public EmbedBuilder userDoesNotExist() {
        return builder
                .setTitle(":x: Account Error")
                .setDescription(user.getName() + " does not have an account!");
    }
    public EmbedBuilder indexOutBounds(String args) {
        return builder
                .setTitle(":x: Index Out of Bounds!")
                .setDescription(args);
    }
    public EmbedBuilder hasAccount() {
        return builder
                .setTitle(":x: Account Already Exists!")
                .setDescription("User already has an account");
    }
}
