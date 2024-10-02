package com.wissen.CollectionsFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapBucketCapacityLoadFactor {

	public static void main(String[] args) {
		//Initial capacity is 8 & 0.55f means it will double the size of bucket if 55% of bukcet 
		//index are filled with node
		Map<String, Integer> hmap = new HashMap<>(8, 0.55F);

	}

}
