package hostel_management_system;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author mdfuadanan
 * @Id 251014032
 */
abstract class Person {
    private String Name,Father_Name,Mother_Name,Date_of_Birth,Permanent_Address,Email;
    private long NID_No,Phone_No;
    public Person(String Name, String Father_Name, String Mother_Name, String Date_of_Birth, long NID_No, String Permanent_Address, long Phone_No, String Email) {
        this.Name = Name;
        this.Father_Name = Father_Name;
        this.Mother_Name = Mother_Name;
        this.Date_of_Birth = Date_of_Birth;
        this.NID_No = NID_No;
        this.Permanent_Address = Permanent_Address;
        this.Phone_No = Phone_No;
        this.Email = Email;
        
       
    }
    abstract void Write (File file);
    protected void WriteCommon(FileWriter writer) throws IOException {
    writer.write("Name: " + Name + "\n");
    writer.write("Father's Name: " + Father_Name + "\n");
    writer.write("Mother's Name: " + Mother_Name + "\n");
    writer.write("Date of Birth: " + Date_of_Birth + "\n");
    writer.write("NID No: " + NID_No + "\n");
    writer.write("Permanent Address: " + Permanent_Address + "\n");
    writer.write("Phone No: " + Phone_No + "\n");
    writer.write("Email: " + Email + "\n");
    }
}
    

interface Calculate{
    double Calculate_Total_Salary();
}    