package me.Shogatsu.Commands.Game;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.GameMenu;
import me.Shogatsu.Menu.ErrorMenu;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
            e.reply(gameMenu.accountMenu().build());
        } else if (!e.getArgs().isEmpty()) {
            List<Member> mentionedUser = e.getMessage().getMentionedMembers();
            Member mentioned = e.getMessage().getMentionedMembers().get(0);
        }
    }
}
