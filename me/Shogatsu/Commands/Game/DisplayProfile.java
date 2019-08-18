package me.Shogatsu.Commands.Game;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.AccountMenu;
import me.Shogatsu.Menu.ErrorMenu;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@CommandInfo(
        name = "Account info",
        description = "Displays the account information"
)
public class DisplayProfile extends Command {
    public DisplayProfile() {
        this.name = "me";
        this.help = "Displays account information";
        this.aliases = new String[] {"profile"};
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        AccountMenu menu;
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake() && e.getArgs().isEmpty()) {
            menu = new AccountMenu(e.getAuthor(), e.getChannel());
            e.reply(menu.accountMenu().build());
        } else if (!e.getArgs().isEmpty()) {
            List<Member> mentionedUser = e.getMessage().getMentionedMembers();
            e.getMember().getVoiceState().inVoiceChannel();
            for (Member m : mentionedUser) {
                User user = m.getUser();
                if (user != null) {
                    menu = new AccountMenu(user, e.getChannel());
                    AccountManager manager = new AccountManager();
                    if (manager.hasAccount(user)) {
                        e.reply(menu.accountMenu().build());
                    } else {
                        ErrorMenu error = new ErrorMenu(user);
                        e.reply(error.userDoesNotExist().build());
                    }
                }
            }
        }
    }
}
