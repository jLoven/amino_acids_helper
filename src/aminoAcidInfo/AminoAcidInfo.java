package aminoAcidInfo;

import java.io.File;

public class AminoAcidInfo {

	private String name;
	private String threeLetterCode;
	private File imagePath;
	
	public String getName() {
		return this.name;
	}
	
	public void setThreeLetterCode(String code) {
		this.threeLetterCode = code;
	}
	
	public String getThreeLetterCode() {
		return this.threeLetterCode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNameAndCode(String name, String code) {
		this.name = name;
		this.threeLetterCode = code;
	}
	
	public File getImagePath() {
		return this.imagePath;
	}
	
	public void setImagePath(File file) {
		this.imagePath = file;
	}
	
}
