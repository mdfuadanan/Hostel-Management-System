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
public class Office_Staff extends Person implements Calculate {
    private double Bonus,Net_Salary,Basic_Salary,Health_Care;
    private String Benefit= "A Flat, A Car, An Insurance";
    private int OId;
    public Office_Staff(File Office_Staff_List, String Name, String Father_Name, String Mother_Name, String Date_of_Birth, long NID_No, String Permanent_Address, long Phone_No, String Email,double Bonus, double Basic_Salary, double Health_Care) throws FileNotFoundException {
        super(Name, Father_Name, Mother_Name, Date_of_Birth, NID_No, Permanent_Address, Phone_No, Email);
        this.Basic_Salary = Basic_Salary;
        this.Bonus = Bonus;
        this.Health_Care = Health_Care;
        this.OId = File_Manager.Last_Id(Office_Staff_List)+ 1;
        
        Write(Office_Staff_List); 
    }
    @Override
    void Write(File Office_Staff_List){
    try {
        FileWriter writer = new FileWriter(Office_Staff_List, true);

        writer.write("ID: O" + OId + "\n");
        super.WriteCommon(writer);
        writer.write("Basic Salary: " + Basic_Salary + "\n");
        writer.write("Bonus: " + Bonus + "\n");
        writer.write("Health Care: " + Health_Care + "\n");
        writer.write("Net Salary: " + Calculate_Total_Salary() + "\n");
        writer.write("Benefit: "+ Benefit + "\n");
        writer.write("----------------------\n");

        writer.close();
    } 
    catch (IOException e) 
    {
        System.out.println("Error writing file.");
    }
    }    
    @Override
    public double Calculate_Total_Salary() {
        return Net_Salary = Basic_Salary + Bonus + Health_Care; 
    }
}


