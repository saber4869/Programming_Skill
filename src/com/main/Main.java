package com.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.algorithm.CalculateModel;
import com.algorithm.GenerateRandomHare;
import com.algorithm.GenerateRandomPuma;
import com.algorithm.MakeMap;
import com.animal.Hare;
import com.animal.Puma;
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
					int temp_num = random.nextInt(5)+1; //改成小数
					puma_1.getLocation()[i][j] = temp_num;
					
					Random random2 = new Random();
					int temp_num2 = random2.nextInt(5)+1;
					hare_1.getLocation()[i][j] = temp_num2;
					}
					
					//System.out.println("origin:in("+i+","+j+")puma number:"+a.Location[i][j]+" hare number:"+r.Location[i][j]);	
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		

		int width = 500;
		int height = 500;
		ArrayList list = new ArrayList();
		Puma puma_1 = new Puma();
		puma_1.setLocation(new double[width][height]);
		Hare hare_1 = new Hare();
		hare_1.setLocation(new double[width][height]);
		

		MakeMap mk = new MakeMap();
	
		Map mapInfo = new Map();
		mapInfo = mk.make(width, height);
		
		generateRandomAnimal(width, height, puma_1, hare_1, mapInfo);
		//generateRandomPuma gene_p = null;
		//generateRandomHare gene_h = null;
		
		//a = gene_p.RandomPuma(width, height, a, m);
		//r = gene_h.RandomHare(width, height, r, m);
		

		CalculateModel cal = new CalculateModel();
		cal.CalModel(width, height, puma_1, hare_1, mapInfo);

		System.out.println("finish");
	}
	
	
	
	
	
	
	
}

