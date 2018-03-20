package cn.wolfcode.shiro;

import cn.wolfcode.domain.User;
import cn.wolfcode.domain.UserType;

public class LoginServiceImpl {
    public static User getLoginUserByName(String name, UserType userType){
        User user = new User();
        if("admin".equals(name) && userType == UserType.ADMIN){
            user.setUserType(UserType.ADMIN);
            user.setPassword("666");
            return user;
        }else if("operator".equals(name)&& userType == UserType.OPERATOR){
            user.setUserType(UserType.OPERATOR);
            user.setPassword("777");
            return user;
        }else if("user".equals(name)&& userType == UserType.USER){
            user.setUserType(UserType.USER);
            user.setPassword("888");
            return user;
        }
        return null;
    }
}
