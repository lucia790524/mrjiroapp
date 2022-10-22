package co.com.mrjiro.springboot.app.models.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lopez
 */
public class Conexion {
    public Connection get_connection(){
        Connection conection = null; 
        try{
         
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3009/bd_pedidos_mrjiro", "root","");
            
        }catch(SQLException e){
            System.out.println(e);
        }   
        return conection;
    }
    
}
