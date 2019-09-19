package me.Shogatsu.Commands.Main;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.HelpMenu;

public class MainHelp extends Command {
    public MainHelp() {
        this.name = "h";
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            HelpMenu helpMenu = new HelpMenu(e.getAuthor());
            e.reply(helpMenu.mainHelp().build());
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
