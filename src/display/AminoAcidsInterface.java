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
	private JLabel imageLabel, aaLabel, nameLabel;
	private static Random r = new Random();
	private static AminoAcidInfo[] aaList = new AminoAcidInfo[20];

	public AminoAcidsInterface(AminoAcidInfo[] listOfAminoAcids) { 
		aaList = listOfAminoAcids;
		final int[] randomList = new int[25];
		for (int i = 0; i < randomList.length; i++) {
			randomList[i] = r.nextInt(20);
		}

		final Toolkit t = Toolkit.getDefaultToolkit();   
		setLayout(new FlowLayout());

		aaLabel = new JLabel("amino acid:");
		nameLabel = new JLabel();
		imageLabel = new JLabel();

		check = new JButton("check ur work");
		check.addActionListener(new ActionListener() {
			int length = 0;
			public void actionPerformed(ActionEvent evt) {
				if (length < randomList.length) {
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
				if (length < randomList.length) {
					check.setVisible(true);
					next.setVisible(false);
					AminoAcidInfo aa = aaList[randomList[length]];
					String name = aa.getName();
					nameLabel.setText(name);
					imageLabel.setIcon(null);
					imageLabel.revalidate();

				}
				length ++;
			}
		});

		start = new JButton("start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
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
			}
		});
		add(start);
		aaLabel.setVisible(false);
		nameLabel.setVisible(false);
		imageLabel.setVisible(false);
		check.setVisible(false);
		next.setVisible(false);

		add(aaLabel);
		add(nameLabel);
		add(imageLabel);
		add(check);
		add(next);

	}
}