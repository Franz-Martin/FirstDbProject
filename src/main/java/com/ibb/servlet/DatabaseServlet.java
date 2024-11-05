package com.ibb.servlet;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Dieses Servlet erzeugt dynamischen Inhalt aus Datenbank-Daten
 */
@WebServlet(urlPatterns = "/myDB")
public class DatabaseServlet extends HttpServlet {

   /**
    * Globale Variable: Die geöffnete Datenbank-Verbindung
    */
   private Connection connection;

   /**
    * Initialisieren der Datenbank-Verbindung mit Parametern aus
    * dem Web Deployment Descriptor WEB-INF/web.xml
    */
   @Override
   public void init(ServletConfig config)throws ServletException {

      // Überschriebene init()-Methode der Superklasse aufrufen !
      super.init(config);
  
      // Parameter aus der Datein WEB-INF/web.xml auslesen
//      String driver = config.getInitParameter("jdbcClass");
//      String dbURL = config.getInitParameter("dbURL");
//      String dbUser = config.getInitParameter("username");
//      String dbPass = config.getInitParameter("password");

      // Initialisieren der Datenbank-Verbindung
      try {
         // Laden des Datenbank-Treibers Über den ClassLoader
        Class.forName("com.mysql.cj.jdbc.Driver");

         // Aufbau der Datenbank-Verbindung
         connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/foodshop", "root","" );
//        Context ctx= new InitialContext();
//        DataSource ds =(DataSource) ctx.lookup("jdbc/foodshop");
//        connection=ds.getConnection();
      } catch (Exception exc) {
         throw new ServletException("SQL-Exception in init()", exc);
      }
   }

   /**
    * Service-Methode zur Verarbeitung von GET-Requests
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

       HttpSession session=request.getSession();
      // Binden der (in JSPs vordefinierten) Variable out
      PrintWriter out = response.getWriter();

      // Erzeugen von HTML-Code ...
      //String str=request.getParameter("where");
      out.println("<!DOCTYPE html><html><body><center>Datensätze</center>");
      out.println("<table><tr><td>Name</td><td>Preis</td></tr>");
      // RequestDispatcher dis=request.getRequestDispatcher("index.jsp?name=Fritz");
      // ... und Einbinden von dynamischem Inhalt
      try {
         ResultSet rs = null;
         try {
            // Ausführen eines SQL-Statements via JDBC
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("Select name, price from foods ");

            // Iterieren Über die Ergebnismenge des SQL-Statements
            while (rs.next()) {
               out.println("<tr><td>" + rs.getString(1) + "</td>");
               out.println("<td>" + rs.getString(2) + "</td></tr>");
            }

         } finally {
            rs.close();
         }

      } catch (SQLException exc) {
         throw new ServletException("SQL-Exception", exc);
      }

      out.println("</table></body></html>");
     
   }

   /**
    * Bearbeiten von POST-Requests analog zu GET
    */
   public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
      throws IOException, ServletException {

      // Weiterleiten des Requests an die Methode doGet()
      doGet(request, response);
   }

   /**
    * Wird verwendet um belegte Ressourcen freizugeben
    */
   public void destroy() {
      try {
         // Freigeben von Datenbank-Ressourcen
         connection.close();
      } catch (SQLException exc) {
         log("SQL-Exception in destroy()", exc);
      }
   }
}
