package display;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import aminoAcidInfo.AminoAcidInfo;

public class AminoAcidsInterface extends JFrame {

	private JButton check, start, next;
	private JLabel imageLabel, aaLabel, nameLabel, doneLabel, doneLabel2;
	private static Random r = new Random();
	private static AminoAcidInfo[] aaList = new AminoAcidInfo[20];
	private static boolean flag = false;
	private static int[] randomList = new int[20];

	public AminoAcidsInterface(AminoAcidInfo[] listOfAminoAcids) { 
		aaList = listOfAminoAcids;
		final Toolkit t = Toolkit.getDefaultToolkit();   
		setLayout(new FlowLayout());

		aaLabel = new JLabel("amino acid:");
		nameLabel = new JLabel();
		imageLabel = new JLabel();
		doneLabel = new JLabel("jk there is no more. u done good");
		doneLabel2 = new JLabel ("i know u wanna play again");
		

		check = new JButton("check ur work");
		check.addActionListener(new ActionListener() {
			int length = 0;
			public void actionPerformed(ActionEvent evt) {
				if (flag) {
					length = 0;
					flag = false;
				}
				if (length < randomList.length - 11) {
					check.setVisible(false);
					next.setVisible(true);
					AminoAcidInfo aa = aaList[randomList[length]];
					Image image = t.getImage(aa.getImagePath().getAbsolutePath());
					ImageIcon icon = new ImageIcon(image);
					imageLabel.setIcon(icon);
					length ++;
					
				} 

			}
		});

		next = new JButton("get a new amino aced");
		next.addActionListener(new ActionListener() {
			int length = 1;
			public void actionPerformed(ActionEvent evt) {
				if (length < randomList.length - 11) {
					check.setVisible(true);
					next.setVisible(false);
					AminoAcidInfo aa = aaList[randomList[length]];
					String name = aa.getName();
					nameLabel.setText(name);
					imageLabel.setIcon(null);
					imageLabel.revalidate();
					length++;
				} else {
					aaLabel.setVisible(false);
					nameLabel.setVisible(false);
					imageLabel.setVisible(false);
					check.setVisible(false);
					next.setVisible(false);
					doneLabel.setVisible(true);
					doneLabel2.setVisible(true);
					start.setVisible(true);
					length = 1;
					flag = true;
				}
			}
		});

		start = new JButton("start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				for (int i = 0; i < randomList.length; i++) {
					randomList[i] = r.nextInt(20);
				}
				
				aaLabel.setVisible(true);
				nameLabel.setVisible(true);
				imageLabel.setVisible(true);
				next.setVisible(true);
				start.setVisible(false);

				check.setVisible(true);
				next.setVisible(false);
				AminoAcidInfo aa = aaList[randomList[0]];
				String name = aa.getName();
				nameLabel.setText(name);
				imageLabel.setIcon(null);
				imageLabel.revalidate();
				doneLabel.setVisible(false);
				doneLabel2.setVisible(false);
			}
		});
		
		aaLabel.setVisible(false);
		nameLabel.setVisible(false);
		doneLabel.setVisible(false);
		doneLabel2.setVisible(false);
		imageLabel.setVisible(false);
		check.setVisible(false);
		next.setVisible(false);

		add(aaLabel);
		add(nameLabel);
		add(imageLabel);
		add(check);
		add(next);
		add(doneLabel);
		add(doneLabel2);
		add(start);

	}
}