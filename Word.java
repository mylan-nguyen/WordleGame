

/*
 * This class represents a word in the game that is comprised of any number of letters. 
 * Each letter is represented by a Letter object. 
 * The Letter objects are stored in a linked list formed by objects of the class LinearNode. 
 * Each node in the linked list stores an object of the class Letter.
 */

public class Word {
	private LinearNode<Letter> firstLetter;
	
	/*
	 * This method initializes the Word object so the Letter objects in array “letters” 
	 * is stored within its linked structure.
	 */
	public Word(Letter[] letters) {
		LinearNode<Letter> node = new LinearNode<Letter>(letters[0]);
		firstLetter = node;
		
		for (int i=1 ; i < letters.length; i++) {
			node.setNext(new LinearNode<Letter>(letters[i]));
			node = node.getNext();
		}
	}
	
	/*
	 * This method creates a String of the form: “Word: L1 L2 L3 … Lk”, 
	 * where each Li is the string produced by invoking the toSting method on each Letter object of this Word.
	 */
	public String toString() {
		String inputLetters = "";
		LinearNode<Letter> node = firstLetter;
		
		while (node != null) {
			inputLetters += node.getElement() + " ";
			node = node.getNext();
		}
		String inputWord = "Word: ";
		inputWord = inputWord + inputLetters;
	
		return inputWord;
	}
	
	/*
	 * This method takes a mystery word as a parameter and updates each of Letters’ 
	 * “label” attribute contained in this Word object with respect to the mystery word.
	 * @return true if this word is identical in content to the mystery word.
	 */
	public boolean labelWord(Word mystery) {
		LinearNode<Letter> thisNode = this.firstLetter;
		LinearNode<Letter> mystNode = mystery.firstLetter;
		
		while (thisNode != null) {
			thisNode.getElement().setUnused();
			thisNode = thisNode.getNext();
		}
		
		thisNode = this.firstLetter;
				
		if (getWord(this).equals(getWord(mystery))) {
			while (thisNode != null) {
				thisNode.getElement().setCorrect();
				thisNode = thisNode.getNext();
			}
			return true;
		}
		
		
		// anything after the statement above is else
		//thisNode = this.firstLetter;
		while (thisNode != null) {
			while (mystNode != null) {
				if (thisNode.getElement().equals(mystNode.getElement()))
					thisNode.getElement().setUsed();				
				mystNode = mystNode.getNext();
			}
			if (thisNode.getElement().decorator() == " ") {
				thisNode.getElement().setUnused();
			}
			mystNode = mystery.firstLetter;
			thisNode = thisNode.getNext();
		}
		
		thisNode = this.firstLetter;
		mystNode = mystery.firstLetter;
		
		while (thisNode != null && mystNode != null) {
			if (thisNode.getElement().equals(mystNode.getElement())) {
				thisNode.getElement().setCorrect();
			}
			thisNode = thisNode.getNext();
			mystNode = mystNode.getNext();
		}
	
		return false;
	}
	
	private String getWord(Word currentWord) {
		String s = "";
		LinearNode<Letter> currentNode = currentWord.firstLetter;
		
		while (currentNode != null) {
			s += currentNode.getElement().toString().charAt(1);
			currentNode = currentNode.getNext();
		}
		return s;
	}

/*
 * public static void main(String[] args) {
		
		
		Word myWord = new Word(Letter.fromString("OBJECT"));
		System.out.println("Before " + myWord);
		//System.out.println(myWord.toString());
		
		Word herWord = new Word(Letter.fromString("CODE"));
		System.out.println("COMPARE TO " + herWord);
		boolean b = myWord.labelWord(herWord);
		System.out.println("After " + myWord);
		System.out.println(myWord.toString());
		System.out.println("Are 2 words are the same word: " + b);
		
	}
 */

	
}