import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//IMPORTS

public class Recipe_Input {

    public static void main(String[] args) throws IOException {
        String text = "";
        // SETTING VARS

        while (!text.equals("n")) { //Checking for the letter n
           
            String amount = "";
            Scanner scan = new Scanner(System.in);
            int count = 1;
            File Recipe_List = new File("Recipe_List.md");
            // CREATED NEW FILE
            if(!Recipe_List.exists()){
                System.out.println("File name: 'Recipe_list' Did not exist.");
                System.out.println("We had to make a new file.");
                Recipe_List.createNewFile(); 
                // CHECKS IF FILE ALREAD EXISTS
            }
            PrintWriter pw = new PrintWriter(new FileWriter("Recipe_List.md", true)); 
            // if file already exists is just writes on (adds) to that same file



            System.out.println("New Recipe Started");// print to the user
            System.out.println("Please enter your recipe name:"); //print to the user
            text = scan.nextLine();// Take next input from user and save it in the var "text"
            pw.write("# " + text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase()  + "\n\n"); // Write to the markdown file
            System.out.println("How many ingredients does your recipe have?");// print to the user
            
            int num = 0; // set the var "num" to 0
            int n = scan.nextInt();  //Takes input of number from user and makes that many ingredient inputs
            
            scan.nextLine();// This just eats the \n input from the user
            
            pw.write("|Amount/Ingredient|\n");//write to the file
            pw.write("|:----------------:|\n");

            while (num != n ) {  //while number does not = n do the following 
                System.out.println("Ingredient: ");// print to user
                text = scan.nextLine();// get user input
                int L = text.length();//char var named L
                char last = text.charAt(L-1);//Checks last letter in the word that was given
                char s = 's';
            if (last == s) {
                        System.out.print("How many " + text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase()  + " is needed in the recipe? ");
                        amount = scan.nextLine();
                        pw.write("* " + amount + " " + text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase() + "\n");
                        num++;
                    }
                    else{
                        System.out.print("How much " + text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase()  + " is needed in the recipe? ");
                        amount = scan.nextLine();
                        pw.write("* " + amount + " " + text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase()  + ""+ "\n");
                        num++;
                    }
            }
            
            while (!text.equalsIgnoreCase("done")){
                System.out.println("\nPlease enter the steps to make the recipe:");//print to user
                System.out.println("When finished type 'done'");
                System.out.print(count + ". "); 
                text = scan.nextLine();// Take next input from user and save it in "text"

                    if (text.equalsIgnoreCase("done")){
                        text = "";
                        break; // if the user input done break out of statment and do nothing to file.
                    }

                pw.write("* __Step "+ count + ".__ " + text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase()  + "\n\n");       
                count++; 
             
                pw.write("---\n");
                pw.flush();//flush the stream
                pw.close();//close the file! 
                
            }
            System.out.println("Your recipe has succesfully been added!\n"); // completed program
            System.out.println("Do you want to add another Recipe? (y/n)");// go again?

            text = scan.next();// Take next input from user and save it in "text"
            scan.nextLine();// Eats the enter \n
        }
        
        }
    }