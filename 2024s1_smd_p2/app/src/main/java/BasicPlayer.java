import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;
import java.util.Random;

// new part 6
public class BasicPlayer extends Player{

    @Override
    public Card playCard(Hand hand, Random random) {
        ArrayList<Card> handCards = hand.getCardList();
        int min = 1000;
        Card selected = null;
        for (Card card : handCards) {
            LuckyThirdteen.Rank rank = (LuckyThirdteen.Rank) card.getRank();
            LuckyThirdteen.Suit suit = (LuckyThirdteen.Suit) card.getSuit();

            // if it is ACE, just return, because it is 0
            if (rank.getRankCardValue() == 1) {
                return card;
            }

            int currentValue = rank.getScoreCardValue() * suit.getMultiplicationFactor();

            if (currentValue < min) {
                selected = card;
                min = currentValue;
            }


        }

        return selected;
    }
}
