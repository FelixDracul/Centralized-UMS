package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Extream programmer
 */
public class DatabaseConnection {
    
    protected String Driver ="com.mysql.jdbc.Driver";
    protected String URL ="jdbc:mysql://localhost:3306/javadatabase";
    
    
    
   
    
 
     protected String checkDB(String table,String uName,String Password){
        String error ="00";
         try{
             
         Class.forName(Driver);
         Connection con = DriverManager.getConnection(URL,"root","");
         Statement st = con.createStatement();
         String query = "SELECT * FROM "+table+" WHERE Uname ='"+uName+"'";
         ResultSet rs = st.executeQuery(query);
         while(rs.next()){
            if(rs.getString("password").equals(Password)){
                error = "correct";
            }
            else{
                error = "wrong username or password";
            }
         }
         }catch(Exception ee){
             error = ee.getMessage();
         }
         
         return error;
    }
    
    
}
