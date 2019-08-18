package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.ErrorMenu;
import org.jetbrains.annotations.NotNull;

@CommandInfo(
        name = "Create account",
        description = "Manual account creation in mongoDB"
)
public class CreateAccount extends Command {
    public CreateAccount() {
        this.name = "create";
        this.cooldown = 50000;
        this.help = "Create a new account";
        this.aliases = new String[] {"ca"};
    }

    @Override
    protected void execute(@NotNull CommandEvent e) {
        AccountManager manager = new AccountManager();

        if (!manager.hasAccount(e.getAuthor())) {
            manager.manageUser(e.getAuthor(), e.getChannel());
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.userDoesNotExist().build());
        }
    }
}
