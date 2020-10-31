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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author SaiRahulReddyKondlapudi
 * @Description This is the ShallowFileIterator that implements the Iterator interface
 *
 */
public class ShallowFileIterator implements Iterator<File> {

  // array of File references which this iterator steps through
  private File[] folderContents;
  // specifies the next File index within folderContents
  private int nextIndex;//

  /**
   * This is the constructor for the ShallowFileIterator and checks if the file exists and it
   * allocates the fields in the class.
   * 
   * @param dir - the folder input for creating the ShallowFileIterator object
   * @throws FileNotFoundException - If the argument passed to your ShallowFileIterator’s
   *                               constructor does not exist within the filesystem, then this
   *                               constructor throws an FileNotFoundException.
   */
  public ShallowFileIterator(File dir) throws FileNotFoundException {
    if (dir.isDirectory() && dir.exists()) {
      folderContents = dir.listFiles();
      Arrays.sort(folderContents);
      nextIndex = 0;
    } else {
      throw new FileNotFoundException(
              "This is not a Directory or the" + " Directory/folder doesnt exist");
    }
  }

  /**
   * Returns true if the iteration has more elements. returns true if next() would return an element
   * rather than throwing an exception.
   *
   * @return true if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    if (nextIndex < folderContents.length)
      return true;
    else
      return false;
  }

  /**
   * Returns the next element in the iteration.
   * 
   * @throws NoSuchElementException - if the iteration has no more elements
   * @return the next element in the iteration
   */
  @Override
  public File next() throws NoSuchElementException {
    if (this.hasNext()) {
      return folderContents[nextIndex++];
    } else {
      throw new NoSuchElementException("The Next File doesnt Exist");
    }
  }


}