package HW4;

import java.util.Arrays;

public class  HashTableSong{
	
	private Song[] table ;
	private int size ;
	static String []searchtable;
	int arraySize;
	public static int itemsInArray =0;
			
		public HashTableSong(int tableSize) {
			table = new Song[nextPrime(tableSize)];
			size =0;
			arraySize= tableSize;
			searchtable= new String[size];
			Arrays.fill(searchtable, "-1");
		}
		public boolean isEmpty() {
			return size ==0;
		}
		public int getSize() {
			
			return size;
		}
		private static int nextPrime( int n )
	    {
	        if (n % 2 == 0)
	            n++;
	        for ( ; !isPrime( n ); n += 2);
	 
	        return n;
	    }
		private static boolean isPrime( int n )
	    {
	        if (n == 2 || n == 3)
	            return true;
	        if (n == 1 || n % 2 == 0)
	            return false;
	        for (int i = 3; i * i <= n; i += 2)
	            if (n % i == 0)
	                return false;
	        return true;
	    }
		public void insert(String val) {
			
			size++;
			
			int pos = myhash(val);
			Song nptr = new Song(val);

			//Search add
		
			if(table[pos]==null) {
				table[pos] = nptr;
				}
			else {
				
				while(table[pos]!=null) {		
				/*	if(nptr.PersonName.equals(val)) {		// The same name can not creat.
					//	System.out.println(val+" can not be created."+nptr.PersonName);
					
						break;
					}
						*/
					++pos;
	//				System.out.println("Collision for "+nptr.PersonName +" Try "+ pos + " Instead ");
					pos%=size;
				}
				
			}
			table[pos]=nptr;
		}
		private int myhash(String x )
	    {
	        int hashVal = x.hashCode( );
	        
	        hashVal%=table.length;
	        if (hashVal < 0)
	            hashVal += table.length;
	        return hashVal;
	    }
	
		 public void printHashTable ()
		    {
		        System.out.println();
		        for (int i = 0; i < table.length; i++)
		        {
		            System.out.print ("Bucket " + i + ":  ");             
		           	Song start = table[i];
		           	
		            while(start != null)
		            {
		                System.out.print(start.SongName+" ");
		                start = start.next;
		            }
		            System.out.println();
		        }
		        
		    }  
		 public boolean search(String val) {
			 
			for(int i =0;i<table.length;i++) {
				Song start = table[i];
				while(start!=null) {
			//		System.out.println("VALUE	    AAAAAAA          "+val+" index "+i);
			//		System.out.println("Perso name SSSSSSSS         "+start.PersonName );
					if(val.equals(start.SongName)) {
						itemsInArray = i;
					//	System.out.println(table[i].SongName+" ÝNDEX NEW for "+start.SongName);
						return true;
						}
					
					start = start.next;
	//				System.out.println(" ");
				}
			
			}
		
	return false;
		 }
		
		 public void personSongList(String val,String index) {
				
			 	int pos = itemsInArray;
			// 	System.out.println(itemsInArray+" SONG INDEX "+ val);
			 	Song nptr = new Song(val);

				//Search add
			
				if(table[pos]==null) {
					table[pos] = nptr;
					}
				else {
					Song entry = table[pos];
					while(entry.next!=null) {
						
						entry = entry.next;
					}
				
					entry.next = nptr;
				}
				
			}
		 public void delete(String index) {
			 int pos = itemsInArray;
			 table[pos]=null;
			 
			 
		 }
		 public boolean search2(String val) {
			 
				for(int i =0;i<table.length;i++) {
					Song start = table[itemsInArray];
					while(start!=null) {
				//		System.out.println("VALUE	    AAAAAAA          "+val+" index "+i);
				//		System.out.println("Perso name SSSSSSSS         "+start.PersonName );
						if(val.equals(start.SongName)) {
							itemsInArray = i;
				//			System.out.println(i+" ÝNDEX NEW for "+start.PersonName);
							return true;
							}
						
						start = start.next;
		//				System.out.println(" ");
					}
				
				}
				return false;
		 }
		 public void print() {
			 
		        
		            Song first = table[itemsInArray];             
		           	Song start = table[itemsInArray].next;
		           	System.out.println(first.SongName+ " likes");
		            while(start != null)
		            {
		            	System.out.print(start.SongName);
		                start = start.next;
		                
		                System.out.println("");
		            }
		            System.out.println();
		        
		 }
		 public void erase(String name) {
			 
			 int pos = itemsInArray;
			 
			 Song entry = table[pos];
	
		 
				while(!entry.next.SongName.equals(name)) { 
					entry= entry.next;
					}
			 	
			 	 	if(entry.next.next ==null) {
			 			 entry.next =null;
			 		 }
			 		
			 		 else if(entry.next.next !=null){
			 		
			 		Song tmp2 = entry.next.next;
			 		
			 		
			 		entry.next = tmp2;
			 		 }
			 			
			 
			 	 
					
					
				 	
				 
}
		 
}
