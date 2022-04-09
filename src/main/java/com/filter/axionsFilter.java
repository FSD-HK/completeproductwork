package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "axionsFilter")
public class axionsFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("axionsFilter");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设置响应头允许Ajax跨域访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        //设置请求头信息
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //*号代表所有异域请求都可以接受
        response.setHeader("Access-Control-Allow-Methods", "*");

        response.setHeader("Access-Control-Max-Age", "3600");

        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type,Accept,"

                + "content-Type,origin,x-requested-with,content-type,accept,authorization,token,id,X-Custom-Header,X-Cookie,Connection,User-Agent,Cookie,*");

        response.setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,content-Type,Accept");

        response.setHeader("Access-Control-Expose-Headers", "*");
        //在各页面加载之前在过滤是进行转码，就不需要在重新在对应页面转码
        servletRequest.setCharacterEncoding("utf-8");
        //让页面请求往后走不过滤使用地址停留在此处
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
