import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_ViewConsultation extends JFrame implements ActionListener {

    // Creating frames, labels, buttons
    JFrame frame;
    JTable consList;
    JButton viewDoc;
    JButton addCons;

    // Creating columns and rows
    String[][] consultationTable = new String[99][10];
    String[] tableColumn = {"First Name", "Last Name", "Phone no", "id", "DOB", "Dr License", "Notes", "Consultation Date", "Time", "Duration"};

    public GUI_ViewConsultation(){
        doctorsArray(WestminsterSkinConsultation.consArray, WestminsterSkinConsultation.patArray);
        this.setTitle("W1867405 Consultation view GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 450);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(117, 17, 152));
        headerPanel.setOpaque(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(117, 17, 152));
        buttonPanel.setOpaque(true);

        JLabel header =  new JLabel("W1867405 Consultation Table");

        header.setFont(new Font("Monospaced Bold Italic", Font.BOLD, 20));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(75, 2, 101));
        header.setOpaque(true);

        consList = new JTable(consultationTable, tableColumn);
        for (int rows = 0; rows < 10; rows++) consList.setRowHeight(rows, 25);
        consList.setFont(new Font("SansSerif", Font.PLAIN, 14));
        consList.setForeground(Color.WHITE);
        consList.setBackground(new Color(117, 17, 152));
        consList.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        consList.getTableHeader().setBackground(new Color(117, 17, 152));
        consList.getTableHeader().setForeground(Color.WHITE);

        // creating tables
        JScrollPane sp = new JScrollPane(consList);

        viewDoc = new JButton("Consultation Details");
        viewDoc.setFont(new Font("Santa Fe LET", Font.PLAIN, 15));
        viewDoc.setBounds(100, 0, 200, 80);
        viewDoc.setBackground(Color.BLACK);
        viewDoc.setForeground(Color.WHITE);
        viewDoc.addActionListener(this);

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
        buttonPanel.add(viewDoc);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(sp);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCons){
            new GUI_AddConsultation();
            this.dispose();
        }
    }

    // Assigning value to table's array
    public void doctorsArray(Consultation[] consultation, Patient[] patient) {
        for(int i = 0; i < consultationTable.length; i++){
            if (!patient[i].getFirstName().equals("e")){
                consultationTable[i][0] = patient[i].getFirstName();
                consultationTable[i][1] = patient[i].getLastName();
                consultationTable[i][2] = patient[i].getDob().toString();
                consultationTable [i][3] = Integer.toString(patient[i].getPatientId());
                consultationTable[i][4] = Integer.toString(patient[i].getPhoneNo());
                consultationTable[i][5] = Integer.toString(consultation[i].getLicNo());
                consultationTable[i][6] = consultation[i].getConsultationDate().toString();
                consultationTable[i][7] = consultation[i].getConsultationDate().getHour() + " : "
                        + consultation[i].getConsultationDate().getMinute();
                consultationTable[i][8] = Integer.toString(consultation[i].getDuration());
                consultationTable[i][9] = consultation[i].getShortNotes();

            }
        }

    }
}
