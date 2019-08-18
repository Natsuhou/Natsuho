package me.Shogatsu.Commands.General;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;

import me.Shogatsu.Menu.AccountMenu;
import me.Shogatsu.Menu.ErrorMenu;

@CommandInfo(
        name = "Whois",
        description = "Displays user information such as: time joined, online status etc"
)
public class WhoIs extends Command {
    public WhoIs() {
        this.name = "whois";
        this.help = "Displays user information";
        this.aliases = new String[] {"userinfo", "who"};
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (e.getArgs().isEmpty()) {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.noArgs("Please provide a name! Type 'whois @UserName").build());
        } else {
            try {
                AccountMenu account = new AccountMenu(e.getAuthor(), e.getChannel());
                e.reply(account.whoIsMenu(e.getMessage()).build());
            } catch (IndexOutOfBoundsException exception) {
                ErrorMenu error = new ErrorMenu(e.getAuthor());
                e.reply(error.indexOutBounds("Please reformat command as: 'whois @Username").build());
            }
        }
    }
}
