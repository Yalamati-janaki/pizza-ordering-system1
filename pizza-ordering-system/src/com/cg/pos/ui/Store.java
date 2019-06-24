package com.cg.pos.ui;
import com.cg.pos.staticdb.*;
import com.cg.pos.utility.ValidateStoreDetails;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.InValidStoreIdException;
import com.cg.pos.service.impl.*;


public class Store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1. ADDING Store Details");
		System.out.println("2. VIEW Store Details");
		System.out.println("3. MODIFY Store Details");
		System.out.println("4. DELETE Store Details");
		System.out.println("5. EXIT");
		System.out.println(" Enter your Choice");
		Scanner s=new Scanner(System.in);
		String choice=s.next();
		StoreDetailsDTO storeDetailEntity=new StoreDetailsDTO();
		StoreDetailsImpl storeDetailImpl=new StoreDetailsImpl();
		ValidateStoreDetails validateStoreDetails=new ValidateStoreDetails();
		
			do {
				try{
				switch(choice) {
				case "1" :
					double storeId=ThreadLocalRandom.current().nextDouble();
					int id=(int) (storeId*100000);
					storeDetailEntity.setStoreId(id);
					System.out.println("Enter Store Name");
					String storeName=s.next();
					validateStoreDetails.isValidStoreName(storeName);
					System.out.println("Enter Store Address");
					String storeAddress=s.next();
					validateStoreDetails.isValidStoreAddress(storeAddress);
					System.out.println("Enter Store Contact");
					String storeContact=s.next();
					validateStoreDetails.isValidStoreContact(storeContact);
					System.out.println("Enter Owner Name");
					String ownerName=s.next();
					validateStoreDetails.isValidOwnerName(ownerName);
			
					storeDetailEntity.setStoreName(storeName);
					storeDetailEntity.setStoreAddress(storeAddress);
					storeDetailEntity.setStoreContact(storeContact);
					storeDetailEntity.setOwnerName(ownerName);
					ArrayList<StoreDetailsDTO> details=storeDetailImpl.addStoreDetails(storeDetailEntity);
					System.out.println(details);
					choice="0";
					break;
				case "2" :
					System.out.println("Enter the Store Name to view its details");
					String storeNameView=s.next();
					String msg=storeDetailImpl.viewStoreDetails(storeNameView);
					System.out.println(msg);
					choice="0";
					break;
				case "3" :
					System.out.println("Select ID to which you want to modify the details");
					System.out.println(StoreDetailsStaticDb.getList());
					int selectedId=s.nextInt();
					if(!validateStoreDetails.isValidStoreId(selectedId)) {
						throw new InValidStoreIdException("Select Proper Id");
					}
					do{
						System.out.println("1. Modify Store NAME");
						System.out.println("2. Modify Store CONTACT");
						System.out.println("3. Modify Store Address");
						System.out.println("4. Modify OWNER NAME");
						System.out.println("Enter your Choice");
						choice=s.next();
						switch(choice) {
					case "1" :
						System.out.println("Enter New Store Name ");
						String newStoreName=s.next();
						validateStoreDetails.isValidStoreName(newStoreName);
						String setStoreName=storeDetailImpl.ModifyStoreName(selectedId,newStoreName);
						System.out.println(setStoreName);
						choice="0";
						break;
					case "2" :
						System.out.println("Enter New Store Contact Number");
						String newStoreContact=s.next();
						validateStoreDetails.isValidStoreContact(newStoreContact);
						String setStoreContact=storeDetailImpl.ModifyStoreContact(selectedId,newStoreContact);
						System.out.println("Your Modified store Contact is : "+setStoreContact);
						choice="0";
						break;
					case "3" :
						System.out.println("Enter New Store Address");
						String newStoreAddress=s.next();
						validateStoreDetails.isValidStoreAddress(newStoreAddress);
						String setStoreAddress=storeDetailImpl.ModifyStoreAddress(selectedId,newStoreAddress);
						System.out.println("Your Modified store Address is : "+setStoreAddress);
						choice="0";
						break;
					case "4" :
						System.out.println("Enter New Owner Name");
						String newOwnerName=s.next();
						validateStoreDetails.isValidOwnerName(newOwnerName);
						String setOwnerName=storeDetailImpl.ModifyOwnerName(selectedId,newOwnerName);
						System.out.println("Your Modified Owner Name :"+setOwnerName);
						choice="0";
						break;
						default :
							System.err.println("Enter valid number");
							System.out.println("1. Modify Store NAME");
							System.out.println("2. Modify Store CONTACT");
							System.out.println("3. Modify Store Address");
							System.out.println("4. Modify OWNER NAME");
							System.out.println("Enter your Choice");
							choice=s.next();
							break;
					}
						System.out.println("Do you want to Continue your modifications");
						 System.out.println(" Enter yes or no");
						 choice=s.next();
						 if(choice.equals("no")) {
							 choice="0";
							 break;
						 }
					
					}while(choice!="0");
					break;
				case "4" :
					System.out.println("Select NAME of Store you want to delete");
					System.out.println(StoreDetailsStaticDb.getList());
					String selectedName=s.next();
					if(!validateStoreDetails.isValidStoreName(selectedName)) {
						throw new InValidStoreIdException("Select Proper Id");
					}
					String setStoreName=storeDetailImpl.deleteStoreDetails(selectedName);
					
					System.out.println(setStoreName);
					choice="0";
					break;
				case "5" :
					 System.out.println("exit");
					 System.exit(0);
					break;
					default :
						System.err.println("Enter PROPER Number");
				}
				 
				}catch(Exception e) {
					System.err.println("Error :"+e.getMessage());
				}
				System.out.println("Do you want to Continue");
				 System.out.println("yes or no");
				 String continueNumber=s.next();
				 if(continueNumber.equals("yes")) {
					 main(args);
				 }
				 else {
					 System.out.println("EXIT");
					 System.exit(0);
				 }
			}while(choice!="0");
			
	}

	
}
