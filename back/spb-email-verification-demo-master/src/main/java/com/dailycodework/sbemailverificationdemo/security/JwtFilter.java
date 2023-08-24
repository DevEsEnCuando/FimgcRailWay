//package com.dailycodework.sbemailverificationdemo.security;
//
//
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//	private final JwtUtil jwtUtil;
//	private final UserRegistrationDetailsService userRegistrationDetailsService;
//
//	@Autowired
//	public JwtFilter(JwtUtil jwtUtil, UserRegistrationDetailsService userRegistrationDetailsService) {
//		this.jwtUtil = jwtUtil;
//		this.userRegistrationDetailsService = userRegistrationDetailsService;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// 1. Validar que sea un Header Authorization valido
//		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//		if (authHeader == null || authHeader.isEmpty() || !authHeader.startsWith("Bearer")) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		// 2. Validar que el JWT sea valido
//		String jwt = authHeader.split(" ")[1].trim();
//
//		if (!this.jwtUtil.isValid(jwt)) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		// 3. Cargar el usuario del userRegistrationDetailsService
//		String username = this.jwtUtil.getUsername(jwt);
//		User user = (User) this.userRegistrationDetailsService.loadUserByUsername(username);
//
//		// 4. Cargar al usuario en el contexto de seguridad.
//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//				user.getUsername(), user.getPassword(), user.getAuthorities());
//
//		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//		System.out.println(authenticationToken);
//		filterChain.doFilter(request, response);
//	}
//}
