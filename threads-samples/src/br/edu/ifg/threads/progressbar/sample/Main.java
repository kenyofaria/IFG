package br.edu.ifg.threads.progressbar.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * This set of classes were written to show how you can use threads to update 
 * screen component state, in this case I bring to you an example using JProgressBar.
 * 
 * IMPORTANT: These classes don't aim to show best development practices.
 * @author kenyo
 *
 */
public class Main extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JButton btn;
	private JProgressBar progress;
	
	private int stage = 0;
	
	public Main(){
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1024, 300);
		
		btn = new JButton("start process");
		btn.setBounds(10, 10, 200, 30);
		
		progress = new JProgressBar();
		progress.setBounds(10, 40, 800, 30);
		progress.setValue(stage);
		
		add(btn);
		add(progress);
		
		btn.addActionListener(listenerBtn());
		
		setVisible(true);
	}

	private ActionListener listenerBtn() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Runnable tarefa = new ProgressBarRunnable(progress);
				Thread t = new Thread(tarefa);
				t.start();
			}
		};
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
}
