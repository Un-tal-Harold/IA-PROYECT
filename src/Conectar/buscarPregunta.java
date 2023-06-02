
package Conectar;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class buscarPregunta {
    
    public static int Buscarporpregunta(String pregunta){
        String consulta ="SELECT  ID  FROM Preguntas WHERE Pregunta=(?);";
        Conectar con = new Conectar();
        int id = 0;
        try{
            CallableStatement cs = con.conectar().prepareCall(consulta);
            //parametro de busqueda
            cs.setString(1, pregunta);
            //realiza la consulta
            cs.execute();
            //mostrar el resultado
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()){
                id=rs.getInt("ID");
                //System.out.println(id);
            }else{
                //System.out.println("Lo sentimos en este momento no podemos resolver su pregunta");
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }      
        return id;
    }
}
