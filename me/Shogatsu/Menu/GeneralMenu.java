package me.Shogatsu.Menu;

import me.Shogatsu.Managers.GeneralManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class GeneralMenu {
    private EmbedBuilder builder;
    private User user;
    public GeneralMenu(User u) {
        //Color Theme: Orange
        this.builder = new EmbedBuilder().setColor(Color.orange);
        this.user = u;
    }
    public EmbedBuilder whoIs(@NotNull Message msg) {
        String iconUrl = "https://cdn1.iconfinder.com/data/icons/MetroStation-PNG/252/MB__search.png";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Member member = msg.getMentionedMembers().get(0);
        GeneralManager general = new GeneralManager();
        return builder
                .setThumbnail(member.getUser().getAvatarUrl())
                .setAuthor("Member information on " + member.getEffectiveName(), member.getUser().getAvatarUrl(), iconUrl)
                .addField("Join Date: ", member.getTimeJoined().format(dtf), true)
                .addField("Status: ", member.getOnlineStatus().toString(), true)
                .addField("Effective ID: ", member.getUser().getId(), true)
                .addField("Roles: ", general.getMentionedRole(msg), true);
    }
    public EmbedBuilder version(String version) {
        return builder
                .setAuthor(user.getName(), user.getAvatarUrl())
                .setTitle("Version Info")
                .setDescription("Currently running on build " + version);
    }
    public EmbedBuilder serverInfo(Guild guild) {
        GeneralManager manager = new GeneralManager();
        return builder
                .setColor(Color.yellow)
                .setAuthor(guild.getName(), guild.getIconUrl())
                .addField("Owner: ", guild.getOwner().getEffectiveName(), true)
                .addField("Region: ", guild.getRegionRaw(), true)
                .addField("Members: ", manager.getGuildMembers(guild.getMembers()), true);
    }
}
