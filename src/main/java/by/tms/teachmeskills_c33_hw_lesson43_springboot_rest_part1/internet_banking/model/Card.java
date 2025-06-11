package by.tms.teachmeskills_c33_hw_lesson43_springboot_rest_part1.internet_banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;
    private Long clientId;
    private String cardNumber;
    private BigDecimal balance;

//    public Card() {
//    }
//
//    public Card(Long id, Long clientId, String cardNumber, BigDecimal balance) {
//        this.id = id;
//        this.clientId = clientId;
//        this.cardNumber = cardNumber;
//        this.balance = balance;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(Long clientId) {
//        this.clientId = clientId;
//    }
//
//    public String getCardNumber() {
//        return cardNumber;
//    }
//
//    public void setCardNumber(String cardNumber) {
//        this.cardNumber = cardNumber;
//    }
//
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
}
