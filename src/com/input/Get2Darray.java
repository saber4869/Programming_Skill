package com.input;
import java.io.*;

public class Get2Darray {
	String fileName;
	BufferedReader bufferIn;
	
	public Get2Darray(String file) throws FileNotFoundException{
		fileName=file;
		bufferIn = new BufferedReader( new FileReader (fileName));
	}
	
	public int[] getdata(String file) throws IOException{
		//get width and height
		String line = bufferIn.readLine();
		String[] a1= line.split(" ");
		int[] data = new int[2];
		data[0] = Integer.parseInt(a1[0]); //column
		data[1] = Integer.parseInt(a1[1]); //row
		return data;
	}
	
	public int[][] getMap(int h,int w) throws IOException{
		//get Map
		int height=h,width=w,i,j,count=0;
		String line= bufferIn.readLine();
		int[][] map = new int[height][width];
		int[] array=new int[width];
		while (line!=null){
			String[] a2 = line.split(" ");
			//String Array to Int Array
			for(i=0;i<a2.length;i++){  //a2.length should equals to width
				array[i]=Integer.parseInt(a2[i]);
			}	
			//Int array to Int 2D Array: height*width
			for(i=0;i<width;i++){
				map[count][i]=array[i];
			}
			count=count+1;
			//Read next line
			line = bufferIn.readLine();
			//Clear the array
			a2 = null;
			array=new int[width];
		}
		bufferIn.close();
		return map;
	}
}