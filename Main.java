//  This program takes a text file, creates an index (by line numbers)
//  for all the words in the file and writes the index
//  into the output file.  The program takes input and output file names
//  from the command-line args or prompts the user for the file names.

import java.util.Scanner;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file:

    if (args.length > 0)
      fileName = args[0];
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
      
    }

    BufferedReader inputFile =
                 new BufferedReader(new FileReader(fileName), 1024);

    // Create output file:

    if (args.length > 1)
      fileName = args[1];
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
      
      
    }

    BufferedWriter outputFile = new BufferedWriter(new FileWriter(fileName));

    // Create index:

    DocumentIndex index = new DocumentIndex();

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    // Save index:

    for (IndexEntry entry : index) {
        String output = entry.toString();
      outputFile.write(output, 0, output.length());
    }

    // Finish:

    inputFile.close();
    outputFile.close();
    keyboard.close();

    System.out.println("Done.");
  }
}
