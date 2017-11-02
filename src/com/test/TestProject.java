package com.test;

import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.input.Get2Darray;
import com.main.Main;
import com.algorithm.CalculateModel;
public class TestProject {

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
	        	//if the user input is a String or not a integer between 1 and 10
	            System.out.println("Wrong number.");
	        }   
	    }
	    

	    @Test //Test the data in the file has been read as its original
	    public void test_compare() throws IOException {
	    	String fileName=".\\maplist\\10x10.dat"; 
	        Get2Darray array = new Get2Darray(fileName);
	    	int[][] matrix = new int[][]{
	    			{0,1,1,1,1,1,1,1,1,1}, 
	    			{1,1,1,1,1,1,1,1,1,1},
	    			{1,1,1,1,1,1,1,1,1,1}, 
	    			{1,1,1,1,1,1,1,1,1,1}, 
	    			{1,0,0,0,0,0,0,1,1,1}, 
	    			{1,0,0,0,0,0,0,0,1,1}, 
	    			{1,0,0,0,0,0,0,0,1,1}, 
	    			{1,1,1,1,1,1,1,1,1,1},
	    			{1,1,1,1,1,1,1,1,1,1}, 
	    			{1,1,1,1,1,1,1,1,1,1}};
	    	int[] data = array.getHeightandWidth();
	    	Assert.assertArrayEquals(matrix,array.getMap(data[0],data[1]));
	    }

	    


	    @Test
	    public void testAlgorithm() throws IOException {
	    	 System.out.println("test algorithm start");
	    	 CalculateModel model = new CalculateModel();
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
