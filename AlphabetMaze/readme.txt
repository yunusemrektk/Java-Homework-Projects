EEM 480 HW 3
In this Homework you are required to find close paths in a maze. Here it is good idea to describe the
problem using an example. It is noticed that there is a maze given with characters selected from English
alphabet as shown in Figure 1. In this maze some loops are hidden and you have to find those loops
starting with character “a”
a r h g f e t g k l
b j i r b d l y n m
c k t a b c g v s a
k l m n h a z m b n
a f e c g b c d f e
n d b r f e d h v s
x d k a y f m n n n
z s w b v b l o a p
h a g c r j k p w l
b k l n g s d k z d
Figure 1
Here at the first glance it is difficult to find them but I am sure that your algorithm will easily find them.
In this maze there are three loops as shown in Figure 2 :
a r h g f e t g k l
b j i r b d l y n m
c k t a b c g v d a
k l m n h a z m c b
a f e c g b c d f e
n d b r f e d h v s
x d k a y f m n n n
z s w b v b l b a p
h a g c r j k p w l
b k l n g s d k z d
Figure 2
As you can easily notice, the loops can only be formed by adjacent squares (not cross vicinity), starts
with character “a” and go through with next character in the alphabet as a – b – c – d - …. then forms a
loop until “a” has been reached. Unfortunately, the size of loops is not known. Your program will check
all possible loops in the maze and give results as :
The maze has three loops
Loop 1 : 3,4 – 3,5 – 3,6 – 2,6 – 1,6 – 1,5 – 1,4 – 1,3 – 2,3 – 2,2 – 3,2 – 4,2 – 4,3 – 4,4 
Loop 2: 3,10 – 4,10 – 4,9 – 3,9
Loop 3: 4,6 – 5,6 – 5,7 – 6,7 – 6,6 – 6,5 – 5,5 – 4,5
Here maybe you have noticed that the upper left corner has been initiated by 1,1. The description of
each position is given as Row, Column order as 4,6 is Row 4, Column 6
My test program use the class MazeClass :
public class MazeClass implements MazeInterface{
 @Override
 public void InputMaze(String FileName) {
 throw new UnsupportedOperationException("Not supported yet."); //To
change body of generated methods, choose Tools | Templates.
 }
 @Override
 public void FindLoops() {
 throw new UnsupportedOperationException("Not supported yet."); //To
change body of generated methods, choose Tools | Templates.
 }
 @Override
 public void FindLoops(String FileName) {
 throw new UnsupportedOperationException("Not supported yet."); //To
change body of generated methods, choose Tools | Templates.
 }

}
Where MazeInterface is
public interface MazeInterface {
 public void InputMaze(String FileName);
 public void FindLoops();
 public void FindLoops(String FileName);
}
There are two necessary methods in the MazeInterface as
public void InputMaze(String FileName); which will read the maze from the
file given by user. The file will contain the maze information as :
10 10
a r h g f e t g k l
b j i r b d l y n m
c k t a b c g v s a
k l m n h a z m b n
a f e c g b c d f e
n d b r f e d h v s
x d k a y f m n n n
z s w b v b l o a p
h a g c r j k p w l
b k l n g s d k z d 
where the first row has the information of the size of the maze and the consecutive lines have the
information of lines of the maze.
public void FindLoops(); which will find the possible loops and put the
result onto the screen in desired format.
The overrided method :
public void FindLoops(String FileName); will create a file given in the
FileName as : /Directory/FileName and the file will contain the information
as :
Example of the file
This program has been written by : “YourName”, “YourSurname” (like Lütfullah
Sütçü)
The maze has three loops
Loop 1 : 3,4 – 3,5 – 3,6 – 2,6 – 1,6 – 1,5 – 1,4 – 1,3 – 2,3 – 2,2 – 3,2 –
4,2 – 4,3 – 4,4
Loop 2: 3,10 – 4,10 – 4,9 – 3,9
Loop 3: 4,6 – 5,6 – 5,7 – 6,7 – 6,6 – 6,5 – 5,5 – 4,5

