package dis.will.be.epic.sauce;

import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.partition;

public class Game {

    private static final int NUMBER_OF_PLAYERS = 4;

    private List<Player> players = newArrayList();

    public void deal() {
        List<Card> deck = DeckFactory.createDeck();
        List<List<Card>> cardsPerPlayer = partition(deck, 8);

        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            List<Card> cardsForOnePlayer = cardsPerPlayer.get(i);
            players.add(new Player(cardsForOnePlayer.subList(0,7), cardsForOnePlayer.get(7)));
        }
    }

    public void makeMove(Player player, Card card) {
        if (!player.getHandCards().contains(card)) {
            throw new IllegalArgumentException("No cheating allowed!");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
