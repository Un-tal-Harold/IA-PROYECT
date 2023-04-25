package Conectar;

import java.sql.*;
import java.util.*;

public class NewMain {

    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);
       
        System.out.println("Que deseas consultar?:");
        String pregunta = teclado.nextLine();
        Conectar con= new Conectar();
        
        buscarPregunta bus = new buscarPregunta();
        BuscarRespuesta respuesta= new BuscarRespuesta();
        respuesta.Buscarporpregunta(bus.Buscarporpregunta(pregunta));
        /*
        buscar2 bu = new buscar2();
        System.out.println("Numero de pregunta a encontrar:");
        int idPregunta= teclado.nextInt();
        bu.Buscarporpregunta(idPregunta);
        */
    }
}