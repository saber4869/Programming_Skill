package com.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**   
 * @author: Guo Zheng 
 */
public class WriteToText {
	public void WriteText(double[][] resultArray, String average, String animal, int T) throws IOException
	{
		
			String filename = "./outputlist/" + animal + "result" + T + ".txt";
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
