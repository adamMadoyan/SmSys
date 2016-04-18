package com.energizeglobal.smsys.pages;


import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.manager.IUserManager;
import com.energizeglobal.smsys.pages.api.Home;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.persistence.EntityNotFoundException;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Login extends BaseAction {

    @Inject
    private IUserManager userManager;

    @InjectComponent
    private BeanEditForm login;

    Object onSuccess() {
        try {
            user = userManager.findByEmailAndPassword(user.getEmail(), user.getPassword());
        }catch (EntityNotFoundException e) {
            login.recordError("Incorrect email or password!");
            return null;
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return Home.class;
    }

    Object onAction() {
        return Registration.class;
    }


}
