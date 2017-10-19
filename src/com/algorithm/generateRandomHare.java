package com.algorithm;

import java.util.Random;

import com.animal.hare;
import com.animal.puma;
import com.map.map;

public class generateRandomHare {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @date: 19/10/2017
	 */
	public hare RandomHare(int width,int height, hare r, map m){
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
					if(m.map[i][j]==0){
						
						r.getXy()[i][j] = 0;
					}else{
					Random random = new Random();
					int temp_num = random.nextInt(5)+1;
					
					
					Random random2 = new Random();
					int temp_num2 = random2.nextInt(5)+1;
					r.getXy()[i][j] = temp_num2;
					}
					
					//System.out.println("origin:in("+i+","+j+")puma number:"+a.xy[i][j]+" hare number:"+r.xy[i][j]);	
			}
		}
		
		return r;
		
	}
	
}
