package org.bitset;

import java.util.BitSet;

public class BitSetExample {

	public static void main(String[] args) {
		BitSet bitset1 = new BitSet();
		BitSet bitset2 = new BitSet();
		BitSet bitset3 = new BitSet();
		bitset1.set(1);
		bitset1.set(2);
		bitset1.set(3);
		bitset1.set(65);
		bitset2.set(3);
		bitset2.set(5);
		bitset2.set(6);
		
		System.out.println("bitset1 - " + bitset1);
		System.out.println("value of bit at 65th index in bitset1 - " + bitset1.get(65));
		System.out.println("bitset2 - " + bitset2);
		
		System.out.println("No. of set bits in bitset1 - " + bitset1.cardinality());
		System.out.println("No. of set bits in bitset2 - " + bitset2.cardinality());
		System.out.println("Length of bitset1 - " + bitset1.length());
		System.out.println("Length of bitset2 - " + bitset2.length());
		System.out.println();
		
		System.out.println("any() method for bitset1");
		System.out.println(!bitset1.isEmpty());
		System.out.println();
		
		System.out.println("none() method for bitset3");
		System.out.println(bitset3.isEmpty());
		System.out.println();
		
		//peform and operations
		System.out.println("AND operation b/w bitset1 & bitset2");
		bitset1.and(bitset2);
		System.out.println("bitset1 after AND operation with bitset2- " + bitset1);
		System.out.println("bit value at 1st index in bitset1 after AND operation with bitset2 - " 
				+bitset1.get(1));

	}

}
