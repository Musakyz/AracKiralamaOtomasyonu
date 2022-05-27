/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import entity.UserManager;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Musa
 */
@WebFilter("/*")
public class LoginFilter  implements Filter{

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
     HttpServletRequest request =( HttpServletRequest)arg0;
     HttpServletResponse response=(HttpServletResponse) arg1;

      String url=request.getRequestURI();
      HttpSession session=request.getSession();
      UserManager user=null;
      if(session!=null){
      user=(UserManager) session.getAttribute("validUser");
    
    }
       if(user==null){
           if(url.contains("logout") || url.contains("private")){
                response.sendRedirect(request.getContextPath()+"/login.xhtml");
           }
           
           
       }else{
           
           if(url.contains("register")){
               response.sendRedirect(request.getContextPath()+"/index.xhtml");
               
           }else if(url.contains("logout")){
               session.invalidate();
               response.sendRedirect(request.getContextPath()+"/login.xhtml");
               
               
           }
           else{
               
               arg2.doFilter(arg0, arg1);
           }
       }
      
      
        arg2.doFilter(arg0, arg1);
    }
    
}
