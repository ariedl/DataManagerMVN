/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucdavis.ucdmc.ri.datamanagermvn.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author ariedl
 */
public class PropsReader {
    private InputStream myInputStream;
    
    public Properties getProperties(String propsFile) throws IOException{
        Properties myProps = new Properties();
        
        try{
            myInputStream = new FileInputStream(new File(propsFile));
            
            if(myInputStream != null){
                myProps.load(myInputStream);
            }else{
                throw new FileNotFoundException();
            }                
            
        }catch(Exception e){
              System.out.println("Exception:  "+e);
        }finally{
            myInputStream.close();
        }
        
        
        return myProps;
    }
}
