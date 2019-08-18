package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.UpdateMenu;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

@CommandInfo(
        name = "Harvest currency",
        description = "The way the user generates currency"
)
public class Harvest extends Command {
    public Harvest() {
        this.name = "harvest";
        this.help = "Harvest loot and stuff";
        this.aliases = new String[] {"roll", "rd"};
        this.cooldown = 50;
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        //ThreadLocalRandom random = new ThreadLocalRandom();
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            int rtd = (int) (Math.random() + 10);
            AccountManager manager = new AccountManager();
            UpdateMenu update = new UpdateMenu(e);
            manager.addCurrency(e.getAuthor(), rtd, e.getChannel());
            e.reply(update.updateCurrencyMenu(rtd).build());
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.userDoesNotExist().build());
        }
    }
}
