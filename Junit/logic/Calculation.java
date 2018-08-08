package com.javatpoint.logic;

public class Calculation {

	public static int findMax(int arr[]){
		int max=0;
		//int max=arr[0];
		for(int i=1;i<arr.length;i++){
			//System.out.println("1=="+arr[i]);
			if(max<arr[i]){
				max=arr[i];
				//System.out.println("max=="+max);
			}
		}
		return max;
	}
	
	public static int cube(int n){
		return n*n*n;
	}
	
	public static int testException(int n){
		return n/0;
	}
	
	
}
