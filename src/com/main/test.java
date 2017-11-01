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

	  @Before//璇存槑鍦ㄦ祴璇曞嚱鏁版墽琛屼箣鍓嶄細棣栧厛鎵ц杩欎釜鍑芥暟 @Before绗﹀彿蹇呴』鍐�
	    public void start() {
	        System.out.println("Code Start!");
	    }

	    @After//璇存槑鍦ㄦ祴璇曞嚱鏁版墽琛屼箣鍚庝細鎺ョ潃鎵ц杩欎釜鍑芥暟  @After绗﹀彿蹇呴』鍐�
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
	        //Main hello = new Main();
	        //hello.main(null);
	    	String fileName="E:/Codes17-18/Java/puma-hare/rsmall.dat"; 
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
