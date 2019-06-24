package com.cg.pos.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.cg.pos.exceptions.InValidOwnerNameException;
import com.cg.pos.exceptions.InValidStoreContactException;
import com.cg.pos.exceptions.InValidStoreNameException;
import com.cg.pos.utility.ValidateStoreDetails;

public class StoreDetailsImplTest {
	 ValidateStoreDetails validateStoreDetails=new ValidateStoreDetails();

	@Before
	public void setUp() throws Exception {
	}


	@Test(expected = InValidStoreNameException.class)
	public void testStoreNameHasNumber() throws InValidStoreNameException{
		validateStoreDetails.isValidStoreName("453");
	}
	
	@Test(expected = InValidStoreNameException.class)
	public void testStoreNameIsEmpty() throws InValidStoreNameException{
		validateStoreDetails.isValidStoreName("");
	}
	
	@Test(expected = InValidStoreNameException.class)
	public void testStoreNameHasSplCharacter() throws InValidStoreNameException{
		validateStoreDetails.isValidStoreName("@#$$%%");
	}
	
	@Test(expected = InValidStoreContactException.class)
	public void testStoreContactHasAlphabet() throws InValidStoreContactException{
		validateStoreDetails.isValidStoreContact("sfgdsg");
	}
	
	@Test(expected = InValidStoreContactException.class)
	public void testStoreContactHasSplChar() throws InValidStoreContactException{
		validateStoreDetails.isValidStoreContact("@#$%^&&*");
	}
	
	@Test(expected = InValidStoreContactException.class)
	public void testStoreContactIsNotInLimit() throws InValidStoreContactException{
		validateStoreDetails.isValidStoreContact("12345678");
	}
	
	@Test(expected = InValidStoreContactException.class)
	public void testStoreContactIsEmpty() throws InValidStoreContactException{
		validateStoreDetails.isValidStoreContact("");
	}
	
	@Test(expected = InValidOwnerNameException.class)
	public void testOwnerNameHasSplCharcter() throws InValidOwnerNameException{
		validateStoreDetails.isValidOwnerName("#$%^&&&*");
	}
	
	@Test(expected = InValidOwnerNameException.class)
	public void testOwnerNameHasNumber() throws InValidOwnerNameException{
		validateStoreDetails.isValidOwnerName("23534667");
	}
	
	@Test(expected = InValidOwnerNameException.class)
	public void testOwnerNameIsEmpty() throws InValidOwnerNameException{
		validateStoreDetails.isValidOwnerName("");
	}
	
	@Test(expected = InValidStoreContactException.class)
	public void testStoreAddressIsEmpty() throws InValidStoreContactException{
		validateStoreDetails.isValidStoreContact("");
	}
}
