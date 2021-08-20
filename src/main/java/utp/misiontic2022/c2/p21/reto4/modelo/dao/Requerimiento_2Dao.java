package utp.misiontic2022.c2.p21.reto4.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        var connection = JDBCUtilities.getConnection();
        var respuesta = new ArrayList<Requerimiento_2>();



        var consulta = "SELECT DISTINCT p.Constructora , p.Ciudad"
        + " FROM Proyecto p "
        + " WHERE p.Ciudad LIKE 'B%'"
        + " ORDER BY p.Ciudad ;"; 
       

 
        PreparedStatement stmt = null;
        ResultSet rset = null;


        try{

            stmt = connection.prepareStatement(consulta);
            rset = stmt.executeQuery();
    
        
        while(rset.next()){
                var requerimiento2VO = new Requerimiento_2();
                requerimiento2VO.setConstructora(rset.getString("Constructora"));
                requerimiento2VO.setCiudad(rset.getString("Ciudad"));
                
                respuesta.add(requerimiento2VO);
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