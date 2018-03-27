package dis.will.be.epic.sauce;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void everyPlayerHas7HandCardsAndATableauCard() {
        game.deal();

        List<Player> players = game.getPlayers();

        assertThat(players.get(0).getHandCards()).hasSize(7);
        assertThat(players.get(1).getHandCards()).hasSize(7);
        assertThat(players.get(2).getHandCards()).hasSize(7);
        assertThat(players.get(3).getHandCards()).hasSize(7);

        assertThat(players.get(0).getTableauCards()).hasSize(1);
        assertThat(players.get(1).getTableauCards()).hasSize(1);
        assertThat(players.get(2).getTableauCards()).hasSize(1);
        assertThat(players.get(3).getTableauCards()).hasSize(1);
    }

    @Test
    public void makeMoveThrowsExceptionWhenCardNotOfActivePlayer() {
        game.deal();
        List<Player> players = game.getPlayers();
        Player activePlayer = players.get(0);
        Player otherPlayer = players.get(1);
        Card cardOfOtherPlayer = otherPlayer.getHandCards().get(0);

        assertThatThrownBy(() -> game.makeMove(activePlayer, cardOfOtherPlayer))
                .isInstanceOf(IllegalArgumentException.class);
    }
}