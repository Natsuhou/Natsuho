package me.Shogatsu.Commands.Account;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.AccountMenu;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.UpdateMenu;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class Harvest extends Command {
    public Harvest() {
        this.name = "harvest";
        this.aliases = new String[] {"roll", "rd"};
        this.cooldown = 10000;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            int rtd = (int) (Math.random() + 10);
            AccountManager manager = new AccountManager();
            UpdateMenu update = new UpdateMenu(e);
            manager.addCurrency(e.getAuthor(), rtd, e.getChannel());
            update.updateCurrencyMenu(rtd);
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor(), e.getChannel());
            e.reply(error.userDoesNotExist().build());
        }
    }
}
