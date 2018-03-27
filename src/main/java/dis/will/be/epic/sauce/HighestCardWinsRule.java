package dis.will.be.epic.sauce;

import java.util.List;

public class HighestCardWinsRule {

    private final CardComparator cardComparator = new CardComparator();


    public boolean appliesToActiveCards(List<Card> activeCards, List<List<Card>> otherCards) {
        Card highestActiveCard = activeCards.stream()
                .max(cardComparator)
                .get();
        Card highestOtherCard = otherCards.stream()
                .flatMap(List::stream)
                .max(cardComparator)
                .get();

        return cardComparator
                .compare(highestActiveCard, highestOtherCard) > 0;
    }
}
