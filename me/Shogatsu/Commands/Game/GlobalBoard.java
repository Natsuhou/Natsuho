package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Menu.ErrorMenu;

public class GlobalBoard extends Command {
    public GlobalBoard() {
        this.name = "top";
        this.aliases = new String[] {"lb", "leaderboard"};
        this.help = "Displays the top global farms";
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {

        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
