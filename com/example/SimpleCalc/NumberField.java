package com.example.SimpleCalc;

import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class NumberField extends TextField implements TextListener, FocusListener {
	private int valor;
	
	public NumberField () {
		addTextListener(this);
		addFocusListener(this);
	}
	
	public int getter() {
		if (isNumber(getText()))
			return valor;
		else return setValue(0);
	}
	
	private boolean isNumber(String a) {
		if(a!=null) 
			return a.matches("[0-9]+");
		return false;
	}

	public int setValue(int value) {
		System.out.println(value);
		valor = value;
		super.setText(Integer.toString(value));
		return valor;
	}

	@Override
	public void textValueChanged(TextEvent e) {
			if (getText().equals("")) {
				setValue(0);
				setCaretPosition(getText().length());
				return;
			}
					
			if (isNumber(getText())) {
				if (valor==0) {
					if (getCaretPosition()==1)
						valor = Integer.parseInt(getText());
					else
						if (getCaretPosition()==getText().length()) {
							setText(getText().substring(1,getText().length()));
							setCaretPosition(getText().length());
						}
				}
				valor = Integer.parseInt(getText());
			}
			else {
				setText(Integer.toString(valor));
				setCaretPosition(getText().length());
			}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		setCaretPosition(getText().length());
	}

	@Override
	public void focusLost(FocusEvent e) {}
}
