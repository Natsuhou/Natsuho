package me.Shogatsu.Commands.General.Memes;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Menu.ErrorMenu;

@CommandInfo(
        name = "Add Meme",
        description = "Stores memes in a mongodb and is displayed via embed"
)
public class AddMeme extends Command {
    public AddMeme() {
        this.name = "am";
        this.cooldown = 25;
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
