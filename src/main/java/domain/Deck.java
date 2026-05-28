package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Deck {

    private final ArrayDeque<Card> cards;

    public Deck(ArrayDeque<Card> cards) {
        this.cards = new ArrayDeque<>(cards);
    }

    public int getCardCount() {
        return this.cards.size(); // Returns collection size [cite: 182]
    }

    public Card removeTop() {
        return null;
    }

    public void addCard(Card card) {

    }

    public void shuffle() {

    }

    public Collection<Card> getCards() {
        return new ArrayList<>(this.cards);
    }

    public int getCountOfCardType(CardType type) {
        return 0;
    }
}
