import java.io.*;
import java.util.*;

public class Run {

    // User input reader
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        WestminsterSkinConsultation run =  new WestminsterSkinConsultation();

        // Menu options
        run.initialize();
        System.out.println("""
                ╔════╦═════════════════════════════════╗
                ║ A  ║  Add doctor to clinic           ║
                ║════╠═════════════════════════════════╣
                ║ D  ║  Delete a doctor from clinic    ║
                ║════╠═════════════════════════════════╣
                ║ V  ║  View all doctors in clinic     ║
                ║════╠═════════════════════════════════╣
                ║ S  ║  Save information in a file     ║
                ║════╠═════════════════════════════════╣
                ║ U  ║  Open GUI                       ║
                ║════╠═════════════════════════════════╣
                ║ Q  ║  Quit                           ║
                ╚════╩═════════════════════════════════╝
                """);
        String task = "";
        label:

        // Endless loop to run till user enter quit
        while(true){
            System.out.print("\nEnter the option to perform task : ");
            task = userInput.nextLine().toUpperCase();
            switch (task) {

                // Add doctor
                case "A":
                    run.addDoctor(WestminsterSkinConsultation.doctorArray);
                    break;
                // Delete doctor
                case "D":
                    run.deleteDoctor(WestminsterSkinConsultation.doctorArray);
                    break;

                // View doctors
                case "V":
                    run.docView(WestminsterSkinConsultation.doctorArray);
                    break;

                // Save date to text file
                case "S":
                    run.saveData(WestminsterSkinConsultation.doctorArray, 1);
                    break;

                //Quit program
                case "Q":
                    run.saveData(WestminsterSkinConsultation.doctorArray, 0);
                    break label;

                //Quit program
                case "U":
                    new GUI_ViewDoctors();
                    break label;
                default:
                    System.out.println("Invalid option. Enter again.\n");
                    break;
            }
        }
    }
}
