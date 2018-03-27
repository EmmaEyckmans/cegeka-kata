package dis.will.be.epic.sauce;

import com.google.common.base.Preconditions;

public class Card {

    private final CardColor cardColor;
    private final int value;

    public Card(CardColor cardColor, int value) {
        Preconditions.checkArgument(assertValue(value), "Card value should be between 1 and 7 :"+value);
        this.cardColor = cardColor;
        this.value = value;
    }

    private boolean assertValue(int value) {
        return value >= 1 && value <= 7;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardColor=" + cardColor +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (value != card.value) return false;
        return cardColor == card.cardColor;
    }

    @Override
    public int hashCode() {
        int result = cardColor != null ? cardColor.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }
}