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
import com.output.JfreechartAverage;
import com.output.WriteToPPM;
import com.output.WriteToText;

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
		
		long totalTime_output = 0;
		
		long startTime_model=System.currentTimeMillis();   //get the start time
		double timeStep = 0.4;
		int generation = 0;
		
		//average density
		double[] avg_puma = new double[14];
		double[] avg_hare = new double[14];
		int count= 0;
		double total_temp_puma = 0; //total density of all puma in the map
		double total_temp_hare = 0; //total density of all hare in the map
		
		
		Puma puma_2 = new Puma();
		Hare hare_2 = new Hare();
		puma_2.setLocation(new double[height][width]);
		hare_2.setLocation(new double[height][width]);
		
		
		
		Puma puma_halo = new Puma();
		puma_halo.setLocation(new double[height+2][width+2]);
		Hare hare_halo = new Hare();
		hare_halo.setLocation(new double[height+2][width+2]);
		int[][] neigh = new int[height][width];
		
		

		
	
		for(double t = 0; t < 500; ){
			for(int i = 0; i < height; i++){
				
				for(int j = 0; j < width; j++){
					double tempPuma = 0;//for puma around nodes
					double tempHare = 0; // for hare around nodes
					int numOfNeighbor = 0;  //number of neighbour of land but not water
					int num_water = 0;
					if(puma_1.getLocation()[i][j] == 0 || hare_1.getLocation()[i][j] == 0)  //if water area then continue
						continue;
					if(height==1 & width==1){
						tempPuma = tempPuma - numOfNeighbor*puma_1.getLocation()[i][j]; //algorithm calculate for puma
						tempHare = tempHare - numOfNeighbor*hare_1.getLocation()[i][j]; //algorithm calculate for hare
						
						puma_2.getLocation()[i][j]= puma_1.getLocation()[i][j]+timeStep*(puma_1.getBirthRate()*hare_1.getLocation()[i][j]*puma_1.getLocation()[i][j]-puma_1.getMortalityRate()*puma_1.getLocation()[i][j]+puma_1.getDiffusionRate()*tempPuma);
						hare_2.getLocation()[i][j]= hare_1.getLocation()[i][j]+timeStep*(hare_1.getBirthRate()*hare_1.getLocation()[i][j]-hare_1.getPredationRate()*hare_1.getLocation()[i][j]*puma_1.getLocation()[i][j]+hare_1.getDiffusionRate()*tempHare);
						continue;
					}
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
			
			if(generation%100 == 0 || generation == 1250){
				long startTime_output=System.currentTimeMillis();   //get the start time
				// calculate average
				for(int i =0; i <height; i++){
					for(int j =0; j< width; j++){
						total_temp_puma += puma_2.getLocation()[i][j];
						total_temp_hare += hare_2.getLocation()[i][j];
						//System.out.println("in("+i+","+j+")puma number:"+b.getLocation()[i][j]+" hare number:"+u.getLocation()[i][j]);	
								
					}
					
				}
				avg_puma[count] = total_temp_puma / (width*height);
				avg_hare[count] = total_temp_hare / (width*height);
				total_temp_puma = 0;
				total_temp_hare = 0;
				//save as a file
				WriteToText file = new WriteToText();
				file.WriteText(puma_2.getLocation(), Double.toString(avg_puma[count]), "puma", generation);
				file.WriteText(hare_2.getLocation(), Double.toString(avg_hare[count]), "hare", generation);
				
				
				//draw ppm
				WriteToPPM output = new WriteToPPM(); //get the output
				output.WritePPM(puma_2.getLocation(),"puma",generation);
				output.WritePPM(hare_2.getLocation(),"hare",generation);
				System.out.println("generation:"+generation+"  puma_average:"+avg_puma[count]+"  hare_average:"+avg_hare[count]+"");
				count ++;
				
				long endTime_output=System.currentTimeMillis();   //get the start time
				totalTime_output = totalTime_output + (endTime_output-startTime_output);
				
			}
			//System.out.println("");
			
			//puma_1 = puma_2 ; //upload the puma density
			//hare_1 = hare_2 ; //upload the hare density
			Puma tmp_puma = puma_1;
					puma_1 = puma_2;
					puma_2 = tmp_puma;
					Hare tmp_hare = hare_1;
					hare_1 = hare_2;
					hare_2 = tmp_hare;

			
			
			t = t+timeStep;	 //time going up
			generation++;
		}
		//System.out.println(generation);
/*		WriteToPPM output = new WriteToPPM(); //get the output
		output.WritePPM(puma_2.getLocation(),"puma",1250);
		output.WritePPM(hare_2.getLocation(),"hare",1250);*/
		
		long endTime_model=System.currentTimeMillis();   //get the start time
		
		System.out.println("algorithm running time: "+(endTime_model-startTime_model-totalTime_output)+"ms");
		
		
		long startTime_output=System.currentTimeMillis();   //get the start time
		JfreechartAverage test = new JfreechartAverage(avg_puma,avg_hare);
		long endTime_output=System.currentTimeMillis();   //get the start time
		totalTime_output = totalTime_output + (endTime_output-startTime_output);
		System.out.println("output time: "+totalTime_output+"ms");

	}
	
	
	
}
