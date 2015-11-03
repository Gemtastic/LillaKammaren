package com.gemtastic.lillakammaren.repository;

import com.gemtastic.lillakammaren.model.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * Although this website has a message repository it does not implement a way to
 * read them as this is information to be sent to the shop owner and is for 
 * their eyes only.
 * 
 * @author Gemtastic
 */
public class MessageRepository {
    private List<Message> messageList;
    public static MessageRepository instance;
    
    public static MessageRepository getInstance(){
        if(instance == null){
            synchronized(MessageRepository.class){
                if(instance == null){
                    instance = new MessageRepository();
                }
            }
        }
        return instance;
    }
    
    private MessageRepository(){
        this.messageList = new ArrayList<>();
    }
    
    public void addMessage(Message message){
        messageList.add(message);
    }
    
    public List<Message> getMessages(){
        return messageList;
    }
}
