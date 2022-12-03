package Model;

// 每个 model.User 对象, 期望能够表示 user 表中的一条记录.
public class User {
    private int userId = 0;
    private String username = "";
    private String password = "";

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
