package utp.misiontic2022.c2.p21.reto4.modelo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
       var connection = JDBCUtilities.getConnection();
       var respuesta = new ArrayList<Requerimiento_1>(); 


       var consulta = "SELECT mc.Nombre_Material, mc.Precio_Unidad"
       + " FROM MaterialConstruccion mc "
       + " WHERE mc.Importado = 'Si'"
       + " ORDER BY mc.Precio_Unidad DESC ;"; 


       PreparedStatement stmt = null;
       ResultSet rset = null;


       try{

        stmt = connection.prepareStatement(consulta);
        rset = stmt.executeQuery();

    
    while(rset.next()){
            var requerimiento1VO = new Requerimiento_1();
            requerimiento1VO.setNombreMaterial(rset.getString("Nombre_Material"));
            requerimiento1VO.setPrecioUnidad(rset.getInt("Precio_Unidad"));
            
            respuesta.add(requerimiento1VO);
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