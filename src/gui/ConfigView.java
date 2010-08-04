package gui;

import fk.fk;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConfigView extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = -566428567305470670L;
    private JTextField studiengang_name;
    private JTextArea wahlfachliste;
    private JButton ok_button;
    private JButton cancel_button;
    private fk fk;
    private JPanel view_panel;

    public ConfigView(fk fk) {
        this.fk = fk;
        init();
    }

    private void init() {

        this.setModal(true);
        this.setSize(300, 200);
        this.view_panel = new JPanel(new GridLayout(3, 2, 10, 15));
        this.studiengang_name = new JTextField();
        this.wahlfachliste = new JTextArea();
        this.ok_button = new JButton("Save");
        this.ok_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                save_clicked();
            }
        });
        this.cancel_button = new JButton("Cancel");

        this.view_panel.add(new JLabel("Studiengang Name"));
        this.view_panel.add(studiengang_name);
        this.view_panel.add(new JLabel("Wahlfächer"));
        this.view_panel.add(wahlfachliste);
        this.view_panel.add(cancel_button);
        this.view_panel.add(ok_button);

        this.add(view_panel);
        this.setVisible(true);


    }

    private void save_clicked() {
        if (this.studiengang_name.getText().equals("") || this.wahlfachliste.getText().equals("")) {
            JOptionPane.showConfirmDialog(rootPane, "Bitte alle Felder ausfüllen", "Fehler", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<String> list = new ArrayList<String>();
            String studiengang = this.studiengang_name.getText().trim();
            String[] facher = this.wahlfachliste.getText().split("\n");
            for (String s : facher) {
                list.add(s.trim());
            }
            fk.setVorlesungen(studiengang, list);
            this.dispose();
        }

    }
}
