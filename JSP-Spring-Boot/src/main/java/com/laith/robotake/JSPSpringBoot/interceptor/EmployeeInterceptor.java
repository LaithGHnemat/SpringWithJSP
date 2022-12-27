/*
package com.laith.robotake.JSPSpringBoot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

 */
/*  note that..

   preHandle: This method is used to
   perform some action on requests sent to the controller.

   there are also two default methods we can override from HandlerInterceptor.

   1)postHandle: This method is used to perform some action on responses sent to the client.

   2)afterCompletion: This method is used to perform actions after request and response.*//*


public class EmployeeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        Object isAuthorized = request.getSession().getAttribute("isAuthorized");
        if (isAuthorized == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
*/
