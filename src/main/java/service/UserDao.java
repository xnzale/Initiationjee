package service;

import model.User;

import java.sql.ResultSet;

public class UserDao {
    public User logon(String login, String pwd){
        User u = null;
        try{
            String sql = "SELECT * FROM utilisateur WHERE login= ? AND password = ?";
            DatabaseHelper db = DatabaseHelper.getInstance();
            db.iniPreparedCmd(sql);
            db.getPstmt().setString(1, login);
            db.getPstmt().setString(2, pwd);
            ResultSet rs = db.My_ExecutePrepareQuery();
            if(rs.next()){
                u = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            rs.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return u;
    }
}
