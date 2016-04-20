package com.energizeglobal.smsys.pages.api;

import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.pages.BaseAction;
import com.energizeglobal.smsys.pages.Login;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Session;

import javax.xml.ws.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.energizeglobal.smsys.entities.lcp.UserType.ADMIN;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Home extends BaseAction {

//    @InjectComponent
//    private ChartComponent chartComponent;

    @Inject
    private ComponentResources resources;

    @Property
    private boolean isAdmin;

    @Property
    private User item;


    static final private String[] ALL_THINGS = {"Sugar", "Spice", "All Things Nice"};

    @Property
    private String[] things;

    @Property
    private String thing;

    @InjectComponent
    private Zone thingsZone;


    Object onShowThings() {

        // Set up the list of things to display
        things = ALL_THINGS;

        // Sleep 4 seconds to simulate a long-running operation
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return request.isXHR() ? thingsZone.getBody() : null;
    }

    void setupRender() {
        isAdmin = user.getUserType().equals(ADMIN);
    }

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
        if (user.getUserType().equals(ADMIN)) {
            users = userManager.getAllUser();
        }
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
