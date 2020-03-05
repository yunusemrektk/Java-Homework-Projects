import java.io.*;
import java.util.Scanner;
import java.util.Stack;


public class MazeClass implements MazeInterface {
private Scanner fReader;
static int row1;
static int col1;
static String [][] mazearray = new String [12][12]; // original maze [10][10]
static int r1;
static int c1;
static Stack<HW3Node> letterstack = new Stack<HW3Node>();
static Stack<HW3Node> mystack = new Stack<HW3Node>();
static Stack<HW3Node> letterstack2 = new Stack<HW3Node>();
static Stack<HW3Node> mystack2 = new Stack<HW3Node>();
static Stack<HW3Node> inversestack = new Stack<HW3Node>();
	@Override
	public void InputMaze(String FileName) {
	
		try {
			fReader = new Scanner(new File(FileName));	// I used scanner method for taking the elements from the text
			while(fReader.hasNextInt()) {				// This wile loop is for getting info for Labirent size.
			    Integer row1 = fReader.nextInt();
				Integer col1 = fReader.nextInt();
			    
				System.out.println("Row1 : "+row1);
				System.out.println("Col1 : "+col1);
				r1 = row1;                     					
				c1 = col1;
			}
		    while(fReader.hasNext()) {						// This wile loop is for the labirent elements.
		    	for(int i = 1; i<=c1 ; i++) {				// I put the elements into the 2d Array.
					for(int j=1;j<=r1 ; j++) {
						String value = fReader.next();
						mazearray[i][j] =value;
						System.out.print(mazearray[i][j]+" ");
					}
					System.out.println("");
				}
		    
		    }
			fReader.close();
			FindLoops();
		}
		catch(Exception e) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	}
	
	@Override
	public void FindLoops() {
		// TODO Auto-generated method stub
		 HW3Node here = new HW3Node();  		
		 HW3Node begin = new HW3Node();
		 HW3Node letter = new HW3Node();
		 HW3Node trash = new HW3Node();
		
		 String find = new String();		// I'm finding the char 'a' in the labirent
		 find = "a";
		
		HW3Node [] offset = new HW3Node[4];		// This offset is created for controlling the next righ , left , down and up elements
		for(int i = 0; i <= 3; i++)
			offset[i] = new HW3Node();
		offset[0].row = 0; 
		offset[0].col = -1; // left
		offset[1].row = 1;
		offset[1].col = 0; // down
		offset[2].row = 0; 
		offset[2].col = 1; // right
		offset[3].row = -1; 
		offset[3].col = 0; // up
		
		for(int i = 0;i<=r1+1;i++) { 				// Labirent walls filled by 'W'
			mazearray[0][i]=mazearray[r1+1][i] = "Ü";											
			mazearray[i][0]=mazearray[i][r1+1] = "Ü";
		}
		
		int r = 0;
	     int c = 0;
	     for(int i =1; i <=r1 ; i++) {				// Searching 'a' in array.
			 for(int j =1 ; j<=c1 ; j++) {
				 if(find.equals(mazearray[i][j])) {
				 
				 letter = new HW3Node(i,j);			
				 letterstack.push(letter);			//I'm sending all coordinates for 'a' to the Stack letterstack.
				
				 }	 
		 
        }
  	  } 
	   
	     here =letterstack.pop();					//Taking the first coordinates and putting it to here.
		 begin = new HW3Node(here.row,here.col);	//Also begin keeps the first 'a' coordinate.
	  	 mystack.push(begin);						// mystack will keep the path.
		
	  	
		try {
			   int option = 0; // next move
			   int LastOption = 3;
		
			   // search for a path
			   	
	    	  	 
			     for(int i = 1 ; i<=r1;i++){    		//This is for rotating about the labirent
			    	 for(int j = 1 ; j<=c1 ;j++){
			    	 
			    		
			    		 
			      while (option <= LastOption){				//This while block controlling the next element.
			    	  
			    	  r = here.row + offset[option].row;
			    	  c = here.col + offset[option].col;
			    	
			          String nextletter = new String();						//Checking the next element if it is next letter.
					  nextletter+=(char)(mazearray[here.row][here.col].charAt(0)+1);			// Creating a next letter object
					  if (nextletter.equals(mazearray[r][c])) break;							// Checking if next letter equals next move.
			         
			         option++; // next option
			         
			      } 
			
			if (option <= LastOption){		// Found a next letter
				here = new HW3Node(r,c);	// Save the coordinate
			 	mystack.push(here); 		// mystack keeps the path.
				
		    	here.row = r;  				//Keep going where we stay
		        here.col = c;	
		        option = 0;
		
			}   
			
			else{		//This code is very complicated but i'm mathematically checking if first element is neighbor to where i'am.
						// This means i'm understanding that we're creating a close loop.
		         if(((begin.col == here.col-1 || begin.col == here.col+1) && begin.row == here.row) ||(begin.col==here.col && (begin.row == here.row-1 || begin.row == here.row+1))){
		        	 if(letterstack.isEmpty())break; 
		        	
		        	 while (!mystack.isEmpty()){ 	//While loop prints the path if there is a loop.			
		     		  here = mystack.pop();
		     		 
		     		  System.out.print(here.row);
		 		      System.out.print(" , ");
		 		      System.out.println(here.col);
		 		     
		     		  }
		        	 
		        	 
		        	 
		        	 System.out.println("");
		        	
		        	 here = letterstack.pop();
			         begin = here;
			         mystack.push(begin);		// If it's a loop go the next 'a' coordinate
			         
			         option=0;
			         
		         	}
		         
		         else{
		        	 if(letterstack.isEmpty())break;	//If letterstack  which keeps the 'a' coordinates on the labirent is empty just jump.
		        	while(!mystack.isEmpty()){			// this block is for When we found a next letter but nowhere to move and no loop
		        	trash = mystack.pop();				// We have to clean the stack .
		        	}

		        	here = letterstack.pop();
		        	begin = here;
		        	mystack.push(begin);
		        	option = 0;
		        	
		         	}
		         
			} 
			
			
			}
			
			    
		}
	}
	
		
		catch(Exception e) {
		throw new UnsupportedOperationException("Not supported yet.");
		}
		}
	
	@Override
	public void Findloops(String Filename) {
		// TODO Auto-generated method stub
		//This is all same with FindLoop function just some modifies has been done for getting the right text output.
		 
		 HW3Node here2 = new HW3Node(); 
		 HW3Node begin2 = new HW3Node();
		 HW3Node letter2 = new HW3Node();
		 HW3Node trash2 = new HW3Node();
		
		 String find2 = new String();
		 find2 = "a";
		
		HW3Node [] offset2 = new HW3Node[4];	
		for(int i = 0; i <= 3; i++)
			offset2[i] = new HW3Node();
		offset2[0].row = 0; 
		offset2[0].col = -1; // left
		offset2[1].row = 1;
		offset2[1].col = 0; // down
		offset2[2].row = 0; 
		offset2[2].col = 1; // right
		offset2[3].row = -1; 
		offset2[3].col = 0; // up
		
		for(int i = 0;i<=r1+1;i++) { 				// Labirent walls filled by 'W'
			mazearray[0][i]=mazearray[r1+1][i] = "Ü";
			mazearray[i][0]=mazearray[i][r1+1] = "Ü";
		}
		
		int r = 0;
	     int c = 0;
	     for(int i =1; i <=r1 ; i++) {					// Searching 'a' in array.
			 for(int j =1 ; j<=c1 ; j++) {
				 if(find2.equals(mazearray[i][j])) {
				 
				 letter2 = new HW3Node(i,j);
				 letterstack2.push(letter2);
				
				 }	 
		 
       }
 	  } 
	   
	     here2 =letterstack2.pop();
		 begin2 = new HW3Node(here2.row,here2.col);	
	  	 mystack2.push(begin2);
		
		
	 
		try {
			   int count =1;
			   FileWriter fw = new FileWriter(Filename);
			   fw.write("This program has been written by : Yunus Emre Kütük\n");
			   fw.write("The maze has three loops\n");
			   int option = 0; // next move
			   int LastOption = 3;
		
			   // search for a path
			   	
	    	  	 
			     for(int i = 1 ; i<=r1;i++){    
			    	 for(int j = 1 ; j<=c1 ;j++){
			    	 
			    		 
			      while (option <= LastOption){
			    	  
			    	  r = here2.row + offset2[option].row;
			    	  c = here2.col + offset2[option].col;
			    	
			          String nextletter = new String();
					  nextletter+=(char)(mazearray[here2.row][here2.col].charAt(0)+1);		// Creating a next letter object
					  if (nextletter.equals(mazearray[r][c])) break;							// Checking if next letter equals next move.
			         
			         option++; // next option
			         
			      } 
			
			if (option <= LastOption){	
				here2 = new HW3Node(r,c);	
			 	mystack2.push(here2); 
			 	
		    	here2.row = r;  
		        here2.col = c;
		        option = 0;
		
			}   
			
			else{
				
		         if(((begin2.col == here2.col-1 || begin2.col == here2.col+1) && begin2.row == here2.row) ||(begin2.col==here2.col && (begin2.row == here2.row-1 || begin2.row == here2.row+1))){
		        	 if(letterstack2.isEmpty())break;
		        	 fw.write("Loop "+count+": ");
		        	 while (!mystack2.isEmpty()){ 						// checking if the first element equals the next element for closing the loop
		     		  here2 = mystack2.pop();
		     		  
		     		  fw.write(" - "+ here2.row+","+here2.col);
		     		//  System.out.print(here2.row);
		 		    //  System.out.print(" , ");
		 		    //  System.out.println(here2.col);
		 		     
		     		  }
		        	 fw.write("\n");
		    		 
		        	 count++;
		        	 
		        	 
		        	 System.out.println("");
		        	
		        	 here2 = letterstack2.pop();
			         begin2 = here2;
			         mystack2.push(begin2);
			      
			         option=0;
			         
		         	}
		         
		         else{
		        	 if(letterstack2.isEmpty())break;
		        	while(!mystack2.isEmpty()){
		        	trash2 = mystack2.pop();
		        	}

		        	here2 = letterstack2.pop();
		        	begin2 = here2;
		        	mystack2.push(begin2);
		        	
		        	option = 0;
		        	
		         	}
		         
			} 
			
			
			}
			
			    
		}
			     fw.close();
	}
	
		
		catch(Exception e) {
		throw new UnsupportedOperationException("Not supported yet.");
		}
		}
}
