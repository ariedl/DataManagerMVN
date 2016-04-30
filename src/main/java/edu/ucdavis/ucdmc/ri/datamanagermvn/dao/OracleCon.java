/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucdavis.ucdmc.ri.datamanagermvn.dao;

import edu.ucdavis.ucdmc.ri.datamanagermvn.services.PropsReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariedl
 */
class OracleCon {
    public Connection getOracleConnection(String databaseNickname){
        Connection con = null;
        //Start by getting some properties
        
        String driver = myJDBCProps.getProperty(databaseNickname+"driver");
        String url = myJDBCProps.getProperty(databaseNickname+"url");
        String username = myJDBCProps.getProperty(databaseNickname+"username");
        String pass = myJDBCPass.getProperty(databaseNickname+"pass");
        
        System.out.println("All my Con info: " + driver+url+username+pass);
        
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, pass);
        } catch (Exception ex) {
            Logger.getLogger(OracleCon.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return con;
    }   
    
    public void closeOracleConnection(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(OracleCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // All basic class stuff!
    
    private String jdbcPropsFile;
    private String jdbcPassFile;

    
    private Properties myJDBCProps;
    private Properties myJDBCPass;
    private PropsReader myPropsReader;

    

    private void setJdbcPropsFile(String jdbcPropsFile) {
        this.jdbcPropsFile = jdbcPropsFile;
    }
    
    private void setJdbcPassFile(String jdbcPassFile) {
        this.jdbcPassFile = jdbcPassFile;
    }

        
    public OracleCon() {
        this.init();
    }

    private void init() {
        this.setJdbcPropsFile("src/main/resources/jdbc.properties");
        this.setJdbcPassFile("src/main/resources/jdbcpass.properties");
        myPropsReader = new PropsReader();
        try {
            myJDBCProps = myPropsReader.getProperties(jdbcPropsFile);
            myJDBCPass = myPropsReader.getProperties(jdbcPassFile);
        } catch (IOException ex) {
            Logger.getLogger(OracleCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
