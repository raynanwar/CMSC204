/*
 

Class: CMSC204
Instructor: Eivazi
Description: (Give a brief description for each Class)
Due: 02/04/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rayn Anwar
*/
import java.util.*;

import java.io.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> acceptedPasswords;
	ArrayList<String> declinedPasswords;
	@Before
	public void setUp() throws Exception {
		acceptedPasswords = new ArrayList<String>();
		declinedPasswords =  new ArrayList<String>();
		String[] goodPasswords = {
			    "aB3#CddSfewfw",
			    "P@fsw0rdwefewf",
			    "Qwerty1!ewfewf",
			    "Xyz123$ewfwef",
			    "AbCdEf9#ewfewf"
			};
		String[] badPasswords = {
			    "short",
			    "nouppercase",
			    "NOLOWERCASE123",
			    "$@*()!$*)!",
			    "RepeatingChars111",
			    "we@kgeS2",
			    "A2bCdfAdccasd2s"
			};
		
		acceptedPasswords.addAll(Arrays.asList(goodPasswords));
		declinedPasswords.addAll(Arrays.asList(badPasswords));
	}

	@After
	public void tearDown() throws Exception {
	acceptedPasswords =  null;
	declinedPasswords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			PasswordCheckerUtility.isValidLength(declinedPasswords.get(0));
		}
		catch (LengthException e){
			assertTrue("Threw Length exception", true);
		}
		try {
			PasswordCheckerUtility.isValidLength(acceptedPasswords.get(0));
		}
		catch (LengthException e) {
			assertFalse("Did not throw length exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			PasswordCheckerUtility.hasUpperAlpha(declinedPasswords.get(1));
		}
		catch (NoUpperAlphaException e) {
			assertTrue("Upper Alpha exception throw", true);
		}
		try {
			PasswordCheckerUtility.hasUpperAlpha(acceptedPasswords.get(0));
		}
		catch (NoUpperAlphaException e) {
			assertFalse("No Upper Alpha exception throw", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			PasswordCheckerUtility.hasLowerAlpha(declinedPasswords.get(2));
		}
		catch (NoLowerAlphaException e) {
			assertTrue("Lower Alpha exception throw", true);
		}
		try {
			PasswordCheckerUtility.hasLowerAlpha(acceptedPasswords.get(0));
		}
		catch (NoLowerAlphaException e) {
			assertFalse("No Lower Alpha exception throw", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			PasswordCheckerUtility.isWeakPassword(declinedPasswords.get(5));
		}
		catch (WeakPasswordException e) {
			assertTrue("Weak Password exception throw", true);
		}
		try {
			PasswordCheckerUtility.isWeakPassword(acceptedPasswords.get(0));
		}
		catch (WeakPasswordException e) {
			assertFalse("No Weak Password exception throw", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			PasswordCheckerUtility.NoSameCharInSequence(declinedPasswords.get(4));
		}
		catch (InvalidSequenceException e) {
			assertTrue("Invalid Sequence exception throw", true);
		}
		
		try {
			PasswordCheckerUtility.NoSameCharInSequence(acceptedPasswords.get(0));
		}
		catch (InvalidSequenceException e) {
			assertFalse("No Invalid Sequence exception throw", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			PasswordCheckerUtility.hasDigit(declinedPasswords.get(0));
		}
		catch (NoDigitException e) {
			assertTrue("Digit exception throw", true);
		}
		try {
			PasswordCheckerUtility.hasDigit(acceptedPasswords.get(0));
		}
		catch (NoDigitException e) {
			assertFalse("No Digit exception throw", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			for(String i : acceptedPasswords) {
				assertEquals(PasswordCheckerUtility.isValidPassword(i), true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		String tempStr = "short The password must be at least 6 characters long";
		ArrayList<String> temp = new ArrayList<>();
		temp = PasswordCheckerUtility.getInvalidPasswords(declinedPasswords);
		assertEquals(temp.get(0), tempStr);
	}
	/**
	 * This tests the SpecialChar method which tests if the password contains a special
	 * character
	 * the frist test case should throw an exception because there is no special character
	 * the second test case shouldnt throw an exception because there is a special character
	 */
	@Test 
	public void testSpecialChar() {
		try {
			PasswordCheckerUtility.hasSpecialChar(declinedPasswords.get(6));
		} catch(NoSpecialCharacterException e) {
			assertTrue("Exception has been thrown", true);
		}
		try {
			PasswordCheckerUtility.hasSpecialChar(declinedPasswords.get(0));
		} catch (NoSpecialCharacterException e) {
			assertFalse("Exception hasn't been done", false);
		}
	}
	@Test
	public void testFile() {
		File passwords = new File("studentPasswords.txt");
		ArrayList<String> passwordsArray = new ArrayList<>();
		ArrayList<String> tempArray = new ArrayList<>();
		String [] error = {"short The password must be at least 6 characters long",
			"nouppercase The password must contain at least one uppercase alphabetic character",
			"NOLOWERCASE123 The password must contain at least one lowercase alphabetic character",
			"$@*()!$*)! The password must contain at least one uppercase alphabetic character",
			"RepeatingChars111 The password must contain at least one special character"
		};
		try {
			Scanner scanner= new Scanner(passwords);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				passwordsArray.add(line);
			}
			scanner.close();
			tempArray = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
			for(int i=0; i< tempArray.size(); i++) {
				assertEquals(error[i], tempArray.get(i));
			}
		}
		
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
