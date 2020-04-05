package com.machun.springbootexcption.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author machun1
 */
@WebFilter(filterName = "loginFilter",urlPatterns = "/api/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("************************Login Filter Init ************************");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Login Filter  ************************");
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        if(req.getParameter("userName").equals("machun"))
        {
         filterChain.doFilter(servletRequest,servletResponse);
        }
        else
        {
            return;
        }

    }

    @Override
    public void destroy() {
        System.out.println("Login Filter Destroy ************************");
    }
}
