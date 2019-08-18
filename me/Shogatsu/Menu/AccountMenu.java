package me.Shogatsu.Menu;

import me.Shogatsu.Managers.AccountManager;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AccountMenu {
    private AccountManager manager;
    private EmbedBuilder builder;
    private User user;
    private MessageChannel channel;
    public AccountMenu(User user, MessageChannel messageChannel) {
        manager = new AccountManager();
        builder = new EmbedBuilder();
        this.user = user;
        this.channel = messageChannel;
    }
    public EmbedBuilder whoIsMenu(@NotNull Message msg) {
        String roles, iconUrl;
        Role tempRoles;
        Member tempMembers;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Member member = msg.getMentionedMembers().get(0);
        List rolesList = member.getRoles();
        iconUrl = "https://cdn1.iconfinder.com/data/icons/MetroStation-PNG/252/MB__search.png";
        if (!rolesList.isEmpty()) {
            tempRoles = (Role) rolesList.get(0);
            roles = tempRoles.getName();
            for (int i = 1; i < rolesList.size(); i++) {
                tempRoles = (Role) rolesList.get(i);
                roles += ", " + tempRoles.getName();
            }
        } else {
            roles = "No Roles";
        }
        return builder
                .setColor(Color.yellow)
                .setThumbnail(member.getUser().getAvatarUrl())
                .setAuthor("Member information on " + member.getEffectiveName(), member.getUser().getAvatarUrl(), iconUrl)
                .addField("Join Date: ", member.getJoinDate().format(dtf), true)
                .addField("Status: ", member.getOnlineStatus().toString(), true)
                .addField("Effective ID: ", member.getUser().getId(), true)
                .addField("Roles: ", roles, true);
    }
    public EmbedBuilder createAccountMenu() {
        return builder
                .setColor(Color.green)
                .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                .setAuthor("Account has been successfully created!", null, user.getAvatarUrl())
                .setDescription("Please have fun and don't forget to vote for free rewards!")
                .setFooter("Need some help? Do 'help for more info!", null);
    }
    public EmbedBuilder accountMenu() {
        String currency = Integer.toString(manager.getCurrency(user, channel));
        return builder
                .setColor(Color.yellow)
                .setTitle("Account Profile")
                .setAuthor(user.getName(), null, user.getAvatarUrl())
                .setDescription(manager.getDescription(user, channel))
                .addField(":peanuts:  " + currency, "", true)
                .addField(":coffee:  " + "amount", "",true)
                .setFooter("ID: " + user.getAsTag(), null);
    }
}
