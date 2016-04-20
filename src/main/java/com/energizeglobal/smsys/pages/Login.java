package com.energizeglobal.smsys.pages;


import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.pages.api.Home;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.persistence.EntityNotFoundException;
import javax.xml.ws.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Login extends BaseAction {

    @InjectComponent
    private BeanEditForm login;

    Object onSuccess() {
        try {
            user = userManager.findByEmailAndPassword(user.getEmail(), user.getPassword());
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
