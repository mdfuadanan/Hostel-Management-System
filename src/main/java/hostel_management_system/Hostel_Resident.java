package hostel_management_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mdfuadanan
 * @Id 251014032
 */
public class Hostel_Resident extends Person {
    private double Advance_Rent;
    private double Room_Rent;
    private double Meal_Bill; 
    private double Other_Bills;
    private double Net_Monthly_Rent;
    private int Floor,RId;
    private String Flat;
    private String  Room;
    private String Branch;
    public Hostel_Resident(File Residents_List,String Name, String Father_Name, String Mother_Name, String Date_of_Birth, long NID_No, String Permanent_Address, long Phone_No, String Email,double Advance_Rent, double Room_Rent, double Meal_Bill, double Other_Bills, int Floor, String Flat, String Room, String Branch) throws FileNotFoundException {
        super(Name, Father_Name, Mother_Name, Date_of_Birth, NID_No, Permanent_Address, Phone_No, Email);
        this.Advance_Rent = Advance_Rent;
        this.Room_Rent = Room_Rent;
        this.Meal_Bill = Meal_Bill;
        this.Other_Bills = Other_Bills;
        this.Floor = Floor;
        this.Flat = Flat;
        this.Room = Room;
        this.Branch = Branch;
        this.RId = File_Manager.Last_Id(Residents_List)+ 1;
        Write(Residents_List);
    }
    @Override
    void Write(File Residents_List) {
        try {
        FileWriter writer = new FileWriter(Residents_List, true);
        writer.write("ID: R" + RId + "\n");
        super.WriteCommon(writer);
        
        writer.write("Advance Rent: "+ Advance_Rent + "\n");
        writer.write("Room Rent: "+ Room_Rent +"\n");
        writer.write("Meal Bill: "+ Meal_Bill +"\n");
        writer.write("Other Bills: " + Other_Bills +"\n");
        writer.write("Floor: " + Floor + "\n");
        writer.write("Flat: " + Flat + "\n");
        writer.write("Room: " + Room + "\n");
        writer.write("Branch: "+ Branch +"\n");
        writer.write("Net Monthly Rent: " + Calculate_Total_Rent() + "\n");
        writer.write("----------------------\n");
        
        writer.close();
    } 
    catch (IOException e) 
    {
        System.out.println("File writting error!!!");
    }
}    
    private double Calculate_Total_Rent(){
    return Net_Monthly_Rent= Room_Rent+ Meal_Bill + Other_Bills;
    }
} 
   

