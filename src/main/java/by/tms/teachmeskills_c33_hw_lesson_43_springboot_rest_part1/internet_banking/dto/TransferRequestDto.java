package by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDto {
    private Long fromCardId;
    private Long toCardId;
    private BigDecimal amount;
}
