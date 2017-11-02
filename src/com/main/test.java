package com.main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.input.Get2Darray;

public class test {

	  @Before
	    public void start() {
	        System.out.println("Code Start!");
	    }

	    @After
	    public void end() {
	        System.out.println("Code End!");
	    }

	   
	    @Test //Test the user input is an integer
	    public void test_scan() throws Exception {
	    	Scanner keyboard = new Scanner(System.in);
	        System.out.println("Give a number between 1 and 10");
	        int input = Integer.parseInt(keyboard.nextLine());
	        if(input < 1 || input > 10) {
	        	//if the user input is a String or 
	            System.out.println("Wrong number.");
	        }   
	    }
	    

	    @Test //Test the 
	    public void test_compare() throws IOException {
	    	String fileName=".\\maplist\\3x3.dat"; 
	        Get2Darray array = new Get2Darray(fileName);
	    	int[][] matrix = new int[][]{{0,1,0},{1,1,0},{0,1,1}};
	    	int[] data = array.getHeightandWidth();
	    	Assert.assertArrayEquals(matrix,array.getMap(data[0],data[1]));
	    }

	    


	    @Test
	    public void testAlgorithm() throws IOException {
	    	 System.out.println("test algorithm start");
	    	 
	    }


}
