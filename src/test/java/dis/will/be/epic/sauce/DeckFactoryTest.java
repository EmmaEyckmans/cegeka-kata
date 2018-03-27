package dis.will.be.epic.sauce;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class DeckFactoryTest {

    @Test
    public void deckContains49Cards() {
        List<Card> deck = DeckFactory.createDeck();
        Assertions.assertThat(deck.size()).isEqualTo(49);
    }

    @Test
    public void cardDeckContains7CardsOfEveryColor() {
        List<Card> deck = DeckFactory.createDeck();
        for (CardColor cardColor : CardColor.values()) {
            assertDeckContains7CardsOfColor(deck, cardColor);
        }
    }

    @Test
    public void deckOrderIsDifferentEveryTime() {
        List<Card> deck1 = DeckFactory.createDeck();
        List<Card> deck2 = DeckFactory.createDeck();

        Assertions.assertThat(deck1).containsAll(deck2);
        Assertions.assertThat(deck1).isNotEqualTo(deck2);

    }

    private void assertDeckContains7CardsOfColor(List<Card> deck, CardColor color) {
        Assertions.assertThat(deck).contains(
                new Card(color, 1),
                new Card(color, 2),
                new Card(color, 3),
                new Card(color, 4),
                new Card(color, 5),
                new Card(color, 6),
                new Card(color, 7)
        );
    }
}