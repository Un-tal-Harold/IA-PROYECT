package Conectar;
import java.sql.*;
public class Conectar {
    	
    public static final String URL = "jdbc:mysql://localhost:3306/ia-project";//si algo es el host
    public static final String USER = "5gdmh4d0q1n9082c34w6";
    public static final String CLAVE = "pscale_pw_Crrkm7UUOarxfeQfpBM2pSikYYeHqkVqcD8g72ZZjOo";
    String driver="com.mysql.cj.jdbc.Driver";
    String cadena=  "jdbc:mysql://aws-eu-west-2.connect.psdb.cloud/ia-project?sslMode=VERIFY_IDENTITY";
    Connection con = null;
     
    public Connection conectar(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(cadena,USER,CLAVE);
            //System.out.println("Si se pudo conectar con la base");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
