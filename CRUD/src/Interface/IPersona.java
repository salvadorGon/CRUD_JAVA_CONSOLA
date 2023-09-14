
package Interface;

import java.util.ArrayList;
import model.Persona;

public interface IPersona {
    
    public int insert(Persona p);
    public Persona getPersona(int i);
    public int delete(int i);
    public ArrayList<Persona> getPersonas();
    public int edit(Persona p);
    public ArrayList<Persona> getPersonas(int cantidad, int inicio);
}
