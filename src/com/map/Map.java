package com.map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class map {
	
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.map
	 * @author: Yixuan Li  
	 * @date: 31/10/2017
	 */
	
	String fileName;
	int height,width;
	BufferedReader readin;

	/**
	  * @what Define the landscape to be read
	  * @param file: the path of document
	 * @return 
	  */
	public map(String file){
		this.fileName=file;
		try {
			readin = new BufferedReader( new FileReader (fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	  * @what Get height and width of landscape
	  * @param file: the path of document
	  * @return 1D array include height and width
	 * @throws IOException 
	  */
	public int[] getHeightandwidth(String file) throws IOException{
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
	  * @return Map (2D array) 
	  */
	public int[][] getMap(int height,int width) throws IOException{
		int i,count=0;
		this.height=height;
		this.width=width;
		String line= readin.readLine();
		int[][] map = new int[height][width];
		int[] array=new int[width];
		while (line!=null){
			String[] a2 = line.split(" ");
			//String Array to int Array
			for(i=0;i<a2.length;i++){  //a2.length should equals to width
				array[i]=Integer.parseInt(a2[i]);
			}	
			//int array to int 2D Array: height*width
			for(i=0;i<width;i++){
				map[count][i]=array[i];
			}
			count=count+1;
			//Read next line
			line = readin.readLine();
			//Clear the array
			a2 = null;
			array=new int[width];
		}
		readin.close();
		return map;
	}
}
