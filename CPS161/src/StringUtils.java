
class StringUtils
{
    private String m_str;
    
    
    public StringUtils(String str)
    {
        m_str = str;
    }
    
    
    
    public String toString()
    {
        return m_str;
    }
    
    
    
    public int letterCount(char c)
    {
    	int length = m_str.length();
    	int count = 0;
    	
    	for(int index = 0; index < length; index++)
    	{
    		char currentChar = m_str.charAt(index);
    		if (Character.toLowerCase(currentChar) == Character.toLowerCase(c))
    		{
    			count++;
    		}
    		
    	}
    		
    	return count;
    }
    
    
    
    public int countVowels()
    {
    	int count = 0;
    	for (int index = 0; index < m_str.length(); index++)
    	{
    		char currentChar = m_str.charAt(index);
    		currentChar = Character.toLowerCase(currentChar);
    		switch(currentChar)
    		{
    			case 'a': case 'e': case 'i': case 'o': case 'u':
    				count++;
    			default:
    		}
    		
    	}
    	return count;
    }
    
    
    
    public int countConsonants()
    {
    	int count = 0;
    	for (int index = 0; index < m_str.length(); index++)
    	{
    		char currentChar = m_str.charAt(index);
    		if(Character.isLetter(currentChar))
    			count++;				
    	}
    		
    	return Math.abs(countVowels() - count); 
    }
    
    
    
    public boolean replaceFirst(String find, String replace_with)
    {
    	int index = m_str.indexOf(find);
    	
    	if (index >= 0)
    	{
    		m_str = m_str.substring(0, index) + replace_with + m_str.substring(index+find.length(), m_str.length());
    		return true;
    	}
    	else
    		return false;
    }
   

    
    public void replaceAll(String find, String replace_with)
    {
    	while (replaceFirst(find, replace_with) == true);
    }


    
    public void testCounts(char c)
    {
        System.out.println("Number of Vowels=" + 
            countVowels());
        System.out.println("Number of Consonants=" + 
            countConsonants());
        System.out.println("Number of "+c +"'s = "+ 
            letterCount(c));
    }
    
    public static void main(String[] args)
    {
        StringUtils su1 = new StringUtils(
            "She Sells Sea Shells Down by the Sea Shore");
        System.out.println("Starting with: " + su1);
        su1.testCounts('s');
        su1.replaceAll("Sea", "Lake");
        System.out.println("Result: " + su1);
        
        System.out.println("*********************************");
        
        StringUtils su2 = new StringUtils(
            "4 Score and 7 Years Ago");
        System.out.println("Starting with: " + su2);
        su2.testCounts('a');
        su2.replaceAll("4", "Four");
        su2.replaceAll("7", "Seven");
        System.out.println("Result: " + su2);
    }
}