package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class New_Vl_dialog extends JDialog {

    private JTextField vl_name;
    private JTextField vl_points;
    private JTextField Studiengang;
    private JButton ok_button;
    private JButton cancel_button;
    private JCheckBox is_Master;
    private JComboBox vl_fachrichtung;
    private String[] test = {"Mathe", "Biologie"};
    private JPanel view_panel;

    public New_Vl_dialog() {
        init();
    }

    private void init() {

        // Only Dialog is editable

        this.setModal(true);

        // initialize all parameters

        this.view_panel = new JPanel(new GridLayout(6, 2, 10, 15));

        this.vl_name = new JTextField();
        this.vl_points = new JTextField();
        this.Studiengang = new JTextField();
        this.Studiengang.setEditable(false);

        this.vl_fachrichtung = new JComboBox(test);

        this.is_Master = new JCheckBox();


        this.ok_button = new JButton("Ok");
        this.ok_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ok_action();
            }
        });
        this.cancel_button = new JButton("Cancel");
        this.cancel_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cancel_action();
            }
        });


        this.view_panel.add(new JLabel("Name der Vorlesung:"));
        this.view_panel.add(vl_name);
        this.view_panel.add(new JLabel("ECTS-Punkte der Vorlesung:"));
        this.view_panel.add(vl_points);
        this.view_panel.add(new JLabel("Studiengang:"));
        this.view_panel.add(Studiengang);
        this.view_panel.add(new JLabel("Fachrichtung:"));
        this.view_panel.add(vl_fachrichtung);
        this.view_panel.add(new JLabel("Master-Vorlesung:"));
        this.view_panel.add(is_Master);
        this.view_panel.add(cancel_button);
        this.view_panel.add(ok_button);




        this.setTitle("Neue Vorlesung hinzufügen");
        this.setSize(400, 250);
        this.add(view_panel);
        this.setVisible(true);
    }

    private void cancel_action() {
        this.dispose();
    }

    private void ok_action() {
        this.dispose();
    }
}
