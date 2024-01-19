package student;
//Reese Saladin

import provided.BinarySequence;

// you may implement any interface you want here
public class HuffmanCodeBook {
    /**
     * A char array storing the characters of CodeBook.
     */
    private char[] bookKeys = new char[2];
    /**
     * a BinarySequence array storing the BinarySequences corresponding to chars in bookKeys.
     */
    private BinarySequence[] bookVals = new BinarySequence[2];
    /**
     * an int representing the number of elements of each array that are "active" or being used.
     */
    private int index;

    /**
     * An empty constructor, setting CodeBook's index to 0.
     */
    public HuffmanCodeBook() {
        index = 0;
    }

    /**
     * Adds a given character/letter and a binary sequence into the CodeBook.
     * @param c - a character to add to the CodeBook.
     * @param seq - the corresponding sequence to be added to CodeBook with char c.
     */
    public void addSequence(char c, BinarySequence seq) {
        if (index == bookKeys.length) {
            char[] newKeys = new char[bookKeys.length * 2];
            for (int i = 0; i < bookKeys.length; i++) {
                newKeys[i] = bookKeys[i];
            }
            bookKeys = newKeys;
            BinarySequence[] newVals = new BinarySequence[bookVals.length * 2];
            for (int i = 0; i < bookVals.length; i++) {
                newVals[i] = bookVals[i];
            }
            bookVals = newVals;
        }
        bookKeys[index] = c;
        bookVals[index] = seq;
        index++;
        for (int i = 1; i < index; i++) { //Insertion Sort
            char character = bookKeys[i];
            BinarySequence sequence = bookVals[i];
            int j = i - 1;
            while (j >= 0 && bookKeys[j] > character) {
                bookKeys[j + 1] = bookKeys[j];
                bookVals[j + 1] = bookVals[j];
                j = j - 1;
            }
            bookKeys[j + 1] = character;
            bookVals[j + 1] = sequence;
        }
    }

    /**
     * Determines if given character is in the CodeBook.
     * @param letter - char that is tested to see if it is in CodeBook.
     * @return - boolean true if char letter is in CodeBook, false otherwise.
     */
    public boolean contains(char letter) { //Binary Search
        int low = 0;
        int high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bookKeys[mid] < letter) {
                low = mid + 1;
            } else if (bookKeys[mid] > letter) {
                high = mid - 1;
            } else if (bookKeys[mid] == letter) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if all letters in given String are contained in CodeBook.
     * @param letters - a String of letters to be tested if they are all in CodeBook.
     * @return - boolean true if all letters in String letters are in CodeBook, false otherwise.
     */
    public boolean containsAll(String letters) {
        int total = 0;
        for (int i = 0; i < letters.length(); i++) {
            for (int j = 0; j < index; j++) {
                if (bookKeys[j] == letters.charAt(i)) {
                    total++;
                }
            }
        }
        return total == letters.length();
    }

    /**
     * Gets the Binary Sequence associated with given char c.
     * @param c - char to get corresponding Binary Sequence of.
     * @return - A BinarySequence that is associated with the char c.
     */
    public BinarySequence getSequence(char c) { //Binary Search
        int low = 0;
        int high = index - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (bookKeys[mid] < c) {
                low = mid + 1;
            } else if (bookKeys[mid] > c) {
                high = mid - 1;
            } else if (bookKeys[mid] == c) {
                return bookVals[mid];
            }
        }
        return null;
    }

    /**
     * Encodes a given String input into a BinarySequence, combining the BinarySequences of each character.
     * @param s - A String input that is to be encoded into a corresponding BinarySequence.
     * @return - a BinarySequence represented the encoded version of input String s.
     */
    public BinarySequence encode(String s) {
        BinarySequence encoded = new BinarySequence();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < index; j++) {
                if (s.charAt(i) == bookKeys[j]) {
                    encoded.append(bookVals[j]);
                }
            }
        }
        return encoded;
    }

    /**
     * Gets the last Index of the active elements of bookKeys and bookVals arrays.
     * @return - an int representing the Index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the character in CodeBook at index i.
     * @param i - an int representing the index of CodeBook to get char from.
     * @return - The character in CodeBook at index i.
     */
    public char getChar(int i) {
        return bookKeys[i];
    }

    /**
     * Returns the BinarySequence value in CodeBook at index i.
     * @param i - an int representing the index of CodeBook to get BinarySequence value from.
     * @return - The BinarySequence in CodeBook at index i.
     */
    public BinarySequence getVals(int i) {
        return bookVals[i];
    }

}
