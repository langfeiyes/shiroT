package cn.wolfcode.shiro;

import cn.wolfcode.domain.UserType;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomLoginToken extends UsernamePasswordToken {
    @Getter@Setter
    private UserType userType;

    public CustomLoginToken(String username, String password, UserType userType){
        super(username, password);
        this.userType = userType;
    }


}
