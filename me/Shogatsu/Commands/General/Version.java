package me.Shogatsu.Commands.General;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Menu.GeneralMenu;

@CommandInfo(
        name = "Version",
        description = "Displays the version of the bot"
)
public class Version extends Command {
    public Version() {
        this.name = "version";
        this.aliases = new String[] {"v", "ver"};
        this.cooldown = 20;
    }
    @Override
    protected void execute(CommandEvent e) {
        GeneralMenu general = new GeneralMenu(e.getAuthor());
        e.reply(general.versionMenu("0.9.1-BETA").build());
    }
}
