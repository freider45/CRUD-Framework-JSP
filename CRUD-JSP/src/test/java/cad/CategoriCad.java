
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
    public static ArrayList<Categoria> listar() {
        try {
            String sql = "{CALL sp_listarCategoriaSuperior()}";
            Connection c = Conexion.conectar();
            
            if (c == null) {
                return new ArrayList<>();
            }
            
            CallableStatement sentencia = c.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery();

            ArrayList<Categoria> lista = new ArrayList<>();

            while (resultado.next()) {
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            
            c.close();
            sentencia.close();
            resultado.close();

            return lista;
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }
    
    public static ArrayList<Categoria> listarSubCategorias(int catSuperior) {
        try {
            String sql = "{CALL sp_listarSubCategoria(?)}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia = (CallableStatement) c.prepareCall(sql);
            sentencia.setInt(1, catSuperior);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();

            while (resultado.next()) {
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static boolean esSuperior(int cat) {
        try {
            String sql = "{CALL sp_contarSubCategorias()}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia = (CallableStatement) c.prepareCall(sql);
            sentencia.setInt(1, cat);
            ResultSet resultado = sentencia.executeQuery();

            resultado.next();
           
            return resultado.getInt("cantidad")>0;
        } catch (SQLException ex) {
            return false;
        }
    }
}
