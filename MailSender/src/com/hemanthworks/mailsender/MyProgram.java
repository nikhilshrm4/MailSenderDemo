package com.hemanthworks.mailsender;

import java.util.Arrays;
import java.util.Stack;

public class MyProgram
{
	public static void main ( String[] args )
	{
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 16;
		if (isElementinRow(matrix, target))
		{
			System.out.println("true");
		}
		else
		{
			int nearestIndex = nearestItem(matrix, target);
			System.out.println(isElementinColumn(matrix, target, nearestIndex));
		}
	}

	public static boolean searchMatrix ( int[][] matrix, int target )
	{

		if (isElementinRow(matrix, target))
		{
			return true;
		}
		else
		{
			int nearestIndex = nearestItem(matrix, target);
			return isElementinColumn(matrix, target, nearestIndex);
		}
	}

	private static int nearestItem ( int[][] matrix, int target )
	{
		int first = 0;
		int last = matrix[0].length-1;
		while (last >= first)
		{
			int mid = (last + first) / 2;
			if (matrix[0][mid] < target && mid+1 > matrix[0].length && matrix[0][mid + 1] > target)
			{
				return mid;
			}
			else if(matrix[0][mid] > target && mid-1 < 0 && matrix[0][mid-1] < target)
			{
				return mid - 1;
			}
			else if (matrix[0][mid] < target)
			{
				first = mid + 1;
			}
			else 
			{
				last = mid-1;
			}
		}

		return -1;
	}

	private static boolean isElementinColumn ( int[][] matrix, int target, int column )
	{
		int first = 0;
		int last = matrix.length-1;
		
		while (last >= first)
		{
			int mid = (first + last) / 2;
			if (matrix[mid][column] == target)
			{
				return true;
			}
			else if (matrix[mid][column] > target)
			{
				last = mid - 1;
			}
			else
			{
				first = mid + 1;
			}
			
		}

		return false;
	}

	private static boolean isElementinRow ( int[][] matrix, int target )
	{
		int first = 0;
		int last = matrix.length-1;
		while (last >= first)
		{
			int mid = (first + last) / 2;
			if (matrix[0][mid] > target)
			{
				last = mid - 1;
			}
			else if (matrix[0][mid] < target)
			{
				first = mid + 1;
			}
			else
			{
				return true;
			}
		}

		return false;
	}

}
