package com.lhb.sh.event;

import com.lhb.sh.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class UserRegisterEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private User user;
    public UserRegisterEvent(Object source, User user) {
        super(source);

        log.info("UserRegisterEvent is triggered,the user is: "+user.toString());
        this.user=user;
    }
}
