package me.Shogatsu.Commands.Account;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.AccountMenu;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.UpdateMenu;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class UpdateDescription extends Command {
    public UpdateDescription() {
        this.name = "cd";
        this.cooldown = 5;
        this.cooldownScope = CooldownScope.USER;
        this.help = "Used to change your profile description!";
    }
    @Override
    protected void execute(CommandEvent e) {
        ErrorMenu error = new ErrorMenu(e.getAuthor(), e.getChannel());

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
