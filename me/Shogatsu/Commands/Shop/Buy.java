package me.Shogatsu.Commands.Shop;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.menu.Menu;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.ShopMenu;
import me.Shogatsu.Menu.UpdateMenu;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public class Buy extends Command {
    public Buy() {
        this.name = "b";
        this.aliases = new String[] {"buy", "purchase"};
    }

    @Override
    protected void execute(CommandEvent e) {
        AccountManager manager = new AccountManager();
        ErrorMenu error = new ErrorMenu(e.getAuthor());

        if (e.getAuthor().isFake() && e.getAuthor().isBot()) {
            e.reply(error.invalidAccount().build());
        } else if (e.getArgs().isEmpty()) {
            e.reply(error.noArgs("Please enter an item from the shop!").build());
        }
        switch (e.getArgs()) {
            case "example1":
                int a1 = -15;
                UpdateMenu u1 = new UpdateMenu(e);
                e.reply(u1.removeCurrencyMenu(a1).build());
                manager.minusCurrency(e.getAuthor(), a1, e.getChannel());
            case "example2":
                int a2 = -15;
                UpdateMenu u2 = new UpdateMenu(e);
                e.reply(u2.removeCurrencyMenu(a2).build());
                manager.minusCurrency(e.getAuthor(), a2, e.getChannel());
        }

    }
}
