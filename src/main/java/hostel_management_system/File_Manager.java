package hostel_management_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mdfuadanan
 * @Id 251014032
 */
public class File_Manager {
    void Delete(File file,String Prefix_Of_Id,int Id)throws IOException{
        File newFile = new File("New File.txt");
        FileWriter writer = new FileWriter(newFile);
        Scanner read = new Scanner(file);
        boolean found = false;
        while (read.hasNextLine()) {
            String record = "";
            String line = read.nextLine();
            while (true) {
            record += line + "\n";
            if (line.equals("----------------------") || !read.hasNextLine()) {
                break;
            }
            line = read.nextLine();
            }
            if (record.contains("ID: " + Prefix_Of_Id + Id + "\n")) {
            found = true;   
            continue;
            }
            writer.write(record);
        }
        read.close();
        writer.close();
        file.delete();
        newFile.renameTo(file);
        if (found) {
            System.out.println("Record Deleted Successfully.");
        } else {
            System.out.println("ID Not Found.");
        }
    }
    String getValue(String record, String key){
    for(String line : record.split("\n")){
        if(line.startsWith(key)){
            return line.replace(key, "").trim();
        }
    }
    return "Not Found";
}
    public static int Last_Id(File file) throws FileNotFoundException {
        Scanner read = new Scanner(file);
        int lastId = 0;

        while (read.hasNextLine()) {
            String line = read.nextLine();

            if (line.startsWith("ID: O")) {
                String idNum = line.replace("ID: O", "").trim();
                lastId = Integer.parseInt(idNum);
            }
            else if (line.startsWith("ID: NO")){
                String idNum = line.replace("ID: NO", "").trim();
                lastId = Integer.parseInt(idNum);
            }
            else if (line.startsWith("ID: R")){
                String idNum = line.replace("ID: R", "").trim();
                lastId = Integer.parseInt(idNum);
            }
            
        }

        read.close();
        return lastId;
    }
    File File_Check(String File_Name) throws IOException{
    File file = new File( File_Name + ".txt");
    if (file.exists()) {
    System.out.println( File_Name + " Found.");
    } 
    else {
    System.out.println( File_Name + " File Not Found.\nCreating new file...");
    file.createNewFile();
    }
    return file;
    }
    void File_Read(File file, String File_Name) throws FileNotFoundException{
    if (file.length() == 0) {
    System.out.println(File_Name + " is empty.");
    } else {
    System.out.println("\n--- "+ File_Name +" ---");
    Scanner read = new Scanner(file);
    while (read.hasNextLine()) {
        System.out.println(read.nextLine());
        }
    read.close();
    }
    }
    void Read_Latest_Entry(File file) throws FileNotFoundException{
        Scanner read = new Scanner(file);
        String lastRecord = ""; 
        String current = ""; 
        while (read.hasNextLine()) 
        { 
            String line = read.nextLine(); 
            current += line + "\n"; 
            if (line.equals("----------------------")) 
            {
                lastRecord = current; current = ""; 
            }
        } 
        read.close(); 
        System.out.println("\n--- Latest Entry ---"); 
        System.out.println(lastRecord); 
    }   
}
