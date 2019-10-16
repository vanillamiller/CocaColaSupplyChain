package auth;
import domain.*;

import domain.Retailer;
import domain.Bottler;
import domain.CocaColaHQ;
import domain.DC;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import domain.AppSession;

import java.util.HashSet;
import java.util.Set;

public class AppRealm extends JdbcRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {

        UsernamePasswordToken userPassToken=(UsernamePasswordToken) token;
        final String username=userPassToken.getUsername();
        System.out.println("this is the username im apprealm: " + username);
        final Transactor user=Transactor.get(username);
        System.out.println("this is the user object in apprealm: " + user);
        System.out.println("apprealm1 " + user.getPassword());
        System.out.println("apprealm2 " + user.getName());
        System.out.println("apprealm3 " + user.getClass());
//        System.out.println(user.getName()+" name should be here");
        if(user==null) {
            System.out.println("No account found with the username " + username);
            return null;
        }
        System.out.println("id: "+user.getID()+" password: "+user.getPassword());
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
        final Transactor user=Transactor.get(id);

        if(user==null){
            System.out.println("no account for use with username id "+id);
            return null;
        }

        if(user instanceof DC) {
            roles.add(AppSession.DC_ROLE);
        }
        else if(user instanceof Retailer) {
            System.out.println("YES ITS A RETAILER");
            roles.add(AppSession.CLIENT_ROLE);
        }
        else if(user instanceof CocaColaHQ) {
            roles.add(AppSession.FACTORYHQ_ROLE);
        }
        else if(user instanceof Bottler) {
            roles.add(AppSession.BOTTLER_ROLE);
            System.out.println("OH CRAP A BOTTLER");
        }
        return new SimpleAuthorizationInfo(roles);
    }
}
