package dis.will.be.epic.sauce;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return Comparator.comparingInt(Card::getValue)
                .compare(o1, o2);
    }
}
