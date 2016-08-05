package com.netcracker.edu.java.tasks;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Sir Nightmare on 08/01/16.
 * Class for CV
 */
public class CurriculumVitaeImpl implements CurriculumVitae
{
    private String text;
    private static final String PHONE_PATTERN =
            "(\\(?([1-9][0-9]{2})\\)?[-. ]*)?([1-9][0-9]{2})[-. ]*(\\d{2})[-. ]*(\\d{2})(\\s*ext\\.?\\s*([0-9]+))?";

    public CurriculumVitaeImpl() {
    }

    /**
     * Sets the text (the main field of the CV).<br/>
     * Implementation note: The text should not be analyzed in this method.<br/>
     *
     * @param text CV text
     */
    @Override
    public void setText(String text) {
        this.text=text;
    }

    /**
     * It is recommended to call this method in all the other methods of you class.
     *
     * @return The current text of the CV (may be changed by update* methods).
     * @throws IllegalStateException If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public String getText() throws IllegalStateException {
        if (text==null){
            throw new IllegalStateException();
        }
        return text;
    }

    /**
     * Returns a list of phones in the same order they occur in the CV.<br/>
     * Implementation note: Use {@link #PHONE_PATTERN} to find phones;
     * use groups of that regular expression to get area code and extension from the matches found;
     * if the area code or extension does not exist there, the Phone must store negative value of it.
     *
     * @return A list that can't be null but may be empty (if no one phone is found).
     * @throws IllegalStateException If the CV text was not set by {@link #setText(String)}.
     * @see Phone
     */
    @Override
    public List<Phone> getPhones() throws IllegalStateException {
        return null;
    }

    /**
     * Returns the full name
     * i.e. the FIRST part of the CV text that satisfies the following criteria:
     * <ol>
     * <li>full name consists of 2 or 3 words separated with a space (' ');</li>
     * <li>each word has 2 or more characters;</li>
     * <li>the first character of the word is upper-case Latin letter (alphabetic character);</li>
     * <li>the last character of the word is either '.' or lower-case Latin letter;</li>
     * <li>non-first and non-last characters of the word can be lower-case Latin letter only.</li>
     * </ol>
     *
     * @return The full name (is exactly equal to its value in the CV text)
     * @throws NoSuchElementException If the CV does not contain a full name that satisfies the criteria.
     * @throws IllegalStateException  If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public String getFullName() throws NoSuchElementException, IllegalStateException {
        return null;
    }

    /**
     * Returns the first name from the CV (the first word of {@link #getFullName()}).
     *
     * @throws NoSuchElementException If the CV does not contain a full name.
     * @throws IllegalStateException  If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public String getFirstName() throws NoSuchElementException, IllegalStateException {
        return null;
    }

    /**
     * Returns the middle name from the CV (the second word of {@link #getFullName()})
     * or null if the full name has two words only.
     *
     * @throws NoSuchElementException If the CV does not contain a full name.
     * @throws IllegalStateException  If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public String getMiddleName() throws NoSuchElementException, IllegalStateException {
        return null;
    }

    /**
     * Returns the last name from the CV (the last word of {@link #getFullName()}).
     *
     * @throws NoSuchElementException If the CV does not contain a full name.
     * @throws IllegalStateException  If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public String getLastName() throws NoSuchElementException, IllegalStateException {
        return null;
    }

    /**
     * Replaces the lastName to <code>newLastName</code> in the CV text.
     *
     * @param newLastName Can't be null
     * @throws NoSuchElementException If the CV does not contain a full name.
     * @throws IllegalStateException  If the CV text was not set by {@link #setText(String)}.
     * @see #getLastName()
     */
    @Override
    public void updateLastName(String newLastName) throws NoSuchElementException, IllegalStateException {

    }

    /**
     * Replaces the <code>oldPhone.getNumber()</code> to <code>newPhone.getNumber()</code>
     * in the CV text.
     * Implementation note: using regex here leads to more code than using non-regex methods of {@link String}
     * (or maybe than using non-regex method of {@link String} and a method of {@link StringBuilder}).
     *
     * @param oldPhone Can't be null
     * @param newPhone Can't be null
     * @throws IllegalArgumentException If the CV does not contain a text equal to <code>oldPhone.getNumber()</code>.
     * @throws IllegalStateException    If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) throws IllegalArgumentException, IllegalStateException {

    }

    /**
     * Finds the <code>piece</code> in the CV text and replaces <code>piece</code>'s characters
     * with 'X' character, excluding the following separating characters: ' ', '.' and '@'.
     * The number of 'X' characters is equal to a number of the replaced characters.<br/>
     * For example: "John A. Smith" is replaced by "XXXX X. XXXXX", "john@hp.com" - by "XXXX@XX.XXX".<br/>
     * This change can be undone by {@link #unhideAll()}.
     *
     * @param piece Can't be null
     * @throws IllegalArgumentException If the CV does not contain a text equal to <code>piece</code>.
     * @throws IllegalStateException    If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public void hide(String piece) throws IllegalArgumentException, IllegalStateException {

    }

    /**
     * Finds the <code>phone</code> in the CV text
     * and replaces all DIGITS of the <code>phone</code> with 'X' character.<br/>
     * For example: "(123)456 7890" is replaced by "(XXX)XXX XXXX".<br/>
     * This change can be undone by {@link #unhideAll()}.
     *
     * @param phone Can't be null
     * @throws IllegalArgumentException If the CV does not contain a text equal to <code>phone</code>.
     * @throws IllegalStateException    If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public void hidePhone(String phone) throws IllegalArgumentException, IllegalStateException {

    }

    /**
     * Undoes all changes made by {@link #hide(String)} and {@link #hidePhone(String)} methods
     * i.e. replaces 'X' pieces of the current CV text ("hidden" pieces inserted by those methods)
     * with appropriate pieces of the original CV text.<br/>
     * Note: there can't be 2 (or more) equal hidden pieces (equal pieces with 'X') in the CV text.<br/>
     * Implementation note: original and hidden pieces should be stored in some collection.
     * Moreover, the collection should be cleared on {@link #setText(String)}.
     *
     * @return The number of replacements made in the CV during unhiding
     * @throws IllegalStateException If the CV text was not set by {@link #setText(String)}.
     */
    @Override
    public int unhideAll() throws IllegalStateException {
        return 0;
    }
}
