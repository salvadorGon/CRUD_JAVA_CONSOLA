
package dao;

import Interface.IPersona;
import data.Conexion;
import model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PersonaDao implements IPersona{

    @Override
    public int insert(Persona p) {
        
        String sql;
        int r = 0;
        try{
            Conexion con = new Conexion();
            sql = "insert into personas(nombre, apellido, edad) values(?,?,?)";
            PreparedStatement ps = con.conectarMYSQL().prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getLstName());
            ps.setInt(3, p.getEdad());
            r =ps.executeUpdate(); 
        }
        catch(SQLException e){
            System.out.println("ERROR:"+e.getMessage());
        }
        return r;
    }

    @Override
    public Persona getPersona(int id) {
        Persona p= new Persona();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try{
            Conexion con = new Conexion();
            sql = "SELECT idPersona, nombre, apellido, edad FROM personas WHERE idPersona = ?";
            ps = con.conectarMYSQL().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery(); 
            while(rs.next()){
                p.setIdPersona(rs.getInt("idPersona"));
                p.setName(rs.getString("nombre"));
                p.setLstName(rs.getString("apellido"));
                p.setEdad(rs.getInt("edad"));
            }
        }
        catch(SQLException e){
            System.out.println("ERROR:"+e.getMessage());
        }
        return p;
    }

    @Override
    public int delete(int i) {
        PreparedStatement ps = null;
        int r = 0;
        String sql;
        try{
            Conexion con = new Conexion();
            sql = "DELETE FROM personas WHERE idPersona = ?";
            ps = con.conectarMYSQL().prepareStatement(sql);
            ps.setInt(1, i);
            r = ps.executeUpdate(); 
        }
        catch(SQLException e){
            System.out.println("ERROR:"+e.getMessage());
        }
        return r;
    }

    @Override
    public ArrayList<Persona> getPersonas() {
        
        String sql;
        ArrayList<Persona> list= new ArrayList<Persona>();
        
        try{
            Conexion con = new Conexion();
            sql = "SELECT idPersona, nombre, apellido, edad FROM personas";
            Statement stm = con.conectarMYSQL().createStatement();
            ResultSet rs = stm.executeQuery(sql); 
            while(rs.next()){
                Persona p = new Persona();
                p.setIdPersona(rs.getInt("idPersona"));
                p.setName(rs.getString("nombre"));
                p.setLstName(rs.getString("apellido"));
                p.setEdad(rs.getInt("edad"));
                list.add(p);  
            }
        }
        catch(SQLException e){
            System.out.println("ERROR:"+e.getMessage());
        }
        return list;
    }

    @Override
    public int edit(Persona p) {
        PreparedStatement ps = null;
        int r = 0;
        String sql;
        try{
            Conexion con = new Conexion();
            sql = "UPDATE personas SET nombre=?, apellido=?, edad=? WHERE idPersona = ?";
            ps = con.conectarMYSQL().prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getLstName());
            ps.setInt(3, p.getEdad());
            ps.setInt(4, p.getIdPersona());
            r = ps.executeUpdate(); 
        }
        catch(SQLException e){
            System.out.println("ERROR:"+e.getMessage());
        }
        return r;
    }

    @Override
    public ArrayList<Persona> getPersonas(int cantidad, int inicio) {
        //Statement stm = null;
        //ResultSet rs = null;
        String sql;
        ArrayList<Persona> list= new ArrayList<Persona>();
        
        try{
            Conexion con = new Conexion();
            sql = "SELECT idPersona, nombre, apellido, edad FROM personas LIMIT ? OFFSET ? ";
            PreparedStatement ps = con.conectarMYSQL().prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, inicio);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next()){
                Persona p = new Persona();
                p.setIdPersona(rs.getInt("idPersona"));
                p.setName(rs.getString("nombre"));
                p.setLstName(rs.getString("apellido"));
                p.setEdad(rs.getInt("edad"));
                list.add(p);  
            }
        }
        catch(SQLException e){
            System.out.println("ERROR:"+e.getMessage());
        }
        return list;
    }
    
}
