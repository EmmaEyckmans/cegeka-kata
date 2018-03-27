package dis.will.be.epic.sauce;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class DeckFactory {

    public static List<Card> createDeck() {
        List<Card> cards = stream(CardColor.values())
                .flatMap(DeckFactory::generate7Cards)
                .collect(toList());
        Collections.shuffle(cards);
        return cards;
    }

    private static Stream<Card> generate7Cards(CardColor cardColor) {
        return IntStream.range(1,8)
                .mapToObj((value)-> new Card(cardColor,value));
    }
}
