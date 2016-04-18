package com.energizeglobal.smsys.filter;

import com.energizeglobal.smsys.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("sso:com.energizeglobal.smsys.entities.User");
        if (user != null && user.getId() != null) {
            res.sendRedirect(req.getContextPath() + "/api/home");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
