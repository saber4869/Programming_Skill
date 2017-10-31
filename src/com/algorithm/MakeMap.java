package com.algorithm;
/**********************************************
* 2017-10-16 FuYu create the class
*
* 2017-10-19 FuYu add the algorithm of making draft map 
*
***********************************************/
import com.map.Map;

public class MakeMap {
	
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @date: 16/10/2017
	 */

	public Map make(int width, int height){
		
		Map m = new Map();
		m.setMap(new int[width][height]);
		
		
		//int[][] map = new int[width][height];
		//map = read();
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
				
					m.map[i][j] = (int)(Math.random() * 2);

					//System.out.println("origin map :("+i+","+j+")"+m.map[i][j]);	
			}
		}
		
		return m;
	}
	
}
