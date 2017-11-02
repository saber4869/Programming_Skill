package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.input.Get2Darray;
import com.main.Main;
import com.output.WriteToPPM;
//import com.output.WriteToPPM;
import com.output.WriteToText;
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
	        keyboard.close();
	    }
	    

	    @Test //Test the data in the file has been read as its original
	    public void test_compare() throws IOException {
	    	//String fileName="./maplist/10x10.dat"; //file path on the local
	    	String fileName="maplist/10x10.dat"; //file path on the cp-lab

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
	    public void testOutputText() throws IOException {
	     	
	    	double[][] text = new double[10][10];
	    	int count = 0;
	    	
	    	double[][] matrix = {
		    		{0.0, 1.943645659365564, 3.0859756826567564, 3.8021404955968228, 2.1033087820557705, 2.112422604082009, 1.295257454500847, 3.3838257530446088, 0.8303928097743914, 2.414247884922569},
		    		{4.168677397771171, 1.7478661660914214, 2.5209000967053417, 1.1761494413945406, 1.4506270492208424, 3.425376045018781, 1.6611886879142501, 1.3019396471085956, 2.0386849608575837, 0.8264152981684162},
		    		{4.236088649376204, 2.4409244515894857, 3.4390510332003648, 1.8583328908069408, 1.9216643746107327, 3.363984418025913, 2.8120855452497104, 3.434475649440431, 3.1367253641948003, 0.8697221637974619},
		    		{2.378768452470652, 2.1207503660317117, 3.314000673371106, 1.5293416329644238, 0.9092775172114204, 3.3634224048729635, 2.0247514574631476, 2.8938915307728044, 2.016878518545353, 1.2108349607658768},
		    		{3.085222811942406, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.9946375323471934, 1.146487298694739, 2.428050425987041},
		    		{0.7643638239096666, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.8784124873713504, 2.724683651736579},
		    		{4.157265053053871, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.627246832727252, 2.1585031869221294},
		    		{3.618134239282334, 1.9636886161927303, 2.8487214196712736, 0.8479721314091924, 4.177713926663713, 3.614193922229804, 4.235971164045301, 3.2806737764527547, 1.924533848929939, 2.8331685183322524},
		    		{3.754734124847755, 2.100010345308968, 3.188809409044615, 2.2523295321159496, 2.592871157322445, 3.3242531236536017, 2.100082543761745, 1.0064288693746333, 0.9029567316095846, 1.4622318735351385},
		    		{3.3546617745074903, 4.152696515716726, 2.2317718462751173, 1.2834822858659871, 2.17961176678734, 3.2578249861723485, 2.841381233360676, 1.4288511341156502, 2.686056060023006, 1.8551666536246358},
		    };
	     	WriteToText output = new WriteToText();
	     	output.WriteText(matrix,"1.9082987060593666","testText",0);
	     	
	    		BufferedReader readin; 	
		    	String fileName="./outputlist/testTextresult0.txt"; 
			readin = new BufferedReader( new FileReader (fileName));
	        
			String line= readin.readLine();
			String[] a1= line.split(" ");
	
			Assert.assertEquals("1.9082987060593666",a1[0]);//
			
			line= readin.readLine();
		
			while (line!=null){ //read line by line
				String[] linedata = line.split(" "); //read one line of data
				
				double[] temparray = new double[10];
				
				for(int i=0;i<linedata.length;i++){  //a2.length should equals to width
					temparray[i] = Double.parseDouble(linedata[i]);
				}	
				
				for(int i = 0;i<10; i++){
					text[count][i]=temparray[i]; 

				}
				count++;
				
				//Read next line
				line = readin.readLine();
				//Clear the array
				linedata = null;
				temparray=new double[10];
			}
			readin.close();
	
	    	Assert.assertArrayEquals(matrix,text);
	    }
	    
	    @Test
	    public void testOutputPPM() throws IOException {
	     	
	    	int[][] text = new int[3][9];
	    	int count = 0;
	    	
	    	double[][] matrixInit = {{0,0,0},{0,0,0},{0,0,0},};
	    	int[][] matrixTest = {{255,255,255,255,255,255,255,255,255},
	    				{255,255,255,255,255,255,255,255,255},
    					{255,255,255,255,255,255,255,255,255,}
	    			};
	    		WriteToPPM output = new WriteToPPM();
	     	output.WritePPM(matrixInit,"testPPM",0);
	     	
	    		BufferedReader readin; 	
		    	String fileName="./outputlist/testPPMoutput0.PPM"; 
			readin = new BufferedReader( new FileReader (fileName));
	      
			String line = readin.readLine();
			
			
			for(int i =0;i<3;i++) {
				line = readin.readLine();
				}
					
		
			while (line!=null){ //read line by line
				String[] linedata = line.split(" "); //read one line of data
				
				int[] temparray = new int[9];
				
				for(int i=0;i<linedata.length;i++){  //a2.length should equals to width
					temparray[i] =Integer.parseInt(linedata[i]);
				}	
				
				for(int i = 0;i<9; i++){
					text[count][i]=temparray[i]; 

				}
				count++;
				
				//Read next line
				line = readin.readLine();
				//Clear the array
				linedata = null;
				temparray=new int[9];
			}
			readin.close();

	    	Assert.assertArrayEquals(matrixTest,text);
	    }
}
