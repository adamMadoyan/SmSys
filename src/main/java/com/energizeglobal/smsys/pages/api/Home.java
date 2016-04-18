package com.energizeglobal.smsys.pages.api;

import com.energizeglobal.smsys.pages.BaseAction;
import com.energizeglobal.smsys.pages.Login;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.services.Session;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Home extends BaseAction {

    void onActivate() {

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
