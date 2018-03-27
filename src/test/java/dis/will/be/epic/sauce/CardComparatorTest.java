package dis.will.be.epic.sauce;

import org.junit.Test;

import static dis.will.be.epic.sauce.CardColor.RED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class CardComparatorTest {

    private final CardComparator comparator = new CardComparator();

    @Test
    public void cardValuesAreEqual() {
        int result = comparator.compare(new Card(RED, 1), new Card(RED, 1));
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void firstCardValueIsHigher() {
        int result = comparator.compare(new Card(RED, 2), new Card(RED, 1));
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void firstCardValueIsLower() {
        int result = comparator.compare(new Card(RED, 1), new Card(RED, 2));
        assertThat(result).isEqualTo(-1);
    }
}