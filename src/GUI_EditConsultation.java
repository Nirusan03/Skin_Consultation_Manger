import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_EditConsultation  extends JFrame implements ActionListener {
    WestminsterSkinConsultation wm = new WestminsterSkinConsultation();
    Container container;
    JLabel header;

    JLabel id;
    JTextField idLabel;

    JLabel licenseNoLabel;
    JTextField licenseNoField;
    JLabel consultationLabel;
    JLabel timeLabel;
    JLabel hhMMLabel;
    JComboBox consMonth;
    JComboBox consDate;
    JComboBox consHr;
    JComboBox consMin;
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
            "51", "52", "53", "54", "55"};

    int[] seconds = {1, 2, 3, 4, 5, 6};
    String[] durations = {"1", "2"};



    public GUI_EditConsultation(){
        setTitle("Edit consultation GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 90, 900, 450);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        header = new JLabel("Edit Consultation");
        header.setFont(new Font("Helvetica BOLD", Font.BOLD, 35));
        header.setSize(380, 50);
        header.setLocation(270, 10);

        id = new JLabel("Patient ID");
        id.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        id.setSize(130, 22);
        id.setLocation(100, 100);

        idLabel = new JTextField();
        idLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        idLabel.setSize(200, 23);
        idLabel.setLocation(230, 100);

        licenseNoLabel = new JLabel("Dr license no ");
        licenseNoLabel.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        licenseNoLabel.setSize(130, 22);
        licenseNoLabel.setLocation(100, 150);

        licenseNoField = new JTextField();
        licenseNoField.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        licenseNoField.setSize(200, 23);
        licenseNoField.setLocation(230, 150);

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
        notesLabel.setLocation(100, 200);

        notesField = new JTextField();
        notesField.setFont(new Font("Helvetica BOLD", Font.BOLD, 18));
        notesField.setSize(290, 83);
        notesField.setLocation(170, 200);

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
        container.add(id);
        container.add(idLabel);
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

    }
}
