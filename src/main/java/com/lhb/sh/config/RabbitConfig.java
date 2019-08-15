package com.lhb.sh.config;

import com.lhb.sh.util.constant.RabbitConstant;
import com.lhb.sh.util.constant.VerifyConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue mailQueue(){
        return  new Queue(RabbitConstant.MAIL_QUEUE);
    }


}
