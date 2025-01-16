package com.ibb.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author Schulung
 */
public  class GConnection {

    /**
     * Holt eine Datenbankverbindung.
     * @return SQL Connection oder null wenn Fehler.
     */
    public Connection getConnection() {
        Connection con=null;
        try {

            //Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/foodshop","root", "");
            Context ctx=new InitialContext();
            //Diese Anweisung ist für Glassfisch bzw Payara
            //DataSource ds=(DataSource) ctx.lookup("jdbc/foodshop");
            DataSource ds=(DataSource) ctx.lookup("java:/comp/env/jdbc/foodshop");
            con=ds.getConnection();
            //conn.setAutoCommit(false);
            return con;

        } catch (SQLException ex) {
            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) { 
            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
