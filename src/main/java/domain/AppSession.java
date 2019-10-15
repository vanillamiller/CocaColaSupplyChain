package domain;

import domain.Transactor;
import domain.User;
import org.apache.shiro.SecurityUtils;

public class AppSession {

    public static final String USER_ATTRIBUTE_NAME="user";
    public static final String FACTORYHQ_ROLE="factory";
    public static final String BOTTLER_ROLE="bottler";
    public static final String DC_ROLE="dc";
    public static final String CLIENT_ROLE="client";

    public static boolean hasRole(String role){
        return SecurityUtils.getSubject().hasRole(role);
    }

    public static boolean isAuthenticatated(){
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public static void init(Transactor user){
        SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user);
    }

    public static Transactor getUser(){
        return (Transactor) SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }


}
