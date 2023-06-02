package Conectar;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarRespuesta {
    public void Buscarporpregunta(int idPregunta){
        String consulta ="SELECT  Respuestas  FROM Respuestas WHERE ID=(?);";
        Conectar con = new Conectar();
        try{
            CallableStatement cs = con.conectar().prepareCall(consulta);
            //parametro de busqueda
            cs.setInt(1, idPregunta);
            //realiza la consulta
            cs.execute();
            //mostrar el resultado
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()){
                String id;
                id=rs.getString("Respuestas");
                System.out.println(id);
            }else{
                System.out.println("Lo sentimos en este momento no podemos resolver su pregunta");
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }      
    }
}
