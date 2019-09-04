package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.GameMenu;
import me.Shogatsu.Menu.ErrorMenu;
import org.jetbrains.annotations.NotNull;

@CommandInfo(
        name = "Change description",
        description = "Change your profile description"
)
public class ChangeProfileDescription extends Command {
    public ChangeProfileDescription() {
        this.name = "cd";
        this.cooldown = 5;
        this.help = "Used to change your profile description!";
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
        if (e.getArgs().isEmpty()) {
            e.reply(errorMenu.invalidArgs("Please specify a description!").build());
        } else if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            GameManager manager = new GameManager();
            GameMenu menu = new GameMenu(e.getAuthor(), e.getChannel());

            manager.setDescription(e.getAuthor(), e.getArgs(), e.getChannel());
            e.reply(menu.setDescriptionMenu().build());
        } else {
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
