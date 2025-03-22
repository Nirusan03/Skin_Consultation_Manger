import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.*;

public class GUI_AddConsultation extends JFrame implements ActionListener {

    WestminsterSkinConsultation wm = new WestminsterSkinConsultation();
    // Creating container, header, labels, field, label, combo box
    Container container;
    JLabel header;
    JLabel fNameLabel, lNameLabel;
    JTextField fNameField, lNameField;
    JLabel dobLabel;
    JComboBox dobYear;
    JComboBox dobMonth;
    JComboBox dobDate;
    JLabel licenseNoLabel;
    JTextField licenseNoField;
    JLabel phoneNoLabel;
    JTextField phoneNoField;
    JLabel consultationLabel;
    JLabel timeLabel;
    JLabel hhMMLabel;
    JComboBox consMonth;
    JComboBox consDate;
    JLabel consTimeLabel;
    JComboBox consHr;
    JComboBox consMin;
    JComboBox amPm;
    JLabel durationLabel;
    JComboBox durationCom;
    JLabel notesLabel;
    JTextField notesField;

    JButton submit;
    JButton reset;
    String[] year = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021", "20222",
            "2023"};

    String[] month = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };

    String[] date = { "1", "2", "3", "4", "5",
                       "6", "7", "8", "9", "10",
                      "11", "12", "13", "14", "15",
                      "16", "17", "18", "19", "20",
                      "21", "22", "23", "24", "25",
                      "26", "27", "28", "29", "30", "31" };

    String[] hour = {"1", "2", "3", "4", "5",
                     "6", "7", "8", "9", "10",
                     "11", "12", "13", "14", "15",
                     "16", "17", "18", "19", "20",
                     "21", "22", "23", "24"};

    String[] minutes = { "1", "2", "3", "4", "5",
                         "6", "7", "8", "9", "10",
                         "11", "12", "13", "14", "15",
                         "16", "17", "18", "19", "20",
                         "21", "22", "23", "24", "25",
                         "26", "27", "28", "29", "30",
                         "31", "32", "33", "34", "35",
                         "36", "37", "38", "39", "40",
                         "41", "42", "43", "44", "45",
                         "46", "47", "48", "49", "50",
                         "51", "52", "53", "54", "55",
                         "56", "57", "58", "59"};

    int[] seconds = {1, 2, 3, 4, 5, 6};
    String[] durations = {"1", "2"};



    public GUI_AddConsultation(){
        setTitle("Add consultation GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 90, 900, 450);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        header = new JLabel("Consultation Booking");
        header.setFont(new Font("Helvetica BOLD", Font.BOLD, 35));
        header.setSize(380, 50);
        header.setLocation(270, 10);

        fNameLabel = new JLabel("First name ");
        fNameLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        fNameLabel.setSize(100, 22);
        fNameLabel.setLocation(100, 100);

        fNameField = new JTextField();
        fNameField.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        fNameField.setSize(200, 23);
        fNameField.setLocation(230, 100);

        lNameLabel = new JLabel("Last name ");
        lNameLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        lNameLabel.setSize(100, 22);
        lNameLabel.setLocation(100, 150);

        lNameField = new JTextField();
        lNameField.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        lNameField.setSize(200, 23);
        lNameField.setLocation(230, 150);

        phoneNoLabel = new JLabel("Phone no ");
        phoneNoLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        phoneNoLabel.setSize(100, 22);
        phoneNoLabel.setLocation(100, 200);

        phoneNoField = new JTextField();
        phoneNoField.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        phoneNoField.setSize(200, 23);
        phoneNoField.setLocation(230, 200);

        dobLabel = new JLabel("DOB");
        dobLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        dobLabel.setSize(100, 22);
        dobLabel.setLocation(100, 250);

        dobDate = new JComboBox(date);
        dobDate.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        dobDate.setSize(40, 22);
        dobDate.setLocation(230, 250);

        dobMonth = new JComboBox(month);
        dobMonth.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        dobMonth.setSize(60, 22);
        dobMonth.setLocation(270, 250);

        dobYear = new JComboBox(year);
        dobYear.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        dobYear.setSize(80, 22);
        dobYear.setLocation(330, 250);

        licenseNoLabel = new JLabel("Dr license no ");
        licenseNoLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        licenseNoLabel.setSize(130, 22);
        licenseNoLabel.setLocation(100, 300);

        licenseNoField = new JTextField();
        licenseNoField.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        licenseNoField.setSize(200, 23);
        licenseNoField.setLocation(230, 300);

        consultationLabel = new JLabel("Consultation : Date");
        consultationLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        consultationLabel.setSize(180, 22);
        consultationLabel.setLocation(500, 100);

        consDate = new JComboBox(date);
        consDate.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        consDate.setSize(40, 22);
        consDate.setLocation(690, 100);

        consMonth = new JComboBox(month);
        consMonth.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        consMonth.setSize(60, 22);
        consMonth.setLocation(730, 100);

        timeLabel = new JLabel(": Time");
        timeLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        timeLabel.setSize(100, 22);
        timeLabel.setLocation(625, 150);

        consHr = new JComboBox(hour);
        consHr.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        consHr.setSize(50, 22);
        consHr.setLocation(690, 150);

        consMin = new JComboBox(minutes);
        consMin.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        consMin.setSize(50, 22);
        consMin.setLocation(739, 150);

        hhMMLabel = new JLabel("HH:MM");
        hhMMLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        hhMMLabel.setSize(100, 22);
        hhMMLabel.setLocation(800, 150);

        durationLabel = new JLabel(": Duration(hrs)");
        durationLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        durationLabel.setSize(140, 22);
        durationLabel.setLocation(625, 200);

        durationCom = new JComboBox(durations);
        durationCom.setFont(new Font("Helvetica BOLD", Font.BOLD, 14));
        durationCom.setSize(40, 22);
        durationCom.setLocation(765, 200);

        notesLabel = new JLabel("Notes");
        notesLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        notesLabel.setSize(100, 22);
        notesLabel.setLocation(500, 250);

        notesField = new JTextField();
        notesField.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        notesField.setSize(290, 83);
        notesField.setLocation(570, 250);

        submit = new JButton("Submit");
        submit.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        submit.setSize(100, 20);
        submit.setLocation(350, 350);
        submit.addActionListener(this);

        reset = new JButton("Reset");
        reset.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        reset.setSize(100, 20);
        reset.setLocation(470, 350);
        reset.addActionListener(this);

        container.add(header);
        container.add(fNameLabel);
        container.add(fNameField);
        container.add(lNameLabel);
        container.add(lNameField);
        container.add(phoneNoLabel);
        container.add(phoneNoField);
        container.add(dobLabel);
        container.add(dobDate);
        container.add(dobMonth);
        container.add(dobYear);
        container.add(licenseNoLabel);
        container.add(licenseNoField);
        container.add(consultationLabel);
        container.add(consMonth);
        container.add(consDate);
        container.add(timeLabel);
        container.add(consHr);
        container.add(consMin);
        container.add(hhMMLabel);
        container.add(durationLabel);
        container.add(durationCom);
        container.add(notesLabel);
        container.add(notesField);
        container.add(submit);
        container.add(reset);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rn;
        if (e.getSource() == submit){
            String fName = fNameField.getText().strip();
            String lName = lNameField.getText().strip();
            String tempPhoneNo = phoneNoField.getText();
            String tempLicense = licenseNoField.getText();
            String notes = notesField.getText();
            boolean checker = false;
            ArrayList <Integer> checkedDoctors = new ArrayList<>();
            int[]  licenses= new int[10];
            int[] count = new int[10];
            for (int elements = 0; elements < count.length; elements++) count[elements] = 0;
            if (fName.equals("") || lName.equals("") || tempPhoneNo.equals("")
                || tempLicense.equals("") || notes.equals("")){
                JOptionPane.showMessageDialog(null, "Warning message", "Please enter all data", JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                    // Converting the values to integer
                    int phoneNo = Integer.parseInt(tempPhoneNo.strip());
                    int licenseNo = Integer.parseInt(tempLicense.strip());
                    int dobD = Integer.parseInt((String) dobDate.getSelectedItem());
                    int dobM = Integer.parseInt(String.valueOf(dobMonth.getSelectedIndex() + 1));
                    int dobY = Integer.parseInt((String) dobYear.getSelectedItem());
                    int consM = Integer.parseInt(String.valueOf(consMonth.getSelectedIndex() + 1));
                    int consD = Integer.parseInt((String) consDate.getSelectedItem());
                    int consH = Integer.parseInt((String) consHr.getSelectedItem());
                    int consMins = Integer.parseInt((String) consMin.getSelectedItem());
                    int durationPeriod = Integer.parseInt((String) durationCom.getSelectedItem());

                    LocalDateTime consultation = LocalDateTime.of(2022, consM, consD, consH, consMins);
                    LocalDateTime consultationFinishes = LocalDateTime.of(2022, consM, consD, (consH+durationPeriod), consMins);

                    // If the values are correct then it will check to save the values
                    int patientCount = WestminsterSkinConsultation.patientCount;
                    int consultationCount = WestminsterSkinConsultation.patientCount;
                    for (int l = 0; l <WestminsterSkinConsultation.doctorArray.length; l++){
                        licenses[l] = WestminsterSkinConsultation.doctorArray[l].getLicenseNo();
                    }
                    for (int i = 0; i < WestminsterSkinConsultation.doctorArray.length; i++){
                        if (WestminsterSkinConsultation.doctorArray[i].getLicenseNo() == licenseNo){
                            int docPos = 0;
                            for(int j = 0; j < WestminsterSkinConsultation.consArray.length; j++){
                                if (licenseNo == WestminsterSkinConsultation.consArray[j].getLicNo())
                                {
                                    checkedDoctors.add(licenseNo);
                                    boolean consulSame = (consultation.isEqual(WestminsterSkinConsultation.consArray[j].getConsultationDate()));

                                    boolean consulBeginBetween = (consultation.isAfter(WestminsterSkinConsultation.consArray[j].getConsultationDate()) &&
                                            consultation.isBefore(WestminsterSkinConsultation.consArray[j].getConsultationEntire()));

                                    boolean consulEndBetween = (consultation.isAfter(WestminsterSkinConsultation.consArray[j].getConsultationDate()) &&
                                            consultationFinishes.isBefore(WestminsterSkinConsultation.consArray[j].getConsultationEntire()));

                                    boolean consulDurationLong = (consultation.isBefore(WestminsterSkinConsultation.consArray[j].getConsultationDate()) &&
                                            consultationFinishes.isAfter(WestminsterSkinConsultation.consArray[j].getConsultationEntire()));
                                        if ((consulSame) || (consulBeginBetween) || (consulEndBetween) || (consulDurationLong)){
                                            while (true){
                                                licenseNo = licenses[new Random().nextInt(licenses.length)];
                                                if (licenseNo != 0){
                                                    break;
                                                }
                                            }
                                        }
                                        else docPos++;
                                }
                            }
                            if (docPos == 0){
                                System.out.println("Patient count " + WestminsterSkinConsultation.patientCount);
                                System.out.println("Consultation count " + WestminsterSkinConsultation.consultationCount);
                                WestminsterSkinConsultation.patArray[patientCount].setFirstName(fName);
                                WestminsterSkinConsultation.patArray[patientCount].setLastName(lName);
                                WestminsterSkinConsultation.patArray[patientCount].setPhoneNo(phoneNo);
                                WestminsterSkinConsultation.patArray[patientCount].setDob(dobY, dobM, dobD);
                                WestminsterSkinConsultation.patArray[patientCount].setPatientId(patientCount++);
                                WestminsterSkinConsultation.consArray[consultationCount].setLicNo(licenseNo);
                                WestminsterSkinConsultation.consArray[consultationCount].setShortNotes(notes);
                                WestminsterSkinConsultation.consArray[consultationCount].setConsultationDate(consM, consD, consH, consMins);
                                WestminsterSkinConsultation.consArray[consultationCount].setDuration(durationPeriod);
                                WestminsterSkinConsultation.patientCount++;
                                WestminsterSkinConsultation.consultationCount++;
                                new GUI_ViewConsultation();
                                this.dispose();
                                break;
                            }
                        }
                    }

                }
                catch (NumberFormatException es){
                    JOptionPane.showMessageDialog(null, "Invalid data type enter", "Please enter all data", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
