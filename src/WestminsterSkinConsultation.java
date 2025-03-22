import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WestminsterSkinConsultation implements SkinConsultationManager{
    static Doctor[] doctorArray;
    static Patient[] patArray;
    static Consultation[] consArray;
    static int doctorCount = 0; // keep track of  count variable

    static int patientCount = 0; // keep track of patients
    static int consultationCount = 0; // keep track of patients
    static String textFileString = ""; // String variable to store file data
    static int fileHeader = 0; // header only : using only once
    static Scanner userInput = new Scanner(System.in); // Scanner input object to get user input

    @Override
    public void initialize() {
        doctorArray = new Doctor [10]; // Array to store doctors
        patArray = new Patient[200]; // Array to store patients
        consArray = new Consultation[200]; // Array to store consultations

        for(int i = 0; i < 10; i++){
            // Creating objects and initializing arrays
            doctorArray[i] = new Doctor();
            doctorArray[i].initializeDoc();
        }

        for (int i = 0; i < 200; i++){
            // Creating objects and initializing arrays
            patArray[i] = new Patient();
            consArray[i] = new Consultation();
            patArray[i].initializePat();
            consArray[i].initializeCons();
        }
    }

    // Sorting method
    @Override
    public void lNameSort(Doctor[] docList) {

        for(int outer = 0; outer < docList.length; outer++)
            for(int inner = outer+1; inner < docList.length; inner++){

                // If previous last name is larger than next last name then it will swap the value
                if (!docList[outer].getFirstName().equals("e") && !docList[inner].getFirstName().equals("e") ){
                    if(docList[outer].getLastName().compareTo(docList[inner].getLastName()) > 0){

                        String tempFirstName= docList[outer].getFirstName();
                        String tempLastName = docList[outer].getLastName();
                        int tempLicense = docList[outer].getLicenseNo();
                        String tempSpecial = docList[outer].getSpecialisation();
                        LocalDate tempDOB = docList[outer].getDob();
                        int tempPhoneNo = docList[outer].getPhoneNo();

                        docList[outer].setFirstName(docList[inner].getFirstName());
                        docList[outer].setLastName(docList[inner].getLastName());
                        docList[outer].setLicenseNo(docList[inner].getLicenseNo());
                        docList[outer].setDob(docList[inner].getDob());
                        docList[outer].setSpecialisation(docList[inner].getSpecialisation());
                        docList[outer].setPhoneNo(docList[inner].getPhoneNo());

                        docList[inner].setFirstName(tempFirstName);
                        docList[inner].setLastName(tempLastName);
                        docList[inner].setLicenseNo(tempLicense);
                        docList[inner].setDob(tempDOB);
                        docList[inner].setSpecialisation(tempSpecial);
                        docList[inner].setPhoneNo(tempPhoneNo);

                    }
                }
            }
    }

    @Override // Viewing doctors
    public void docView(Doctor[] docList) {
        lNameSort(docList); // Sortign the name before showing
        if (doctorCount <= 0) System.out.println("There is no doctor in the clinic");
        else {
            System.out.println("===============================");
            System.out.println("VIEW DOCTORS SELECTED");
            for (Doctor doctor : docList) {
                if (!doctor.getFirstName().equals("e")) {
                    int docAge = LocalDate.now().getYear() - doctor.getDob().getYear();
                    String[] print = {"    Dr. " + doctor.getFirstName() + " " + doctor.getLastName(),
                                      "    License no : " + doctor.getLicenseNo(),
                                      "    Specialisation : " + doctor.getSpecialisation(),
                                      "    Mobile number : " + doctor.getPhoneNo(),
                                      "    DOB : " + doctor.getDob(),
                                      "    Age : " + docAge};

                    // Display doctor name
                    System.out.println(
                            "╔" + "═".repeat(40) + "╗" +
                                    "\n║" + print[0] + " ".repeat(40-print[0].length()) +"║"+
                                    "\n║" + print[1]+ " ".repeat(40-print[1].length()) +"║"+
                                    "\n║" + print[2] + " ".repeat(40-print[2].length()) +"║"+
                                    "\n║" + print[3]+ " ".repeat(40-print[3].length()) +"║"+
                                    "\n║" + print[4] + " ".repeat(40-print[4].length()) +"║"+
                                    "\n║" + print[5]+ " ".repeat(40-print[5].length()) +"║"+
                                    "\n╚" + "═".repeat(40) + "╝\n");
                }
            }
        }
    }

    @Override // Adding a doctor
    public void addDoctor(Doctor[] docList) {
        String fName, lName;
        int drLicenseNo, year, month, day;
        LocalDateTime savingDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormat  = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        fileHeader++;
        // Text file header
        if(fileHeader == 1)
            textFileString += "W1867405 Consultation booking - " + LocalDate.now() + "\n════════════════════════════════════════\n";

        System.out.print("""
                |- ----------- -|
                |  DOCTOR NAME -|
                |- ----------- -|
                """);

        // Storing data inside array
        while (true) {
            try {
                System.out.print("Enter the doctor's First Name : ");
                fName = userInput.nextLine();
                fName = Character.toUpperCase(fName.charAt(0)) + fName.substring(1);
                docList[doctorCount].setFirstName(fName);
                break;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Must enter Doctor's First name : ");
            }
        }

        // Storing data inside array
        while (true){
            try {
                System.out.print("Enter the doctor's Last Name : ");
                lName = userInput.nextLine();
                lName = Character.toUpperCase(lName.charAt(0)) + lName.substring(1);
                docList[doctorCount].setLastName(lName);
                break;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Must enter Doctor's Last name : ");
            }
        }

        System.out.print("""
                \n
                |- ------------- -|
                |  DATE OF BIRTH -|
                |- ------------- -|
                """);

        // Storing data inside array
        while (true) {
            try {
                System.out.print("Enter the birth year of Dr : ");
                year = userInput.nextInt();

                if (year > 1995 || year < 1950) {
                    System.out.println("Must be a valid year.\n");
                } else
                    break;
            } catch (InputMismatchException e) {
                System.out.println("DOB can only be number");
                userInput.nextLine();
            }
        }

        // Storing data inside array
        while (true) {
            try {
                System.out.print("Enter the birth month of Dr : ");
                month = userInput.nextInt();

                if (month > 13 || month < 0) {
                    System.out.println("Must be a valid month.\n");
                } else
                    break;
            } catch (InputMismatchException e) {
                System.out.println("DOB can only be number");
                userInput.nextLine();
            }
        }

        // Storing data inside array
        while (true) {
            try {
                System.out.print("Enter the birth date of Dr : ");
                day = userInput.nextInt();

                if (day > 32 || day < 0) {
                    System.out.println("Must be a valid date.\n");
                } else{
                    docList[doctorCount].setDob(year, month, day);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("DOB can only be number");
                userInput.nextLine();
            }
        }

        System.out.print("""
                \n|- -------------------------|
                |  DOCTOR'S License no     -|
                |  DOCTOR'S Specialisation -|
                |  DOCTOR'S Phone No       -|
                |- ----------------------- -|
                """);

        // Storing data inside array
        while (true) {
            try {
                boolean same = true;
                System.out.print("Enter the doctor's license no : ");
                drLicenseNo = userInput.nextInt();
                for (Doctor doctor : docList) {
                    if (doctor.getLicenseNo() == drLicenseNo) {
                        System.out.println("\nLicense cannot be same.");
                        same = false;
                        break;
                    }
                }

                if (drLicenseNo == 0 || !same)
                    System.out.println("Must enter the doctor's license no.\n");
                else {
                    docList[doctorCount].setLicenseNo(drLicenseNo);
                    userInput.nextLine();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Dr license number can be in digits only\n");
                userInput.nextLine();
            }
        }

        // Storing data inside array
        while (true) {
            System.out.print("Enter doctor's Specialisation  : ");
            docList[doctorCount].setSpecialisation(userInput.nextLine());
            if (docList[doctorCount].getSpecialisation().equals(""))
                System.out.println("Must enter the specialisation.");
            else
                break;
        }

        // Storing data inside array
        while (true) {
            try {
                System.out.print("Enter the doctor's mobile no : ");
                docList[doctorCount].setPhoneNo(userInput.nextInt());
                userInput.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Mobile number can only be digits.\n");
                userInput.nextLine();
            }
        }

        textFileString +="Doctor added to the clinic :" +
                "\nDoctor Name - " + fName + " " + lName +
                "\nDr.  " + fName + " " + lName + "'s License Number : " + docList[doctorCount].getLicenseNo() +
                "\nDr. "  + fName + " " + lName + "'s specialisation : " + docList[doctorCount].getSpecialisation()+
                "\nDr. "  + fName + " " + lName + "'s DOB : " + docList[doctorCount].getDob()+
                "\nDr. "  + fName + " " + lName + "'s Age : " + (LocalDate.now().getYear() - docList[doctorCount].getDob().getYear()
               + "\n\n");
        doctorCount++;
    }

    // Deleting doctor
    @Override
    public void deleteDoctor(Doctor[] docList) {
        int docLicenseNo;
        boolean remove = false;
        if (doctorCount != 0){
            System.out.println("Doctors name and license number mentioned below.");
            lNameSort(docList);

            for (Doctor dr: docList){
                if (!dr.getFirstName().equals("e")){
                    System.out.println("\nDr. " + dr.getFirstName() +" " + dr.getLastName()+
                                       "\nLicense no : " + dr.getLicenseNo());
                }
            }

            while(true){
                try {
                    System.out.print("\nEnter the doctor's license number to remove  : ");
                    docLicenseNo = userInput.nextInt();
                    if (docLicenseNo == 0)
                        System.out.println("Number not entered.\n");
                    else break;
                }
                catch (InputMismatchException e){
                    System.out.println("Doctor's license number can only be digit\n");
                    userInput.nextLine();
                }
            }

            // Deleting doctor's data and shifting the other doctors to left.
            int docPos = 0;
            for(int i = 0; i < docList.length;){
                if (docLicenseNo == docList[i].getLicenseNo()){
                    doctorCount--;
                    System.out.println("Dr. " + docList[i].getFirstName() + " " + docList[i].getLastName() + " removed from the list." + "\n" +
                            "Current doctor count of the clinic : " + doctorCount);
                    textFileString +="Doctor removed from the clinic +" +
                            "\nDoctor Name :  " + docList[i].getFirstName() + " " + docList[i].getLastName() +
                            "\nDr.  " + docList[i].getFirstName() + " " + docList[i].getLastName() + "'s License Number : " +
                            docList[i].getLicenseNo() + "\n\n";
                    docPos = i;
                    for(int num = docPos; num < docList.length; num++){
                        if (docPos <= 9){
                            docList[docPos].setFirstName(docList[docPos+1].getFirstName());
                            docList[docPos].setLastName(docList[docPos+1].getLastName());
                            docList[docPos].setLicenseNo(docList[docPos+1].getLicenseNo());
                            docList[docPos].setDob(docList[docPos+1].getDob());
                            docList[docPos].setSpecialisation(docList[docPos+1].getSpecialisation());
                            docList[docPos].setPhoneNo(docList[docPos+1].getPhoneNo());

                            docList[doctorCount].initializeDoc();
                            docView(docList);
                            break;
                        }
                        i++;
                        docPos++;
                    }
                    break;
                }

                if(i == docList.length){
                    System.out.println("Invalid License number entered");
                    break;
                }
            }
        }

        else {
            System.out.println("There is no doctor in clinic\n");
        }
    }

    // Saving data to text file
    @Override
    public void saveData(Doctor[] docList, int quit) throws IOException {
        FileWriter writeFile = new FileWriter("WestminsterFile_W1867405.txt", true);
        lNameSort(docList);
        if(quit == 1) {
            writeFile.write(textFileString);
            writeFile.close();
            textFileString = "";
        }


        else if(quit == 0){
            textFileString += "-".repeat(39) + "\nFinalised Doctors: \n";
            for(int i = 0; i < docList.length; i++){
                if (!docList[i].getFirstName().equals("e")){
                    textFileString += (i+1)+") Dr. " + docList[i].getFirstName() +" " + docList[i].getLastName()+
                            "\n   Doctor's license no : " + docList[i].getLicenseNo()+
                            "\n   Doctor's Specialisation : " + docList[i].getSpecialisation() +
                            "\n   Doctor's Mobile number : " + docList[i].getPhoneNo() +
                            "\n   Doctor's DOB : " + docList[i].getDob() + "\n" +
                            "\n   Doctor's Age " + (LocalDate.now().getYear() - docList[i].getDob().getYear()) +"\n";
                }
            }
            textFileString += "\n════════════════════════════════════════\n\n";
            writeFile.write(textFileString);
            writeFile.close();
        }
        System.out.println("Data saved to text file");
    }

}
