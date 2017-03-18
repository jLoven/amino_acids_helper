package aminoAcidInfo;

import java.io.File;

public class Initializer {


	static final File dir = new File("/Users/platypus/Desktop/random_stuff/code/java/amino_acids_helper/AminoAcidQuiz/images/");

	public static AminoAcidInfo[] makeList() {

		AminoAcidInfo[] listOfAminoAcids = new AminoAcidInfo[20];

		for (int i = 0; i < listOfAminoAcids.length; i++) {
			listOfAminoAcids[i] = new AminoAcidInfo();
		}

		listOfAminoAcids[0].setNameAndCode("alanine", "ALA");
		listOfAminoAcids[1].setNameAndCode("arginine", "ARG");
		listOfAminoAcids[2].setNameAndCode("asparagine", "ASN");
		listOfAminoAcids[3].setNameAndCode("aspartate", "ASP");
		listOfAminoAcids[4].setNameAndCode("cysteine", "CYS");
		listOfAminoAcids[5].setNameAndCode("glutamine", "GLN");
		listOfAminoAcids[6].setNameAndCode("glutamate", "GLU");
		listOfAminoAcids[7].setNameAndCode("glycine", "GLY");
		listOfAminoAcids[8].setNameAndCode("histidine", "HIS");
		listOfAminoAcids[9].setNameAndCode("isoleucine", "ILE");
		listOfAminoAcids[10].setNameAndCode("leucine", "LEU");
		listOfAminoAcids[11].setNameAndCode("lysine", "LYS");
		listOfAminoAcids[12].setNameAndCode("methionine", "MET");
		listOfAminoAcids[13].setNameAndCode("phenylalanine", "PHE");
		listOfAminoAcids[14].setNameAndCode("proline", "PRO");
		listOfAminoAcids[15].setNameAndCode("serine", "SER");
		listOfAminoAcids[16].setNameAndCode("threonine", "THR");
		listOfAminoAcids[17].setNameAndCode("tryptophan", "TRP");
		listOfAminoAcids[18].setNameAndCode("tyrosine", "TYR");
		listOfAminoAcids[19].setNameAndCode("valine", "VAL");

		for (AminoAcidInfo a : listOfAminoAcids) {
			for (final File f : dir.listFiles()) {
				if ((a.getName().trim() + ".gif").equalsIgnoreCase(f.getName().trim())) {
					//  System.out.println(f.getName());
					a.setImagePath(f);
				}
			}
		}
		
		return listOfAminoAcids;
	}
}
