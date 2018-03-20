package cn.wolfcode.shiro.realm;

import cn.wolfcode.domain.User;
import cn.wolfcode.domain.UserType;
import cn.wolfcode.shiro.CustomLoginToken;
import cn.wolfcode.shiro.LoginServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class AdminRealm extends AuthorizingRealm {
    public String getName() {
        return "AdminRealm";
    }
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
                throws AuthenticationException {
        CustomLoginToken currentToken = (CustomLoginToken) token;
        if(currentToken.getUserType() != UserType.ADMIN){
            //非管理员登录，认证失败
            return null;
        }
        //查询管理账号
        //User user = getUserByUsername();
        //此处为模拟管理员
        User user = LoginServiceImpl.getLoginUserByName(
                    currentToken.getUsername(), UserType.ADMIN);
        if(user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
    //授权：此处不研究
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
