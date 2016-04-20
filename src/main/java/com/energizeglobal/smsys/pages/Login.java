package com.energizeglobal.smsys.pages;


import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.pages.api.Home;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.EventLink;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.apache.tapestry5.services.ajax.JSONCallback;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import javax.persistence.EntityNotFoundException;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
//@Import(library = "testJSON.js")
public class Login extends BaseAction {

//
//    @Inject
//    private AjaxResponseRenderer ajaxResponseRenderer;

    @InjectComponent
    private BeanEditForm login;


//    @Inject
//    private JavaScriptSupport javaScriptSupport;
//
//    @AfterRender
//    void addJavaScript(){
//        javaScriptSupport.addInitializerCall("testJSON", jsonCallbackLink.getClientId());
//    }

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

//
//
//
//    @InjectComponent
//    private EventLink jsonCallbackLink;
//
//    @OnEvent("sendJSON")
//    void sendJSON() {
//        ajaxResponseRenderer.addCallback(new JSONCallback() {
//            public void run(JSONObject reply) {
//                reply.put("message", messages.get("server.message"));
//            }
//        });
//    }

    Object onAction() {
        return Registration.class;
    }


}
