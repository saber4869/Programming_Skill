package com.algorithm;

import java.util.Random;

import com.animal.hare;
import com.animal.puma;
import com.map.map;

public class generateRandomPuma {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @date: 19/10/2017
	 */
	public puma RandomPuma(int width,int height, puma a, map m){
		
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
					if(m.map[i][j]==0){
						a.getXy()[i][j] = 0;
						
					Random random = new Random();
					int temp_num = random.nextInt(5)+1;
					a.getXy()[i][j] = temp_num;
					
					Random random2 = new Random();
					int temp_num2 = random2.nextInt(5)+1;
					
					}
					
					//System.out.println("origin:in("+i+","+j+")puma number:"+a.xy[i][j]+" hare number:"+r.xy[i][j]);	
			}
		}
		
		return a;
		
	}
}
