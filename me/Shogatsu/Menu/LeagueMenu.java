package me.Shogatsu.Menu;


import com.merakianalytics.orianna.types.core.summoner.Summoner;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class LeagueMenu {
    private EmbedBuilder builder;
    private User user;
    public LeagueMenu(User u) {
        this.user = u;
        this.builder = new EmbedBuilder()
                .setColor(Color.DARK_GRAY);
    }
    /*
    public EmbedBuilder LeagueDemo(Summoner summoner) {
        return builder
                .setAuthor(user.getName(), user.getAvatarUrl())
                .setTitle("[" + summoner.getName() + "'s profile]")
                .setDescription(":trophy: Level " + summoner.getSummonerLevel())
                .addField()
    }
    */
    public EmbedBuilder OriannaMenu(Summoner summoner) {
        summoner.getCurrentMatch();
        return builder
                .setAuthor(user.getName(), user.getAvatarUrl())
                .setTitle("[ " + summoner.getName() + "'s profile ]")
                .setDescription(":timer: Level " + summoner.getLevel());
    }
}
