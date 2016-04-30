/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucdavis.ucdmc.ri.datamanagermvn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariedl
 */
public class GenericJDBCDAO {
    private Connection myConnection;
    
    
    public ResultSet getResultSet(String databaseNickname, String sql){
        this.openCon(databaseNickname);
        Statement stmt = null;
        ResultSet myResultSet = null;
        try{
            stmt = myConnection.createStatement();
            myResultSet = stmt.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Exception" + e);
        }
       return myResultSet;      
    }

    private void openCon(String databaseNickname) {
        OracleCon myOracleCon = new OracleCon();
        myConnection = myOracleCon.getOracleConnection(databaseNickname);
    }
    
    public void closeCon(){
        try {
            myConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericJDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
