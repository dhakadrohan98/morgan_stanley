package org.bitset;

import java.util.BitSet;

public class ComparingBitSetWithAnotherBitSet {

	public static void main(String[] args) {
		BitSet bitSet = new BitSet();
		BitSet allSet = new BitSet();
		bitSet.set(0, 10);
		allSet.set(0,9);
		boolean isAllSet = bitSet.equals(allSet);
		System.out.println(isAllSet);

	}

}
