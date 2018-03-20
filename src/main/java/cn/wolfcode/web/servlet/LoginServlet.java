package cn.wolfcode.web.servlet;

import cn.wolfcode.domain.User;
import cn.wolfcode.domain.UserType;
import cn.wolfcode.shiro.CustomLoginToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取登录参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");

        //获取shiro操作主体
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            try {
                CustomLoginToken token = new CustomLoginToken(username, password, UserType.valueOf(userType.toUpperCase()));
                subject.login(token);
            }catch (Exception e){
                e.printStackTrace();
                req.setAttribute("errorMsg", "登录失败....");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                return;
            }
        }

        User user = (User) subject.getPrincipal();
        resp.sendRedirect("/" + user.getUserType().name().toLowerCase() +".jsp");
    }
}
