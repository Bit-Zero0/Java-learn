package Model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

// 每个 model.Blog 对象, 对应 blog 表里的一条记录
public class Blog {
    private int blogId;
    private  String title;
    private String content;
    private  int userId;
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    //装换出来是是时间戳
    //    public Timestamp getPostTime() {
    //        return postTime;
    //    }

    // 使用 SimpleDateFormat 来完成时间戳到格式化日期时间的转换.
    public String getPostTime(){
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleTimeFormat.format(postTime);
    }

    public void setPostTime(Timestamp postTime){
        this.postTime = postTime;
    }

}
