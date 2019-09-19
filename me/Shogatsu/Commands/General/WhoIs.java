package me.Shogatsu.Commands.General;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;

import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.GeneralMenu;

@CommandInfo(
        name = "Whois",
        description = "Displays user information such as: time joined, online status etc"
)
public class WhoIs extends Command {
    public WhoIs() {
        this.name = "whois";
        this.aliases = new String[] {"userinfo", "who"};
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (e.getArgs().isEmpty()) {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.invalidArgs("Please provide a name!").build());
        } else {
            try {
                GeneralMenu general = new GeneralMenu(e.getAuthor());
                e.reply(general.whoIs(e.getMessage()).build());
            } catch (IndexOutOfBoundsException exception) {
                ErrorMenu error = new ErrorMenu(e.getAuthor());
                e.reply(error.invalidArgs("Please reformat command as: 'whois @Username").build());
            }
        }
    }
}
