/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaBeans.Categoria;

/**
 *
 * @author JHONMAROCI
 */
public class CategoriCad {
    public static ArrayList<Categoria> listar() throws SQLException{
        try{
            String sql= "{CALL sp_listarCategoriaSuperior()}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia = c.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery();

            ArrayList<Categoria> lista = new ArrayList<>();

            while(resultado.next()){
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }
}
