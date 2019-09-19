package me.Shogatsu;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import me.Shogatsu.Commands.Game.*;
import me.Shogatsu.Commands.Game.Shop.Shop;
import me.Shogatsu.Commands.General.GeneralHelp;
import me.Shogatsu.Commands.General.ServerInfo;
import me.Shogatsu.Commands.General.Version;
import me.Shogatsu.Commands.General.WhoIs;
import me.Shogatsu.Commands.LeagueOfLegends.LeagueHelp;
import me.Shogatsu.Commands.LeagueOfLegends.Lol;
import me.Shogatsu.Commands.Main.MainHelp;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Core extends ListenerAdapter {
    public static void main(String[] args) {
        final String wow = "";
        EventWaiter waiter = new EventWaiter();
        try {
            CommandClientBuilder builder = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setPrefix("'")
                    .setActivity(Activity.watching("the world"))
                    .addCommands(
                            //Main Help Command
                            new MainHelp(),
                            //General
                            new GeneralHelp(),
                            new ServerInfo(),
                            new WhoIs(),
                            new Version(),
                            //Game
                            new GameHelp(),
                            new ChangeProfileDescription(),
                            new DisplayProfile(),
                            new HarvestEggs(),
                            new CreateAccount(),
                            new Shop(waiter),
                            new DisplayFarm(),
                            //League of Legends
                            new LeagueHelp(),
                            new Lol()
                    );
            new JDABuilder(AccountType.BOT)
                    .setToken(wow)
                    .setStatus(OnlineStatus.ONLINE)
                    .addEventListeners(builder.build(), waiter)
                    .build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}