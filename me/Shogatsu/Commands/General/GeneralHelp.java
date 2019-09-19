package me.Shogatsu.Commands.General;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.HelpMenu;

@CommandInfo(
        name = "General Help",
        description = "Displays the help menu for the general commands"
)
public class GeneralHelp extends Command {
    public GeneralHelp() {
        this.name = "gh";
        this.help = "Displays the help menu for the general commands";
        this.cooldown = 10;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            HelpMenu helpMenu = new HelpMenu(e.getAuthor());
            e.reply(helpMenu.GeneralHelp().build());
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
