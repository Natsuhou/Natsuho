package me.Shogatsu.Managers;

import me.Shogatsu.Menu.AuthMenu;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import org.jetbrains.annotations.Contract;

public class AuthManager {
    private User user;
    @Contract(pure = true)
    public AuthManager(User user) {
        this.user = user;
    }
    public void messageAuth() {
        AuthMenu menu = new AuthMenu(user);
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(menu.verificationMenu().build()).queue());
    }
    public void authSuccess(Guild guild) {
        AuthMenu menu = new AuthMenu(user);
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(menu.verificationSuccess(guild).build()).queue());
        user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(menu.startupMessage(guild).build()).queue());
        //Set the user to the default role
    }
}
