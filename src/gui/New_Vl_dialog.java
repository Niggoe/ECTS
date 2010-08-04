package gui;

import fk.fk;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;

public class New_Vl_dialog extends JDialog {

    private JTextField vl_name;
    private JTextField vl_points;
    private JButton ok_button;
    private JButton cancel_button;
    private JCheckBox is_Master;
    private String[] fachrichtungen;
    private String[] studiengange;
    private JComboBox vl_fachrichtung;
    private JComboBox Studiengang;
    private String[] test = {"Mathe", "Biologie"};
    private JPanel view_panel;
    private HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
    private fk fk;

    public New_Vl_dialog(fk fk) {
        this.fk = fk;
        init();
    }

    private void init() {

        // Only Dialog is editable

        this.setModal(true);

        this.hashmap = fk.getMap();
        // initialize all parameters

        this.view_panel = new JPanel(new GridLayout(6, 2, 10, 15));

        this.vl_name = new JTextField();
        this.vl_points = new JTextField();


        if (this.hashmap.keySet().isEmpty()) {
            String[] nichts = new String[]{"Noch nichts angelegt"};
            this.Studiengang = new JComboBox(nichts);
            this.vl_fachrichtung = new JComboBox(nichts);
        } else {
            this.Studiengang = new JComboBox(this.getStudiengange());
            this.Studiengang.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    selection_changed_combobox(Studiengang.getSelectedIndex());
                }
            });

            this.vl_fachrichtung = new JComboBox(createStringArrayStudiengang(this.studiengange[this.Studiengang.getSelectedIndex()]));
        }


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

    public String[] createStringArrayStudiengang(String studiengang) {
        ArrayList<String> list = hashmap.get(studiengang);
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        this.fachrichtungen = array;
        return array;
    }

    public String[] getStudiengange() {
        String[] array = hashmap.keySet().toArray(new String[hashmap.keySet().size()]);
        this.studiengange = array;
        return array;
    }

    private void ok_action() {
        this.dispose();
    }

    private void selection_changed_combobox(final int selectedIndex) {
            ComboBoxModel model = new ComboBoxModel() {
            String[] test = createStringArrayStudiengang(studiengange[selectedIndex]);
            String selection = null;

            public void setSelectedItem(Object anItem) {
                selection = (String) anItem;
            }

            public Object getSelectedItem() {
               return selection;
            }

            public int getSize() {
                return test.length;
            }

            public Object getElementAt(int index) {
                return test[index];
            }

            public void addListDataListener(ListDataListener l) {

            }

            public void removeListDataListener(ListDataListener l) {
                
            }

            
        };

        this.vl_fachrichtung.setModel(model);
    }
}
