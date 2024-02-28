package com.example.SimpleCalc;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton extends Button implements ActionListener {
	Boton (int a) {
		super(Integer.toString(a));
		addActionListener(this);
	}

	public Boton() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Ventana.ventana.text.getText().equals("0"))
			Ventana.ventana.text.setText("");
		if (Ventana.ventana.tipoOperacion==0) {
			Ventana.ventana.text.setText(getLabel());
			Ventana.ventana.tipoOperacion = -1;
		} else
		Ventana.ventana.text.setText(Ventana.ventana.text.getText()+getLabel());
		Ventana.ventana.text.requestFocusInWindow();
	}
}
