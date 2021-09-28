import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Recipe_Input {

    public static void main(String[] args) throws IOException {
        String text = "";
        String amount = "";
        Scanner scan = new Scanner(System.in);
        File Recipe_List = new File("Recipe_List.md");
        if(!Recipe_List.exists()){
            System.out.println("File name: 'Recipe_list' Did not exist.");
            System.out.println("We had to make a new file.");
            Recipe_List.createNewFile();
        }
        PrintWriter pw = new PrintWriter(new FileWriter("Recipe_List.md", true));

        while (!text.equals("n")) {
            System.out.println("New Recipe Started");
            System.out.println("Please enter your recipe name:");
            text = scan.nextLine();// Take next input from user and save it in "text"
            pw.write("# " + text + "\n\n");
            System.out.println("How many ingredients does your recipe have?");
            int num = 0;
            int n = scan.nextInt();  //Takes input of number from user and makes that many ingredient inputs
            scan.nextLine();// This just eats the \n input from the user
            pw.write("|Amount/Ingredient|\n");
            pw.write("|:----------------:|\n");
            while (num != n ) {   
                System.out.println("Ingredient: ");
                text = scan.nextLine();
                System.out.print("How much " + text + " is needed in the recipe? ");
                    amount = scan.nextLine();
                    pw.write("| " + amount + " " + text + "|"+ "\n");
                    num++;
                // if(text == "milk"){
                //     System.out.print("How much " + text + " is needed in the recipe? ");
                //     amount = scan.nextLine();
                //     pw.write("* " + amount + " " + text + ""+ "\n");
                //     num++;
                // } else{
                // System.out.print("How many " + text + " is needed in the recipe? ");
                // amount = scan.nextLine();
                // pw.write("* " + amount + " " + text + ""+ "\n");
                // num++;
                // }
            }
            int count = 1;
            while (!text.equalsIgnoreCase("done")){
            System.out.println("Please enter the steps to make the recipe:");
            System.out.println("When finished type 'done'");
            System.out.print(count+". "); 
            text = scan.nextLine();// Take next input from user and save it in "text"
            pw.write("__Step "+ count + ".__ " + text + "\n\n");       
            count++; 
            }

            System.out.println("Add another Recipe? (y/n)");

            text = scan.next();// Take next input from user and save it in "text"
            scan.nextLine();// Eats the enter \n
        }
        pw.write("---\n");
        pw.flush();
        pw.close();
        System.out.println("Recipe has Succesfully been added!"); // completed program
        }
    }