package HW4;

import java.util.Arrays;

public class  HashTablePerson{ 
	
	private Person[] table ;
	private int size ;
	static String []searchtable;
	int arraySize;
	public static int itemsInArray =0;
			
		public HashTablePerson(int tableSize) {
			table = new Person[nextPrime(tableSize)];
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
		private static int nextPrime( int n ) 	// we want to create a hash array with prime size.
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
			Person nptr = new Person(val);

			//Search add
		
			if(table[pos]==null) { 	//If index is empty put the value.
				table[pos] = nptr;
				}
			else {
				
				while(table[pos]!=null) {		
					
					++pos;			// If the index is not empty find a new index.
					pos%=size;
				}
				
			}
			table[pos]=nptr;
		}
		private int myhash(String x )
	    {
	        int hashVal = x.hashCode( );		//I create the index from strings hash code.
	        
	        hashVal%=table.length;				// Initialize the hashCode
	        if (hashVal < 0)					//If the code is negative number add the array size until it's become a positive number
	            hashVal += table.length;
	        return hashVal;
	    }
	
		 public void printHashTable ()
		    {
		        System.out.println();
		        for (int i = 0; i < table.length; i++)
		        {
		            System.out.print ("Bucket " + i + ":  ");             
		           	Person start = table[i];
		           	
		            while(start != null)
		            {
		                System.out.print(start.PersonName+" ");
		                start = start.next;
		            }
		            System.out.println();
		        }
		        
		    }  
		 public boolean search(String val) {
			 
			for(int i =0;i<table.length;i++) {
				Person start = table[i];
				
				while(start!=null) {
			
					if(val.equals(start.PersonName)) {
						itemsInArray = i;
						//System.out.println(val+" ÝNDEX NEW for "+start.PersonName);
						return true;
						}
					
					start = start.next;

				}
			
			}
		
	return false;
		 }
		
		 public void personSongList(String val,String index) {
				
			 	int pos = itemsInArray;
		//	    System.out.println(itemsInArray+"  index olan");
				Person nptr = new Person(val);

				//Search add
			
				if(table[pos]==null) {
					table[pos] = nptr;
					}
				else {
					Person entry = table[pos];
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
					Person start = table[itemsInArray];
					while(start!=null) {
				
						if(val.equals(start.PersonName)) {
							itemsInArray = i;
				
							return true;
							}
						
						start = start.next;
		
					}
				
				}
			
		return false;
			 }
		 public void print() {
		
		        
		            Person first = table[itemsInArray];             
		           	Person start = table[itemsInArray].next;
		           	System.out.println(first.PersonName+ " likes");
		            while(start != null)
		            {
		            	System.out.print(start.PersonName);
		                start = start.next;
		                
		                System.out.println("");
		            }
		            System.out.println();
		        
		 }
		 public void erase(String name) {
			 
			 int pos = itemsInArray;
			 
			 Person entry = table[pos];
	
		 
				while(!entry.next.PersonName.equals(name)) { 
					entry= entry.next;
					}
			 	
			 	 	if(entry.next.next ==null) {
			 			 entry.next =null;
			 		 }
			 		
			 		 else if(entry.next.next !=null){
			 		
			 		Person tmp2 = entry.next.next;
			 		
			 		
			 		entry.next = tmp2;
			 		 }
			 			
			 
			 	 
					
					
				 	
				 
}
			 	
			 	
			 
		 
		 
}
