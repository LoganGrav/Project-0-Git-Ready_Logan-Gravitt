// Logan Gravitt
// CS 1400 Quiz 3


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PopulationProject {

    public static void main(String[] args) {
        File inputFile = new File("C:\\workspace\\USPopulation.txt"); //opens the input file
        Scanner scnr = null;
        try {
            scnr = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Population file not found");
            System.exit(1);
        }
        
        int[] pops = new int[41]; //reads populations data
        int i = 0;
        while (scnr.hasNextInt()) {  //reads each line and puts data into an array
            pops[i] = scnr.nextInt();
            i++;
        }
        
     
        int totalChange = 0;
        for (i = 1; i < pops.length; i++) {     //calculates total change using previous array
            int change = pops[i] - pops[i-1];
            totalChange += change;
        }
        double avgChange = (double)totalChange / (pops.length - 1); //calculates average change
        System.out.printf("Average Difference: %.3f people%n", avgChange);  //prints the average change
        
      
        int maxIncrease = 0;
        int maxIncreaseYear = 0;
        for (i = 1; i < pops.length; i++) {    //goes through each line of the array, noting the increase of each
            int increase = pops[i] - pops[i-1];
            if (increase > maxIncrease) {  //if the new increase is the largest so far, it is noted here
                maxIncrease = increase;
                maxIncreaseYear = i + 1950;
            }
        }
        System.out.printf(maxIncreaseYear + " is the year with the greatest increase");  //prints the year with the greatest increase
	  System.out.println ();
       
        int minIncrease = Integer.MAX_VALUE; 
        int minIncreaseYear = 0;
        for (i = 1; i < pops.length; i++) { //goes through each line of the array, noting the increase of each
            int increase = pops[i] - pops[i-1];
            if (increase < minIncrease) {  //if the new increase is the smallest so far, it is noted here
                minIncrease = increase;
                minIncreaseYear = i + 1950;
            }
        }
        System.out.printf(minIncreaseYear + " is the year with the smallest increase"); //prints the year with the smallest increase
        System.out.println ();
        scnr.close(); //close scanner
    }

}