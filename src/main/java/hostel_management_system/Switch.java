package hostel_management_system;

import static hostel_management_system.Hostel_Management_System.FM;
import static hostel_management_system.Hostel_Management_System.Dp;
import static hostel_management_system.Hostel_Management_System.sc;
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
public class Switch {
    void Switch_Of_Main_Menu() throws IOException{
        System.out.print("Enter:");
        int Choice= sc.nextInt();
        sc.nextLine();
        switch(Choice){
            case 1 -> {
                Dp.Office_List_Main_Menu();
            }
            case 2 -> {
                Dp.Non_Office_List_Main_Menu();
            }
            case 3 -> {
                Dp.Resident_List_Main_Menu();
            }
            case 0 ->{
                    sc.close();
                    System.out.println("Exiting Program...");
                    System.exit(0);

                }
            default -> System.out.println("Invalid Input");}
    }
    void Switch_Of_Office_List(int Choice1,File Office_Staff_List) throws FileNotFoundException, IOException {
        switch(Choice1){
        case 1 -> {
            System.out.print("Name: ");
            String Name= sc.nextLine();
            System.out.print("Father's Name: ");
            String Father_Name= sc.nextLine();
            System.out.print("Mother's Name: ");
            String Mother_Name= sc.nextLine();
            System.out.print("Date of Birth: ");
            String Date_of_Birth= sc.nextLine();
            System.out.print("NID No: ");
            long NID_No= sc.nextLong();
            sc.nextLine();
            System.out.print("Permanent Address: ");
            String Permanent_Address = sc.nextLine();
            System.out.print("Phone No: ");
            long Phone_No = sc.nextLong();
            sc.nextLine();
            System.out.print("Email: ");
            String Email = sc.nextLine();
            System.out.print("Basic Salary:");
            double Basic_Salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Bonus: ");
            double Bonus = sc.nextDouble();
            sc.nextLine();
            System.out.print("Health Care: ");
            double Health_Care = sc.nextDouble();
            sc.nextLine();
            Office_Staff Staff = new Office_Staff(Office_Staff_List, Name, Father_Name, Mother_Name, Date_of_Birth, NID_No, Permanent_Address, Phone_No, Email, Bonus, Basic_Salary, Health_Care);        
            System.out.println("Data Added Successfully.");
            FM.Read_Latest_Entry(Office_Staff_List);
            System.out.println("Returning to Office Staff List");
            return;
        }
        case 2 -> {
            System.out.print("Office Staff Id: ");
            int OId = sc.nextInt();
            sc.nextLine();
            File newFile = new File("New File.txt");
            Scanner read = new Scanner(Office_Staff_List);
            FileWriter writer = new FileWriter(newFile);
            StringBuilder allData = new StringBuilder();
            boolean found = false;
            while(read.hasNextLine()) {
                String record = "";
                String line = read.nextLine();
                while(true) {
                    record += line + "\n";
                    if(line.equals("----------------------")||!read.hasNextLine()){
                        break;
                    }
                    line = read.nextLine();
                }
            if(record.contains("ID: O" + OId)) {
                found = true;
                System.out.println("Office Staff Found.");
                System.out.println("1.Name: " + FM.getValue(record, "Name:"));
                System.out.println("2.Father's Name: " + FM.getValue(record, "Father's Name:"));
                System.out.println("3.Mother's Name: " + FM.getValue(record, "Mother's Name:"));
                System.out.println("4.Date of Birth: " + FM.getValue(record, "Date of Birth:"));
                System.out.println("5.NID No: " + FM.getValue(record, "NID No:"));
                System.out.println("6.Permanent Address: " + FM.getValue(record, "Permanent Address:"));
                System.out.println("7.Phone No: " + FM.getValue(record, "Phone No:"));
                System.out.println("8.Email: " + FM.getValue(record, "Email:"));
                System.out.println("9.Basic Salary: "+ FM.getValue(record,"Basic Salary: "));
                System.out.println("10.Bonus: " + FM.getValue(record,"Bonus: "));
                System.out.println("11.Health Care: "+ FM.getValue(record,"Health Care: "));
                System.out.println("12.Net Salary: "+ FM.getValue(record,"Net Salary: "));
                System.out.println("13.Benefit: "+ FM.getValue(record,"Benefit: "));
                System.out.print("Enter which field to Update:");
                int Update_Office = sc.nextInt();
                sc.nextLine();
                switch(Update_Office){
                case 1 -> {
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    record = record.replaceFirst("Name: .*", "Name: " + newName);
                    break;
                }
                case 2 -> {
                    System.out.print("New Father's Name: ");
                    String newFatherName = sc.nextLine();
                    record = record.replaceFirst("Father's Name: .*", "Father's Name: " + newFatherName);
                    break;
                }
                case 3 -> {
                    System.out.print("New Mother's Name: ");
                    String newMotherName = sc.nextLine();
                    record = record.replaceFirst("Mother's Name: .*", "Mother's Name: " + newMotherName);
                    break;
                }
                case 4 -> {
                    System.out.print("New Date of Birth: ");
                    String newDate_of_Birth = sc.nextLine();
                    record = record.replaceFirst("Date of Birth: .*", "Date of Birth: " + newDate_of_Birth);
                    break;
                }
                case 5 ->{
                    System.out.println("New NID No: ");
                    long newNID_No = sc.nextLong();
                    sc.nextLine();
                    record = record.replaceFirst("NID No: .*", "NID No: " + newNID_No );
                    break;
                }
                case 6 ->{
                    System.out.print("Permanent Address: ");
                    String newPermanent_Address = sc.nextLine();
                    record = record.replaceFirst("Permanent Address: .*","Permanent Address: " + newPermanent_Address);
                    break;
                }
                case 7 -> {
                    System.out.print("New Phone No: ");
                    long newPhone_No = sc.nextLong();
                    sc.nextLine();
                    record = record.replaceFirst("Phone No: .*", "Phone No: " + newPhone_No);
                    break;
                }
                case 8 -> {
                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();
                    record = record.replaceFirst("Email: .*", "Email: " + newEmail);
                    break;
                }
                case 9 ->{
                    System.out.print("New Basic Salary:");
                    double newBasic_Salary = sc.nextDouble();
                    sc.nextLine();
                    record = record.replaceFirst("Basic Salary: .*", "Basic Salary: " + newBasic_Salary);
                    break;
                }
                case 10 ->{
                    System.out.print("New Bonus: ");
                    double newBonus = sc.nextDouble();
                    sc.nextLine();
                    record = record.replaceFirst("Bonus: .*", "Bonus: " + newBonus);
                    break;
                }
                case 11 ->{
                    System.out.print("New Health Care: ");
                    double newHealth_Care = sc.nextDouble();
                    sc.nextLine();
                    record = record.replaceFirst("Health Care: .*", "Health Care: " + newHealth_Care);
                    break;
                }
                case 12 ->{
                    System.out.print("New Net Salary: ");
                    double newNet_Salary = sc.nextDouble();
                    sc.nextLine();
                    record = record.replaceFirst("Net Salary: .*", "Net Salary: " + newNet_Salary);
                    break;
                }
                case 13 ->{
                    System.out.print("New Benefit: ");
                    double newBenefit = sc.nextDouble();
                    sc.nextLine();
                    record = record.replaceFirst("Benefit: .*", "Benefit: " + newBenefit);
                    break;
                }
                default->{
                    System.out.println("Invalid Option.");
                }
            }
        }
            allData.append(record).append("\n");
            }
            writer.write(allData.toString());
            read.close();
            writer.close();
            if (Office_Staff_List.delete()){
            newFile.renameTo(Office_Staff_List);
            System.out.print("Renamed Successfully.");}
            else {
            System.out.print("Renaming Unsuccessfully.");
            }

        if(found){
            System.out.println("Updated Successfully.");}
        else{
            System.out.println("Office Staff ID Not Found.");}
            System.out.println("Returning to Office Staff List");
            return;
        }
        case 3 -> {
            System.out.print("Office Staff Id: ");
            int OId = sc.nextInt();
            FM.Delete(Office_Staff_List,"O",OId);
            System.out.println("Returning to Office Staff List");
            return;

        }
        case 0->{
            sc.close();
            System.exit(0);
        }
        default -> System.out.println("Invalid Input");
        }
    }
    void Switch_Of_Non_Office_List(int Choice2,File Non_Office_Staff_List) throws FileNotFoundException, IOException{
    switch(Choice2){
    case 1 -> {
        System.out.print("Name: ");
        String Name= sc.nextLine();
        System.out.print("Father's Name: ");
        String Father_Name= sc.nextLine();
        System.out.print("Mother's Name: ");
        String Mother_Name= sc.nextLine();
        System.out.print("Date of Birth: ");
        String Date_of_Birth= sc.nextLine();
        System.out.print("NID No: ");
        long NID_No = sc.nextLong();
        sc.nextLine();
        System.out.print("Permanent Address: ");
        String Permanent_Address = sc.nextLine();
        System.out.print("Phone No: ");
        long Phone_No = sc.nextLong();
        sc.nextLine();
        System.out.print("Email: ");
        String Email = sc.nextLine();
        System.out.print("Basic Salary:");
        double Basic_Salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Bonus: ");
        double Bonus = sc.nextDouble();
        sc.nextLine();
        Non_Office_Staff Staff = new Non_Office_Staff(Non_Office_Staff_List, Name,  Father_Name, Mother_Name, Date_of_Birth, NID_No, Permanent_Address, Phone_No, Email, Basic_Salary, Bonus);
        System.out.println("Data Added Successfully.");
        FM.Read_Latest_Entry(Non_Office_Staff_List);
        System.out.println("Returning to Office Staff List");
        return;
    }

    case 2 -> {
        System.out.print("Non Office Staff Id: ");
        int NOId = sc.nextInt();
        sc.nextLine();
        File newFile = new File("New File.txt");
        Scanner read = new Scanner(Non_Office_Staff_List);
        FileWriter writer = new FileWriter(newFile);
        StringBuilder allData = new StringBuilder();
        boolean found = false;
        while(read.hasNextLine()) {
            String record = "";
            String line = read.nextLine();
            while(true) {
                record += line + "\n";
                if(line.equals("----------------------")||!read.hasNextLine()){
                    break;
                }
                line = read.nextLine();
            }
        if(record.contains("ID: NO" + NOId)) {
            found = true;
            System.out.println("Non Office Staff Found.");
            System.out.println("1.Name: " + FM.getValue(record, "Name:"));
            System.out.println("2.Father's Name: " + FM.getValue(record, "Father's Name:"));
            System.out.println("3.Mother's Name: " + FM.getValue(record, "Mother's Name:"));
            System.out.println("4.Date of Birth: " + FM.getValue(record, "Date of Birth:"));
            System.out.println("5.NID No: " + FM.getValue(record, "NID No:"));
            System.out.println("6.Permanent Address: " + FM.getValue(record, "Permanent Address:"));
            System.out.println("7.Phone No: " + FM.getValue(record, "Phone No:"));
            System.out.println("8.Email: " + FM.getValue(record, "Email:"));
            System.out.println("9.Basic Salary: "+ FM.getValue(record,"Basic Salary: "));
            System.out.println("10.Bonus: " + FM.getValue(record,"Bonus: "));
            System.out.println("11.Net Salary: "+ FM.getValue(record,"Net Salary: "));
            System.out.println("12.Benefit: "+ FM.getValue(record,"Benefit: "));
            System.out.print("Enter which field to Update:");
            int UpdateR = sc.nextInt();
            sc.nextLine();
            switch(UpdateR){
            case 1 -> {
                System.out.print("New Name: ");
                String newName = sc.nextLine();
                record = record.replaceFirst("Name: .*", "Name: " + newName);
                break;
            }
            case 2 -> {
                System.out.print("New Father's Name: ");
                String newFatherName = sc.nextLine();
                record = record.replaceFirst("Father's Name: .*", "Father's Name: " + newFatherName);
                break;
            }
            case 3 -> {
                System.out.print("New Mother's Name: ");
                String newMotherName = sc.nextLine();
                record = record.replaceFirst("Mother's Name: .*", "Mother's Name: " + newMotherName);
                break;
            }
            case 4 -> {
                System.out.print("New Date of Birth: ");
                String newDate_of_Birth = sc.nextLine();
                record = record.replaceFirst("Date of Birth: .*", "Date of Birth: " + newDate_of_Birth);
                break;
            }
            case 5 ->{
                System.out.println("New NID No: ");
                long newNID_No = sc.nextLong();
                sc.nextLine();
                record = record.replaceFirst("NID No: .*", "NID No: " + newNID_No );
                break;
            }
            case 6 ->{
                System.out.print("Permanent Address: ");
                String newPermanent_Address = sc.nextLine();
                record = record.replaceFirst("Permanent Address: .*","Permanent Address: " + newPermanent_Address);
                break;
            }
            case 7 -> {
                System.out.print("New Phone No: ");
                long newPhone_No = sc.nextLong();
                sc.nextLine();
                record = record.replaceFirst("Phone No: .*", "Phone No: " + newPhone_No);
                break;
            }
            case 8 -> {
                System.out.print("New Email: ");
                String newEmail = sc.nextLine();
                record = record.replaceFirst("Email: .*", "Email: " + newEmail);
                break;
            }
            case 9 ->{
                System.out.print("New Basic Salary:");
                double newBasic_Salary = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Basic Salary: .*", "Basic Salary: " + newBasic_Salary);
                break;
            }
            case 10 ->{
                System.out.print("New Bonus: ");
                double newBonus = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Bonus: .*", "Bonus: " + newBonus);
                break;
            }
            case 11 ->{
                System.out.print("New Net Salary: ");
                double newNet_Salary = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Net Salary: .*", "Net Salary: " + newNet_Salary);
                break;
            }
            case 12 ->{
                System.out.print("New Benefit: ");
                double newBenefit = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Benefit: .*", "Benefit: " + newBenefit);
                break;
            }
           
            default->{
                System.out.println("Invalid Option.");
            }
        }
    }
        allData.append(record).append("\n");
        }
        writer.write(allData.toString());
        read.close();
        writer.close();
        if (Non_Office_Staff_List.delete()){
        newFile.renameTo(Non_Office_Staff_List);
        System.out.print("Renamed Successfully.");}
        else {
        System.out.print("Renaming Unsuccessfully.");
        }

    if(found){
        System.out.println("Updated Successfully.");}
    else{
        System.out.println("Non Office ID Not Found.");}
        System.out.println("Returning to Non Office List");
        return;
    }
    case 3 -> {
        System.out.print("Non Office Staff Id: ");
        int NOId = sc.nextInt();
        FM.Delete(Non_Office_Staff_List,"NO",NOId);
        System.out.println("Returning to Non Office Staff List");
        return;

    }
    case 0->{
        sc.close();
        System.exit(0);
    }
    default -> System.out.println("Invalid Input");}
    }
    void Switch_Of_Resident_List(int Choice3, File Residents_List) throws FileNotFoundException, IOException {
    switch(Choice3){
    case 1 -> {
        System.out.print("Name: ");
        String Name= sc.nextLine();
        System.out.print("Father's Name: ");
        String Father_Name= sc.nextLine();
        System.out.print("Mother's Name: ");
        String Mother_Name= sc.nextLine();
        System.out.print("Date of Birth: ");
        String Date_of_Birth= sc.nextLine();
        System.out.print("NID No: ");
        long NID_No = sc.nextLong();
        sc.nextLine();
        System.out.print("Permanent Address: ");
        String Permanent_Address = sc.nextLine();
        System.out.print("Phone No: ");
        long Phone_No = sc.nextLong();
        sc.nextLine();
        System.out.print("Email: ");
        String Email = sc.nextLine();
        System.out.print("Advance Rent: ");
        double Advance_Rent = sc.nextDouble();
        sc.nextLine();
        System.out.print("Room Rent: ");
        double Room_Rent = sc.nextDouble();
        sc.nextLine();
        System.out.print("Meal Bill: ");
        double Meal_Bill = sc.nextDouble();
        sc.nextLine();
        System.out.print("Other Bills: ");
        double Other_Bills = sc.nextDouble();
        sc.nextLine();
        System.out.print("Floor: ");
        int Floor = sc.nextInt();
        sc.nextLine();
        System.out.print("Flat: ");
        String Flat = sc.nextLine();
        System.out.print("Room: ");
        String Room = sc.nextLine();
        System.out.print("Branch: ");
        String Branch = sc.nextLine();
        Hostel_Resident Resident = new Hostel_Resident(Residents_List, Name,  Father_Name, Mother_Name, Date_of_Birth, NID_No, Permanent_Address, Phone_No, Email, Advance_Rent, Room_Rent, Meal_Bill, Other_Bills, Floor, Flat, Room, Branch);        
        System.out.println("Data Added Successfully.");
        FM.Read_Latest_Entry(Residents_List);
        System.out.println("Returning to Resident List");
        return;
    }
    case 2 -> {
        System.out.print("Resident Id: ");
        int RId = sc.nextInt();
        sc.nextLine();
        File newFile = new File("New File.txt");
        Scanner read = new Scanner(Residents_List);
        FileWriter writer = new FileWriter(newFile);
        StringBuilder allData = new StringBuilder();
        boolean found = false;
        while(read.hasNextLine()) {
            String record = "";
            String line = read.nextLine();
            while(true) {
                record += line + "\n";
                if(line.equals("----------------------")||!read.hasNextLine()){
                    break;
                }
                line = read.nextLine();
            }
        if(record.contains("ID: R" + RId+"\n")) {
            found = true;
            System.out.println("Resident Found.");
            System.out.println("1.Name: " + FM.getValue(record, "Name:"));
            System.out.println("2.Father's Name: " + FM.getValue(record, "Father's Name:"));
            System.out.println("3.Mother's Name: " + FM.getValue(record, "Mother's Name:"));
            System.out.println("4.Date of Birth: " + FM.getValue(record, "Date of Birth:"));
            System.out.println("5.NID No: " + FM.getValue(record, "NID No:"));
            System.out.println("6.Permanent Address: " + FM.getValue(record, "Permanent Address:"));
            System.out.println("7.Phone No: " + FM.getValue(record, "Phone No:"));
            System.out.println("8.Email: " + FM.getValue(record, "Email:"));
            System.out.println("9.Advance Rent: " + FM.getValue(record, "Advance Rent:"));
            System.out.println("10.Room Rent: " + FM.getValue(record, "Room Rent:"));
            System.out.println("11.Meal Bill: " + FM.getValue(record, "Meal Bill:"));
            System.out.println("12.Other Bills: " + FM.getValue(record, "Other Bills:"));
            System.out.println("13.Floor: " + FM.getValue(record, "Floor:"));
            System.out.println("14.Flat: " + FM.getValue(record, "Flat:"));
            System.out.println("15.Room: " + FM.getValue(record, "Room:"));
            System.out.println("16.Branch: " + FM.getValue(record, "Branch:"));
            System.out.print("Enter which field to Update:");
            int UpdateR = sc.nextInt();
            sc.nextLine();
            switch(UpdateR){
            case 1 -> {
                System.out.print("New Name: ");
                String newName = sc.nextLine();
                record = record.replaceFirst("Name: .*", "Name: " + newName);
                break;
            }
            case 2 -> {
                System.out.print("New Father's Name: ");
                String newFatherName = sc.nextLine();
                record = record.replaceFirst("Father's Name: .*", "Father's Name: " + newFatherName);
                break;
            }
            case 3 -> {
                System.out.print("New Mother's Name: ");
                String newMotherName = sc.nextLine();
                record = record.replaceFirst("Mother's Name: .*", "Mother's Name: " + newMotherName);
                break;
            }
            case 4 -> {
                System.out.print("New Date of Birth: ");
                String newDate_of_Birth = sc.nextLine();
                record = record.replaceFirst("Date of Birth: .*", "Date of Birth: " + newDate_of_Birth);
                break;
            }
            case 5 ->{
                System.out.println("New NID No: ");
                long newNID_No = sc.nextLong();
                sc.nextLine();
                record = record.replaceFirst("NID No: .*", "NID No: " + newNID_No );
                break;
            }
            case 6 ->{
                System.out.print("Permanent Address: ");
                String newPermanent_Address = sc.nextLine();
                record = record.replaceFirst("Permanent Address: .*","Permanent Address: " + newPermanent_Address);
                break;
            }
            case 7 -> {
                System.out.print("New Phone No: ");
                long newPhone_No = sc.nextLong();
                sc.nextLine();
                record = record.replaceFirst("Phone No: .*", "Phone No: " + newPhone_No);
                break;
            }
            case 8 -> {
                System.out.print("New Email: ");
                String newEmail = sc.nextLine();
                record = record.replaceFirst("Email: .*", "Email: " + newEmail);
                break;
            }
            case 9 -> {
                System.out.print("New Advance Rent: ");
                double newAdvance_Rent = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Advance Rent: .*", "Advance Rent: " + newAdvance_Rent);
                break;
            }
            case 10 -> {
                System.out.print("New Room Rent: ");
                double newRoom_Rent = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Room Rent: .*", "Room Rent: " + newRoom_Rent);
                break;
            }

            case 11 -> {
                System.out.print("New Meal Bill: ");
                double newMeal_Bill = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Meal Bill: .*", "Meal Bill: " + newMeal_Bill);
                break;
            }

            case 12 -> {
                System.out.print("New Other Bills: ");
                double newOther_Bills = sc.nextDouble();
                sc.nextLine();
                record = record.replaceFirst("Other Bills: .*", "Other Bills: " + newOther_Bills);
                break;
            }

            case 13 -> {
                System.out.print("New Floor: ");
                int newFloor = sc.nextInt();
                sc.nextLine();
                record = record.replaceFirst("Floor: .*", "Floor: " + newFloor);
                break;
            }

            case 14 -> {
                System.out.print("New Flat: ");
                String newFlat = sc.nextLine();
                record = record.replaceFirst("Flat: .*", "Flat: " + newFlat);
                break;
            }

            case 15 -> {
                System.out.print("New Room: ");
                String newRoom = sc.nextLine();
                record = record.replaceFirst("Room: .*", "Room: " + newRoom);
                break;
            }

            case 16 -> {
                System.out.print("New Branch: ");
                String newBranch = sc.nextLine();
                record = record.replaceFirst("Branch: .*", "Branch: " + newBranch);
                break;
            }
            default->{
                System.out.println("Invalid Option.");
            }
        }
    }
        allData.append(record).append("\n");
        }
        writer.write(allData.toString());
        read.close();
        writer.close();
        if (Residents_List.delete()){
        newFile.renameTo(Residents_List);
        System.out.print("Renamed Successfully.");}
        else {
        System.out.print("Renaming Unsuccessfully.");
        }

    if(found){
        System.out.println("Updated Successfully.");}
    else{
        System.out.println("Resident ID Not Found.");}
        System.out.println("Returning to Resident List");
        return;
    }
    case 3 -> {
        System.out.print("Resident Id: ");
        int RId = sc.nextInt();
        sc.nextLine();
        FM.Delete(Residents_List,"R",RId);
        System.out.println("Returning to Resident List");
        return;

    }
    case 0->{
        sc.close();
        System.exit(0);
    }
    default -> System.out.println("Invalid Input");
    }
    }
}
