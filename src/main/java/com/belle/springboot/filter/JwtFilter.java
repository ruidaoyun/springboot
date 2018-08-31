package com.belle.springboot.filter;

import com.belle.springboot.commons.JwtHelper;
import com.belle.springboot.pojo.Audience;
import com.belle.springboot.pojo.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Autowired
    private Audience audience;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request=(HttpServletRequest) servletRequest;
        final HttpServletResponse response=(HttpServletResponse) servletResponse;
        //等到请求头信息authorization信息
        final String authHeader=request.getHeader ("authorization");

        if ("OPTIONS".equals (request.getMethod ())) {
            response.setStatus (HttpServletResponse.SC_OK);
            filterChain.doFilter (servletRequest, servletResponse);
        } else {

           /* if (authHeader == null || !authHeader.startsWith ("bearer;")) {
                response.sendRedirect ("/401");
            }
            final String token=authHeader.substring (7);

            try {
                if (audience == null) {
                    BeanFactory factory=WebApplicationContextUtils.getRequiredWebApplicationContext (request.getServletContext ());
                    audience=(Audience) factory.getBean ("audience");
                }
                final Claims claims=JwtHelper.parseJWT (token, audience.getBase64Secret ());
                System.err.println (claims);
                if (claims == null) {

                }
            } catch (final Exception e) {
                //登录过期
                response.sendRedirect ("/expire");
            }

            filterChain.doFilter (servletRequest, servletResponse);*/
            if ((authHeader != null) && (authHeader.length() > 7))
            {
                String HeadStr = authHeader.substring(0, 6).toLowerCase();
                if (HeadStr.compareTo("bearer;") == 0)
                {

                    String token = authHeader.substring(7, authHeader.length());
                    if (JwtHelper.parseJWT(token, audience.getBase64Secret()) != null)
                    {
                        filterChain.doFilter(request, response);
                        return;
                    }
                }
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            ObjectMapper mapper = new ObjectMapper();
            JsonResult resultMsg = new JsonResult (1,"unauthorized",null);
            response.getWriter().write(mapper.writeValueAsString(resultMsg));
            return;
        }
    }
}
