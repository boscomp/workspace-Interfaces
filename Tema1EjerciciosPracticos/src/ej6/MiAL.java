package ej6;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MiAL implements ActionListener{

	private JTextField t;
	private JFrame f;
	public  void BL(JFrame frame, JTextField t) {
		
		this.f=frame;
		this.t=t;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ActionListener al= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

	

}
