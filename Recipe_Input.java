import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Recipe_Input {

    public static void main(String[] args) throws IOException {
        String text = "";
        Scanner scanner = new Scanner(System.in);
        File Recipe_List = new File("Recipe_List.pdf");
        if(!Recipe_List.exists()){
            System.out.println("File name: 'Recipe_list' Did not exist.");
            System.out.println("We had to make a new file.");
            Recipe_List.createNewFile();
        }
        PrintWriter pw = new PrintWriter(new FileWriter("Recipe_List.md", true));

        while (!text.equals("n")) {
            System.out.println("Please enter your recipe name:");
            text = scanner.nextLine();// Take next input from user and save it in "text"
            pw.write("# " + text + "\n");
            
            System.out.println("How many ingredients does your recipe have?");
            int num = 0;
            int n = scanner.nextInt();
            while (num <= (n)) {   
                System.out.println("Ingredient:");
                text = scanner.nextLine();
                pw.write("* " + text + "\n");
                num++;
            }
            // add in a way to make the user input how many ingredients there are then have the computer put that many.

            
            System.out.println("Please enter the steps to make the recipe:");
            text = scanner.nextLine();// Take next input from user and save it in "text"
            pw.write("1. " + text + "\n"); 
            //Add in a way to have more steps

            System.out.println("Add another Recipe? (y/n)");
            // FOR SOME REASON WHEN YOU TYPE Y IT WILL SKIP THE NEXT PROMPT!!!!!!!
            text = scanner.next();// Take next input from user and save it in "text"
        }
        pw.close();
        System.out.println("completed");
        }
    }