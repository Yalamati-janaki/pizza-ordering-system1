package com.cg.pos.staticdb;

import java.util.ArrayList;

import com.cg.pos.entity.StoreDetailsDTO;

public class StoreDetailsStaticDb {

	public static StoreDetailsDTO storeDetailEntity = new StoreDetailsDTO();
	private static ArrayList<StoreDetailsDTO> list = new ArrayList<StoreDetailsDTO>();

	public static StoreDetailsDTO getStoreDetailEntity() {
		return storeDetailEntity;
	}
	public static ArrayList<StoreDetailsDTO> getList() {
		return list;
	}
	public static void storeData() {
		list.add(new StoreDetailsDTO(10101, "Domino", "3/103,airoli,sector 9.", "5345233210", "potter"));
		list.add(new StoreDetailsDTO(10102, "Phut", "3/103,airoli,sector 10.", "9876548801", "Harry"));
	}
	public static ArrayList<StoreDetailsDTO> addDetails(StoreDetailsDTO storeDetailEntity) {
		list.add(storeDetailEntity);
		return StoreDetailsStaticDb.list;
	}
	
}
