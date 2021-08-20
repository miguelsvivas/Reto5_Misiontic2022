package utp.misiontic2022.c2.p21.reto4.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        var connection = JDBCUtilities.getConnection();
        var respuesta = new ArrayList<Requerimiento_3>();
        
        var consulta = "SELECT c.Proveedor, mc.Nombre_Material, mc.Importado, mc.Precio_Unidad, SUM(c.Cantidad ) as Cantidad"
        + " FROM MaterialConstruccion mc "
        + " JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion" 
        + " WHERE mc.Importado = 'Si'AND c.Proveedor = 'Homecenter'"
        + " GROUP BY mc.Nombre_Material"
        + " HAVING SUM(c.Cantidad)>100";



        
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try{

            stmt = connection.prepareStatement(consulta);
            rset = stmt.executeQuery();

        
        while(rset.next()){
                var requerimiento3VO = new Requerimiento_3();
                requerimiento3VO.setProveedor(rset.getString("Proveedor"));
                requerimiento3VO.setNombreMaterial(rset.getString("Nombre_Material"));
                requerimiento3VO.setImportado(rset.getString("Importado"));
                requerimiento3VO.setPrecioUnidad(rset.getInt("Precio_Unidad"));
                requerimiento3VO.setCantidad(rset.getInt("Cantidad"));
                
                respuesta.add(requerimiento3VO);
            }

        }finally{
            if(rset != null){
                rset.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(connection != null){
                connection.close();
            }
        }         



        return respuesta;




    }





   
}