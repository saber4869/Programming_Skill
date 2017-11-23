package com.input;
import java.io.*;
/**
 * @author: Yixuan Li
 * @date: 2017-Oct-31
 * @what: read from the file to get width,height and 2D array data.
 * 
 */
public class Get2Darray {
	String fileName;
	int height,width;
	BufferedReader readin;
	
	/**
	  * @what Define the landscape to be read
	  * @param file: the path of document
	  * @throws FileNotFoundException 
	  */
	public Get2Darray(String file) throws FileNotFoundException{
		this.fileName=file;
        readin = new BufferedReader( new FileReader (fileName));
	}
	
	/**
	  * @what Get height and width of landscape
	  * @param file: the path of document
	  * @throws IOException
	  * @return 1D array include height and width
	  */
	public int[] getHeightandWidth() throws IOException{
		//read a line
		String line = readin.readLine();
		String[] a1= line.split(" ");
		int[] data = new int[2];
		data[0] = Integer.parseInt(a1[0]); //column
		data[1] = Integer.parseInt(a1[1]); //row
		return data;
	}
	
	/**
	  * @what Get data inside landscape
	  * @param file: the path of document
	  * @throws IOException
	  * @return Map (2D array) 
	  */
	public int[][] getMap(int height,int width) throws IOException{
		int i,count=0;
		this.height=height;
		this.width=width;
		String line= readin.readLine();
		int[][] map = new int[height][width];
		int[] array=new int[width];
		while (line!=null){ //read line by line
			String[] linedata = line.split(" "); //read one line of data
			//String array to int Array
			for(i=0;i<width;i++){  //linedata.length should equals to width
				array[i]=Integer.parseInt(linedata[i]);
			}	
			//int array to int 2D Array: height*width
			for(i=0;i<width;i++){
				map[count][i]=array[i];
			}
			count=count+1;
			//Read next line
			line = readin.readLine();
			//Clear the array
			linedata = null;
			array=new int[width];
		}
		readin.close();
		return map;
	}
}