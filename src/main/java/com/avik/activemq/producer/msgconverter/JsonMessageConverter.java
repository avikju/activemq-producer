package com.avik.activemq.producer.msgconverter;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>This class converts the object to JSON without using the type property. So that, our producer and consumer can be at different micro-services.
 * </p>
 * @author avik
 *
 */
@Component
public class JsonMessageConverter implements MessageConverter {

    @Autowired
    private ObjectMapper mapper;

    /**
     * Converts message to JSON. Used mostly by {@link org.springframework.jms.core.JmsTemplate}
     */
    @Override
    public javax.jms.Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        String json;

        try {
            json = mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new MessageConversionException("Message cannot be parsed. ", e);
        }

        TextMessage message = session.createTextMessage();
        message.setText(json);

        return message;
    }

    /**
     * Extracts JSON payload for further processing by JacksonMapper.
     */
    @Override
    public Object fromMessage(javax.jms.Message message) throws JMSException, MessageConversionException {
        return ((TextMessage) message).getText();
    }
}
