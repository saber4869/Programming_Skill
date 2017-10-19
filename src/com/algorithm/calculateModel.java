package com.algorithm;

import com.animal.hare;
import com.animal.puma;
import com.map.map;

public class calculateModel {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @date: 19/10/2017
	 */
	
	
	public void calModel(int width,int height, puma a, hare r,map m){
		
		puma b = new puma();
		hare u = new hare();
		b.setXy(new double[width][height]);
		u.setXy(new double[width][height]);
		
		for(double t = 0; t < 50; ){
			for(int i = 0; i < width; i++){
				
				for(int j = 0; j < height; j++){
					double temp = 0;//for puma around nodes
					double temph = 0; // for hare around nodes
					int num = 0;  //number of neighbour of land but not water
					int num_water = 0;
					if(a.getXy()[i][j] == 0 || r.getXy()[i][j] == 0)  //if water area then continue
						continue;
					if(i-1 < 0){   //left column
						if(j-1 < 0)
						{
							num = 2;
							temp = a.getXy()[i+1][j]+a.getXy()[i][j+1];
							temph = r.getXy()[i+1][j]+r.getXy()[i][j+1];
							if(a.getXy()[i+1][j]==0) num--;
							if(a.getXy()[i][j+1] == 0) num--;
						}
						else if(j+1 > a.getXy()[i].length-1)
						{
							num = 2;
							temp = a.getXy()[i+1][j]+ a.getXy()[i][j-1];
							temph = r.getXy()[i+1][j]+ r.getXy()[i][j-1];
							if(a.getXy()[i+1][j]==0) num--;
							if(a.getXy()[i][j-1] == 0) num--;
						}
						else
						{
							num = 3;
							temp = a.getXy()[i+1][j]+a.getXy()[i][j+1]+a.getXy()[i][j-1];
							temph = r.getXy()[i+1][j]+r.getXy()[i][j+1]+r.getXy()[i][j-1];
							if(a.getXy()[i+1][j]==0) num--;
							if(a.getXy()[i][j+1] == 0) num--;
							if(a.getXy()[i][j-1] == 0) num--;
						}                                       
					}else if(j-1 < 0 && i-1 >= 0 && i+1 <= a.getXy().length-1 ){ //top row
						num = 3;
						temp = a.getXy()[i-1][j]+a.getXy()[i+1][j]+a.getXy()[i][j+1];
						temph = r.getXy()[i-1][j]+r.getXy()[i+1][j]+r.getXy()[i][j+1];
						if(a.getXy()[i-1][j]==0) num--;
						if(a.getXy()[i][j+1] == 0) num--;
						if(a.getXy()[i+1][j] == 0) num--;
					}else if(i+1 > a.getXy().length-1){  //right column
						if(j-1 < 0)
						{
							num = 2;
							temp = a.getXy()[i-1][j]+a.getXy()[i][j+1];
							temph = r.getXy()[i-1][j]+r.getXy()[i][j+1];
							if(a.getXy()[i-1][j]==0) num--;
							if(a.getXy()[i][j+1] == 0) num--;
						}
						else if(j+1 > a.getXy()[i].length-1)
						{
							num = 2;
							temp = a.getXy()[i-1][j]+ a.getXy()[i][j-1];
							temph = r.getXy()[i-1][j]+ r.getXy()[i][j-1];
							
							if(a.getXy()[i-1][j] == 0) num--;
							if(a.getXy()[i][j-1] == 0) num--;
						}
						else
						{
							num = 3;
							temp = a.getXy()[i-1][j]+a.getXy()[i][j+1]+a.getXy()[i][j-1];
							temph = r.getXy()[i-1][j]+r.getXy()[i][j+1]+r.getXy()[i][j-1];
							
							if(a.getXy()[i-1][j]==0) num--;
							if(a.getXy()[i][j+1] == 0) num--;
							if(a.getXy()[i][j-1] == 0) num--;
						}
					}else if(j+1 > a.getXy()[i].length-1 && i-1 >=0 && i+1 <= a.getXy().length-1){ //bottom row
						num = 3;
						temp = a.getXy()[i-1][j]+a.getXy()[i+1][j]+a.getXy()[i][j-1];
						temph = r.getXy()[i-1][j]+r.getXy()[i+1][j]+r.getXy()[i][j-1];
						
						if(a.getXy()[i-1][j]==0) num--;
						if(a.getXy()[i+1][j] == 0) num--;
						if(a.getXy()[i][j-1] == 0) num--;
					}else{
						num = 4;
						temp = a.getXy()[i-1][j]+a.getXy()[i+1][j]+a.getXy()[i][j-1]+a.getXy()[i][j+1];
						temph = r.getXy()[i-1][j]+r.getXy()[i+1][j]+r.getXy()[i][j-1]+r.getXy()[i][j+1];
						
						if(a.getXy()[i-1][j] == 0) num--;
						if(a.getXy()[i+1][j]==0) num--;
						if(a.getXy()[i][j+1] == 0) num--;
						if(a.getXy()[i][j-1] == 0) num--;
						
					}
					temp = temp - num*a.getXy()[i][j];
					temph = temph - num*r.getXy()[i][j];
					
					b.getXy()[i][j]= a.getXy()[i][j]+0.4*(0.02*r.getXy()[i][j]*a.getXy()[i][j]-0.06*a.getXy()[i][j]+0.2*temp);
					u.getXy()[i][j]= r.getXy()[i][j]+0.4*(0.08*r.getXy()[i][j]-0.04*r.getXy()[i][j]*a.getXy()[i][j]+0.2*temph);
					
				}
	
			}

			
		
			for(int i =0; i <width; i++){
				for(int j =0; j< height; j++){
					
					System.out.println("in("+i+","+j+")puma number:"+b.getXy()[i][j]+" hare number:"+u.getXy()[i][j]);	
							
				}
				
			}
			System.out.println("");
			a = b ;
			r = u ;
			t = t+0.4;	
		}
	}
	
	
	
	
}
