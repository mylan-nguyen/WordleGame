/*
 * This class represents a single letter that will be used in the game. 
 * Each game letter also has an accompanying integer label which indicates whether it is 
 * used, unused, or correct with respect to the mystery word.
 */
public class Letter {


	// declare private variables and constants
	private char letter;
	private int label;
	private final int UNSET = 1;
	private final int UNUSED = 2;
	private final int USED = 3;
	private final int CORRECT = 4;
	
	public Letter(char c) {
		this.label = UNSET;
		this.letter = c;
	}
	
	/*
	 * This method first checks whether otherObject is of the class Letter, and if not the value false is returned. 
	 * If otherObject is of the class Letter, then the “letter” attributes of otherObject and 
	 * this object are compared: If they are the same the value true is returned, otherwise false is returned.
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Letter == false) {
			return false;
		}
		else {
			if (this.letter == ((Letter)otherObject).letter) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/*
	 * This method decorates/surrounds the letters with either “-“, ”+”, or “!” 
	 * which correspond to unused, used, and correct.
	 */
	public String decorator() {
		if (this.label == USED) {
			return "+";
		}
		else if(this.label == UNUSED) {
			return "-";
		}  
		else if (this.label == CORRECT) {
			return "!";
		}
		else if (this.label == UNSET) {
			return " ";
		}
		else {
			return null;
		}
	}
	
	/*
	 * OVERRIDE METHOD that gives a representation of letter & label which uses the helper method decorator.
	 */
	public String toString() {
		String formatted_letter = "";
		formatted_letter = this.decorator() + this.letter + this.decorator();
		
		return formatted_letter;
	}
	
	public void setUnused() {
		this.label = UNUSED;
	}
	
	public void setUsed() {
		this.label = USED;
	}
	
	public void setCorrect() {
		this.label = CORRECT;
	}
	
	public boolean isUnused() {
		if (this.label == UNUSED) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * This method produces an array of objects of the class Letter from the string s given as parameter. 
	 * For each character in s a Letter object is created and stored in the array. 
	 * The Letter objects are stored in the array in the same order in which the corresponding characters appear in s.
	 */
	public static Letter[] fromString(String S) {
		
		Letter[] letter_array = new Letter[S.length()];
		
		for (int i=0; i < S.length(); i++) {
			letter_array[i] = new Letter(S.charAt(i));
			//System.out.println(new Letter(S.charAt(i)));
		}
		
		return letter_array;
	}
	
	/*
	 * public static void main(String[] args) {
		
		Letter myLetter = new Letter('M');
		String letterString = "summer";
		
		myLetter.setUnused();
		myLetter.decorator();
		System.out.println(myLetter);
		System.out.println(myLetter.fromString(letterString));

	}
	
	 */
	
}
