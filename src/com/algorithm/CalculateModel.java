package com.algorithm;
/**********************************************
* 2017-10-16 FuYu create the class
*
* 2017-10-19 FuYu add the algorithm 
*
***********************************************/
import java.io.IOException;

import com.animal.Hare;
import com.animal.Puma;
import com.map.Map;
import com.output.WriteToPPM;

public class CalculateModel {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.algorithm
	 * @author: Fu Yu  
	 * @throws: IOException 
	 * @what: get the model 
	 * @param: width and height are the two attributes of map
	 * @param: puma_1 is the initial puma info
	 * @param: hare_1 is the initial hare info 
	 * @param: mapInfo is the information of the map we need
	 * @return: void
	 * @date: 31/10/2017
	 */
	
	
	public void CalModel(int width,int height, Puma puma_1, Hare hare_1,Map mapInfo) throws IOException{
		
		
		double timeStep = 0.4;
		
		Puma puma_2 = new Puma();
		Hare hare_2 = new Hare();
		puma_2.setLocation(new double[width][height]);
		hare_2.setLocation(new double[width][height]);
		
		//average density
		//double[][] aver_hare = new double[width][height];
		for(double t = 0; t < 50; ){
			for(int i = 0; i < width; i++){
				
				for(int j = 0; j < height; j++){
					double tempPuma = 0;//for puma around nodes
					double tempHare = 0; // for hare around nodes
					int numOfNeighbor = 0;  //number of neighbour of land but not water
					int num_water = 0;
					if(puma_1.getLocation()[i][j] == 0 || hare_1.getLocation()[i][j] == 0)  //if water area then continue
						continue;
					if(i-1 < 0){   //left column
						if(j-1 < 0)  //top left point
						{
							numOfNeighbor = 2; //neighbor equals 2
							tempPuma = puma_1.getLocation()[i+1][j]+puma_1.getLocation()[i][j+1];
							tempHare = hare_1.getLocation()[i+1][j]+hare_1.getLocation()[i][j+1];
							if(mapInfo.getMap()[i+1][j]==0) numOfNeighbor--;  //if the neighbor contains water then minus 1
							if(mapInfo.getMap()[i][j+1] == 0) numOfNeighbor--;
						}
						else if(j+1 > puma_1.getLocation()[i].length-1) //bottom left point 
						{
							numOfNeighbor = 2; //neighbor equals 2
							tempPuma = puma_1.getLocation()[i+1][j]+ puma_1.getLocation()[i][j-1];
							tempHare = hare_1.getLocation()[i+1][j]+ hare_1.getLocation()[i][j-1];
							if(mapInfo.getMap()[i+1][j]==0) numOfNeighbor--; //if the neighbor contains water then minus 1
							if(mapInfo.getMap()[i][j-1] == 0) numOfNeighbor--;
						}
						else  //other points except the top and bottom ones
						{
							numOfNeighbor = 3; 
							tempPuma = puma_1.getLocation()[i+1][j]+puma_1.getLocation()[i][j+1]+puma_1.getLocation()[i][j-1];
							tempHare = hare_1.getLocation()[i+1][j]+hare_1.getLocation()[i][j+1]+hare_1.getLocation()[i][j-1];
							if(mapInfo.getMap()[i+1][j]==0) numOfNeighbor--;
							if(mapInfo.getMap()[i][j+1] == 0) numOfNeighbor--;
							if(mapInfo.getMap()[i][j-1] == 0) numOfNeighbor--;
						}                                       
					}else if(j-1 < 0 && i-1 >= 0 && i+1 <= puma_1.getLocation().length-1 ){ //top row
						numOfNeighbor = 3;
						tempPuma = puma_1.getLocation()[i-1][j]+puma_1.getLocation()[i+1][j]+puma_1.getLocation()[i][j+1];
						tempHare = hare_1.getLocation()[i-1][j]+hare_1.getLocation()[i+1][j]+hare_1.getLocation()[i][j+1];
						if(mapInfo.getMap()[i-1][j]==0) numOfNeighbor--;
						if(mapInfo.getMap()[i][j+1] == 0) numOfNeighbor--;
						if(mapInfo.getMap()[i+1][j] == 0) numOfNeighbor--;
					}else if(i+1 > puma_1.getLocation().length-1){  //right column
						if(j-1 < 0) //top right point
						{
							numOfNeighbor = 2;
							tempPuma = puma_1.getLocation()[i-1][j]+puma_1.getLocation()[i][j+1];
							tempHare = hare_1.getLocation()[i-1][j]+hare_1.getLocation()[i][j+1];
							if(mapInfo.getMap()[i-1][j]==0) numOfNeighbor--;
							if(mapInfo.getMap()[i][j+1] == 0) numOfNeighbor--;
						}
						else if(j+1 > puma_1.getLocation()[i].length-1) //bottom right point
						{
							numOfNeighbor = 2;
							tempPuma = puma_1.getLocation()[i-1][j]+ puma_1.getLocation()[i][j-1];
							tempHare = hare_1.getLocation()[i-1][j]+ hare_1.getLocation()[i][j-1];
							
							if(mapInfo.getMap()[i-1][j] == 0) numOfNeighbor--;
							if(mapInfo.getMap()[i][j-1] == 0) numOfNeighbor--;
						}
						else //other points except the top and bottom ones
						{
							numOfNeighbor = 3;
							tempPuma = puma_1.getLocation()[i-1][j]+puma_1.getLocation()[i][j+1]+puma_1.getLocation()[i][j-1];
							tempHare = hare_1.getLocation()[i-1][j]+hare_1.getLocation()[i][j+1]+hare_1.getLocation()[i][j-1];
							
							if(mapInfo.getMap()[i-1][j]==0) numOfNeighbor--;
							if(mapInfo.getMap()[i][j+1] == 0) numOfNeighbor--;
							if(mapInfo.getMap()[i][j-1] == 0) numOfNeighbor--;
						}
					}else if(j+1 > puma_1.getLocation()[i].length-1 && i-1 >=0 && i+1 <= puma_1.getLocation().length-1){ //bottom row
						numOfNeighbor = 3;
						tempPuma = puma_1.getLocation()[i-1][j]+puma_1.getLocation()[i+1][j]+puma_1.getLocation()[i][j-1];
						tempHare = hare_1.getLocation()[i-1][j]+hare_1.getLocation()[i+1][j]+hare_1.getLocation()[i][j-1];
						
						if(mapInfo.getMap()[i-1][j]==0) numOfNeighbor--;
						if(mapInfo.getMap()[i+1][j] == 0) numOfNeighbor--;
						if(mapInfo.getMap()[i][j-1] == 0) numOfNeighbor--;
					}else{  //other points inside the map (not on the border)
						numOfNeighbor = 4;
						tempPuma = puma_1.getLocation()[i-1][j]+puma_1.getLocation()[i+1][j]+puma_1.getLocation()[i][j-1]+puma_1.getLocation()[i][j+1];
						tempHare = hare_1.getLocation()[i-1][j]+hare_1.getLocation()[i+1][j]+hare_1.getLocation()[i][j-1]+hare_1.getLocation()[i][j+1];
						
						if(mapInfo.getMap()[i-1][j] == 0) numOfNeighbor--;
						if(mapInfo.getMap()[i+1][j]==0) numOfNeighbor--;
						if(mapInfo.getMap()[i][j+1] == 0) numOfNeighbor--;
						if(mapInfo.getMap()[i][j-1] == 0) numOfNeighbor--;
						
					}
					tempPuma = tempPuma - numOfNeighbor*puma_1.getLocation()[i][j]; //algorithm calculate for puma
					tempHare = tempHare - numOfNeighbor*hare_1.getLocation()[i][j]; //algorithm calculate for hare
					
					puma_2.getLocation()[i][j]= puma_1.getLocation()[i][j]+timeStep*(puma_1.getBirthRate()*hare_1.getLocation()[i][j]*puma_1.getLocation()[i][j]-puma_1.getMortalityRate()*puma_1.getLocation()[i][j]+puma_1.getDiffusionRate()*tempPuma);
					hare_2.getLocation()[i][j]= hare_1.getLocation()[i][j]+timeStep*(hare_1.getBirthRate()*hare_1.getLocation()[i][j]-hare_1.getPredationRate()*hare_1.getLocation()[i][j]*puma_1.getLocation()[i][j]+hare_1.getDiffusionRate()*tempHare);
					
				}
	
			}
	
		//print part
			/*for(int i =0; i <width; i++){
				for(int j =0; j< height; j++){
					
					System.out.println("in("+i+","+j+")puma number:"+b.getLocation()[i][j]+" hare number:"+u.getLocation()[i][j]);	
							
				}
				
			}
			System.out.println("");*/
			puma_1 = puma_2 ; //upload the puma density
			hare_1 = hare_2 ; //upload the hare density
			t = t+timeStep;	 //time going up
		}
		
		WriteToPPM output = new WriteToPPM(); //get the output
		output.WritePPM(puma_2.getLocation(),"puma",1);
		

	}
	
	
	
}
