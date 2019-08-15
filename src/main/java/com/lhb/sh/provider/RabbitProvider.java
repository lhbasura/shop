package com.lhb.sh.provider;

import com.lhb.sh.model.entity.User;
import com.lhb.sh.util.constant.RabbitConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Slf4j
@Component
public class RabbitProvider {
    @Resource
    private AmqpTemplate amqpTemplate;
    public void sendMail(User user){
        log.info("send user to RabbitMq:"+user);
        amqpTemplate.convertAndSend(RabbitConstant.MAIL_QUEUE,user);
    }

}
