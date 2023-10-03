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
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}
