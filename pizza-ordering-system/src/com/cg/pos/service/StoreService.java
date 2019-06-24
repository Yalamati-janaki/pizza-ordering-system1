package com.cg.pos.service;

import java.util.ArrayList;

import com.cg.pos.entity.StoreDetailsDTO;

import com.cg.pos.exceptions.InValidAlreadyExistingException;
import com.cg.pos.exceptions.InValidOwnerNameException;
import com.cg.pos.exceptions.InValidStoreAddressException;
import com.cg.pos.exceptions.InValidStoreContactException;
import com.cg.pos.exceptions.InValidStoreNameException;


public interface StoreService {
	public ArrayList<StoreDetailsDTO> addStoreDetails(StoreDetailsDTO storeDetailEntity) throws InValidStoreNameException, 
	InValidStoreAddressException, InValidStoreContactException, InValidOwnerNameException, 
	InValidStoreAddressException, InValidAlreadyExistingException;
	public String deleteStoreDetails(String storeName);
	public String viewStoreDetails(String storeName);
	public String ModifyStoreName(int storeId,String storeNmae) throws InValidStoreNameException;
	public String ModifyStoreContact(int storeId,String storeContact) throws InValidStoreContactException;
	public String ModifyStoreAddress(int storeId,String storeAddress) throws InValidStoreAddressException;
	public String ModifyOwnerName(int storeId,String ownerName) throws InValidOwnerNameException;
	
}
