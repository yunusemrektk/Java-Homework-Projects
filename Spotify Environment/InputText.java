package HW4;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputText {
private Scanner fReader;

static String []tmppersonlist=new String[50];
static String []tmpsonglist = new String[50];
static String []recommandarray = new String[50];
HashTablePerson pwithsonghashLL = new HashTablePerson(59);
HashTableSong swithpersonhashLL = new HashTableSong(59);
int ind=0;
int ind2=0;
public void InputTxt(String FileName) {

		try {
			
			fReader = new Scanner(new File(FileName));	
			int ind=0;
			int ind2=0;
			   Person pLinked = new Person(null);
			   
			   while(fReader.hasNext()) {				
			   String command = fReader.nextLine();
			   StringTokenizer st = new StringTokenizer(command);
			   StringTokenizer st2 = new StringTokenizer(command);
			   char commandCheck= command.charAt(0);
			  
			  
			   if(commandCheck=='I') {
				
				   	st.nextToken();
				  	pLinked = new Person(st.nextToken());
				
				  		if(pwithsonghashLL.search(pLinked.PersonName))		//Search the person name if it's in the list that means person was created before
				  		System.out.println(pLinked.PersonName+" can not be created.");
				  	else
				  	{
				  		
				  		tmppersonlist[ind]=pLinked.PersonName;			// If couldn't find the person insert that name to person hash table
				  		ind++;
				   		pwithsonghashLL.insert(pLinked.PersonName);
				  		
				  	}
		 
			   }
			  
			   if(commandCheck =='L') {
				  
				   String tmpcommand = st.nextToken();
				   String tmpperson =   st.nextToken();
				   String tmpcommand2 = st2.nextToken();
				   String tmpperson2 = st2.nextToken();
				   Song sLinked =new Song(st.nextToken(tmpcommand).trim());
		
				  if(pwithsonghashLL.search(tmpperson)==true) { //Find the person for adding the song to him.
					
					  pwithsonghashLL.personSongList(sLinked.SongName,tmpperson);// Check the boolean function if L command's person was created before .
				  }
				   else {
					   System.out.println(tmpperson+" is not created before so Song cannot be liked. ");
				   }
					 Song sLinked2 = new Song(st2.nextToken(tmpcommand2).trim());
					 if(swithpersonhashLL.search(sLinked2.SongName)) {
					//	 System.out.println(sLinked2.SongName+" can not create the same song");
					 }
					 else {
						 swithpersonhashLL.insert(sLinked2.SongName);
						 
					tmpsonglist[ind2]=sLinked2.SongName;
					ind2++;
					 }
					
					
					 if(swithpersonhashLL.search(sLinked2.SongName))		// This is adding person to song.
					 {
						 swithpersonhashLL.personSongList(tmpperson2, sLinked2.SongName);
					
					 }
					 else {
				
					 }
			   
			  
			}
			   if(commandCheck =='E') {
				   String tmpcommand = st.nextToken();
				   String tmpperson =   st.nextToken();
				   Song sLinked =new Song(st.nextToken(tmpcommand).trim());
				
				  
				   if(pwithsonghashLL.search(tmpperson)) { 	//Erase the song from person hash.
					   if(swithpersonhashLL.search(sLinked.SongName)){
					   pwithsonghashLL.erase(sLinked.SongName);
					   }
					   else
						   System.out.println(sLinked.SongName + "the song didn't liked before");
					   }
				   	   else
					   System.out.println(tmpperson+" is not created before ");
				   
				  
				
				 
				   if(swithpersonhashLL.search(sLinked.SongName)) { // Erase the person from song hash.
					 if(pwithsonghashLL.search(tmpperson)) {
					   swithpersonhashLL.erase(tmpperson);
					 
					 }
					 else 
						 System.out.println(tmpperson + " didn't created before.");
				   		}
				   else 
					   System.out.println(tmpperson +" didn't like the song before.");
				   
				   	
				   
			   }
			   
			   if(commandCheck =='D') {
				   st.nextToken();
				   String tmpperson =   st.nextToken();
				  
				   if(pwithsonghashLL.search(tmpperson)==true)	// Delete the person from person hash.
					   pwithsonghashLL.delete(tmpperson);
				   else
					   System.out.println(tmpperson+" is not in the list.");
				
				   while(swithpersonhashLL.search(tmpperson)==true) {		// Do that for song hash until no name has found.
					   
			  			swithpersonhashLL.erase(tmpperson);
			  			
				   }	
			   }
			   if(commandCheck =='P'){
				   st.nextToken();
				   String tmpperson = st.nextToken();
				   if(pwithsonghashLL.search(tmpperson)) {	//If the name is found in person hash print it.

					   pwithsonghashLL.print();
				   }
				   else
					   System.out.println(tmpperson +"is not in the list");
					   
			   }
			   if(commandCheck == 'M') {
				   st.nextToken();
				   String tmpperson = st.nextToken();
				  int []countarray= new int[50];
				 
				  int possibility;
				   
				   int counter =0;
				  
				   //Matcing Algorithm
				   if(pwithsonghashLL.search(tmpperson)) { 	//Find the person
					   for(int j =0;tmpsonglist[j]!=null;j++) {	// for checking every songs 
					   for(int i =0; tmppersonlist[i]!=null ; i++) {  //for checking every person names.
					 
					  if(pwithsonghashLL.search(tmpperson)) {			//Find the name and it's index in hash table
						  if(pwithsonghashLL.search2(tmpsonglist[j])) {	//check that index if there is a song a matching
								if(swithpersonhashLL.search(tmpsonglist[j])) {	//go to song hash and it's index in hash table
									if(swithpersonhashLL.search2(tmppersonlist[i]) ) {	//find if there is an another person in that index
										if(!tmppersonlist[i].equals(tmpperson)) {
					    				
					    			++countarray[i] ; // Count up the founded person in that temporary index.
					    							  // It means that I store the number of person matches in tmppersonlist array.
					    	
					    			
					    			}
					    			else
					    				counter++;
					    			
					    		}
					    			
						  	}	
					    	}
						  //**
						  
					   }
					  
					   }	   
				   
				   }
					  
				  System.out.println("");
				  System.out.println("Possible friends of "+tmpperson);
				   for (int i =0;i<countarray.length;i++) {		
					   if((countarray[i]>=1)) {					// countarray keeps the number of matches .
						   possibility = (countarray[i]*100)/counter; 	// percentage of matching.
				   System.out.println(tmppersonlist[i]+" "+possibility+"% match ("+ countarray[i]+" songs out of "+counter +")");
			
					   }
				   }
				   }
				   else {
					System.out.println(tmpperson+" not in the list");
				}
			   }
			   
			   if(commandCheck == 'R') {
				   st.nextToken();
				   String tmpperson = st.nextToken();
				   	 
				      int []countarray= new int[50];
				      String []rcount = new String[50];
					  
					 
					  
					   //Matcing Algorithm
					   if(pwithsonghashLL.search(tmpperson)) { 	//Find the person
						   for(int j =0;tmpsonglist[j]!=null;j++) {	// for checking every songs 
						   for(int i =0; tmppersonlist[i]!=null ; i++) {  //for checking every person names.
						 
						  if(pwithsonghashLL.search(tmpperson)) {			//Find the name and it's index in hash table
							  if(pwithsonghashLL.search2(tmpsonglist[j])) {	//check that index if there is a song a matching
									if(swithpersonhashLL.search(tmpsonglist[j])) {	//go to song hash and it's index in hash table
										if(swithpersonhashLL.search2(tmppersonlist[i]) ) {	//find if there is an another person in that index
											if(!tmppersonlist[i].equals(tmpperson)) {
						    				
						    			++countarray[i] ; // Count up the founded person in that temporary index.
						    							  // It means that I store the number of person matches in tmppersonlist array.
						    	
						    			
						    			}
						    			
						    			
						    			
						    		}
						    			
							  	}	
						    	}
							  //**
							  
						   }
						  
						   }	   
					   
					   }
						  
					 
					  int index=0;
					   for (int i =0;i<countarray.length;i++) {		
						   if((countarray[i]>=1)) {					// countarray keeps the number of matches .
							   
							   recommandarray[index++]=tmppersonlist[i];
						   }
					   }
					   }
					   else {
						
					}
				   
					  // Recommand from matched person
					   
					   for(int k = 0;recommandarray[k]!=null;k++) { 		//It's almost the same algorithm with matcihng
						   for(int l =0; tmpsonglist[l]!=null;l++) {			// I use the matched people for recommanding
						   
							   if(pwithsonghashLL.search(recommandarray[k])) { 		// Go to matched people's song list and recommand the songs don't match.
								 	if(pwithsonghashLL.search2(tmpsonglist[l])) {
								   		if(pwithsonghashLL.search(tmpperson)){
								   			if(pwithsonghashLL.search2(tmpsonglist[l])) {
								   				}
								   			else {
								   				rcount[l]=tmpsonglist[l];
								   			}
								   		}
								   		
								   		}
							   		}
						   
					   }
						  }
					   System.out.println("");
					   System.out.println("Recommands for "+tmpperson+" :");
					   int fivesongs=0;					
					   for(int m=0;m<rcount.length;m++) {
						   if(rcount[m]!=null&fivesongs!=5) {			// Only five song will  be recommanded.
							   fivesongs++;
						   System.out.println(rcount[m]);
						   }
					   }
				   
					
					
			   }
			   
			  
			   if(commandCheck == 'X') {
				   fReader.close();		
				 
				   break;
				
			   }
			   
			}

			
			   
		
			fReader.close();
		
		}
	
		catch(Exception e) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
		//////			Hash tables for person and song			 \\\\\\\\
	
	//		pwithsonghashLL.printHashTable(); 			 
	//	swithpersonhashLL.printHashTable();
	
	}	
//Theese all lines same as what i did before . They are for getting command from console.

	public void I(String Name) {
	Person pLinked = new Person(Name);	
/*	HashTablePerson pwithsonghashLL = new HashTablePerson(59);
	 HashTableSong swithpersonhashLL = new HashTableSong(59);*/
	 int ind=0;
	
	  
	   if(pwithsonghashLL.search(pLinked.PersonName))		//Search the person name if it's in the list that means person was created before
  		System.out.println(pLinked.PersonName+" can not be created.");
	   else
  	{
  		
  		tmppersonlist[ind]=pLinked.PersonName;			// If couldn't find the person insert that name to person hash table
  		ind++;
   		pwithsonghashLL.insert(pLinked.PersonName);
  		
  	}
	 //  pwithsonghashLL.printHashTable();
}
	
	public void L(String Name ,String SongName) {
		
		
		if(pwithsonghashLL.search(Name)==true) { //Find the person for adding the song to him.
			  Song sLinked =new Song(SongName); 	//This keeps the song name in the command line
			
		
			  pwithsonghashLL.personSongList(sLinked.SongName,Name);// Check the boolean function if L command's person was created before .
		  }
		   else {
			   System.out.println(Name+" is not created before so Song cannot be liked. ");
		   }
			 Song sLinked2 = new Song(SongName);
			 if(swithpersonhashLL.search(sLinked2.SongName)) {
			//	 System.out.println(sLinked2.SongName+" can not create the same song");
			 }
			 else {
				
				 swithpersonhashLL.insert(sLinked2.SongName);
				 
			tmpsonglist[ind2]=sLinked2.SongName;
			ind2++;
			 }
			
			
			 if(swithpersonhashLL.search(sLinked2.SongName))		// This is adding person to song.
			 {
				
				 swithpersonhashLL.personSongList(Name, sLinked2.SongName);
			
			 }
			 else {
		
			 }
			 
	//			pwithsonghashLL.printHashTable(); 			 
	//		swithpersonhashLL.printHashTable();
			
	}
	public void E(String Name, String SongName) {
		
		 if(pwithsonghashLL.search(Name)) { 	//Erase the song from person hash.
			   if(swithpersonhashLL.search(SongName)){
			   pwithsonghashLL.erase(SongName);
			   }
			   else
				   System.out.println(SongName + "the song didn't liked before");
			   }
		   	   else
			   System.out.println(Name+" is not created before ");
		   
		  
		
		 
		   if(swithpersonhashLL.search(SongName)) { // Erase the person from song hash.
			 if(pwithsonghashLL.search(Name)) {
			   swithpersonhashLL.erase(Name);
			 
			 }
			 else 
				 System.out.println(Name + " didn't created before.");
		   		}
		   else 
			   System.out.println(Name +" didn't like the song before.");	
//			pwithsonghashLL.printHashTable(); 			 
			//	swithpersonhashLL.printHashTable();
	   
	}
	public void D(String Name) {
		if(pwithsonghashLL.search(Name)==true)	// Delete the person from person hash.
			   pwithsonghashLL.delete(Name);
		   else
			   System.out.println(Name+" is not in the list.");
		
		   while(swithpersonhashLL.search(Name)==true) {		// Do that for song hash until no name has found.
			   
	  			swithpersonhashLL.erase(Name);
	  			
		   }	
		//	pwithsonghashLL.printHashTable(); 			 
		//	swithpersonhashLL.printHashTable();
	}
	public void P(String Name) {
		
		if(pwithsonghashLL.search(Name)) {	//If the name is found in person hash print it.

			   pwithsonghashLL.print();
		   }
		   else
			   System.out.println(Name +"is not in the list");
		
			//	pwithsonghashLL.printHashTable(); 			 
			//	swithpersonhashLL.printHashTable();
	}
	public void M(String Name) {
		int []countarray= new int[50];
		  int possibility;
		   
		   int counter =0;
		  
		   //Matcing Algorithm
		   if(pwithsonghashLL.search(Name)) { 	//Find the person
			   for(int j =0;tmpsonglist[j]!=null;j++) {	// for checking every songs 
			   for(int i =0; tmppersonlist[i]!=null ; i++) {  //for checking every person names.
			 
			  if(pwithsonghashLL.search(Name)) {			//Find the name and it's index in hash table
				  if(pwithsonghashLL.search2(tmpsonglist[j])) {	//check that index if there is a song a matching
						if(swithpersonhashLL.search(tmpsonglist[j])) {	//go to song hash and it's index in hash table
							if(swithpersonhashLL.search2(tmppersonlist[i]) ) {	//find if there is an another person in that index
								if(!tmppersonlist[i].equals(Name)) {
			    				
			    			++countarray[i] ; // Count up the founded person in that temporary index.
			    							  // It means that I store the number of person matches in tmppersonlist array.
			    	
			    			
			    			}
			    			else
			    				counter++;
			    			
			    		}
			    			
				  	}	
			    	}
				  //**
				  
			   }
			  
			   }	   
		   
		   }
			  
		  System.out.println("");
		  System.out.println("Possible friends of "+Name);
		   for (int i =0;i<countarray.length;i++) {		
			   if((countarray[i]>=1)) {					// countarray keeps the number of matches .
				   possibility = (countarray[i]*100)/counter; 	// percentage of matching.
		   System.out.println(tmppersonlist[i]+" "+possibility+"% match ("+ countarray[i]+" songs out of "+counter +")");
	
			   }
		   }
		   }
		   else {
			System.out.println(Name+" not in the list");
		}
		
	}
	public void R(String Name) {
			int []countarray= new int[50];
	      String []rcount = new String[50];
		  
		   
		  
		   //Matcing Algorithm
		   if(pwithsonghashLL.search(Name)) { 	//Find the person
			   for(int j =0;tmpsonglist[j]!=null;j++) {	// for checking every songs 
			   for(int i =0; tmppersonlist[i]!=null ; i++) {  //for checking every person names.
			 
			  if(pwithsonghashLL.search(Name)) {			//Find the name and it's index in hash table
				  if(pwithsonghashLL.search2(tmpsonglist[j])) {	//check that index if there is a song a matching
						if(swithpersonhashLL.search(tmpsonglist[j])) {	//go to song hash and it's index in hash table
							if(swithpersonhashLL.search2(tmppersonlist[i]) ) {	//find if there is an another person in that index
								if(!tmppersonlist[i].equals(Name)) {
			    				
			    			++countarray[i] ; // Count up the founded person in that temporary index.
			    							  // It means that I store the number of person matches in tmppersonlist array.
			    	
			    			
			    			}
			    			
			    				
			    			
			    		}
			    			
				  	}	
			    	}
				  //**
				  
			   }
			  
			   }	   
		   
		   }
			  
		 
		  int index=0;
		   for (int i =0;i<countarray.length;i++) {		
			   if((countarray[i]>=1)) {					// countarray keeps the number of matches .
				   
				   recommandarray[index++]=tmppersonlist[i];
			   }
		   }
		   }
		   else {
			
		}
	   
		  // Recommand from matched person
		   
		   for(int k = 0;recommandarray[k]!=null;k++) {
			   for(int l =0; tmpsonglist[l]!=null;l++) {
			   
				   if(pwithsonghashLL.search(recommandarray[k])) {
					 	if(pwithsonghashLL.search2(tmpsonglist[l])) {
					   		if(pwithsonghashLL.search(Name)){
					   			if(pwithsonghashLL.search2(tmpsonglist[l])) {
					   				}
					   			else {
					   				rcount[l]=tmpsonglist[l];
					   			}
					   		}
					   		
					   		}
				   		}
			   
		   }
			  }
		   System.out.println("");
		   System.out.println("Recommands for "+Name+" :");
		   int fivesongs=0;
		   for(int m=0;m<rcount.length;m++) {
			   if(rcount[m]!=null&fivesongs!=5) {
				   fivesongs++;
			   System.out.println(rcount[m]);
			   }
		   }
	}
	
//		O C:\Users\YUNUS EMRE\Desktop\input.txt
	
}

