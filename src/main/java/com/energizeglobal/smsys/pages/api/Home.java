package com.energizeglobal.smsys.pages.api;

import com.energizeglobal.smsys.pages.BaseAction;
import com.energizeglobal.smsys.pages.Login;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Session;

import javax.xml.ws.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Home extends BaseAction {

    @Inject
    private ComponentResources resources;

    public StreamResponse onExternalImage() {
        return new StreamResponse() {
            public String getContentType() {
                return "image/jpeg";
            }

            public InputStream getStream() {
                try {
                    return new FileInputStream(user.getAvatar());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void prepareResponse(org.apache.tapestry5.services.Response response) {

            }

            public void prepareResponse(Response response) {
            }
        };
    }

    public Link getExternalImageLink() {
        return resources.createEventLink("externalImage");
    }

    void onActivate() {
        System.out.println(messages.get("application.image.path"));
    }

    @OnEvent
    public Object onActionInvalidate() {

        Session session = request.getSession(true);
        if (session != null) {
            session.invalidate();
        }

        return Login.class;
    }

}
