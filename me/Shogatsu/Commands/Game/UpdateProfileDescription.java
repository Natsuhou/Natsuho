package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.UpdateMenu;
import org.jetbrains.annotations.NotNull;

@CommandInfo(
        name = "Change description",
        description = "Change your profile description"
)
public class UpdateProfileDescription extends Command {
    public UpdateProfileDescription() {
        this.name = "cd";
        this.cooldown = 5;
        this.cooldownScope = CooldownScope.USER;
        this.help = "Used to change your profile description!";
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        ErrorMenu error = new ErrorMenu(e.getAuthor());

        if (e.getArgs().isEmpty()) {
            e.reply(error.noArgs("Please specify a description!").build());
        } else if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            AccountManager manager = new AccountManager();
            UpdateMenu update = new UpdateMenu(e);

            manager.setDescription(e.getAuthor(), e.getArgs(), e.getChannel());
            e.reply(update.updateDescriptionMenu().build());
        } else {
            e.reply(error.invalidAccount().build());
        }
    }
}
