package com.energizeglobal.smsys.pages;


import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.pages.api.Home;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.BeanEditForm;

import javax.persistence.EntityNotFoundException;

import static com.energizeglobal.smsys.entities.lcp.UserStatus.INACTIVE;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
//@Import(library = "testJSON.js")
public class Login extends BaseAction {

    @InjectComponent
    private BeanEditForm login;


    Object onSuccess() {
        try {
            User selectedUser = userManager.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (selectedUser.getStatus().equals(INACTIVE)) {
                login.recordError("Your account not activated yet, Please connect administration for activating your account.");
                return null;
            }
            user = selectedUser;
        } catch (EntityNotFoundException e) {
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
