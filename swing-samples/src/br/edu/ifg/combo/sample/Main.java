package br.edu.ifg.combo.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class shows how to populate a JCombo with developer-defined object list.
 * The presented approach is based on override toString method from rendered objects. 
 * IMPORTANT: This code does not aims to apply best practices of programming.
 * 
 * @author kenyo
 *
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JComboBox<Course> cmb;
	private JButton btn;

	private List<Course> courses;

	public Main() {
		Course cc = new Course(1L, "CC");
		Course ec = new Course(2L, "EC");
		courses = Arrays.asList(cc, ec);
		init();
	}

	public void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1024, 300);

		btn = new JButton("start process");
		btn.setBounds(10, 10, 200, 30);

		cmb = new JComboBox<Course>();
		for (Course c : courses) {
			cmb.addItem(c);
		}
		cmb.setBounds(500, 10, 200, 30);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.this, "course id: " + ((Course) cmb.getSelectedItem()).getId()
						+ "   course name: " + ((Course) cmb.getSelectedItem()).getId());
			}
		});
		add(btn);
		add(cmb);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}
