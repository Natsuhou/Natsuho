package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.GameMenu;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

@CommandInfo(
        name = "Profile",
        description = "Displays the account information"
)
public class DisplayProfile extends Command {
    public DisplayProfile() {
        this.name = "profile";
        this.help = "Displays account information";
        this.aliases = new String[] {"me"};
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        GameMenu gameMenu;
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake() && e.getArgs().isEmpty()) {
            gameMenu = new GameMenu(e.getAuthor(), e.getChannel());
            e.reply(gameMenu.account().build());
        } else if (!e.getArgs().isEmpty()) {
            try {
                GameManager gameManager = new GameManager();
                User mentionedUser = e.getMessage().getMentionedUsers().get(0);
                if (gameManager.hasAccount(mentionedUser)) {
                    gameMenu = new GameMenu(mentionedUser, e.getChannel());
                    e.reply(gameMenu.account().build());
                } else {
                    ErrorMenu errorMenu = new ErrorMenu(mentionedUser);
                    e.reply(errorMenu.userDoesNotExist().build());
                }
            } catch (IndexOutOfBoundsException exception) {
                ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
                e.reply(errorMenu.invalidArgs("Please reformat mention as @Username").build());
            }
        }
    }
}
