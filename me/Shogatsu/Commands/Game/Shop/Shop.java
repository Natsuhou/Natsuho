package me.Shogatsu.Commands.Game.Shop;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.GameManager;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.ShopMenu;
import net.dv8tion.jda.api.entities.MessageReaction;

@CommandInfo(
        name = "Shop",
        description = "Buy farm upgrades and stuff"
)
public class Shop extends Command {
    private EventWaiter waiter;
    public Shop(EventWaiter w) {
        this.name = "shop";
        this.aliases = new String[] {"shp", "sh"};
        this.waiter = w;
    }
    @Override
    protected void execute(CommandEvent e) {
        ShopMenu shop = new ShopMenu(e.getAuthor(), e.getChannel());
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            e.reply(shop.shopMenu().build());
            e.getChannel().sendMessage(shop.shopMenu().build()).queue(message -> message.addReaction("U+1F603").queue());
            for (MessageReaction shopReact : e.getMessage().getReactions()) {
                String emoteName = shopReact.getReactionEmote().getName();
                switch (emoteName) {
                    case "U+1F603":
                        e.reply("You wanna buy this item?");
                        break;
                    default:
                        e.reply("Invalid purchase");
                }
            }
            //e.getMessage().addReaction("U+1F603").queue();
            GameManager manage = new GameManager();
            String item1 = "test1";
            String name = "Name";
            manage.buyShopItem(e.getAuthor(), e.getChannel(), item1, name);
        } else {
            ErrorMenu error = new ErrorMenu(e.getAuthor());
            error.invalidAccount();
        }
    }
}
