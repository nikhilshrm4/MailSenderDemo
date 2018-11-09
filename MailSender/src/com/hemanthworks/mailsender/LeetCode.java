package com.hemanthworks.mailsender;

import java.util.Scanner;

public class LeetCode
{
	public static void main ( String[] args )
    {
		int[] input = {1,0,0,2,-1,0,6,0,0,9,12};
        int first = 0;
        int last = (input.length -1);
        int numOfSwaps = 0;
        int nonZeroElements = 0;
        
        while(first < last) {
            if(input[first] == 0 && input[last] != 0) {
                swap(input,first,last);
                numOfSwaps++;
                first++;
                last--;
                nonZeroElements++;
            }
            else {
            	if(input[first] != 0) {
                    first++;
                    nonZeroElements++;
                }
                if(input[last] == 0) {
                    last--;
                }
               
            }
			
        }
        
        System.out.println(nonZeroElements);
        System.out.println(numOfSwaps);
    }
	
	public static void swap(int[] input, int indexOne, int indexTwo)
	{
		int temp = input[indexOne];
		input[indexOne] = input[indexTwo];
		input[indexTwo] = temp;
	}
}
