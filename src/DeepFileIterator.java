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
 * @Description This is the DeepFileIterator class which implements the Iterator Interface
 *
 */
public class DeepFileIterator implements Iterator<File> {

  // An array of File references which this iterator steps through
  private File[] folderContents;
  // specifies the next File index within folderContents
  private int nextIndex;
  // DeepFileIterator reference that is used to step with directory.
  private DeepFileIterator contentsIterator;

  /**
   * This the constructor for DeepFileIterator class and is used too allocate the fields in this
   * class
   * 
   * @param dir - the folder input for creating the DeepFileIterator object
   * @throws FileNotFoundException - if the file is not found then this exception is thrown.
   */
  public DeepFileIterator(File dir) throws FileNotFoundException {
    if (!dir.exists()) {
      throw new FileNotFoundException("Path doesn't exist");
    }
    folderContents = dir.listFiles();
    Arrays.sort(folderContents);
    nextIndex = 0;
    contentsIterator = null;

  }

  /**
   * Returns true if the iteration has more elements. returns true if next() would return an element
   * rather than throwing an exception.
   *
   * @return true if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    try {
      if (contentsIterator != null && contentsIterator.hasNext()
              || nextIndex < folderContents.length) {
        return true;
      }
    } catch (NoSuchElementException e) {
      return false;
    }
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
    if (!hasNext()) {
      throw new NoSuchElementException("No more elements.");
    }
    if (contentsIterator != null && contentsIterator.hasNext()) {
      return contentsIterator.next();
    } else if (folderContents[nextIndex].isDirectory()) {
      try {
        contentsIterator = new DeepFileIterator(folderContents[nextIndex]);
      } catch (FileNotFoundException e) {
        contentsIterator = null;
        e.printStackTrace();
      }
    }
    return folderContents[nextIndex++];

  }
}


