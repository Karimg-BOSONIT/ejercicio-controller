package org.example.ejerciciocontroller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String redirectHeader = httpRequest.getHeader("redirige");
        if ("SALTA".equals(redirectHeader)) {
            entryJump();
        }
        //sino tiene SALTA, siga ejecutando el resto del codigo
        chain.doFilter(request, response);
    }

    private String entryJump(){
        System.out.println("ENTRYJUMP");
        return "Entrado en Jump";
    }
}
