package model;

public class Persona {
    private int idPersona;
    private String name;
    private String lstName;
    private int edad;

    public Persona() {
    }

    public Persona(int idPersona, String name, String lstName, int edad) {
        this.idPersona = idPersona;
        this.name = name;
        this.lstName = lstName;
        this.edad = edad;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLstName() {
        return lstName;
    }

    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
