/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author nimamonsefi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
            Scanner scanner=new Scanner(System.in);
            
            int i;
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Nima:1521:xe"
                                ,"nimamonsefi","password");
            for(i=1;i<9;i++){
                PreparedStatement preparedStatement=connection
                        .prepareStatement("insert into tb2 (code,username,email,password,age"
                                + ",degree) values (?,?,?,?,?,?)");
                
                System.out.print("\nEnter Your Code : ");
                preparedStatement.setString(1,scanner.next());
                
                System.out.print("Enter Your Username : ");
                preparedStatement.setString(2,scanner.next());
                
                System.out.print("Enter Your Email : ");
                preparedStatement.setString(3,scanner.next());
                
                System.out.print("Enter Your Password : ");
                preparedStatement.setString(4,scanner.next());
                
                System.out.print("\nEnter Your Age : ");
                preparedStatement.setInt(5,scanner.nextInt());
                
                System.out.print("\nEnter Your Degree : ");
                preparedStatement.setString(6,scanner.next());
                
                preparedStatement.executeUpdate();
            }
            
        }catch(ClassNotFoundException|SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
