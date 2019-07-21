package me.Shogatsu.Music;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.managers.AudioManager;

public class Play extends Command {
    Music natsuho;
    Guild guild;
    EmbedBuilder error;
    AudioManager manager;
    public Play() {
        this.name = "play";
        this.help = "Play a certain track";
        /*
        User does !(COMMAND) ->>> Considered CommandEvent e
        When referring to CommandEvent e we can do e.getargs or e.reply.
        Rather than getting the event voice channel which doesn't exist, we need to find
        out which channel the user is in.
         */
    }
    @Override
    public void execute(CommandEvent e) {
        natsuho = new Music();
        guild = e.getGuild();
        //Probably want to remove the arguements
        Message message = e.getMessage();
        message.delete().queue();

        //Make it so the bot connects to a certain voice chanel
        if (guild != null && !e.getAuthor().isBot()) {
            if (e.getArgs().isEmpty()) {
                e.reply("Please enter a youtube link into the command!");
                e.getAuthor().getAsMention();
            } else {

                try {
                    natsuho.loadAndPlay(e.getTextChannel(), e.getArgs());
                } catch (IndexOutOfBoundsException et) {
                    e.reply("Please reformat command as: 'play (youtube link) to play a song!");
                }
            }
        } else {
            e.reply("Either guild is null or command issuer is a bot.");
        }
    }
}
