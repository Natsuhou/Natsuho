package me.Shogatsu;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import me.Shogatsu.Commands.Game.*;
import me.Shogatsu.Commands.Game.Shop;
import me.Shogatsu.Commands.General.ServerInfo;
import me.Shogatsu.Commands.General.Version;
import me.Shogatsu.Commands.General.WhoIs;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Core extends ListenerAdapter {
    public static void main(String[] args) {
        final String cat = "";
        EventWaiter waiter = new EventWaiter();
        try {
            CommandClientBuilder builder = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setHelpWord("help")
                    .setPrefix("'")
                    .setActivity(Activity.watching("the world"))
                    .addCommands(
                            //General
                            new ServerInfo(),
                            new WhoIs(),
                            new Version(),
                            //Game
                            new ChangeProfileDescription(),
                            new DisplayProfile(),
                            new HarvestEggs(),
                            new CreateAccount(),
                            new Shop(waiter),
                            new DisplayFarm()
                    );
            new JDABuilder(AccountType.BOT)
                    .setToken(cat)
                    .setStatus(OnlineStatus.ONLINE)
                    .addEventListeners(builder.build(), waiter)
                    .build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}