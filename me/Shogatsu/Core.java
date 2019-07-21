package me.Shogatsu;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.Shogatsu.Account.UpdateAccount;
import me.Shogatsu.Commands.ServerInfo;
import me.Shogatsu.Commands.Shutdown;
import me.Shogatsu.Commands.WhoIs;
import me.Shogatsu.Music.Play;
import me.Shogatsu.Music.Skip;
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
                    .setHelpWord("h")
                    .setPrefix("'")
                    .setGame(Game.playing("Type 'help for info!"))
                    .addCommands(
                            //Commands
                            new ServerInfo(),
                            new Shutdown(),
                            new WhoIs(),
                            //Account
                            new UpdateAccount(),
                            //Music
                            new Play(),
                            new Skip()
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