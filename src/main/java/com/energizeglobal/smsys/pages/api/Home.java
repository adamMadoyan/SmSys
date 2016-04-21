package com.energizeglobal.smsys.pages.api;

import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.pages.BaseAction;
import com.energizeglobal.smsys.pages.Login;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Session;

import javax.xml.ws.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.energizeglobal.smsys.entities.lcp.UserStatus.ACTIVE;
import static com.energizeglobal.smsys.entities.lcp.UserStatus.INACTIVE;
import static com.energizeglobal.smsys.entities.lcp.UserType.ADMIN;
import static com.energizeglobal.smsys.entities.lcp.UserType.USER;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Home extends BaseAction {

    @Inject
    private ComponentResources resources;

    @Property
    private boolean isAdmin;

    @Property
    private User item;

    void setupRender() {
        isAdmin = user.getUserType().equals(ADMIN);
    }

    public StreamResponse onExternalImage(final long userId) {
        return new StreamResponse() {
            public String getContentType() {
                return "image/jpeg";
            }

            public InputStream getStream() {
                try {
                    User currentUser = null;
                    try {
                         currentUser = userManager.findById(userId);
                    } catch (DatabaseException e) {
                        e.printStackTrace();
                    }
                    return new FileInputStream(currentUser == null ? null : currentUser.getAvatar());
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

    public Link getExternalImageLink(long userId) {
        return resources.createEventLink("externalImage", userId);
    }

    void onActivate() {
        if (user.getUserType().equals(ADMIN)) {
            users = userManager.getAllUser();
        }
        System.out.println(messages.get("application.image.path"));
    }

    @CommitAfter
    public Object onActionFromStatus(int index) {

        User currentUser = users.get(index);

        if (currentUser.getStatus().equals(ACTIVE)) {
            currentUser.setStatus(INACTIVE);
        } else {
            currentUser.setStatus(ACTIVE);
        }
        try {
            userManager.edit(currentUser);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Object onActionFromInvalidate() {

        Session session = request.getSession(true);
        if (session != null) {
            session.invalidate();
        }

        return Login.class;
    }

    public int getIndex() {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean getActive() {
        return item.getStatus().equals(ACTIVE);
    }

}
