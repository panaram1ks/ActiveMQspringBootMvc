package com.demo.jms;

import com.demo.pojo.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author E.Parominsky 04/03/2024 12:04
 */
@Component
public class MessageConsumer {

    @JmsListener(destination = "mytestqueue")
    public void receiveMessage(String messageStr) throws IOException {
        System.out.println(messageStr);
        ObjectMapper mapper = new ObjectMapper();
        Products products = mapper.readValue(messageStr, Products.class);
        System.out.println(products.getName());
    }

}
