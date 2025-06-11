package by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.model;

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
}
