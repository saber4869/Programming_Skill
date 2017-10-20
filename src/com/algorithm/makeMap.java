package com.algorithm;

import com.map.map;

public class makeMap {
	
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @date: 16/10/2017
	 */

	public map make(int width, int height){
		
		map m = new map();
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
