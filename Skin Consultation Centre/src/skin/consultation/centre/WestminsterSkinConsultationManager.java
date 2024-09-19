/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skin.consultation.centre;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WestminsterSkinConsultationManager {
    
     public static void main(String[] args) throws IOException {
         int chooseOption=0;
         Scanner in=new Scanner(System.in);
        while(chooseOption>=0 && chooseOption<=3)  {       
         System.out.println("Ente the number..");
         System.out.println("1: ADD DOCTOR");
          System.out.println("2: DELETE DOCTOR");
          System.out.println("3: PRINT THE DOCTOR");
           System.out.println("4: Exit");
         chooseOption=in.nextInt();
         
        if(chooseOption==1){
            insertDoctor();
        }
        else if(chooseOption==2){
            deleteDoctor();
        } 
        else if(chooseOption==3){
            printDetails();
        } 
        else if(chooseOption==4){
            System.out.println("Wrong Selection");
        } 
        }
    }

    private static void insertDoctor() {
        
        Scanner inInt=new Scanner(System.in);
        Scanner inString=new Scanner(System.in);
        System.out.println("Enter Name");
        String name=inString.nextLine();
        System.out.println("Enter Surname");
        String surname=inString.nextLine();
        System.out.println("Enter Date Of Birth");
        String date=inInt.next();
        System.out.println("Enter Mobile Number");
        String phoneNumber=inInt.next();
        System.out.println("Enter Licence number");
        String licence=inInt.next();
        System.out.println("Enter Specialisation");
        String specialisation=inString.nextLine();
        
        
      
       if(name.equals("") || phoneNumber.equals(" ") || surname.equals("")|| date.equals("") || licence.equals("") || specialisation.equals("") )
            System.out.println("Please fill all the blanks");
        else{
                  try (
                    FileWriter f = new FileWriter("doctorDetails.txt", true); 
                    BufferedWriter b = new BufferedWriter(f); 
                    PrintWriter p = new PrintWriter(b);
                    ) 
            { 
               
                p.print(name+","+surname+","+date+","+phoneNumber+","+licence+","+specialisation); 
                System.out.println("Patient registerd");
                 p.println();
                
            } catch (IOException i) { i.printStackTrace(); }
        }
    }

    private static void deleteDoctor() throws IOException {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter doctor name!!");
        String holdname=in.next();
       
            File inputFile = new File("doctorDetails.txt");
            File tempFile = new File("myTempFile.txt");
 
            BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
       
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                
                String trimmedLine = currentLine.trim();
                 String[] columnsName = currentLine.split(",");
                if(!columnsName[0].equals(holdname)) continue;
                else{
                writer.write(currentLine + System.getProperty("line.separator"));
                System.out.println("Doctor Removed");
                }
            }
            writer.close(); 
            reader.close(); 
            inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);
                        if(successful){
                            System.out.println("Doctor Removed");
                        }
                        
                        

             } catch (FileNotFoundException ex) {
                       System.out.println(ex);
                    }

    }

    private static void printDetails() {
    
         String filePath = "doctorDetails.txt";
        File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
             for(int i=0;i<tableLines.length;i++){
            String firstLine = tableLines[i].toString().trim();
            
            String[] columnsName = firstLine.split(",");
           
                 System.out.println("Name: "+columnsName[0].toString()+", Surname: "+columnsName[1].toString()+", Date Of Birth: "+columnsName[2].toString()+", Mobile Number: "+columnsName[3].toString()
                 +", Licence: "+columnsName[4].toString()+", Specialisation: "+columnsName[5].toString());
            
            }
        } catch (Exception ex) {
            System.out.println("Error: "+ex.getMessage());
         }
    }
}
