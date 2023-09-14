package crud;

import Interface.IPersona;
import dao.PersonaDao;
import data.Conexion;
import java.util.ArrayList;
import java.util.Iterator;
import model.Persona;

public class CRUD {
    public static void main(String[] args) {
        
       
       Persona p = new Persona();
       IPersona per = new PersonaDao();
       
       ArrayList<Persona> p1 = per.getPersonas();
       Iterator iterator = p1.iterator();
       System.out.println("ID\tNombre\t\tApellido\t\tEdad");
       while(iterator.hasNext()){
           p = (Persona) iterator.next();
           System.out.print(p.getIdPersona());
           System.out.print("\t"+p.getName());
           System.out.print("\t"+p.getLstName());
           System.out.println("\t"+p.getEdad());
       }
    }    
}
