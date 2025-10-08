package gui;

import javax.swing.*;
import java.awt.*;

public class HostelDetailsForm extends JFrame {

    public HostelDetailsForm() {
        setTitle("Hostel Details - LBSCEK");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel("LBS College of Engineering Kasaragod (LBSCEK) - Hostels", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // Hostel details
        JTextArea detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);

        detailsArea.setText(
            "LBSCEK provides three in-campus and three out-campus hostels with full-furnished facilities for boys and girls separately.\n\n" +
            "Hostels are governed by the Hostel Warden (faculty) assisted by Resident Tutors (RTs), HRTs, and Matron for the welfare of the inmates.\n\n" +
            "Facilities include 24x7 WIFI, indoor games, knowledge sharing, mutual care, and dedicated messes with quality food.\n\n" +
            "Email: warden@lbscek.ac.in\n\n" +
            "Hostel Monitoring Committee:\n" +
            "- Prof. Jowhar Mubarak, Asst. Prof ME (Co-Ordinator)\n" +
            "- Prof. Joshua P Y, Deputy Warden (Member)\n" +
            "- Prof. Anish Joseph Jacob, Asst. Prof (EEE) (Member RT)\n" +
            "- Sri. Jayadevan P, T/M, ME (Member RT)\n" +
            "- Prof. Nishanth Augustine, Asst. Prof (ECE) (Member RT)\n" +
            "- Prof. Sreedhanya M I, Asst. Prof (EEE) (Member RT)\n" +
            "- Prof. Arun S Mathew, Asst. Prof (EEE) (Member HRT)\n" +
            "- Prof. Seena Thomas, Asst. Prof (CSE) (Member HRT)\n" +
            "- Sri. Binu K S, T/M (CSE) (Member HRT)\n" +
            "- Sri. Anoop Raheem A N, T/I, ECE (Member Non-Teaching)\n" +
            "- Smt. Manjusha O T, (Attender) (Member Non-Teaching)\n" +
            "- Student Representatives included\n\n" +
            "Hostel Rules and Guidelines:\n" +
            "1. Allotment only for students/staff of the institute.\n" +
            "2. Priority based on distance from hometown.\n" +
            "3. No criminal background students.\n" +
            "...\n" + 
            "20. Amendments will be made at proper time by hostel authorities.\n\n" +
            "Contact Info:\n" +
            "L B S College of Engineering (Govt. of Kerala Undertaking)\n" +
            "Povval, Muliyar Post Office, Kasaragod, Kerala-671542\n" +
            "Phone: 04994 250290, 04994 250555\n" +
            "Email: principal@lbscek.ac.in\n" +
            "Mon – Fri 9:00A.M. – 5:00P.M."
        );

        add(new JScrollPane(detailsArea), BorderLayout.CENTER);

        setVisible(true);
    }

    // Test
    public static void main(String[] args) {
        new HostelDetailsForm();
    }
}
