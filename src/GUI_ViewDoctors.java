import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class GUI_ViewDoctors extends JFrame implements ActionListener {

    // Creating frames, labels, buttons
    JFrame frame;
    JTable doctorList;
    JButton consShow;
    JButton addCons;

    // Creating columns and rows
    String[][] docData = new String[10][7];
    String[] tableColumn = {"First Name", "Last Name", "DOB", "License no", "Age", "Specialisation", "Phone no"};
    public GUI_ViewDoctors(){

        // initializing array
        doctorsArray(WestminsterSkinConsultation.doctorArray);
        this.setTitle("W1867405 Doctor GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 450);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 243, 243));
        headerPanel.setOpaque(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 243, 243));
        buttonPanel.setOpaque(true);

        JLabel header =  new JLabel("W1867405 Doctor Table");

        header.setFont(new Font("Monospaced Bold Italic", Font.BOLD, 20));
        header.setForeground(Color.BLACK);
        header.setBackground(new Color(255, 243, 243));
        header.setOpaque(true);

        doctorList = new JTable(docData, tableColumn);
        for (int rows = 0; rows < 10; rows++) doctorList.setRowHeight(rows, 25);
        doctorList.setFont(new Font("SansSerif", Font.PLAIN, 14));
        doctorList.setForeground(Color.BLACK);
        doctorList.setBackground(new Color(255, 243, 243));
        doctorList.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        doctorList.getTableHeader().setBackground(new Color(255, 243, 243));
        doctorList.getTableHeader().setForeground(Color.BLACK);

        // creating table
        JScrollPane sp = new JScrollPane(doctorList);

        consShow = new JButton("Consultation Details");
        consShow.setFont(new Font("Santa Fe LET", Font.PLAIN, 15));
        consShow.setBounds(100, 0, 200, 80);
        consShow.setBackground(Color.BLACK);
        consShow.setForeground(Color.WHITE);
        consShow.addActionListener(this);

        addCons = new JButton("Add Consultation");
        addCons.setFont(new Font("Santa Fe LET", Font.PLAIN, 15));
        addCons.setBounds(0, 0, 230, 100);
        addCons.setBackground(Color.BLACK);
        addCons.setForeground(Color.WHITE);
        addCons.addActionListener(this);

        headerPanel.setPreferredSize(new Dimension(100, 50));
        buttonPanel.setPreferredSize(new Dimension(100, 50));
        headerPanel.add(header);
        buttonPanel.add(addCons);
        buttonPanel.add(consShow);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(sp);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consShow)
            new GUI_ViewConsultation();
        if (e.getSource() == addCons)
            new GUI_AddConsultation();
    }

    public void doctorsArray(Doctor[] doctors) {
        // Assigning value to table's array

        for (int i = 0; i < doctors.length; i++) {
            if (!doctors[i].getFirstName().equals("e")){
                docData[i][0] = doctors[i].getFirstName();
                docData[i][1] = doctors[i].getLastName();
                docData[i][2] = doctors[i].getDob().toString();
                docData[i][3] = Integer.toString(doctors[i].getLicenseNo());
                docData[i][4] = String.valueOf(LocalDate.now().getYear() - doctors[i].getDob().getYear());
                docData[i][5] = doctors[i].getSpecialisation();
                docData[i][6] = Integer.toString(doctors[i].getPhoneNo());
            }
        }
    }
}