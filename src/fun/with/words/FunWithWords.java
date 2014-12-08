/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.with.words;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tyler_Atiburcio
 */
public class FunWithWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new File("corncob_wordlist.txt"));
        ArrayList<String> data = new ArrayList<String>();
        while(in.hasNext()) data.add(in.next());
        
        System.out.println("Checking list for palindrome");
        for(String s : findPalindrome(data)) System.out.println(s);
        System.out.println("\n\nChecking list for is a crossword problem");
        for(String s : findCrossword(data)) System.out.println(s);
        System.out.println("\n\nChecking list for words that contain excatly 1 vowel once");
        for(String s : excatlyOnce(data)) System.out.println(s);
        System.out.println("\n\nChecking list for worsd that have vowels in order");
        for(String s : inOrder(data)) System.out.println(s);
    }
    
    private static ArrayList<String> findPalindrome(ArrayList<String> data)
    {
        ArrayList<String> found = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            boolean isPalinDrome = true;
            for (int j = 0; j < data.get(i).length(); j++) {
                if(data.get(i).charAt(j) != data.get(i).charAt((data.get(i).length()-1)-j)) isPalinDrome = false;
            }
            if(isPalinDrome) found.add(data.get(i));
        }
        return found;
    }

    private static ArrayList<String> findCrossword(ArrayList<String> data) {
        ArrayList<String> found = new ArrayList<String>();
        for(String s : data) if(s.matches("[A-Za-z]z[A-Za-z]e[A-Za-z]")) found.add(s);
        return found;
    }

    private static ArrayList<String> excatlyOnce(ArrayList<String> data) {
        ArrayList<String> found = new ArrayList<String>();
        for(String s : data)
        {
            int[] count = new int[5];
            //Each Element represents a vowel 0:a 1:e 2:i 3:o 4:u
            for(char c : s.toCharArray())
            {
                switch(c)
                {
                    case 'a':
                    case 'A':
                    {
                        count[0]++;
                        break;
                    }
                    case 'e':
                    case 'E':
                    {
                        count[1]++;
                        break;
                    }
                    case 'i':
                    case 'I':
                    {
                        count[2]++;
                        break;
                    }
                    case 'o':
                    case 'O':
                    {
                        count[3]++;
                        break;
                    }
                    case 'u':
                    case 'U':
                    {
                        count[4]++;
                        break;
                    }
                                
                                
                }
                boolean isValid = true;
                for(int n : count) if(n != 1) isValid = false;
                if(isValid) found.add(s);
            }
        }
        return found;
    }

    private static ArrayList<String> inOrder(ArrayList<String> data) {
        ArrayList<String> found = new ArrayList<String>();
        for(String s : data) if(s.matches(".*a.*e.*i.*o.*u.*")) found.add(s);
        return found;
            
    }
    
    
    
    
    
    
}
