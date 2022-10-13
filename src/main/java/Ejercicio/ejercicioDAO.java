
package Ejercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ejercicioDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionEjercicio acceso = new conexionEjercicio();
    
    public void listar(){
        String sql = "Select * from producto ";
        try{
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("*****************************");
                System.out.println("Codigo: " + rs.getInt(1));
                System.out.println("Nombre producto: " + rs.getString(2));
                System.out.println("Cantidad: " + rs.getInt(3));
                System.out.println("Lugar de fabricacion: " + rs.getString(4));
                System.out.println("Fecha de ingreso: "+rs.getString(5));
            }
        }catch (Exception e){
        }
    }
    
    public void ingresoDatos(int codigo, String nombre, int cantidad, String fabricacion, String fecha){
        String sql = "insert into producto (codigo, nombreProd, cantidad, fabricacion, fecha) values (?,?,?,?,?);";
        try{
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, cantidad);
            ps.setString(4, fabricacion);
            ps.setString(5, fecha);
            ps.executeUpdate();
        }catch(Exception e){
        }
        
    }
    
    public void modificar(int codigo, String nombre, int cantidad, String fabricacion, String fecha){
        
        String sql = "Update producto set nombreProd = ?, cantidad = ?, fabricacion = ?, fecha = ? where codigo = ?";
        try{
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
        
            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            ps.setString(3, fabricacion);
            ps.setString(4, fecha);
            ps.setInt(5, codigo);
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
        
    }
    public void eliminar(int codigo){
        String sql = "delete from producto where codigo = ?";
        try{
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
    }
    
}
