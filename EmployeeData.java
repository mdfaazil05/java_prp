import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeData {

    String FullRoute;

    public static void addDetails(Scanner scanner,FileWriter writer){
        System.out.println("\n-----------------------------------------------");
        System.out.println("Do you want to add details? (click y/n)");
        String q= scanner.nextLine();
        if (q.equalsIgnoreCase("y")){
            System.out.println("Employee name: ");
            String employeeName=scanner.nextLine();
            System.out.println("Employee age: ");
            String employeeAge=scanner.nextLine();
            System.out.println("Department: ");
            String Department=scanner.nextLine();
            try{
            writer.append(employeeName+","+employeeAge+","+Department+"\n");
            writer.flush(); // Ensure data is written immediately
            System.out.println("Data added successfully!\n");
            addDetails(scanner, writer);
            }
            catch(Exception e){
                System.err.println(e);
            }
        }
        else if(q.equalsIgnoreCase("n")){
            System.out.println("\n-----------------------------------------------");
            System.out.println("Thanks please check the file");
        }
        else{
            System.out.println("Please click a valid letter!!");
            addDetails(scanner, writer);
        }
    }




    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(System.getProperty("os.name"));

        System.out.println("-----------------------------------------------");
        System.out.println("Enter the route: ");

        String route = scanner.nextLine();
        System.out.println("What should be th name of the file?");
        String fileName=scanner.nextLine();
        
        EmployeeData emp=new EmployeeData();
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){
           emp.FullRoute=route+"/"+fileName+".csv";
            
        }
        else if (System.getProperty("os.name").toLowerCase().contains("windows")){
            String tempRoute=route+"\\"+fileName;
            emp.FullRoute=tempRoute.replace("\\", "\\\\");
        }


        try {
            File file = new File(emp.FullRoute);
            if (file.createNewFile()) {
                FileWriter writer =new FileWriter(emp.FullRoute);
                // writer.write(text);
                System.out.println("-----------------------------------------------\n");
                System.out.println("File create is successfully created!");

                writer.write("EmployeeName,EmployeeAge,Department\n");

                addDetails(scanner,writer);
                
                writer.close();
            } else {
                System.out.println("The file exists");
            }
        } catch (IOException e) {
            System.err.println(e);

        }
        scanner.close();
    }
}
