
package data;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexion {
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String database;
    public String hostname;
    public String port;
    public String url;
    public String username;
    public String password;
    Connection con = null;

    public Conexion(String database, String hostname, String port, String url, String username, String password) {
        this.database = database;
        this.hostname = hostname;
        this.port = port;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Conexion() {
        this.database = "base";
        this.hostname = "localhost";
        this.port = "3306";
        this.url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useUnicode=true&use"+
                "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.username = "root";
        this.password = "";
    }
    
    public Connection conectarMYSQL(){
        try{
            Class.forName(driver);
            this.con = (Connection) DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException e){
            System.out.println("ocurre una classNotFoundException: "+e.getMessage());
        }
        catch(SQLException e){
            System.out.println("ocurre una SQLException: "+e.getMessage());
        }
        return con;
    }
}
