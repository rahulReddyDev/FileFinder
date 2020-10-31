//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: File Finder
// Files: ShallowFileIterator.java,
// DeepFileIterator.java,FilteredFileIterator.java,P07Tester.java
// Course: (CS 300, Spring, and 2020)
//
// Author: Sai Rahul Reddy Kondlapudi
// Email: kondlapudi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * @author SaiRahulReddyKondlapudi
 * @Description This is the tester class that tests the other classes in this project
 *
 */
public class P07Tester {
  /**
   * This specific test method creates a new ShallowFileIterator using a reference to the provided
   * file system directory. It should then repeatedly call next, and collects the names of the files
   * returned into a single comma-separated String.
   * 
   * @param dir - the folder input for the test method
   * @return true if the test method is successful
   */
  public static boolean testShallowFileIterator(File dir) {
    String expectedResults =
            "assignments, exam preparation, lecture notes, " + "reading notes, todo.txt, ";
    String result = "";
    try {
      ShallowFileIterator itr = new ShallowFileIterator(dir);
      while (itr.hasNext()) {
        result += itr.next().getName() + ", ";
      }

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (NoSuchElementException e1) {
      System.out.println(e1.getMessage());
      e1.printStackTrace();
    }
    if (!result.equals(expectedResults)) {
      return false;
    }
    return true;
  }

  /**
   * This is the test method which is used to check if the DeepFileIterator class is working
   * 
   * @param folder - the folder input for the test method
   * @return true if the test method is successful
   */
  public static boolean testDeepFileIterator(File folder) {
    folder = new File(folder.getPath() + File.separator + "assignments");
    String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
            + "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
            + "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";
    String result = "";
    try {
      DeepFileIterator itr = new DeepFileIterator(folder);
      while (itr.hasNext()) {
        result += itr.next().getName() + ", ";
      }

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (NoSuchElementException e1) {
      System.out.println(e1.getMessage());
      e1.printStackTrace();
    }
    if (!result.equals(expectedResults)) {
      return false;
    }
    return true;

  }

  /**
   * This is the method which checks if the FilteredFileIterator is working
   * 
   * @param dir the folder input for the test method
   * @return true if the test method is successful
   */
  public static boolean testFilteredFileIterator(File dir) {
    String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
            + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
            + "AlphabetTrain.java, codeSamples.java, ";
    String result = "";
    try {
      FilteredFileIterator itr = new FilteredFileIterator(dir, ".java");
      while (itr.hasNext()) {
        result += itr.next().getName() + ", ";
      }

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (NoSuchElementException e1) {
      System.out.println(e1.getMessage());
      e1.printStackTrace();
    }
    if (!result.equals(expectedResults)) {
      return false;
    }
    return true;

  }

  /**
   * This is the main method where all the methods are called.
   * 
   * @param args
   */
  public static void main(String[] args) {
    File folder = new File("./filesystem");
    System.out.println("testShallowMethod: " + testShallowFileIterator(folder));
    System.out.println("testDeepFileIterator: " + testDeepFileIterator(folder));
    System.out.println("testFilteredFileIterator: " + testFilteredFileIterator(folder));

  }

}