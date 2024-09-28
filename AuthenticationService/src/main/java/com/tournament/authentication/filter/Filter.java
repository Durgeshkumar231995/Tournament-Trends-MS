package com.tournament.authentication.filter;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Filter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;

        String token=httpRequest.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")) {
            throw new ServletException();
        } else {
            String jwtTok = token.substring(7); // get the token after 7 character skiping Bearer text
            // validation
            String email= Jwts.parser().setSigningKey("secret").parseClaimsJws(jwtTok).getBody().getSubject();


            request.setAttribute("username", jwtTok);
            chain.doFilter(httpRequest, httpResponse);
        }

    }

}
