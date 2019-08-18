package me.Shogatsu.Menu;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class AuthMenu {
    private EmbedBuilder builder;
    private User user;
    @Contract(pure = true)
    public AuthMenu(User user) {
        this.builder = new EmbedBuilder();
        this.user = user;
    }
    //This should be set to change
    public EmbedBuilder startupMessage(@NotNull Guild guild) {
        return builder
                .setColor(Color.yellow)
                .setThumbnail(guild.getIconUrl())
                .setTitle("Welcome to " + guild.getName() + "!")
                .setDescription("We hope you stay for a long time!")
                .setFooter("Type 'help for help!", null);
    }
    public EmbedBuilder verificationMenu() {
        return builder
                .setTitle(":shield: Verification")
                .setThumbnail(user.getAvatarUrl())
                .setColor(Color.yellow)
                .setDescription("Please authenticate your account by reacting to this message!");
    }
    public EmbedBuilder verificationSuccess(@NotNull Guild guild) {
        return builder
            .setTitle(":shield: Verify ")
            .setThumbnail(user.getAvatarUrl())
            .setColor(Color.green)
            .setDescription("Account has been verified! You now have default access to " + guild.getName());
    }
    public EmbedBuilder authTimeout() {
        return builder
                .setTitle(":shield: Verify")
                .setThumbnail(user.getAvatarUrl())
                .setColor(Color.red)
                .setDescription("Account verification has failed! Please re-authenticate or ask for help!");
    }
}
