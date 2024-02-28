package com.example.SimpleCalc;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ventana extends Frame implements WindowListener, KeyListener {
	static Ventana ventana;
	NumberField text = new NumberField();
	int valorOperacion = 0;
	int tipoOperacion = 0;
	
	public static void main (String[] args) {
		ventana = new Ventana();
	}

	private Ventana() {
		super("Calculadora");
		Panel center = new Panel();
		center.setLayout(new BorderLayout());
		Panel right = new Panel();
		right.setLayout(new GridLayout(0,1));
		Panel numbers = new Panel();
		numbers.setLayout(new GridLayout(3,0));
		center.add(numbers);
		for(int i = 1; i < 10; i++) {
			numbers.add(new Boton(i));}
		center.add(new Boton(0),BorderLayout.SOUTH);
		for(int i = 4; i > -1; i--) {
			addWithActionListener(new Boton(),right,i);}
		addWindowListener(this);
		add(center);
		add(right,BorderLayout.EAST);
		center.add(text,BorderLayout.NORTH);
		pack();
		setVisible(true);
	}
	void addWithActionListener (Boton b, Panel r, int o) {		
		b.addActionListener(e->{
			if (o>0) {
				valorOperacion = text.getter();
				text.setValue(0);
			} else {
				switch (tipoOperacion) {
				case 4: text.setValue(valorOperacion+text.getter()); break;
				case 3: text.setValue(valorOperacion-text.getter()); break;
				case 2: text.setValue(valorOperacion*text.getter()); break;
				case 1: text.setValue(valorOperacion/(text.getter()==0?1:text.getter())); break;
				}
			}
			tipoOperacion = o;
		});
		r.add(b);
		switch (o) {
		case 4: b.setLabel("+"); break;
		case 3: b.setLabel("-"); break;
		case 2: b.setLabel("x"); break;
		case 1: b.setLabel("÷"); break;
		case 0: b.setLabel("="); break;
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}