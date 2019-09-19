package me.Shogatsu.Commands.General;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.GeneralMenu;

@CommandInfo(
        name = "Version",
        description = "Displays the version of the bot"
)
public class Version extends Command {
    public Version() {
        this.name = "ver";
        this.aliases = new String[] {"version", "v"};
        this.cooldown = 20;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            GeneralMenu general = new GeneralMenu(e.getAuthor());
            e.reply(general.version("1.0.5").build());
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            e.reply(error.invalidAccount().build());
        }
    }
}
