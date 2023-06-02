package Conectar;
import java.sql.*;
public class Conectar {
    	
    public static final String URL = "jdbc:mysql://aws.connect.psdb.cloud/ia-project?sslMode=VERIFY_IDENTITY";
    public static final String  USER = "u2ek9w1t1sqlfbag631l";
    public static final String CLAVE = "pscale_pw_2yCewaInZSgIyFDq6XDug8jIF8NpfSSrFOrgtTp0Whn";
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
