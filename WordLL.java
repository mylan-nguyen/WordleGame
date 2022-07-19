/*
 * This class is a central repository for information about a WordLL game.
 * It stores a mystery word and all word guesses tried so far. 
 * It keeps a history of the past word guesses in a linked structure.
 */
public class WordLL {
	private Word mysteryWord;
	private LinearNode<Word> history;
	
	public WordLL(Word mystery) {
		history = new LinearNode<Word>();	// initialize an empty history
		mysteryWord = mystery;	// set mysteryWord attributes to the parameter mystery
	}
	
	public boolean tryWord(Word guess) {
		boolean myGuess = guess.labelWord(mysteryWord);
		
		// create a node of the class LinearNode, store the Word guess object in it 
		LinearNode<Word> guessNode = new LinearNode<Word>(guess);
		
		// then link this node to the front of the linked list pointed by history
		guessNode.setNext(history.getNext());
		
		history.setNext(guessNode);
		
		if (myGuess == true) {
			return myGuess;
		}
		return false;
	}
	
	public String toString() {
		String inputWords = "";
		LinearNode<Word> node = history;
		
		while (node != null) {
			if (node.getElement() != null) {
				inputWords += node.getElement() + "\n";
			}
			
			node = node.getNext();
		}
		return inputWords;
	}
}
