package by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.controller;

import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.dto.TransferRequestDto;
import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.model.Card;
import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.model.Client;
import by.tms.teachmeskills_c33_hw_lesson_43_springboot_rest_part1.internet_banking.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/banking")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty.");
        }

        try {
            String pathDir = System.getProperty("user.dir");
            File uploadDirFile = new File(pathDir + File.separator + "uploads");

            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            File dest = new File(uploadDirFile, file.getOriginalFilename());
            file.transferTo(dest);

            return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error when uploading: " + e.getMessage());
        }
    }



    @GetMapping("/cards")
    public ResponseEntity<Map<Long, Card>> getAllCards() {
        Map<Long, Card> cards = bankService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/clients")
    public ResponseEntity<Map<Long, Client>> getAllClients() {
        Map<Long, Client> clients = bankService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/saveClient")
    public ResponseEntity<String> saveClient(@RequestBody Client client) {
        bankService.saveClient(client);
        return ResponseEntity.ok("Client saved.");
    }


    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Client client = bankService.getClientById(id);
        if(client != null){
            return ResponseEntity.ok(client);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/card/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id){
        Card card = bankService.getCardById(id);
        if(card != null){
            return ResponseEntity.ok(card);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequestDto dto){
        boolean success = bankService.transfer(dto.getFromCardId(), dto.getToCardId(), dto.getAmount());
        if(success){
            return ResponseEntity.ok("Translation completed successfully.");
        }else {
            return ResponseEntity.badRequest().body("Translation error: check details and balance.");
        }
    }
}
