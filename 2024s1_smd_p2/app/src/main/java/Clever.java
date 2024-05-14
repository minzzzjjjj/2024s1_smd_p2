import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// clecer logic, 选弃牌堆里比较多的卡打出去
//相当于把大家都不要的卡丢了，自己保留稀有度高的
//升级：给手上的每张卡都去计算一个稀有度，打出目前稀有度最低的那张卡（可以是一个数学公式）
public class Clever extends Player {
    @Override
    public Card playCard(Hand hand, Random random, List<Card> cardsPlayed ) {
        Map<LuckyThirdteen.Rank, Integer> rankFrequencies = new HashMap<>();
        for (Card card : cardsPlayed) {
            LuckyThirdteen.Rank rank = (LuckyThirdteen.Rank) card.getRank();

            rankFrequencies.put(rank, rankFrequencies.getOrDefault(rank, 0) + 1);
        }

        Card selected = null;

        int minFrequency = 99;

        for (Card card : hand.getCardList()) {
            LuckyThirdteen.Rank rank = (LuckyThirdteen.Rank) card.getRank();
            int frequency = rankFrequencies.getOrDefault(rank, 0);
            if (frequency < minFrequency) {
                minFrequency = frequency;
                selected = card;
            }
        }

        return selected;
    }

}
