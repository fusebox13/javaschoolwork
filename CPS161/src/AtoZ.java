
public class AtoZ {

	public static void main(String[] args) {
		
		//declared starting letter
		char letter = 'a';
		
		//Switch nested in the loop determines if the letter is a vowel or consonant
		//the loop displays each letter, and stops at the letter 'z'
		while (letter <= 'z')
		{
			switch(letter)
			{
			case 'a':	System.out.println(letter + " is a Vowel.");
						break;
			case 'e': 	System.out.println(letter + " is a Vowel.");
						break;
			case 'i': 	System.out.println(letter + " is a Vowel.");
						break;
			case 'o': 	System.out.println(letter + " is a Vowel.");
						break;
			case 'u': 	System.out.println(letter + " is a Vowel.");
						break;
			default:	System.out.println(letter + " is a Consonant");
						break;
			}
			letter++;
		}

	}

}
