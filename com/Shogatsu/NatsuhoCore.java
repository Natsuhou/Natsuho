package com.Shogatsu;

import com.Shogatsu.commands.Incomplete.CreateAccount;
import com.Shogatsu.commands.Live.Demo;
import com.Shogatsu.commands.Live.ChangeName;
import com.Shogatsu.commands.Live.ServerInfo;
import com.Shogatsu.commands.Live.MusicCommands.Play;
import com.Shogatsu.commands.Live.WhoIs;
import com.Shogatsu.commands.Live.Shutdown;
import com.Shogatsu.commands.Live.MusicCommands.Skip;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Random;

public class NatsuhoCore extends ListenerAdapter {
  public static void main(String[] args) {
    // Idk what this is at the moment
    EventWaiter waiter = new EventWaiter();

    try {
      // Configuration File
      /*
      List<String> config = Files.readAllLines(Paths.get("config.txt"));

      String token = config.get(0);

      String ownerId = config.get(1);
      */
      String[] startupMsg = {
              "pp-lease be kind to me!", "sorry if I do something wrong!", "do 'help for more!",
              "please be patient!"
      };
      Random random = new Random();
      int rng = random.nextInt(startupMsg.length);

      String token = "NTgyNTA3MTc1MjAxNzM0NjU2.XOu0LQ.LzXguFKMVHqyJesSKqiD8vkqXHc";

      // Command Client Builder (https://github.com/jagrosh)
      CommandClientBuilder builder = new CommandClientBuilder()
          .setOwnerId("381773847357161482")
          .setPrefix("'")
          .setHelpWord("help")
          .setGame(Game.playing(startupMsg[rng]))
          .addCommands(
                  //General Server Commands
                  new Demo(),
                  new ServerInfo(),
                  new Shutdown(),
                  new WhoIs(),
                  //Game
                  new CreateAccount(),
                  new ChangeName(),
                  //Natsuho Music
                  new Play(),
                  new Skip()
          );

      //CommandClient client = builder.build();

      new JDABuilder(AccountType.BOT)
          // Bot Token
          .setToken(token)
          // Bot Status
          .setStatus(OnlineStatus.ONLINE)

          // Event Listeners
          .addEventListener(waiter)
          .addEventListener(builder.build())
          .build();

    } catch (LoginException e) {
      e.printStackTrace();
    }
  }
}
