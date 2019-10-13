package auth;
import domain.*;

import domain.external.Retailer;
import domain.internal.Bottler;
import domain.internal.CocaColaHQ;
import domain.internal.DC;
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
        final Transactor user=User.getUser(username);
        if(user==null) {
            System.out.println("No account found with the username " + username);
            return null;
        }

        return new SimpleAuthenticationInfo(user.getID(), user.getPassword(), getName());
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals){
        Set<String> roles=new HashSet<>();

        if(principals.isEmpty()){
            System.out.println("Given principals to authorize are empty.");
            return null;
        }

        int id=(Integer) principals.getPrimaryPrincipal();
        final Transactor user=User.getUser(id);

        if(user==null){
            System.out.println("no account for use with username "+id);
            return null;
        }

        if(user instanceof DC)
            roles.add(AppSession.DC_ROLE);
        else if(user instanceof Retailer)
            roles.add(AppSession.CLIENT_ROLE);
        else if(user instanceof CocaColaHQ)
            roles.add(AppSession.FACTORYHQ_ROLE);
        else if(user instanceof Bottler)
            roles.add(AppSession.BOTTLER_ROLE);
        return new SimpleAuthorizationInfo(roles);
    }
}
