package com.Shogatsu;

import com.Shogatsu.commands.CreateAccount;
import com.Shogatsu.commands.Debug;
import com.Shogatsu.commands.Incomplete.ServerInfo;
import com.Shogatsu.commands.Incomplete.WhoIs;
import com.Shogatsu.commands.Shutdown;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class BotCore extends ListenerAdapter {
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
      String token = "NTgyNTA3MTc1MjAxNzM0NjU2.XOu0LQ.LzXguFKMVHqyJesSKqiD8vkqXHc";

      // Command Client Builder (https://github.com/jagrosh)
      CommandClientBuilder builder = new CommandClientBuilder()
          .setOwnerId("381773847357161482")
          .setPrefix("'")
          .setHelpWord("help")
          .setGame(Game.playing("congrats class of 2019!"))
          .addCommands(
                  new Debug(),
                  new ServerInfo(),
                  new Shutdown(),
                  new WhoIs(),
                  new CreateAccount()
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
