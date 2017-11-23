package com.main;
/**********************************************
* 2017-10-16 FuYu create the class
*
* 2017-10-19 FuYu change the main function
*
***********************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import com.algorithm.CalculateModel;
import com.algorithm.GenerateRandomHare;
import com.algorithm.GenerateRandomPuma;
import com.algorithm.MakeMap;
import com.algorithm.NewCalculateModel;
import com.animal.Hare;
import com.animal.Puma;
import com.input.Get2Darray;
import com.map.Map;


/**   
 * 
 * 
 * 
 * @Package: com.main
 * @author: Fu Yu  
 * @date: 16/10/2017
 * @what: Main function
 */

public class Main {

	/**
	  * @author Fu Yu
	  * @date 2017-Oct-19
	  * @what generate the random density of puma and hare
	  * @param: width and height are the two attributes of map
	  * @param: puma_1 is the initial puma info
	  * @param: hare_1 is the initial hare info 
	  * @param: mapInfo is the information of the map we need
	  * @return void
	  */
	public static void generateRandomAnimal(int width,int height, Puma puma_1, Hare hare_1,Map mapInfo){
		for(int i=0 ; i<height;i++){
			for(int j =0; j<width; j++){
					if(mapInfo.map[i][j]==0){
						puma_1.getLocation()[i][j] = 0;
						hare_1.getLocation()[i][j] = 0;
					}else{
					Random random = new Random();
					double temp_num = random.nextDouble()*5; //
					puma_1.getLocation()[i][j] = temp_num;
					
					Random random2 = new Random();
					double temp_num2 = random2.nextDouble()*5;
					hare_1.getLocation()[i][j] = temp_num2;
					}
					
					//System.out.println("origin:in("+i+","+j+")puma number:"+puma_1.getLocation()[i][j]+" hare number:"+hare_1.getLocation()[i][j]);	
			}
		}
	}
	
	/**
	  * @author Fu Yu & Yixuan Li
	  * @date 2017-Nov-01
	  * @what Main function, begin with reading input file,then run the algorithm,and last get output.
	  * @return void
	  */
	public static void main(String[] args) throws IOException{
		
		
		long startTime=System.currentTimeMillis();   //get the start time
		
		long startTime_input=System.currentTimeMillis();   //get the start time
		//initialize the puma and hare information
        //String fileName = "./maplist/10x10.dat"; //file path on local
		String fileName = "maplist/40x50.dat"; //file path on the cp-lab
		Get2Darray landscape = new Get2Darray(fileName);
	    int[] heightandwidth = landscape.getHeightandWidth();
		int width = heightandwidth[0];
		int height = heightandwidth[1];
		int[][] amap = landscape.getMap(height, width);
		
		Puma puma_1 = new Puma();
		puma_1.setLocation(new double[height][width]);
		Hare hare_1 = new Hare();
		hare_1.setLocation(new double[height][width]);
		
		//make the map (temp)
		//MakeMap mk = new MakeMap();

		Map mapInfo = new Map();
		mapInfo.map = amap;
		generateRandomAnimal(width, height, puma_1, hare_1, mapInfo);
		/*GenerateRandomPuma gene_p = new GenerateRandomPuma();
		GenerateRandomHare gene_h = new GenerateRandomHare();
		
		puma_1.setLocation(gene_p.RandomPuma(width, height, puma_1, mapInfo));
		hare_1.setLocation(gene_h.RandomHare(width, height, hare_1, mapInfo)); */
		
		
		long endTime_input=System.currentTimeMillis();   //get the start time
		Puma puma_test= new Puma();

		Hare hare_test= new Hare();
		double[][] p1 = new double[height][width];
		double[][] h1 = new double[height][width];
		
		for(int i = 0; i< height ; i++){
			for(int j=0; j<width; j++){
				p1[i][j] = puma_1.getLocation()[i][j];
				h1[i][j] = hare_1.getLocation()[i][j];
			}
		}
		
		puma_test.setLocation(p1);
		hare_test.setLocation(h1);
		//System.out.println(p1[10][10]);
		
		
		//do the algorithm
		CalculateModel cal = new CalculateModel();
		cal.CalModel(width, height, puma_1, hare_1, mapInfo);
		//System.out.println(p1[10][10]);
		long endTime1=System.currentTimeMillis(); //get the end time 
		System.out.println("total time(old version): "+(endTime1-startTime+endTime_input-startTime_input)+"ms");
		
		long startTime2=System.currentTimeMillis(); //get the end time 
		NewCalculateModel cal2 = new NewCalculateModel();
		cal2.CalModel(width, height, puma_test, hare_test, mapInfo);
		
		long endTime2=System.currentTimeMillis(); //get the end time 
		System.out.println("input time: "+(endTime_input-startTime_input)+"ms");
		System.out.println("total time(new version with halo): "+(endTime2-startTime2+endTime_input-startTime_input)+"ms");
		
		flag=1;
	}
	
	public static int flag = 0;

	public static int getFlag() {
		return flag;
	}

	public static void setFlag(int flag) {
		Main.flag = flag;
	}
	
	
}

