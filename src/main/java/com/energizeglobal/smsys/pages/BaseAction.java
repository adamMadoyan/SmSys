package com.energizeglobal.smsys.pages;

import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.manager.IUserManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.services.Request;

import javax.inject.Inject;
import java.util.List;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class BaseAction {

    @Inject
    protected Request request;

    @org.apache.tapestry5.ioc.annotations.Inject
    protected Messages messages;

    @Property
    @SessionState(create = false)
    protected User user;

    @Inject
    protected IUserManager userManager;

    @Property
    @SessionState(create = false)
    protected List<User> users;

//    protected void putUserIntoSession(User user) {
//        request.getSession(true).setAttribute(CURRENT_USER, user);
//    }
//    protected User getUserFromSession() {
//        return  (User) request.getSession(true).getAttribute(CURRENT_USER);
//    }


}
