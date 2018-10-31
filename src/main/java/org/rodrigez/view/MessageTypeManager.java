package org.rodrigez.view;

import org.rodrigez.view.messagetypes.ErrorMessageType;
import org.rodrigez.view.messagetypes.InfoMessageType;
import org.rodrigez.view.messagetypes.MessageType;

import java.util.HashMap;
import java.util.Map;

public class MessageTypeManager {
    private Map<String,MessageType> messages = new HashMap<>();

    private MessageTypeManager() {
        messages.put("info", new InfoMessageType());
        messages.put("error", new ErrorMessageType());
    }

    private static class ControllerManagerHolder{
        private static final MessageTypeManager messageManager = new MessageTypeManager();
    }

    public static MessageTypeManager getInstance(){
        return MessageTypeManager.ControllerManagerHolder.messageManager;
    }

    public MessageType getMessageType(String messageName){
        MessageType message = messages.get(messageName);
        return (message == null) ? new ErrorMessageType(): message;
    }
}