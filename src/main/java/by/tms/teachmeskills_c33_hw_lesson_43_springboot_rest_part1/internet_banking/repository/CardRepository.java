package by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.repository;

import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.model.Card;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CardRepository {
    private final Map<Long, Card> cards = new HashMap<>();

    public CardRepository(){
        cards.put(1001L, new Card(1001L, 1L, "4440 0000 5467 7869", new BigDecimal("5000")));
        cards.put(1002L, new Card(1002L, 2L, "4440 1111 5467 7869", new BigDecimal("2000")));
    }

    public Card findById(Long id) {
        return cards.get(id);
    }

    public Map<Long, Card> getAllCards(){
        return cards;
    }

    public void updateCard(Card card){
        cards.put(card.getId(), card);
    }
}
