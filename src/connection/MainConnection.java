package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainConnection {
    static String user = "postgres";
    static  String pwd = " ";
    static String url = "jdbc:postgresql://localhost:5432/SchoolDB";
    static String sql = "select * from students";

  public static void main(String[] args) throws SQLException {
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    try {
      con= DriverManager.getConnection(url, user, pwd);
      st = con.createStatement();
      rs = st.executeQuery(sql);
    
    while(rs.next()) {
      System.out.println(rs.getInt("student_id")+ " " + rs.getString("student_name")
      +" " + rs.getInt("class_id")+" "+ rs.getInt("grade")+" " + rs.getString("gender")
      +" "+ rs.getInt("age"));
    }
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }finally {
      if(rs != null) {
        rs.close();        
      }
      if(st != null) {
        st.close();
      }
      if(con != null) {
        con.close();
      }
    }
    
    

  }

}
