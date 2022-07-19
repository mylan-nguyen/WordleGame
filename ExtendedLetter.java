
public class ExtendedLetter extends Letter {

	
	private String content;
	private int family;
	private boolean related;
	private final int SINGLETON = -1;
	
	public ExtendedLetter(String s) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = SINGLETON; 
	}
	
	public ExtendedLetter(String s, int fam) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = fam;
	}
	
	
	public boolean equals(Object other) {
		
		if (other instanceof ExtendedLetter == false) {
			return false;
		} 
		else {
			if (this.family == ((ExtendedLetter)other).family) {
				this.related = true;
			}
						
			if (this.content.equals(((ExtendedLetter)other).content)) {
				return true;
			} else {
				return false;
			}
			
		}
	}
	
	
	public String toString() {
		
		if (this.isUnused() == true && this.related == true) {
			return "." + this.content + ".";
		}
		else {
			return this.decorator() + this.content + this.decorator();
		}

	}
	
	public static Letter[] fromStrings(String[] content, int[] codes) {
		int l = content.length;
		Letter[] letters = new Letter[l];
		
		if (codes == null) {
			for (int i = 0; i < l; i++)
				letters[i] = new ExtendedLetter(content[i]);
		} 
		else {
			for (int i = 0; i < l; i++)
				letters[i] = new ExtendedLetter(content[i], codes[i]);
		}
		
		return letters;
	}
	
	
	public static void main(String[] args) {
		
		ExtendedLetter el1 = new ExtendedLetter("@"); 
		ExtendedLetter el2 = new ExtendedLetter(":)",1); 
		ExtendedLetter el3 = new ExtendedLetter(":(",1);

		// ********** ExtendedLetter equals
		System.out.println(el1.equals(el1) && !el1.equals(el2) && !el3.equals(el2));
		el1.setCorrect();
		el2.setUnused();
		el3.setUnused();
		
		System.out.println(el1);
		System.out.println(el2);
		System.out.println(el3);
		
	}
	

}
