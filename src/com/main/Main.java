package com.main;
/**********************************************
* 2017-10-16 FuYu create the class
*
* 2017-10-19 FuYu change the main function
*
***********************************************/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;




import com.algorithm.CalculateModel;
import com.algorithm.GenerateRandomHare;
import com.algorithm.GenerateRandomPuma;
import com.algorithm.MakeMap;
import com.animal.Hare;
import com.animal.Puma;
import com.input.Get2Darray;
import com.map.Map;


/**   
 * 
 * 
 * 
 * @Package: com.action
 * @author: Fu Yu  
 * @date: 16/10/2017
 */

public class Main {

	/**
	  * @author Fu Yu
	  * @date 2017-10-19
	  * @what generate the density of puma and hare
	  * @param: width and height are the two attributes of map
	  * @param: puma_1 is the initial puma info
	  * @param: hare_1 is the initial hare info 
	  * @param: mapInfo is the information of the map we need
	  * @return void
	  */
	public static void generateRandomAnimal(int width,int height, Puma puma_1, Hare hare_1,Map mapInfo){
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
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
	
	public static void main(String[] args) throws IOException{
		
		
		long startTime=System.currentTimeMillis();   //get the start time
		
		
		//initialize the puma and hare information
        String fileName = "./maplist/3x3.dat";
		Get2Darray landscape = new Get2Darray(fileName);
		int[] heightandwidth = landscape.getHeightandWidth();
		int height = heightandwidth[0];
		int width = heightandwidth[1];
		int[][] amap = landscape.getMap(height, width);
		
		Puma puma_1 = new Puma();
		puma_1.setLocation(new double[width][height]);
		Hare hare_1 = new Hare();
		hare_1.setLocation(new double[width][height]);
		
		//make the map (temp)
		MakeMap mk = new MakeMap();

		Map mapInfo = new Map();
		mapInfo.map = amap;
		generateRandomAnimal(width, height, puma_1, hare_1, mapInfo);
		//generateRandomPuma gene_p = null;
		//generateRandomHare gene_h = null;
		
		//a = gene_p.RandomPuma(width, height, a, m);
		//r = gene_h.RandomHare(width, height, r, m);
		
		//do the algorithm
		CalculateModel cal = new CalculateModel();
		cal.CalModel(width, height, puma_1, hare_1, mapInfo);

		
		long endTime=System.currentTimeMillis(); //get the end time 
		System.out.println("total time: "+(endTime-startTime)+"ms");
	}
}

