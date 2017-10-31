package com.algorithm;
/**********************************************
* 2017-10-16 FuYu create the class
*
* 2017-10-19 FuYu add the algorithm of generating puma 
*
***********************************************/
import java.util.Random;

import com.animal.Hare;
import com.animal.Puma;
import com.map.Map;

public class GenerateRandomPuma {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @date: 19/10/2017
	 */
	public Puma RandomPuma(int width,int height, Puma puma_1, Map mapInfo){
		
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
					if(mapInfo.map[i][j]==0){
						puma_1.getLocation()[i][j] = 0;
						
					Random random = new Random();
					int temp_num = random.nextInt(5)+1;
					puma_1.getLocation()[i][j] = temp_num;
					
					Random random2 = new Random();
					int temp_num2 = random2.nextInt(5)+1;
					
					}
					
					//System.out.println("origin:in("+i+","+j+")puma number:"+a.Location[i][j]+" hare number:"+r.Location[i][j]);	
			}
		}
		
		return puma_1;
		
	}
}
