package com.marketplace.Marketplace.Service;

import com.marketplace.Marketplace.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.marketplace.Marketplace.Repository.MessageRepository;
import com.marketplace.Marketplace.Repository.MessageAjoutRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageAjoutRepository messageAjoutRepository;

    // ENREGISTRER NOUVELLE MESSAGE
    public MessageAjout envoyerMessage(MessageAjout message) {
        return messageAjoutRepository.save(message);
    }

    //GET MESSAGE PAR idenvoyeur et idrecepteur
    public List<Message> getConversation(Long envoyeurId, Long recepteurId) {
        List<Message> messages = messageRepository.findByUserenvoyeur_IduAndUserrecepteur_Idu(envoyeurId, recepteurId);
        messages.addAll(messageRepository.findByUserrecepteur_IduAndUserenvoyeur_Idu(envoyeurId, recepteurId));
        messages.sort((m1, m2) -> m1.getIdmessage().compareTo(m2.getIdmessage()));
        return messages;
    }

    //GET USERS par MESSAGE PAR idu qu'il SOIT ENVOYEUR ou RECEPTEUR and USERS WHO TALKED IN THE MESSAGE
    public List<Message> getAllMessageUser(Long idu){
        List<Message> messages = messageRepository.findByUserenvoyeur_IduOrUserrecepteur_Idu(idu,idu);
        messages.sort((m1, m2) -> m1.getIdmessage().compareTo(m2.getIdmessage()));

        //
        //List<UserAjout> usersOthers = messages.getUserenvoyeur();
        //usersOthers.addAll(messages.getUserrecepteur());

        return messages;
    }

    // DELETE by id
    public void deleteMessage(Long idmessage){
        messageRepository.deleteById(idmessage);
    }

    // DELETE ALL BETWEEN
    public void deleteALlMessageByUsers(Integer idu1,Integer idu2){
        messageAjoutRepository.deleteByEnvAndRec(idu1,idu2);
    }


    //GET MESSAGE PAR idenvoyeur
    //public List<Message> getConversationUser(Integer envoyeurId) {
        //List<Message> messages = messageRepository.findByIduenvoyeur(envoyeurId);
        //messages.addAll(messageRepository.findByIdurecepteurAndIduenvoyeur(envoyeurId, recepteurId));
        //messages.sort((m1, m2) -> m1.getDate().compareTo(m2.getDate()));
        //return messages;
    //}

    //GET ALL MESSAGE PAR idu
    /*public List<Message> getConversationEntreUser(Integer idu) {
        List<Message> messages = messageRepository.findByIduenvoyeurOrIdurecepteur(idu,idu);
        return messages;
    }*/

    // LU : TRUE
    public Message updateLu(Long idmessage){
        Optional<Message> messageTrouve = messageRepository.findById(idmessage);
        if (messageTrouve.isPresent()){
            Message message = messageTrouve.get();
            // SET NBLIKE

            message.setLu(true);
            return messageRepository.save(message);
        }
        return null;
    }

    public boolean getNonLu(Long idu){
        List<Message> messages = messageRepository.findByUserrecepteur_IduAndLu(idu,false);
        if (messages != null && !messages.isEmpty()){
            return true;
        }
        return false;


    }
}