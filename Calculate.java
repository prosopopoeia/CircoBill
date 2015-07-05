/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billing;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author ComputationalMachine
 */
public class Calculate {
    private final double PER_MIN_RATE = 1.50;
    private Random  randy = new Random();
   //private ArrayList
    
    public String generateID(){//fix
      String invoiceNumber; 
      int temp = randy.nextInt(100000000) + 10000000;
      invoiceNumber =  "cls-" + Integer.toString(temp);
      return invoiceNumber;        
    }
    
    public double totalMaterials(String material){
        double sum = 0;
        double total = 0;
        int quantity = 0;
        boolean notfound = true;
        String[] materialArr = material.split("\\s+");
        for(int j = 0; j<materialArr.length; j++){
            if(materialArr[j].matches("\\d+") && notfound){
                sum = 0;
                quantity = 0;
                quantity = Integer.parseInt(materialArr[j]);
                System.out.println(quantity + "  :a match!");
                notfound = false;
            
            }else if(materialArr[j].length() > 0 && materialArr[j].charAt(0) == '$'){
              materialArr[j] = materialArr[j].substring(1);
              if(materialArr[j].trim().length() < 1)
                  JOptionPane.showMessageDialog(null, "please make sure there are no spaces between the $ symbol and the numeric figure in the materials section");
              else
                sum += Double.parseDouble(materialArr[j]);
              notfound = true;
              //System.out.println("parsed: " + materialArr[j].substring(1)+"aka"+total);
           }
           total += sum * quantity;
        }
        return total;
    }
/*    public String[] parseMaterials(String material){
        System.out.println("loop in parse");
        boolean notfound = true;
        String[] materialArr = material.split("\\s+");
        for(int j = 0; j<materialArr.length; j++){
           if(materialArr[j].matches("\\d+") && notfound){
                
                notfound = false;
            
            }else if(materialArr[j].charAt(0) == '$'){
              notfound = true;
            }else{
           
        }
        
        return materialArr;
    }*/
    public String getDate() {
     DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
     Date date = new Date();
     return dateFormat.format(date);
 }
    
    public double calcLabor(String min, String hr){
        double a, b;
        a = (!min.equals("")) ? Double.parseDouble(min) : 0;
        b = (!hr.equals("")) ? Double.parseDouble(hr)*60 : 0;
        System.out.println(b + " and" + a );
        a += b;
       // a *= SERVICE_RATE;   System.out.println(b + " and 2" + a );
        return a;       
    }
    public double calcTotal(double materials, double labor, double trip, double misc, double previous){
        return labor + trip + misc + materials + previous;
    }
    public double calcLabor(int hours, int minutes){
        double charge = 0;
        int total = (hours * 60) + minutes;
        charge = total * PER_MIN_RATE;
        return charge;
    }
    public String listIntoString(ArrayList aL){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < aL.size(); j++)
            sb.append(aL.get(j) + " ");
        return sb.toString();
        
    }
    
}
