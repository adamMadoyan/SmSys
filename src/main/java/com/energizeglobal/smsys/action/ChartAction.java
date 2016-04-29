package com.energizeglobal.smsys.action;

import com.energizeglobal.smsys.entities.Health;
import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.manager.IUserManager;
import com.energizeglobal.smsys.manager.impl.UserManager;
import com.google.gson.Gson;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */

public class ChartAction extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("sso:" + User.class.getName());
        Set<Health> healths = user.getHealths();
        Writer writer = response.getWriter();

        for (Health health : healths) {
            health.setUser(null);
        }

        writer.write(gson.toJson(healths));
        writer.flush();
        writer.close();
    }
}
