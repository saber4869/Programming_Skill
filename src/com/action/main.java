package com.action;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.algorithm.calculateModel;
import com.algorithm.generateRandomHare;
import com.algorithm.generateRandomPuma;
import com.algorithm.makeMap;
import com.animal.hare;
import com.animal.puma;
import com.map.map;




public class main {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.action
	 * @author: Fu Yu  
	 * @date: 16/10/2017
	 */
	public static void generateRandomAnimal(int width,int height, puma a, hare r,map m){
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
					if(m.map[i][j]==0){
						a.getXy()[i][j] = 0;
						r.getXy()[i][j] = 0;
					}else{
					Random random = new Random();
					int temp_num = random.nextInt(5)+1;
					a.getXy()[i][j] = temp_num;
					
					Random random2 = new Random();
					int temp_num2 = random2.nextInt(5)+1;
					r.getXy()[i][j] = temp_num2;
					}
					
					//System.out.println("origin:in("+i+","+j+")puma number:"+a.xy[i][j]+" hare number:"+r.xy[i][j]);	
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		

		int width = 5;
		int height = 5;
		ArrayList list = new ArrayList();
		puma a = new puma();
		a.setXy(new double[width][height]);
		hare r = new hare();
		r.setXy(new double[width][height]);
		

		makeMap mk = new makeMap();
	
		map m = new map();
		m = mk.make(width, height);
		
		generateRandomAnimal(width, height, a, r, m);
		//generateRandomPuma gene_p = null;
		//generateRandomHare gene_h = null;
		
		//a = gene_p.RandomPuma(width, height, a, m);
		//r = gene_h.RandomHare(width, height, r, m);
		

		
		/*puma b = new puma();
		hare u = new hare();
		b.setXy(new double[width][height]);
		u.setXy(new double[width][height]);*/
	
		
		
		calculateModel cal = new calculateModel();
		cal.calModel(width, height, a, r, m);
		
		
		
		System.out.println("finish");
	}
	
	
	
	
	
	
	
}

