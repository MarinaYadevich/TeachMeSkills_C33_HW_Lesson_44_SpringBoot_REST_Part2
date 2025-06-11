package by.tms.teachmeskills_c33_hw_lesson43_springboot_rest_part1.internet_banking.dto;

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

//    public TransferRequestDto() {
//    }
//
//    public TransferRequestDto(Long fromCardId, Long toCardId, BigDecimal amount) {
//        this.fromCardId = fromCardId;
//        this.toCardId = toCardId;
//        this.amount = amount;
//    }
//
//    public Long getFromCardId() {
//        return fromCardId;
//    }
//
//    public void setFromCardId(Long fromCardId) {
//        this.fromCardId = fromCardId;
//    }
//
//    public Long getToCardId() {
//        return toCardId;
//    }
//
//    public void setToCardId(Long toCardId) {
//        this.toCardId = toCardId;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigDecimal amount) {
//        this.amount = amount;
//    }
}
