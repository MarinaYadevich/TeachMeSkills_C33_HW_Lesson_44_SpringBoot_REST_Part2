package by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.service;

import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.model.Card;
import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.model.Client;
import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.repository.CardRepository;
import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class BankService {

    private final CardRepository cardRepository;
    private final ClientRepository clientRepository;

    public BankService(CardRepository cardRepository, ClientRepository clientRepository) {
        this.cardRepository = cardRepository;
        this.clientRepository = clientRepository;
    }

    public Card getCardById(Long idCard) {
        return cardRepository.findById(idCard);
    }

    public Client getClientById(Long idClient) {
        return clientRepository.getClientById(idClient);
    }

    public Map<Long, Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    public Map<Long, Card> getAllCards() {
        return cardRepository.getAllCards();
    }

    public void saveClient(Client client){
        clientRepository.saveClient( client);
    }

    public boolean transfer(Long fromCardId, Long toCardId, BigDecimal amount) {
        Card fromCard = cardRepository.findById(fromCardId);
        Card toCard = cardRepository.findById(toCardId);

        if (fromCard == null || toCard == null) {
            return false; //одна из карт не найдена
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            // Нельзя перевести 0 или отрицательную сумму
            return false;
        }
        if (fromCard.getBalance().compareTo(amount) < 0) {
            return false; // на карте отправителя нет достаточной суммы
        }

        //снимаем деньги с карты отправителя
        fromCard.setBalance(fromCard.getBalance().subtract(amount));
        cardRepository.updateCard(fromCard);

        //добавляем деньги на карту получателя
        toCard.setBalance(toCard.getBalance().add(amount));
        cardRepository.updateCard(toCard);

        return true; // успешный перевод
    }
}
