package Program;

public class minCat {

	

		

	
	public String mixString(String magicWord, String magicalWorld) {
		String output;
	if (magicWord.length() > magicalWorld.length()) {
		int diff1 = magicWord.length() - magicalWorld.length();
		magicWord = magicWord.substring(diff1, magicWord.length());
		output = magicWord+magicalWorld;
	}
	
	else if (magicWord.length() < magicalWorld.length()) {
		int diff2 = magicalWorld.length() - magicWord.length();
		magicalWorld = magicalWorld.substring(diff2, magicalWorld.length());
		output = magicWord+magicalWorld;
	}
	else {
		output = magicWord+magicalWorld;
	}
	
	return output;
	}

}
