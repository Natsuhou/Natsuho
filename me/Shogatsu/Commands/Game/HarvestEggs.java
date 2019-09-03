package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.GameMenu;
import me.Shogatsu.Menu.ErrorMenu;
import org.jetbrains.annotations.NotNull;

@CommandInfo(
        name = "Harvest currency",
        description = "The way the user generates currency"
)
public class HarvestEggs extends Command {
    public HarvestEggs() {
        this.name = "harvest";
        this.help = "Harvest loot and stuff";
        this.aliases = new String[] {"h"};
        this.cooldown = 50;
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            int amount = 10;
            GameManager manager = new GameManager();
            GameMenu menu = new GameMenu(e.getAuthor(), e.getChannel());
            manager.addCurrency(e.getAuthor(), amount, e.getChannel());
            e.reply(menu.updateEggMenu(amount).build());
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.userDoesNotExist().build());
        }
    }
}
