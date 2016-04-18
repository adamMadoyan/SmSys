package com.energizeglobal.smsys.pages;

import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.pages.api.Home;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import java.util.Date;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Registration extends BaseAction {

    @Property
    @Validate("required")
    private String confirmPassword;

    @InjectComponent
    private BeanEditForm register;


    void onValidateFromRegister() {
        if (!user.getPassword().equals(confirmPassword)) {
            register.recordError("Password and confirm password are not equal!");
            return;
        }
        if (user.getDob().after(new Date())) {
            register.recordError("Incorrect date of birth!");
            return;
        }
    }

    @CommitAfter
    Object onSuccess() {
        try {
            userManager.add(user);
            return Home.class;
        } catch (DatabaseException e) {
            e.printStackTrace();
//            TODO log error
        }
        return null;
    }

}
