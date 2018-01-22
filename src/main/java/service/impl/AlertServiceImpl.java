package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import service.AlertService;

@Service("alertService")
public class AlertServiceImpl implements AlertService {

    @Autowired
    private JmsOperations jmsOperations;

    @Override
    public void sendAlert(String message) {

//        jmsOperations.send("alert.queue", new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage(message);
//            }
//        });

        jmsOperations.convertAndSend("alert.queue", message);

    }

//    @Override
//    public void receiveAlert() {
//        try {
//            TextMessage message = (TextMessage)jmsOperations.receive("alert.queue");
//            System.out.println("message: " + message.getText());
//        } catch (JMSException e) {
//            throw JmsUtils.convertJmsAccessException(e);
//        }
//    }

    @Override
    public void receiveAlert(String message) {
        System.out.println("message: " + message);
    }
}
