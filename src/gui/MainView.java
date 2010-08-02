package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import fk.Vl_table_modle;

public class MainView extends JFrame {

	private JMenuBar menubar;
	private JMenu filemenu;
        private JMenu configmenu;
	private JMenuItem load_menu;
	private JMenuItem save_menu;
	private JMenuItem exit_menu;

	private JPanel view_panel;
	private JPanel button_panel;
	
	private JButton new_vl;
	private JButton extract_points;
	
	private JTable list_vls;

	/**
	 * auto-generated ID
	 */
	private static final long serialVersionUID = -2092581057554144116L;

	public void init() {
		this.setTitle("ECTS Punkterechner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800, 600));

		//set GridBagLayout
		
		GridBagLayout gblayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		this.view_panel = new JPanel(gblayout);
		this.view_panel.setSize(800, 600);
		
		this.button_panel = new JPanel(new GridLayout(1,2));
		
		// button panel filled
		
		this.new_vl = new JButton("Neue Vorlesung");
		this.extract_points = new JButton("Punkteauszug");

		// create the Menubar and its components


		this.menubar = new JMenuBar();
		this.filemenu = new JMenu("File");
                this.configmenu = new JMenu("Config");

		this.load_menu = new JMenuItem("Load");
		this.save_menu = new JMenuItem("Save");
		this.exit_menu = new JMenuItem("Exit");
		this.exit_menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closeFrame();
			}
		});
		this.filemenu.add(load_menu);
		this.filemenu.add(save_menu);
		this.filemenu.addSeparator();
		this.filemenu.add(exit_menu);

		this.menubar.add(filemenu);
                this.menubar.add(configmenu);
		this.setJMenuBar(menubar);

		// create JTable View with all classes
		JTable table = new JTable(new Vl_table_modle());
		table.setPreferredScrollableViewportSize(new Dimension(600, 400));
		table.setFillsViewportHeight(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		
		this.button_panel.add(extract_points);
		this.button_panel.add(new_vl);
		
		// Add the scroll pane to this panel.
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth =1;
		c.gridheight = 1;
		this.view_panel.add(scrollPane,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.gridwidth =1;
		c.gridheight = 1;
		this.view_panel.add(button_panel,c);

		// make Frame visible
		this.add(view_panel);
		this.setVisible(true);
	}

	protected void closeFrame() {
		this.dispose();
	}

	public static void main(String[] args) {
		MainView mv = new MainView();
		mv.init();
	}

}
