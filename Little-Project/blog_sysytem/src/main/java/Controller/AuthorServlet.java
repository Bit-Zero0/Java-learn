package Controller;

import Model.Blog;
import Model.BlogDao;
import Model.User;
import Model.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//主要用于
@WebServlet("/authorInfo")
public class AuthorServlet extends HttpServlet {
    private ObjectMapper  objectMapper =new ObjectMapper();


    // 通过这个方法, 来获取到指定的博客的作者信息.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");

        String param = req.getParameter("blogId");
        if(param == null || "".equals(param)){
            //缺少参数
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"参数缺失!\" }");
            return;
        }

        // 根据当前 blogId 在数据库中进行查找, 找到对应的 Blog 对象, 再进一步的根据 blog 对象, 找到作者信息.
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(param));
        if(blog == null){
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"要查询的博客不存在!\" }");
            return;
        }

        // 根据 blog 对象, 查询到用户对象
        UserDao  userDao = new UserDao();
        User author = userDao.SelectById(blog.getUserId());
        if(author == null){
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"要查询的用户不存在!\" }");
            return;
        }

        author.setPassword("");
        resp.getWriter().write(objectMapper.writeValueAsString(author));
    }
}
