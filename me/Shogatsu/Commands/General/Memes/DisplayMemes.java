package me.Shogatsu.Commands.General.Memes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Menu.ErrorMenu;

@CommandInfo(
        name = "Display Memes",
        description = "UUID is guildId stored in mongdb and info displayed via embed"
)
public class DisplayMemes extends Command {
    public DisplayMemes() {
        this.name = "dm";
        this.help = "Show what memes you have stored";
        this.cooldown = 10;
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {

        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
