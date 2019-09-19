package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.ErrorMenu;
import org.jetbrains.annotations.NotNull;

@CommandInfo(
        name = "Create account",
        description = "Manual account creation"
)
public class CreateAccount extends Command {
    public CreateAccount() {
        this.name = "create";
        this.cooldown = 50;
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        GameManager manager = new GameManager();
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            if (!manager.hasAccount(e.getAuthor())) {
                manager.manageUser(e.getAuthor());
            } else {
                ErrorMenu error = new ErrorMenu(e.getAuthor());
                e.reply(error.hasAccount().build());
            }
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.userDoesNotExist().build());
        }
    }
}
