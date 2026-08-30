package hostel_management_system;

import static hostel_management_system.Hostel_Management_System.FM;
import static hostel_management_system.Hostel_Management_System.Sw;
import static hostel_management_system.Hostel_Management_System.sc;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author mdfuadanan
 * @Id 251014032
 */
public class Display {
    void Main_Menu_Display(){
        System.out.println("----------------------------");
        System.out.println("|                          |");
        System.out.println("| Hostel Management System |");
        System.out.println("|                          |");
        System.out.println("-----------Lists------------");
        System.out.println("|1.Office Staff            |");
        System.out.println("|2.Non-Office Staff        |");
        System.out.println("|3.Hostel Resident         |");
        System.out.println("|0.Exit                    |");
        System.out.println("----------------------------");
    }        
    void Office_List_Main_Menu() throws IOException{
        while(true){
            File Office_Staff_List= FM.File_Check("Office Staff List");
            FM.File_Read(Office_Staff_List,"Office Staff List");
            System.out.println("----------------------------");
            System.out.println("|1.Add Office Staff        |");
            System.out.println("|2.Update Office Staff     |");
            System.out.println("|3.Remove Office Staff     |");
            System.out.println("|4.Return to Main Menu     |");
            System.out.println("----------------------------");
            System.out.print("Enter:");
            int Choice1= sc.nextInt();
            sc.nextLine();
            if (Choice1==4){
                return;
            }
            else{
                Sw.Switch_Of_Office_List(Choice1,Office_Staff_List);
            }
            }
    }
    void Non_Office_List_Main_Menu() throws IOException{
    while(true){
        File Non_Office_Staff_List= FM.File_Check("Non Office Staff List");
        FM.File_Read(Non_Office_Staff_List,"Non Office Staff List");
        System.out.println("----------------------------");
        System.out.println("|1.Add Non-Office Staff    |");
        System.out.println("|2.Update Non-Office Staff |");
        System.out.println("|3.Remove Non-Office Staff |");
        System.out.println("|4.Return to Main Menu     |");
        System.out.println("----------------------------");
        System.out.print("Enter:");
        int Choice2= sc.nextInt();
        sc.nextLine();
        if (Choice2==4){
            return;
        }
        else{
            Sw.Switch_Of_Non_Office_List(Choice2,Non_Office_Staff_List);
        }
    }
    }
    void Resident_List_Main_Menu() throws IOException {
        while(true){
        File Residents_List= FM.File_Check("Resident List");
        FM.File_Read(Residents_List,"Resident List");
        System.out.println("----------------------------");
        System.out.println("|1.Add New Resident         |");
        System.out.println("|2.Update An Resident       |");
        System.out.println("|3.Remove An Resident       |");
        System.out.println("|4.Return to Main Menu      |");
        System.out.println("----------------------------");
        System.out.print("Enter:");
        int Choice3= sc.nextInt();
        sc.nextLine();
        if (Choice3==4){
            return;
        }
        else{
            Sw.Switch_Of_Resident_List(Choice3,Residents_List);
        }
    }        
    }
}
