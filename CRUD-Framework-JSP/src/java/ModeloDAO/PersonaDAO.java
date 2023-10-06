
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="select * from persona";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setAtrId(rs.getInt("Id"));
                per.setAtrDni(rs.getString("DNI"));
                per.setAtrName(rs.getString("Nombres"));    
                per.setAtrLstName(rs.getString("Apellidos"));
                per.setAtrPhone(rs.getString("Telefono"));
                per.setAtrEmail(rs.getString("Email"));
                per.setAtrResid(rs.getString("Residencia"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql="select * from persona where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setAtrId(rs.getInt("Id"));
                p.setAtrDni(rs.getString("DNI"));
                p.setAtrName(rs.getString("Nombres"));
                p.setAtrLstName(rs.getString("Apellidos"));
                p.setAtrPhone(rs.getString("Telefono"));
                p.setAtrEmail(rs.getString("Email"));
                p.setAtrResid(rs.getString("Residencia"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="insert into persona(DNI, Nombres, Apellidos, Telefono, Email, Residencia) values ('"+per.getAtrDni()+"','"+per.getAtrName()+"','"+per.getAtrLstName()+"','"+per.getAtrPhone()+"','"+per.getAtrEmail()+"','"+per.getAtrResid()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql="update persona set DNI='"+per.getAtrDni()+"',Nombres='"+per.getAtrName()+"',Apellidos='"+per.getAtrLstName()+"',Telefono='"+per.getAtrPhone()+"',Email='"+per.getAtrEmail()+"',Residencia='"+per.getAtrResid()+"' where Id="+per.getAtrId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from persona where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
