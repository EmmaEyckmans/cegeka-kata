package dis.will.be.epic.sauce;


import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static dis.will.be.epic.sauce.CardColor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HighestCardWinsRuleTest {

    @Test
    @SuppressWarnings("unchecked")
    public void highestCardInActiveHandShouldReturnTrue() {
        HighestCardWinsRule rule = new HighestCardWinsRule();
        List<Card> activeCards = Lists.newArrayList(
                new Card(RED, 2)
        );
        List<List<Card>> otherCards = Lists.<List<Card>>newArrayList(
                Lists.newArrayList(
                    new Card(RED, 1)));
        assertThat(rule.appliesToActiveCards(activeCards, otherCards)).isTrue();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void highestCardNotInActiveHandShouldReturnFalse() {
        HighestCardWinsRule rule = new HighestCardWinsRule();
        List<Card> activeCards = Lists.newArrayList(new Card(RED, 1));
        List<List<Card>> otherCards = Lists.<List<Card>>newArrayList(
                Lists.newArrayList(new Card(RED, 2)));
        assertThat(rule.appliesToActiveCards(activeCards, otherCards)).isFalse();
    }
}