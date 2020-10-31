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
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author SaiRahulReddyKondlapudi
 * @Description This is the class FilteredFileIterator which implements the Iterator interface.
 * 
 * 
 */
public class FilteredFileIterator implements Iterator<File> {

  // A DeepFileIterator object
  private DeepFileIterator fileIterator;
  // a String variable for searching the specific file name
  private String searchPattern;
  // this must be part of a file to be returned from filteredFileIterator
  private File nextMatchingFile;

  /**
   * This is the constructor for the class FilteredFileIterator and is used to allocate the fields
   * in the of the class
   * 
   * @param dir           - the folder input for creating the FilteredFileIterator object
   * @param searchPattern - a String variable for searching the specific file name
   * @throws FileNotFoundException - if the file is not found then this exception is thrown.
   */
  public FilteredFileIterator(File dir, String searchPattern) throws FileNotFoundException {
    this.searchPattern = searchPattern;
    fileIterator = new DeepFileIterator(dir);
    nextMatchingFile = getNextFile();
  }

  /**
   * Returns true if the iteration has more elements. returns true if next() would return an element
   * rather than throwing an exception.
   *
   * @return true if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return nextMatchingFile != null;
  }

  /**
   * Returns the next element in the iteration.
   * 
   * @throws NoSuchElementException - if the iteration has no more elements
   * @return the next element in the iteration
   */
  @Override
  public File next() {
    if (hasNext()) {
      File current = nextMatchingFile;
      // get new nextMatchingFile and return current matching file
      nextMatchingFile = getNextFile();
      return current;
    } else {
      throw new NoSuchElementException("Iterator does not have next element!");
    }
  }

  /**
   * This method can repeatedly call next on the fileIterator, until it returns a file that contains
   * the specified searchPattern. This file can then be stored within nextMatchingFile. If the
   * fileIterator is exhausted before a matching file can be found
   * 
   * @return file that contains the specified searchPattern
   */
  private File getNextFile() {
    while (fileIterator.hasNext()) {
      File next = fileIterator.next();
      if (next.getName().contains(searchPattern)) {
        return next;
      }
    }
    return null;
  }
}
