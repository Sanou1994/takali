package com.connecsen.oterrain.utils;

import net.bytebuddy.utility.RandomString;

public final class Utility {
	// CONSTANT POUR LA SECURITE
	public static final String SECRET="sanouarouna90@gmail.com";
	public static final long EXPIRATION_TIME =864_000_000 ;// 10 JOURS
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "Authorization";

	
	// LES URLS D'ACCESS
	public static final String ADD_USER = "/user/add";
	public static final String UPDATE_USER = "/user/update";
	public static final String GET_USER_BY_ID = "/user/users/{id}";
	public static final String DELETE_USER_BY_ID = "/user/users/{id}";
	public static final String GET_ALL_USERS = "/user/users";
	
	public static final String ADD_ROLE = "/user/role/add";
	public static final String UPDATE_ROLE = "/user/role/update";
	public static final String GET_ROLE_BY_ID = "/user/role/roles/{id}";
	public static final String DELETE_ROLE_BY_ID = "/user/role/roles/{id}";
	public static final String GET_ALL_ROLES = "/user/role/roles";
	
	public static final String DO_REGISTER = "/user/register";
	public static final String DO_LOGIN = "/user/login";
	public static final String DO_FORGOT_PASSWORD = "/user/forgot";
	public static final String DO_UPDATE_PASSWORD = "/user/updatePassword";
	
	
	//GENERATEUR DE TOKEN POUR RECUPERER LE MOT DE PASSE
	public static String getTokenResetPassword() {
		return RandomString.make(30);
	}

}
