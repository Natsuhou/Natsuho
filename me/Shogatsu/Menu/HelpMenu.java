package me.Shogatsu.Menu;

import me.Shogatsu.Commands.Game.CreateAccount;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class HelpMenu {
    private EmbedBuilder builder;
    public HelpMenu(@NotNull User u) {
        this.builder = new EmbedBuilder()
                .setAuthor(u.getName(), u.getAvatarUrl())
                .setColor(Color.orange)
                .setFooter("Type 'help to navigate back to main help menu");
    }
    public EmbedBuilder mainHelp() {
        return builder
                .setTitle("Help Menu")
                .setDescription("Main menu for all command information")
                .addField("'lh", "Displays info on League of Legends commands", true)
                .addField("'eh", "Displays info on custom game commands", true)
                .addField("'gh", "Displays info on general server commands", true);
    }
    public EmbedBuilder LeagueHelp() {
        return builder
                .setTitle("League Help")
                .setDescription("Command info for League of Legends commands")
                .addField("'ss (League Username)", "arguments", true);
    }
    public EmbedBuilder GeneralHelp() {
        return builder
                .setTitle("General Help")
                .setDescription("Command info for general commands")
                .addField("'sinfo", "Displays general info about the current guild you're in", true)
                .addField("'version", "Displays the current bots version for some reason", true)
                .addField("'whois @User", "Displays general information on the player specified", true);
    }
    public EmbedBuilder GameHelp() {
        return builder
                .setTitle("Game Help")
                .setDescription("Command info for game commands");
    }
}
