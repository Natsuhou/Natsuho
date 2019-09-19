package me.Shogatsu.Commands.LeagueOfLegends;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.HelpMenu;

public class LeagueHelp extends Command {
    public LeagueHelp() {
        this.name = "lh";
        this.help = "Displays the help menu for the league commands";
        this.cooldown = 15;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            HelpMenu helpMenu = new HelpMenu(e.getAuthor());
            e.reply(helpMenu.LeagueHelp().build());
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
