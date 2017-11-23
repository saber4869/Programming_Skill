package com.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/** 
 * This class is output text information section
 * which receive an 2-dimension array and write it to a txt file 
 * without converting the array to a RGB color array which tell 
 * the density of hare and puma directly.  
 * @author: Guo Zheng 
 */
public class WriteToText {
	
	/**   
	 * 
	 * @Package: com.output
	 * @throws: IOException 
	 * @param resultArray the density of either hare or puma in a 2-dimension array
	 * @param average average density in this generation
	 * @param animal tell us which animal we are recording
	 * @param T the specific cycle that need to write to a ppm file 
	 * @date: 31/10/2017
	 */
	public void WriteText(double[][] resultArray, String average, String animal, int T) throws IOException
	{
		    //set filename using animal and T
			String filename = null;
					if(T<1000){
					filename="./outputlist/" + animal + "result00" + T + ".txt";}
					else{
						filename="./outputlist/" + animal + "result0" + T + ".txt";
					}
			
			//write  result assay into text file
			BufferedWriter writetxt = new BufferedWriter(new FileWriter(filename));
			writetxt.write(average);
			writetxt.newLine();
			for(int i = 0; i < resultArray.length; i++){
				for(int j = 0; j < resultArray[i].length ; j++){
					writetxt.write(resultArray[i][j]+"");
					if(j < resultArray[i].length - 1)
						writetxt.write(" ");
				}
				writetxt.newLine();
			}
			writetxt.flush();
			writetxt.close();
		
		
	}

}
