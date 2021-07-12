package com.connecsen.oterrain.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.connecsen.oterrain.utils.Utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin","*");
		response.addHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type"+
		                   ",Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin,Access-Control-Allow-Credentials, Authorization");
		if(request.getMethod().equals("OPTIONS"))
		{
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			
			String jwtToken =request.getHeader(Utility.HEADER_STRING);
			System.out.println("token :"+jwtToken);
			if(jwtToken == null  || !jwtToken.startsWith(Utility.TOKEN_PREFIX)){
				filterChain.doFilter(request, response);return ;
			}
			Claims claims =Jwts.parser()
					     .setSigningKey(Utility.SECRET)
					     .parseClaimsJws(jwtToken.replace(Utility.TOKEN_PREFIX, ""))
					     .getBody();
			String username =claims.getSubject();
			@SuppressWarnings("unchecked")
			ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
			Collection<GrantedAuthority>authorities= new ArrayList<GrantedAuthority>();
			roles.forEach( r->{
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));

			}
					
			);
			UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(username,null,authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			filterChain.doFilter(request, response);
		}
	}
	

}
