/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billing;

/**
 *
 * @author ComputationalMachine
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.Properties;
 
/**
 * @author  
 * 
 */
public class DBHandlers {
  public ResultSet query(Customers cust, Bills bill)
   {
   //   ## DEFINE VARIABLES SECTION ##
   // define the driver to use 
      Properties props = new Properties();
      props.setProperty("user", "name");
      props.setProperty("password", "password");
      String driver = "org.apache.derby.jdbc.EmbeddedDriver";
  
   // define the Derby connection URL to use 
      String connectionURL = "jdbc:derby://localhost:1527/Circo";
      Connection conn = null;
      Statement s;
      PreparedStatement psInsert;
      ResultSet queryResult = null;
      int id = 0;
      String phone;
      boolean newCustomer = true;
        try {
            // Create and connect to the database.
            conn = DriverManager.getConnection(connectionURL,props);		 
            System.out.println("Connected to database " + connectionURL);  
            s = conn.createStatement();
            queryResult = s.executeQuery("select ID, PHONE1 from cust");
            while (queryResult.next() && newCustomer){
                if(queryResult.getInt("ID") > id){
                  id = queryResult.getInt("ID");
                  phone = queryResult.getString("PHONE1");
                  if(phone.equals(cust.getPhone())){
                      newCustomer = false;
                      id -= 1;   //if not a new customer subtract one so the id# is the same when incremented                      
                  }
                }
            }//end while
            id += 1;
            queryResult.close();
            if(newCustomer){
                psInsert = conn.prepareStatement("Insert into cust (first_name, last_name, ID, PHONE1, PHONE2, LAST_TRANSACTION) values(\'" + cust.getFirstName() + "\', \'" + cust.getLastName() + "\', " + id + ", \'" + cust.getPhone() + "\', \'" + cust.getPhone2() + "\', \'" + bill.getBillDate() + "\')");
                psInsert.executeUpdate();  
                psInsert = conn.prepareStatement("Insert into addy values (\'" + cust.getMailAddy() + "\', \'" + cust.getAddy() + "\', \'" + cust.getState() + "\', \'" + cust.getZip() + "\', \'" + cust.getCity() + "\', "+ id + ")");
                psInsert.executeUpdate();
            }
            psInsert = conn.prepareStatement("Insert into bill values (\'" + bill.getInvNum() + "\', \'" + bill.getBillDate() + "\', \'" + bill.getDateOfService() + "\', " + bill.getLabor()+ ", " + bill.getTripCharge() + ", " + bill.getMaterialsTotal() + ", " + bill.getMisc() +", " + bill.getTotal() + ", \'" + bill.getTime() + "\', " + id + ", \'" + bill.getSeviceReport() + "\', \'" + bill.getMaterialString() + "\')");
            psInsert.executeUpdate();

             // Release the resources (clean up )
            psInsert.close();
            s.close();
            conn.close();						
            
            //   ## DATABASE SHUTDOWN SECTION ## 
            /*** In embedded mode, an application should shut down Derby.
               Shutdown throws the XJ015 exception to confirm success. ***/			
            if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver")) {
               boolean gotSQLExc = false;
               try {
                  DriverManager.getConnection("jdbc:derby:;shutdown=true");
               } catch (SQLException se)  {	
                  if ( se.getSQLState().equals("XJ015") ) {		
                     gotSQLExc = true;
                  }
               }
               if (!gotSQLExc) {
               	  System.out.println("Database did not shut down normally");
                  //conn.close(); // try again
               }  else  {
                  System.out.println("Database shut down normally");	
               }  
            }
            
         //  Beginning of the primary catch block: prints stack trace
         }  catch (Throwable e)  {   
            System.out.println(" . . . exception thrown:");
            e.printStackTrace(System.out);
         }
         return queryResult;
      }
}
