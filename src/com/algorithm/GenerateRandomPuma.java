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
	 * @param: width and height are the two attributes of map
	 * @param: hare_1 is the initial puma info 
	 * @param: mapInfo is the information of the map we need
	 * @return: a puma with density
	 * @date: 19/10/2017
	 */
	public double[][] RandomPuma(int width,int height, Puma puma_1, Map mapInfo){
		
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
					if(mapInfo.map[i][j]==0){
						puma_1.getLocation()[i][j] = 0;
						
					}else{                   // else make the density a random value
							//Random random = new Random();
							//int temp_num = random.nextInt(5)+1;
							
							
							Random random2 = new Random();
							double temp_num2 = random2.nextDouble()*5;
							puma_1.getLocation()[i][j] = temp_num2;
							}
					
					//System.out.println("origin:in("+i+","+j+")puma number:"+puma_1.getLocation()[i][j]);	
			}
		}
		
		return puma_1.getLocation();
		
	}
}
