package session;

import domain.User;
import org.apache.shiro.SecurityUtils;

public class AppSession {

    public static final String USER_ATTRIBUTE_NAME="user";
    public static final String CUSTOMER_ROLE="customer";
    public static final String AUTHOR_ROLE="author";

    public static boolean hasRole(String role){
        return SecurityUtils.getSubject().hasRole(role);
    }

    public static boolean isAuthenticatated(){
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public static void init(User user){
        SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user);
    }

    public static User getUser(){
        return (User) SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }


}
