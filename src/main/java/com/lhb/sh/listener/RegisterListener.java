package com.lhb.sh.listener;


import com.lhb.sh.event.UserRegisterEvent;
import com.lhb.sh.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegisterListener {

    @EventListener
    public void listener(UserRegisterEvent event) {
        User user = event.getUser();
        log.info("listen in UserRegisterEvent,the user is:"+user.toString());
    }
}
