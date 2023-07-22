import java.util.Scanner;

public class SoundexApp{
    public static void main(String[] args) 
    {
        // Ayşegül Yıldız

        // define variables
        Scanner scan;
        String input;
        String soundex;
        scan = new Scanner(System.in);

        // ask for input
        System.out.print( "Enter a string: ");
        input = scan.next();

         // while loop to ask for input as long as the input is not exit
        while( !input.equals("exit")){
            // check if the input only contains letters
            if (isAlphaWord(input)){
                
                // use different methods to change the input and get the soundex version of the word
                input = buildCode(input);
                input = removeAdjacentDuplicates(input);
                input = padCode(input);
                soundex = getSoundex(input);
                // print the soundex
                System.out.printf( "Soundex: %s %n ", soundex);
                System.out.print( "Enter a string: ");
                input = scan.next();
            }
            else{
                // if the input does not only contain letetrs display an error message
                System.out.println( "Characters must be alphabetic..." );
                System.out.print( "Enter a string: ");
                input = scan.next();
                
            }
    }
    scan.close();
    // display goodbye message if the input is exit
    if (input.equals("exit")){
        System.out.println("Goodbye!");
    }   
    }

    // create isAlphaWord method to determine if the input only contains letters
    /** * This is a simple description of the method. . . 
    * @param input input string
    * @return      return true if every character in string is alphabetic
    */
    public static boolean isAlphaWord( String input ){
        // for loop to check every character to see if they are letters
        for (int i = 0; i < input.length(); i++){
            if (!( input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') && !( input.charAt(i) >= 'a' && input.charAt(i) <= 'z')) {
                return false;
            }
        }
        return true;   
    }
    
    /** * This is a simple description of the method. . . 
    *  // method to remove the vowels and h, y, w letters
    * @param input input string
    * @return      string of the input with the specific letters removed
    */
    public static String removeLetters( String input){
        
        // for loop to check characters and remove them if they contain unwanted letters
        for ( int i = 1; i < input.length(); i++){
            if ( input.charAt(i) == 'h' || input.charAt(i) == 'w' || input.charAt(i) == 'y' || input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'u' || input.charAt(i) == 'o' ){
                
                if ( i < input.length() )
                input = input.substring(0,i) + input.substring(i+1);

                else 
                {
                    input = input.substring(0,i); 
                }
            }
        }
        return input;
    }
    /** * This is a simple description of the method. . . 
    * buildCode method to make the input as wanted to transform it into soundex
    * @param input input string
    * @return      return the input as the unwanted characters removed
    */
    public static String buildCode( String input )
    {
        input = removeLetters(input);
        return input;
    }
    /** * This is a simple description of the method. . . 
    * method to remove duplicate letters 
    * @param input input string
    * @return      return the input without duplicate characters
    */
    public static String removeAdjacentDuplicates( String input ){
        // check if any character is the same using for loops
        for (int i = 0; i < input.length() ; i++){
            for ( int f = 1; f < input.length() && f != i; f++){
                if ( input.charAt(i) == input.charAt(f) ){
                    input = input.substring(0,f) + input.substring(f+1);
                }
            }
        }
        return input;
    }
    
    /** * This is a simple description of the method. . .
    * method to trim the letters after fourth one  
    * @param input input string
    * @return      equal the length of the input to four
    */
    public static String padCode( String input ){
        // if the input length is bigger than four than just take the first four characters
        if ( input.length() > 4 ){
            input = input.substring(0,4);
        }
        // if the length is smaller than four complete it to four by adding zeros
        else if ( input.length() == 3){
            input = input.substring(0) + '0';
        }
        else if ( input.length() == 2 ){
            input = input.substring(0) + '0' + '0';
        }
        
        return input;
    }
    
    /** * This is a simple description of the method. . . 
    * method to get the equvalent of the soundex of the given word 
    * @param input input string
    * @return      the soundex string
    */
    public static String getSoundex( String input ){
        String soundex;
        soundex =  input.substring(0,1);
        for (int i = 1 ; i< input.length() ; i++ ){
            // utilize the the getCode method to change letters to their assigned integers
            char a = input.charAt(i);
            soundex = soundex + getCode(a);
        } 
        return soundex;
    }
    
    /** * This is a simple description of the method. . . 
    * method to alter the letters to given integers 
    * @param a char 
    * @return  int as the corresponding integer to the character within the input
    */
    public static int getCode(char a){
        int c = 0;
        // use if to check which integer is suitable for the characters of the input
            if ( a == 'b' ||  a == 'p' ||  a == 'f' ||  a == 'v' ){
                c = 1;
            }
            else if ( a == 'c' || a == 'g' || a == 'j' || a == 'k' || a == 'q' || a == 's' || a == 'x' || a == 'z' ){
                c =2;
            }
            else if ( a == 'd' || a == 't'){
                c = 3;
            }
            else if ( a == 'l'){
                c = 4;
            }
            else if ( a == 'm' || a == 'n' ){
                c = 5;
            }
            else if ( a == 'r' ){
                c = 6;
            }
        
        return c;   
    }
}

   
