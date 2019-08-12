package com.lhb.sh.config;

import com.lhb.sh.util.constant.MailConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue mailQueue(){
        return  new Queue(MailConstant.MAIL_QUEUE);
    }


}
