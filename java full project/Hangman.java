import java.util.*;
import java.nio.file.*;;
public class Hangman
{
    static String Real_word="";
    static int len;
    Hangman()
    {
        Real_word="";
        len=0;
    }
    static String Get_Random_Word() throws Exception
    {
        String data=new String(Files.readAllBytes(Paths.get("Hangman.txt")));
        String[] words = data.split("\\R");
        data= words[(int)(Math.random()*words.length)];
        return data;
    }

    
    static char[] Initialize_Guessed_Word(String a ,int len)
    {
        char[] word = new char[len];
        for(int i=0;i<len;i++){
            char ch=a.charAt(i);
            if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                word[i]='_';
            else
                word[i]=ch;
        }
        return word;
    }

    private static void Update_Guessed_word(String Real_word, char[] guessedWord, char guessedChar) {
        for (int i = 0; i < Real_word.length(); i++) {
            if (Real_word.charAt(i) == guessedChar) {
                guessedWord[i] = guessedChar;
            }
        }
    }
    public static void PlayHangman() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int error=0;
        len = Real_word.length();
        Real_word = Get_Random_Word();
        char[] guessedWord=Initialize_Guessed_Word(Real_word,Real_word.length());
        System.out.println("Hi User!! Lets Play Hangman\n\nI'll give you a word with some of its letters hidden. You have to guess the word\nRemember you only have 6 tries");
        
        while(error<=6 && Real_word.equals(String.valueOf(guessedWord))==false)
        {
            System.out.println(String.valueOf(guessedWord));
            System.out.println("\nEnter the character you guessed :");
            char guessedChar = sc.nextLine().charAt(0);
            if(Real_word.indexOf(guessedChar)==-1)
            {
                error ++;
                System.out.println("the character you guessed is wrong !\n"+(7-error)+"tries left");

            }
            else
            {
                Update_Guessed_word(Real_word,guessedWord, guessedChar);
                System.out.println("correct guess !");
            }
        }
        if(Real_word.equals(String.valueOf(guessedWord))==true)
            System.out.println("Congratulations you win :" + Real_word);
        else 
            System.out.println("You lose! The word was: " + Real_word);
    }
}