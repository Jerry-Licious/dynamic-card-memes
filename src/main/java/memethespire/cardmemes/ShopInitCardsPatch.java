package memethespire.cardmemes;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.ShopScreen;
import memethespire.MemeCollection;

@SpirePatch(clz = ShopScreen.class, method = "initCards")
public class ShopInitCardsPatch {
    @SpirePostfixPatch
    // Modify shown card names and descriptions when a shop is loaded.
    public static void modifyCards(ShopScreen instance) {
        instance.coloredCards.forEach((card) ->
                MemeCollection.applyFirstApplicableCardModificationFromAllCollections(card, AbstractDungeon.player));
        instance.colorlessCards.forEach((card) ->
                MemeCollection.applyFirstApplicableCardModificationFromAllCollections(card, AbstractDungeon.player));
    }
}
