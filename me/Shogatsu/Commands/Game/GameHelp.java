package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.HelpMenu;

public class GameHelp extends Command {
    public GameHelp() {
        this.name = "eh";
        this.help = "Displays the help menu for the game commands";
        this.cooldown = 10;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            HelpMenu helpMenu = new HelpMenu(e.getAuthor());
            e.reply(helpMenu.GameHelp().build());
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
