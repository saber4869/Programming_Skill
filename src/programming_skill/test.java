package programming_skill;

import java.util.ArrayList;
import java.util.Random;


public class test {

	public static void main(String[] args){
		int width = 3;
		int height = 3;
		ArrayList list = new ArrayList();
		puma a = new puma();
		a.xy = new double[width][height];
		/*
		a.xy[0][0] = 1;
		a.xy[0][1] = 2;
		a.xy[1][0] = 3;
		a.xy[1][1] = 4;*/
		hare r = new hare();
		r.xy = new double[width][height];
		
		for(int i=0 ; i<width;i++){
			for(int j =0; j<height; j++){
					Random random = new Random();
					int temp_num = random.nextInt(5)+1;
					a.xy[i][j] = temp_num;
					
					Random random2 = new Random();
					int temp_num2 = random2.nextInt(5)+1;
					r.xy[i][j] = temp_num2;
					System.out.println("origin:in("+i+","+j+")puma number:"+a.xy[i][j]+" hare number:"+r.xy[i][j]);	
			}
		}
		
		/*r.xy[0][0] = 1;
		r.xy[0][1] = 1;	
		r.xy[1][0] = 1;
		r.xy[1][1] = 1;
		*/
		puma b = new puma();
		hare u = new hare();
		b.xy = new double[width][height];
		u.xy = new double[width][height];
		for(double t = 0; t < 50; ){
			for(int i = 0; i < width; i++){
				
				for(int j = 0; j < height; j++){
					double temp = 0;//for puma around nodes
					double temph = 0; // for hare around nodes
					int num = 0;  //number of neighbour of land but not water
					int num_water = 0;
					if(a.xy[i][j] == 0 || r.xy[i][j] == 0)  //if water area then continue
						continue;
					if(i-1 < 0){   //left column
						if(j-1 < 0)
						{
							num = 2;
							temp = a.xy[i+1][j]+a.xy[i][j+1];
							temph = r.xy[i+1][j]+r.xy[i][j+1];
							if(a.xy[i+1][j]==0) num--;
							if(a.xy[i][j+1] == 0) num--;
						}
						else if(j+1 > a.xy[i].length-1)
						{
							num = 2;
							temp = a.xy[i+1][j]+ a.xy[i][j-1];
							temph = r.xy[i+1][j]+ r.xy[i][j-1];
							if(a.xy[i+1][j]==0) num--;
							if(a.xy[i][j-1] == 0) num--;
						}
						else
						{
							num = 3;
							temp = a.xy[i+1][j]+a.xy[i][j+1]+a.xy[i][j-1];
							temph = r.xy[i+1][j]+r.xy[i][j+1]+r.xy[i][j-1];
							if(a.xy[i+1][j]==0) num--;
							if(a.xy[i][j+1] == 0) num--;
							if(a.xy[i][j-1] == 0) num--;
						}                                       
					}else if(j-1 < 0 && i-1 >= 0 && i+1 <= a.xy.length-1 ){ //top row
						num = 3;
						temp = a.xy[i-1][j]+a.xy[i+1][j]+a.xy[i][j+1];
						temph = r.xy[i-1][j]+r.xy[i+1][j]+r.xy[i][j+1];
						if(a.xy[i-1][j]==0) num--;
						if(a.xy[i][j+1] == 0) num--;
						if(a.xy[i+1][j] == 0) num--;
					}else if(i+1 > a.xy.length-1){  //right column
						if(j-1 < 0)
						{
							num = 2;
							temp = a.xy[i-1][j]+a.xy[i][j+1];
							temph = r.xy[i-1][j]+r.xy[i][j+1];
							if(a.xy[i-1][j]==0) num--;
							if(a.xy[i][j+1] == 0) num--;
						}
						else if(j+1 > a.xy[i].length-1)
						{
							num = 2;
							temp = a.xy[i-1][j]+ a.xy[i][j-1];
							temph = r.xy[i-1][j]+ r.xy[i][j-1];
							
							if(a.xy[i-1][j] == 0) num--;
							if(a.xy[i][j-1] == 0) num--;
						}
						else
						{
							num = 3;
							temp = a.xy[i-1][j]+a.xy[i][j+1]+a.xy[i][j-1];
							temph = r.xy[i-1][j]+r.xy[i][j+1]+r.xy[i][j-1];
							
							if(a.xy[i-1][j]==0) num--;
							if(a.xy[i][j+1] == 0) num--;
							if(a.xy[i][j-1] == 0) num--;
						}
					}else if(j+1 > a.xy[i].length-1 && i-1 >=0 && i+1 <= a.xy.length-1){ //bottom row
						num = 3;
						temp = a.xy[i-1][j]+a.xy[i+1][j]+a.xy[i][j-1];
						temph = r.xy[i-1][j]+r.xy[i+1][j]+r.xy[i][j-1];
						
						if(a.xy[i-1][j]==0) num--;
						if(a.xy[i+1][j] == 0) num--;
						if(a.xy[i][j-1] == 0) num--;
					}else{
						num = 4;
						temp = a.xy[i-1][j]+a.xy[i+1][j]+a.xy[i][j-1]+a.xy[i][j+1];
						temph = r.xy[i-1][j]+r.xy[i+1][j]+r.xy[i][j-1]+r.xy[i][j+1];
						
						if(a.xy[i-1][j] == 0) num--;
						if(a.xy[i+1][j]==0) num--;
						if(a.xy[i][j+1] == 0) num--;
						if(a.xy[i][j-1] == 0) num--;
						
					}
					temp = temp - num*a.xy[i][j];
					temph = temph - num*r.xy[i][j];
					
					b.xy[i][j]= a.xy[i][j]+0.4*(0.02*r.xy[i][j]*a.xy[i][j]-0.06*a.xy[i][j]+0.2*temp);
					u.xy[i][j]= r.xy[i][j]+0.4*(0.08*r.xy[i][j]-0.04*r.xy[i][j]*a.xy[i][j]+0.2*temph);
					
				}
	
			}
			/*
			System.out.println(b.xy[0][0]); //new puma
			System.out.println(b.xy[0][1]);
			System.out.println(b.xy[1][0]);
			System.out.println(b.xy[1][1]);
			System.out.println("/n");
			System.out.println(u.xy[0][0]); //new hare
			System.out.println(u.xy[0][1]);
			System.out.println(u.xy[1][0]);
			System.out.println(u.xy[1][1]);
			System.out.println("/n");
			System.out.println("");*/
		
			for(int i =0; i <width; i++){
				for(int j =0; j< height; j++){
					
					System.out.println("in("+i+","+j+")puma number:"+b.xy[i][j]+" hare number:"+u.xy[i][j]);	
							
				}
				
			}
			System.out.println("");
			a = b ;
			r = u ;
			t = t+0.4;
		}
	
	}
	
	
	
	
	
	
	
}

