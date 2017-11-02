package com.algorithm;
/**********************************************
* 2017-10-16 FuYu create the class
*
* 2017-10-19 FuYu add the algorithm of generating hare 
*
***********************************************/
import java.util.Random;

import com.animal.Hare;
import com.animal.Puma;
import com.map.Map;

public class GenerateRandomHare {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @param: width and height are the two attributes of map
	 * @param: hare_1 is the initial hare info 
	 * @param: mapInfo is the information of the map we need
	 * @return: a hare with density
	 * @date: 19/10/2017
	 */
	public double[][] RandomHare(int width,int height, Hare hare_1, Map mapInfo){
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
					if(mapInfo.map[i][j]==0){ //if the point is water, then make the density 0
						 
						hare_1.getLocation()[i][j] = 0;
					}else{                   // else make the density a random value
					//Random random = new Random();
					//int temp_num = random.nextInt(5)+1;
					
					
					Random random2 = new Random();
					double temp_num2 = random2.nextDouble()*5;
					hare_1.getLocation()[i][j] = temp_num2;
					}
					
						
			}
		}
		
		return hare_1.getLocation();
		
	}
	
}
