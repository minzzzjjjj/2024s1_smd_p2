import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player{
    @Override
    public Card playCard(Hand hand, Random random, List<Card> cardsPlayed ) {
        Card selected = getRandomCard(hand,random);
        return selected;
    }

    public Card getRandomCard(Hand hand,Random random) {


        int x = random.nextInt(hand.getCardList().size());
        return hand.getCardList().get(x);
    }
}
