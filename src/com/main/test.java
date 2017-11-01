package com.main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test {

	  @Before//璇存槑鍦ㄦ祴璇曞嚱鏁版墽琛屼箣鍓嶄細棣栧厛鎵ц杩欎釜鍑芥暟 @Before绗﹀彿蹇呴』鍐�
	    public void start() {
	        System.out.println("Code Start!");
	    }

	    @After//璇存槑鍦ㄦ祴璇曞嚱鏁版墽琛屼箣鍚庝細鎺ョ潃鎵ц杩欎釜鍑芥暟  @After绗﹀彿蹇呴』鍐�
	    public void end() {
	        System.out.println("Code End!");
	    }

	    @Test
	    public void testAdd() throws IOException {
	        String str = "abc";
	        System.out.println(str);
	        Main hello = new Main();
	        hello.main(null);
	        
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
	    public void testAlgorithm() throws IOException {
	    	 System.out.println("test algorithm start");
	    	 
	    }


}
