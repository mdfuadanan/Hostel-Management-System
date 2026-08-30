package hostel_management_system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author mdfuadanan
 * @Id 251014032
 */
public class Hostel_Management_System {
    static Scanner sc = new Scanner(System.in);
    static File_Manager FM = new File_Manager();
    static Display Dp = new Display();
    static Switch Sw = new Switch();
    public static void main(String[] args) throws FileNotFoundException, IOException {
        while(true){
        Dp.Main_Menu_Display();
        try{
        Sw.Switch_Of_Main_Menu();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found Exception");  
        }catch(IOException e){
            System.out.println("IO Exception");   
        }
        
        }
    }   
}