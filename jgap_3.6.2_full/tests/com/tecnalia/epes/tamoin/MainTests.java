package com.tecnalia.epes.tamoin;

public class MainTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 100*10/36 + 2;
		int j = (100*10/36) + 2;
		
		
		double k = Double.parseDouble(String.valueOf(100))*1000/3600 + 2;
		int kInt = (int) Math.round(k);
		
		
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(kInt);
	}

}
