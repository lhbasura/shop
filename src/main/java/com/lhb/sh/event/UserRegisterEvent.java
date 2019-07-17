package com.lhb.sh.event;

import com.lhb.sh.model.User;
import org.springframework.context.ApplicationEvent;

public class UserRegisterEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private User user;
    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user=user;
    }
}
