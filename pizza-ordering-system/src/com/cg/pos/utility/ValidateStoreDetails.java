package com.cg.pos.utility;

import java.util.ArrayList;
import java.util.Iterator;

import com.cg.pos.entity.StoreDetailsDTO;

import com.cg.pos.exceptions.InValidAlreadyExistingException;
import com.cg.pos.exceptions.InValidOwnerNameException;
import com.cg.pos.exceptions.InValidStoreAddressException;
import com.cg.pos.exceptions.InValidStoreContactException;
import com.cg.pos.exceptions.InValidStoreIdException;
import com.cg.pos.exceptions.InValidStoreNameException;
import com.cg.pos.staticdb.StoreDetailsStaticDb;

public class ValidateStoreDetails {
	public boolean isValidStoreName(String storeName) throws InValidStoreNameException {

		if (!storeName.matches("^[a-zA-Z]*$") || storeName.isEmpty()) {
			throw new InValidStoreNameException("Enter Valid Store Name in alphabets within the length of 15 ");
		}

		return true;

	}

	public boolean isValidStoreAddress(String storeAddress) throws InValidStoreAddressException {

		if (!storeAddress.matches("^[\\\\$#\\\\+{}:\\\\?\\\\.,~@\\\"a-zA-Z0-9 ]+$") || storeAddress.isEmpty()) {
			throw new InValidStoreAddressException("Enter Valid Store Address ");
		}
		return true;

	}

	public boolean isValidStoreContact(String storeContact) throws InValidStoreContactException {
		if (!storeContact.matches("[1-9][0-9]{9}")||storeContact.isEmpty()) {
			throw new InValidStoreContactException("enter valid contact number with only numbers");
		}

		return true;
	}

	public boolean isValidOwnerName(String ownerName) throws InValidOwnerNameException {

		if (!(ownerName.matches("^[a-zA-Z]*$"))||ownerName.isEmpty()) {
			throw new InValidOwnerNameException("enter valid name");
		}
		return true;
	}
	public boolean isValidStoreId(int storeId) throws InValidStoreIdException {
		String id=Integer.toString(storeId);
		if(!id.matches("[0-9]{5}")) {
			throw new InValidStoreIdException("Enter only numbers");
		}
		else {
			ArrayList list;
			list = StoreDetailsStaticDb.getList();
			Iterator i = list.iterator();
			while (i.hasNext()) {
				StoreDetailsDTO store = (StoreDetailsDTO) i.next();
				if(storeId==store.getStoreId()) {
					return true;
				}
		}
		return false;
		}
	}

	public boolean isValidDbCheck(String storeName, String storeContact) throws InValidAlreadyExistingException {
		ArrayList list;
		list = StoreDetailsStaticDb.getList();
		Iterator i = list.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			String dbName = store.getStoreName();
			String dbcontact = store.getStoreContact();
			if (storeName.equals(dbName)) {
				throw new InValidAlreadyExistingException(" Enter New Details because store name alreday existing");
			}
			if (storeContact.equals(dbcontact)) {
				throw new InValidAlreadyExistingException(" Enter New Details because store contact alreday existing");
			}
		}
		return true;

	}

	public String isValidExistingCheck(String modifyStore) throws InValidAlreadyExistingException {
		ArrayList list;
		list = StoreDetailsStaticDb.getList();
		Iterator i = list.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			String dbName = store.getStoreName();

			if (!modifyStore.equals(dbName)) {
				throw new InValidAlreadyExistingException(" Not Existing, Enter Valid Name to Modify");
			}
		}

		return "okay";

	}

}
