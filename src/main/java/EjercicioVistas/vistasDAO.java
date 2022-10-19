
package EjercicioVistas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class vistasDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexionvistas acceso = new conexionvistas();
    
   
    
    public void ingresoDatos(int codigo, String nombre, int cantidad, String fabricacion, String fecha){
        String sql = "insert into productos (codigo, nombre_producto, cantidad, fabricacion, fecha) values (?,?,?,?,?);";
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
        
        String sql = "Update productos set nombre_producto = ?, cantidad = ?, fabricacion = ?, fecha = ? where codigo = ?";
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
    
        public ArrayList listar(){
        String sql = "Select * from productos ";
        try{
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<producto> datos = new ArrayList<>();
            
            while (rs.next()) {
                producto pro = new producto();

                pro.setCodigo(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setCantidad(rs.getInt(3));
                pro.setFabricacion(rs.getString(4));
                pro.setFecha(rs.getString(5));
                //System.out.println(rs.getInt(1));
                datos.add(pro);
            }
            return datos;
            
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
        
    }
        
        public void buscar(int codigo){
            
            String sql = "select * from productos where codigo ="+codigo;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Modificar mv = new Modificar();
                mv.mostrar(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
                mv.setVisible(true);
                
               
            }else{
                System.out.println("Codigo invalido");
            }
        } catch (Exception e) {
        }
            
             
            
        }
        
        public void eliminar(int codigo) {
        String sql = "delete from productos where codigo=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
        
       public void buscar_eliminar(int codigo){
        String sql = "select * from productos where codigo ="+codigo;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                eliminar elim = new eliminar();
                elim.t_codigo.setText(rs.getInt(1)+"");
                elim.t_nombre.setText(rs.getString(2));
                elim.t_cantidad.setText(rs.getInt(3)+"");
                elim.t_fabricacion.setText(rs.getString(4));
                elim.t_fecha.setText(rs.getString(5));
                
                elim.setVisible(true);

            }else{
                System.out.println("Codigo invalido");
            }
        } catch (Exception e) {
        } 
       }
       
       public static void main(String[] args) {
        vistasDAO ej = new vistasDAO();
        ej.listar();
        
    }
    
}
