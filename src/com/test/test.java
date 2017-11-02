package com.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.algorithm.CalculateModel;
import com.input.Get2Darray;
import com.main.Main;

public class test {

	  @Before
	    public void start() {
	        System.out.println("Code Start!");
	    }

	    @After
	    public void end() {
	        System.out.println("Code End!");
	    }

	    //Test the user input is an integer
	    @Test
	    public void test_scan() throws Exception {
	    	//Main hello = new Main();
	    	//hello.main(null);
	    	Scanner keyboard = new Scanner(System.in);
	        System.out.println("Give a number between 1 and 10");
	        int input = Integer.parseInt(keyboard.nextLine());
	        if(input < 1 || input > 10) {
	            System.out.println("Wrong number.");
	        }   
	    }
	    

	    @Test
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
	    	 CalculateModel cal = new CalculateModel();
	    }
	    @Test
	    public void testRandomGenerate() throws IOException {
	    	 System.out.println("test random generate animal start");
	    	 Main main = new Main();
	    	
	    }
	    @Test
	    public void testoutput() throws IOException {
	    
	    }
	    
	    
}
