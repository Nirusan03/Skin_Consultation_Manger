import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_DeleteConsultation   extends JFrame implements ActionListener {
    WestminsterSkinConsultation wm = new WestminsterSkinConsultation();
    Container container;
    JLabel header;

    JLabel id;
    JTextField idLabel;

    JLabel licenseNoLabel;
    JTextField licenseNoField;

    JButton submit;
    JButton reset;

    public GUI_DeleteConsultation(){
        setTitle("Delete consultation GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 90, 900, 450);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        header = new JLabel("Delete Consultation");
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
        container.add(submit);
        container.add(reset);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
