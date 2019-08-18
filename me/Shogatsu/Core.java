package me.Shogatsu;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.Shogatsu.Commands.Game.DisplayProfile;
import me.Shogatsu.Commands.Game.CreateAccount;
import me.Shogatsu.Commands.Game.UpdateProfileDescription;
import me.Shogatsu.Commands.Game.Harvest;
import me.Shogatsu.Commands.General.ServerInfo;
import me.Shogatsu.Commands.General.WhoIs;
import me.Shogatsu.Commands.Music.Play;
import me.Shogatsu.Commands.Shop.Buy;
import me.Shogatsu.Verification.GuildJoin;
import me.Shogatsu.Verification.ReactAuthentication;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Core extends ListenerAdapter {
    private String authenticationToken;
    private Guild guild;
    public static void main(String[] args) {
        final String cat = "";
        try {
            CommandClientBuilder builder = new CommandClientBuilder()
                    .setOwnerId("381773847357161482")
                    .setHelpWord("help")
                    .setPrefix("'")
                    .setGame(Game.playing("Type 'help for info!"))
                    .addCommands(
                            //Commands
                            new ServerInfo(),
                            new WhoIs(),
                            //Game
                            new UpdateProfileDescription(),
                            new DisplayProfile(),
                            new Harvest(),
                            new CreateAccount(),
                            new Buy(),
                            //Music
                            new Play()
                            //Account authentication
                    );
            new JDABuilder(AccountType.BOT)
                    .setToken(cat)
                    .setStatus(OnlineStatus.ONLINE)
                    .addEventListener(builder.build(), new GuildJoin(), new ReactAuthentication())
                    .build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}