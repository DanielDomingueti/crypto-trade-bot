package com.domingueti.tradebot.security.jwt;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.domingueti.tradebot.modules.Admin.dtos.AdminRouteDTO;
import com.domingueti.tradebot.modules.Admin.repositories.AdminRepository;
import com.domingueti.tradebot.modules.User.dtos.UserOnlyDataDTO;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.security.dtos.AdminLoginDTO;
import com.domingueti.tradebot.security.dtos.UserLoginDTO;
import com.domingueti.tradebot.utils.statics.ApplicationContextUtils;
import com.domingueti.tradebot.utils.statics.ReplaceRouteNumbers;

public class JWTAuthentication {

	private ApplicationContext appCtx;
	private JWTHandler jwtHandler;
	private SecurityConstants securityConstants;

	public JWTAuthentication() {
		appCtx = ApplicationContextUtils.getAppContext();
		jwtHandler = (JWTHandler) appCtx.getBean("jwtHandler");
		securityConstants = (SecurityConstants) appCtx.getBean("securityConstants");
	}

	public UsernamePasswordAuthenticationToken getAdminAuthentication(HttpServletRequest request, boolean userRoute) {
		AdminRepository adminRepository = (AdminRepository) appCtx.getBean("adminRepository");

		String token = request.getHeader(securityConstants.getHeaderString()).replace(securityConstants.getTokenType(),
				"");

		String requestURI = ReplaceRouteNumbers.execute(request.getRequestURI());

		if (token != null) {
			Collection<SimpleGrantedAuthority> authorities = jwtHandler.getAuthorities(token);

			String email = jwtHandler.getSubject(token);

			if (userRoute) {
				return new UsernamePasswordAuthenticationToken(null, email, authorities);
			}

			AdminRouteDTO findAdmin = adminRepository.findOneByEmailAndDeletedAtIsNull(email, requestURI,
					request.getMethod());

			if (findAdmin != null) {
				AdminLoginDTO adminPrincipal = new AdminLoginDTO(findAdmin.getId(), findAdmin.getName(), email);

				return new UsernamePasswordAuthenticationToken(adminPrincipal, email, authorities);
			}
		}
		return null;
	}

	public UsernamePasswordAuthenticationToken getUserAuthentication(HttpServletRequest request) {
		UserRepository userRepository = (UserRepository) appCtx.getBean("userRepository");

		String token = request.getHeader(securityConstants.getHeaderString()).replace(securityConstants.getTokenType(),
				"");

		String requestURI = ReplaceRouteNumbers.execute(request.getRequestURI());

		if (token != null) {

			Long adminId = jwtHandler.getAdminId(token);
			boolean adminLogin = adminId != null;

			Collection<SimpleGrantedAuthority> authorities = jwtHandler.getAuthorities(token);

			String emailOrDocument = jwtHandler.getSubject(token);

			UserOnlyDataDTO findUser = userRepository.findOneByEmailOrDocumentAndDeletedAtIsNull(emailOrDocument,
					request.getMethod(), requestURI);

			if (findUser != null) {
				UserLoginDTO userPrincipal = new UserLoginDTO(findUser.getId(), findUser.getName(),
						emailOrDocument, adminLogin, adminId);

				return new UsernamePasswordAuthenticationToken(userPrincipal, emailOrDocument, authorities);
			}
		}

		return null;

	}
}
