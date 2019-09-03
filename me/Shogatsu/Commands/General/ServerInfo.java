package me.Shogatsu.Commands.General;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.GeneralManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.GeneralMenu;
import org.jetbrains.annotations.NotNull;

@CommandInfo(
        name = "Server info",
        description = "Displays guild's owner, region and members"
)

public class ServerInfo extends Command {
    public ServerInfo() {
        this.name = "sinfo";
        this.aliases = new String[] {"sInfo", "serverInfo"};
        this.help = "Returns information about the server";
        this.cooldown = 5;
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            GeneralMenu generalMenu = new GeneralMenu(e.getAuthor());
            e.reply(generalMenu.serverInfoMenu(e.getGuild()).build());
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.invalidAccount().build());
        }
    }
}

