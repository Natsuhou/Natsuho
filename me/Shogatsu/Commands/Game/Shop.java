package me.Shogatsu.Commands.Game;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.GameMenu;
import me.Shogatsu.Menu.ShopMenu;
import net.dv8tion.jda.client.managers.EmoteManager;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.MessageReaction;

import javax.print.DocFlavor;

public class Shop extends Command {
    public Shop() {
        this.name = "shop";
        this.aliases = new String[] {"shp", "sh"};
    }

    @Override
    protected void execute(CommandEvent e) {
        ShopMenu shop = new ShopMenu(e.getAuthor(), e.getChannel());
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            e.reply(shop.shopMenu().build());
            for (MessageReaction shopReact : e.getMessage().getReactions()) {
                String emoteName = shopReact.getReactionEmote().getName();
                switch (emoteName) {
                    case "":

                }
            }
            e.getMessage().addReaction(":egg:").queue();
            GameManager manage = new GameManager();
            String item1 = "test1";
            String name = "Name";
            manage.buyShopItem(e.getAuthor(), e.getChannel(), item1, name);
            //e.getMessage().getReactions().get(1).getReactionEmote();
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            error.invalidAccount();
        }
    }
}
