package com.marketplace.Marketplace.Controller;

import com.marketplace.Marketplace.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.marketplace.Marketplace.Service.MessageService;
import org.springframework.http.ResponseEntity;
import com.marketplace.Marketplace.Model.UserAjout;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Enregistrer le message
    @PostMapping("/envoyer")
    public ResponseEntity<MessageAjout> envoyerMessage(@RequestBody MessageAjout message) {
        MessageAjout nouveauMessage = messageService.envoyerMessage(message);
        return ResponseEntity.ok(nouveauMessage);
    }

    //
    @GetMapping("/conversation/{envoyeurId}/{recepteurId}")
    public ResponseEntity<List<Message>> getConversation(@PathVariable Long envoyeurId, @PathVariable Long recepteurId) {
        List<Message> conversation = messageService.getConversation(envoyeurId, recepteurId);
        return ResponseEntity.ok(conversation);
    }

    @GetMapping("/usersTalk/{idu}")
    public ResponseEntity<List<UserAjout>> getAllMessageUser(@PathVariable Long idu) {
        List<Message> messages = messageService.getAllMessageUser(idu);
        List<UserAjout> usersOthers = new ArrayList<>();
        for ( Message message : messages){
            UserAjout usersEnv = message.getUserenvoyeur();
            UserAjout usersRecep = message.getUserrecepteur();
            usersOthers.add(usersEnv);
            usersOthers.add(usersRecep);
        }
        usersOthers = usersOthers.stream()
                .distinct()
                .collect(Collectors.toList());

        usersOthers.removeIf(userajout->userajout.getIdu() == idu);
        return ResponseEntity.ok(usersOthers);
    }

    // DELETE ONE MESSAGE BY IDMESSAGE
    @DeleteMapping("/{idmessage}")
    public void deleteMessage(@PathVariable Long idmessage){
        messageService.deleteMessage(idmessage);
    }

    // DELETE CONV BETWEEN TWO USERS
    @DeleteMapping("deleteConv/{idu1}/{idu2}")
    public void deleteMessage(@PathVariable Integer idu1,@PathVariable Integer idu2){
        messageService.deleteALlMessageByUsers(idu1,idu2);
    }

    // LU : true
    @PutMapping("/lu/{idmessage}")
    public Message updateLu(@PathVariable Long idmessage){
        return messageService.updateLu(idmessage);
    }

    // message where idrecepteur = you and lu = false
    @GetMapping("/hasNonLu/{recepteurId}")
    public boolean getNonLu(@PathVariable Long recepteurId) {
        return messageService.getNonLu(recepteurId);
    }
}