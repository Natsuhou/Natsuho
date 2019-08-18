package me.Shogatsu.Managers;

import me.Shogatsu.Menu.AuthMenu;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AuthManager {
    private User user;
    @Contract(pure = true)
    public AuthManager(User user) {
        this.user = user;
    }
    @NotNull
    private String generateAuthCode() {
        StringBuilder sb = new StringBuilder();
        String authElements = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+=-[]/*";

        int count = 7;

        while (count-- != 0) {
            int character = (int) (Math.random()*authElements.length());
            sb.append(authElements.charAt(character));
        }
        return sb.toString();
    }
    public void messageAuth() {
        AuthMenu menu = new AuthMenu(user);
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(menu.verificationMenu().build()).queue());
    }
    public void authSuccess(Guild guild) {
        AuthMenu menu = new AuthMenu(user);
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(menu.verificationSuccess(guild).build()).queue());
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(menu.startupMessage(guild).build()).queue());
    }
    public void authError() {
        AuthMenu menu = new AuthMenu(user);
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(menu.authTimeout().build()).queue());
    }
}
