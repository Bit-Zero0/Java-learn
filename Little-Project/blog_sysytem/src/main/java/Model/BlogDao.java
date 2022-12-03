package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 这个类用于去封装博客表的基本操作
public class BlogDao {
    // 往博客表里, 插入一个博客.
    public void insert(Blog blog){
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DBUtil.getConnection();

            String sql = "insert into blog values(null , ? , ? ,? , now())";
            statement = connection.prepareStatement(sql);
            statement.setString(1 , blog.getTitle());
            statement.setString(2 , blog.getContent());
            statement.setInt(3 , blog.getUserId());

            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection , statement , null);
        }
    }


    public List<Blog> selectALL(){
        List<Blog> blogs  = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId((resultSet.getInt("blogId")));
                blog.setTitle(resultSet.getString("title"));
                String content = resultSet.getString("content");
                if(content.length() > 50)
                {
                    content =  content.substring(0 , 50)+ "...";
                }

                blog.setContent(content);
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection , statement , resultSet);
        }

        return blogs;
    }

    // 能够根据博客 id 获取到指定的博客内容 (用于在博客详情页)
    public Blog selectOne(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from blog where blogId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , blogId);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getShort("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection , statement , resultSet);
        }

        return null;
    }


    public void delete(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "delete from blog where blogId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , blogId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
