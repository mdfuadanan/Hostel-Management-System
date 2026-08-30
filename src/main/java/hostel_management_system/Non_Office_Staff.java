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
public class Non_Office_Staff extends Person implements Calculate {
     private double Basic_Salary,Bonus,Net_Salary;
    private int NOId;
    private String Benefit="A Hostal Seat, 3 Meals";
    public Non_Office_Staff(File Non_Office_Staff_List, String Name, String Father_Name, String Mother_Name, String Date_of_Birth, long NID_No, String Permanent_Address, long Phone_No, String Email,double Basic_Salary, double Bonus) throws FileNotFoundException {
        super(Name, Father_Name, Mother_Name, Date_of_Birth, NID_No, Permanent_Address, Phone_No, Email);
        this.Basic_Salary = Basic_Salary;
        this.Bonus = Bonus;
        this.NOId = File_Manager.Last_Id(Non_Office_Staff_List) +1;
        Write(Non_Office_Staff_List);
       
    }
    @Override
    public double Calculate_Total_Salary() {
        return Net_Salary = Basic_Salary + Bonus; 
    }
    
    @Override
    void Write(File Non_Office_Staff_List) {
    try {
        FileWriter writer = new FileWriter(Non_Office_Staff_List, true);

        writer.write("ID: NO" + NOId + "\n");
        super.WriteCommon(writer);
        writer.write("Basic Salary: " + Basic_Salary + "\n");
        writer.write("Bonus: " + Bonus + "\n");
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
}

