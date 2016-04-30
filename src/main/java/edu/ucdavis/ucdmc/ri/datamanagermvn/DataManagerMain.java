/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucdavis.ucdmc.ri.datamanagermvn;

import edu.ucdavis.ucdmc.ri.datamanagermvn.dao.GenericJDBCDAO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ariedl
 */
public class DataManagerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Hello World, I'm using Maven now!");
        
        //Lets read some data, shall we?
        String rpreprocSql = "select * from ri_dt.x_ucd_loinc_map";
        String clarpSQL = "select * from zc_disp_enc_type";
        
        GenericJDBCDAO myDao = new GenericJDBCDAO();
        ResultSet rs = myDao.getResultSet("clarp", clarpSQL);
        while(rs.next())
            {
                System.out.println(rs.getInt("DISP_ENC_TYPE_C")+" "+rs.getString("NAME"));
            }
        //Be sure to close the connection when done with your data!!
        myDao.closeCon();
        
        rs = myDao.getResultSet("rpreproc", rpreprocSql);
        while(rs.next())
            {
                System.out.println(rs.getInt("COMPONENT_ID")+" "+rs.getString("LOINC"));
            }
        //Close the connection!!
        myDao.closeCon();
        
    }
    
}
