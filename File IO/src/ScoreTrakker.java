/**
 * 
 * @author Shayla Klein 
 * @author Connor Brennan
 * 
 * C10A File IO Pair Exercise
 *
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 

public class ScoreTrakker {
	
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	/**
	 * Takes the name of the file as a parameter and reads the student data from the file. Stores the student objects in the ArrayList
	 * @param fName
	 * @return
	 */
	public void loadDataFromFile(String fName) throws FileNotFoundException{
		
		File f = new File("Z:\\adit\\My Documents\\C10A\\File IO\\" + fName);
		students = new ArrayList<Student>();
		Scanner scan;
		scan = new Scanner(f);
		while (scan.hasNext()) {
			String sName = (scan.next() + " " + scan.next());
			String score = scan.next();
			try {
				int sScore = Integer.parseInt(score);
				Student s = new Student(sName, sScore);
				students.add(s);
			} catch (NumberFormatException n) {
				System.out.println("Incorrect format for " + sName + " not a valid score: " + score + "\n");
			}
		}
		
		scan.close();
		
	}

		
	
	/**
	 * Sorts and prints the ArrayList using an iterated for loop
	 */
	public void printInOrder() {
		Collections.sort(students);
		System.out.println("Student Score List");
		for(Student s : students) {
			System.out.println(s.toString());
		}
		System.out.println("\n");
	}
	
	/**
	 * Loops through the files in the files array and handles a FileNotFoundException
	 * @param fName
	 */
	public void processFiles() {
		for(String s: files) {
			try {	
				loadDataFromFile(s);
				printInOrder();
				
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + s);
			}
		
		}
	}
	
	/**
	 * creates a new object of type ScoreTrakker and calls processFiles
	 * @param args
	 */
	public static void main(String[]args) {
			ScoreTrakker trakk = new ScoreTrakker();
			trakk.processFiles();
	}
		
}



