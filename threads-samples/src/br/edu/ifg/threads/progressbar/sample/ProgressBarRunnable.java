package br.edu.ifg.threads.progressbar.sample;

import javax.swing.JProgressBar;

public class ProgressBarRunnable implements Runnable{

	private JProgressBar progressBar;
	private int stage = 0;

	public ProgressBarRunnable(JProgressBar progressBar) {
		this.progressBar = progressBar;

	}
	
	@Override
	public void run() {
		while(stage < 100) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			progressBar.setValue(stage);
			stage ++;
		}
		
	}

}
