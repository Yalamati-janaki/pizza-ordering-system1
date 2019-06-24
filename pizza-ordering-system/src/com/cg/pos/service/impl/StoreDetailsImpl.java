package com.cg.pos.service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.InValidAlreadyExistingException;
import com.cg.pos.exceptions.InValidOwnerNameException;
import com.cg.pos.exceptions.InValidStoreAddressException;
import com.cg.pos.exceptions.InValidStoreContactException;
import com.cg.pos.exceptions.InValidStoreNameException;
import com.cg.pos.service.StoreService;
import com.cg.pos.staticdb.StoreDetailsStaticDb;
import com.cg.pos.utility.ValidateStoreDetails;

public class StoreDetailsImpl extends ValidateStoreDetails implements StoreService {
	static
	{
		StoreDetailsStaticDb.storeData();
	}
	ArrayList<StoreDetailsDTO> list = new ArrayList<StoreDetailsDTO>();
	StoreDetailsDTO storeDetailEntity = new StoreDetailsDTO();
	ArrayList list1;
	@Override
	public ArrayList<StoreDetailsDTO> addStoreDetails(StoreDetailsDTO storeDetailEntity) throws InValidStoreNameException, InValidStoreAddressException,InValidStoreContactException, InValidOwnerNameException, InValidAlreadyExistingException {
		// TODO Auto-generated method stub
		String storeName = storeDetailEntity.getStoreName();
		String storeContact = storeDetailEntity.getStoreContact();

		if (isValidDbCheck(storeName, storeContact)) {
			StoreDetailsStaticDb.addDetails(storeDetailEntity);
			return StoreDetailsStaticDb.getList();
		}
		return StoreDetailsStaticDb.getList();
	}


	@Override
	public String deleteStoreDetails(String storeName) {
		// TODO Auto-generated method stub
		list1 = StoreDetailsStaticDb.getList();
		Iterator i = list1.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			String dbName=store.getStoreName();
			if(storeName.equals(dbName)) {
				i.remove();
				return storeName+" is deleted ";
			}
		}
		return "NOT FOUND";
	}

	@Override
	public String viewStoreDetails(String storeName) {
		// TODO Auto-generated method stub
		
		list1 = StoreDetailsStaticDb.getList();
		Iterator i = list1.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			String dbName=store.getStoreName();
			if(storeName.equals(dbName)) {
				
				return "Selected Store Details : [ store Name "+store.getStoreName()+", StoreId :"+store.getStoreId()+", Contact :"+store.getStoreContact()+", Address :"+store.getStoreAddress()+", Owner name :"+store.getOwnerName()+" ]" ;
			}
		}
		return "Select from the List "+StoreDetailsStaticDb.getList();
	}

	@Override
	public String ModifyStoreName(int storeId, String storeName) throws InValidStoreNameException {
		// TODO Auto-generated method stub
		list1 = StoreDetailsStaticDb.getList();
		Iterator i = list1.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			int dbId=store.getStoreId();
			if(storeId==(dbId)) {
				storeDetailEntity.setStoreName(storeName);
				return "For "+dbId+" store name"+storeName+" is set ";
			}
		}
		return "entered valid";
	}

	@Override
	public String ModifyStoreContact(int storeId,String storeContact) throws InValidStoreContactException {
		// TODO Auto-generated method stub
		list1 = StoreDetailsStaticDb.getList();
		Iterator i = list1.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			int dbId=store.getStoreId();
			if(storeId==(dbId)) {
				storeDetailEntity.setStoreContact(storeContact);
				return "For "+dbId+" store name "+storeContact+" is set ";
			}
		}
		return "entered valid";
	}

	@Override
	public String ModifyStoreAddress(int storeId,String storeAddress) throws InValidStoreAddressException {
		// TODO Auto-generated method stub
		
		list1 = StoreDetailsStaticDb.getList();
		Iterator i = list1.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			int dbId=store.getStoreId();
			if(storeId==(dbId)) {
				storeDetailEntity.setStoreContact(storeAddress);
				return "For "+dbId+" store name"+storeAddress+" is set ";
			}
		}
		return "Entered valid";
	}

	@Override
	public String ModifyOwnerName(int storeId,String ownerName) throws InValidOwnerNameException {
		// TODO Auto-generated method stub
		
		list1 = StoreDetailsStaticDb.getList();
		Iterator i = list1.iterator();
		while (i.hasNext()) {
			StoreDetailsDTO store = (StoreDetailsDTO) i.next();
			int dbId=store.getStoreId();
			if(storeId==(dbId)) {
				storeDetailEntity.setStoreContact(ownerName);
				return "For "+dbId+" store name"+ownerName+" is set ";
			}
		}
		return "Entered valid" ;
	}


}
