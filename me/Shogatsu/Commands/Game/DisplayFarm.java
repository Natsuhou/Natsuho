package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.GameMenu;
import net.dv8tion.jda.core.entities.User;

import java.util.Map;

public class DisplayFarm extends Command {
    public DisplayFarm() {
        this.name = "farm";
        this.help = "Displays information about a user's farm";
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            GameMenu game = new GameMenu(e.getAuthor(), e.getChannel());
        } else {

        }
    }
}
