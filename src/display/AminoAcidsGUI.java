package display;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import aminoAcidInfo.AminoAcidInfo;
import aminoAcidInfo.Initializer;

public class AminoAcidsGUI {  
	
	public static void main(String[] args) {
		
		AminoAcidInfo[] listOfAminoAcids = Initializer.makeList();
		AminoAcidsInterface gui = new AminoAcidsInterface(listOfAminoAcids);
		
		gui.setTitle("u better learn the amino aceds");
		gui.setBounds(300, 300, 300, 300);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(gui.EXIT_ON_CLOSE);
	}  

}  

