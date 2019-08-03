package me.Shogatsu;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.Shogatsu.Commands.Account.AccountInfo;
import me.Shogatsu.Commands.Account.UpdateDescription;
import me.Shogatsu.Commands.Account.Harvest;
import me.Shogatsu.Commands.General.ServerInfo;
import me.Shogatsu.Commands.General.Shutdown;
import me.Shogatsu.Commands.General.WhoIs;
import me.Shogatsu.Commands.Music.Play;
import me.Shogatsu.Commands.Shop.Buy;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Core extends ListenerAdapter {
    public static void main(String[] args) {
        final String cat = "";
        try {
            CommandClientBuilder natsuho = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setHelpWord("help")
                    .setPrefix("'")
                    .setGame(Game.playing("Type 'help for info!"))
                    .addCommands(
                            //Commands
                            new ServerInfo(),
                            new Shutdown(),
                            new WhoIs(),
                            //Account
                            new UpdateDescription(),
                            new AccountInfo(),
                            new Harvest(),
                            new Buy(),
                            new Play()
                    );
            new JDABuilder(AccountType.BOT)
                    .setToken(cat)
                    .setStatus(OnlineStatus.ONLINE)
                    .addEventListener(natsuho.build())
                    .build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}