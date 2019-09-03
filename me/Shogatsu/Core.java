package me.Shogatsu;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import me.Shogatsu.Commands.Game.*;
import me.Shogatsu.Commands.Game.Shop;
import me.Shogatsu.Commands.General.ServerInfo;
import me.Shogatsu.Commands.General.Version;
import me.Shogatsu.Commands.General.WhoIs;
import me.Shogatsu.Commands.Music.Play;
import me.Shogatsu.Verification.GuildJoin;
import me.Shogatsu.Verification.Authentication;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Core extends ListenerAdapter {
    public static void main(String[] args) {
        final String cat = "";
        EventWaiter waiter = new EventWaiter();
        try {
            CommandClientBuilder builder = new CommandClientBuilder()
                    .setOwnerId("")
                    .setHelpWord("help")
                    .setPrefix("'")
                    .setGame(Game.watching("the world"))
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
                            new Shop(),
                            new DisplayFarm(),
                            //Music
                            new Play()
                    );
            new JDABuilder(AccountType.BOT)
                    .setToken(cat)
                    .setStatus(OnlineStatus.ONLINE)
                    .addEventListener(builder.build(), new GuildJoin(), new Authentication())
                    .build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}