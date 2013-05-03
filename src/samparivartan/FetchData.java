/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package samparivartan;

/**
 *
 * @author nisheeth
 */
import java.sql.*;
import javax.swing.*;

public class FetchData
{

   String[]  highFreqWords(String lastWord)
  {
        String words[]= new String[5];
         System.out.println("MySQL Connect Example.");
         Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "samparivartan";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";
    try {
      Class.forName(driver).newInstance();
      conn = DriverManager.getConnection(url+dbName,userName,password);
      System.out.println("Connected to the database");



      Statement stmt=conn.createStatement();
       int len=lastWord.length();
      String ff="select Hword from transliteration where sno in (select sno from tmapping where (select subStr(tmapping.eword,1,"+len+") from dual)  like '"+lastWord+"') order by frequency desc";
      ResultSet rs=stmt.executeQuery(ff);
      int i=0;
      while ((rs.next())&&(i<5))
    {
        String uu=rs.getString(1);
        //System.out.println(uu);
        words[i]=uu;
         i++;
    }


      conn.close();
      conn=null;


    } catch (Exception e) {
      e.printStackTrace();
    }
       return words;

  }
}
