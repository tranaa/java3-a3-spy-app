
package com.tranaa.aaron_vinayak_a3.filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * This Class is used as a filter to hide the words which are taken from the 
 * predefined XML file
 * @author Aaron Tran,Vinayak Pavate
 */
public class CensorFilter implements Filter{
    
    private FilterConfig fiterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fiterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     
        MyWrapper myWrapper = new MyWrapper((HttpServletResponse)response);
        
        chain.doFilter(request, myWrapper);
        
        String fromJsp = myWrapper.toString();
        
        ServletContext context = request.getServletContext();
        String words = context.getInitParameter("filterWords");
        String[] filterWords = words.split(":");
        //We are replacing the selected words from the context parameter with *
        for(String filterWord : filterWords) {
            if (fromJsp.contains(filterWord)){
                fromJsp = fromJsp.replaceAll("(?i)"+filterWord+"(.+)", "****");
            }
        }
        //get the changed words out from the filter        
        PrintWriter out = response.getWriter();
        out.print(fromJsp);
    }


    @Override
    public void destroy() {
        //nothing to do here
    }

}
