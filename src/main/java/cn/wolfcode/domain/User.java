package cn.wolfcode.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * 所有类型统一登录信息
 */
@Setter@Getter
public class User {
    private Long id;
    private String username;
    private String password;
    private UserType userType;

    //其他必要的信息...
}
