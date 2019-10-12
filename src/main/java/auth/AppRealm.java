package auth;
import domain.*;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import session.AppSession;

import java.util.HashSet;
import java.util.Set;

public class AppRealm extends JdbcRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {

        UsernamePasswordToken userPassToken=(UsernamePasswordToken) token;
        final String username=userPassToken.getUsername();
//        final User user=User.getUser(username);
        return null;
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals){
        Set<String> roles=new HashSet<>();
        if(principals.isEmpty()){
            System.out.println("Given principals to authorize are empty.");
            return null;
        }

        Retailer username=new Retailer();
//        final User user=User.getUser(username);
        final Transactor user=new Retailer();

        if(username==null){
            System.out.println("no account for use with username "+username);
            return null;
        }

        if(user instanceof DC || user instanceof CocaColaHQ){
            roles.add(AppSession.AUTHOR_ROLE);
        } else if(user instanceof Retailer){
            roles.add(AppSession.AUTHOR_ROLE);
        }
        return new SimpleAuthorizationInfo(roles);
    }
}
