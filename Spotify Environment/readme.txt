ALGORITHM AND COMPLEXITY HOMEWORK 4
The Environment that i used is Eclipse Java.In this Project there are too many different
algorithms and I want to explain them very clear.
There are some commands for the Spotify environment . They are all must be arranged in a
different way. In this Project I have to define two hash tables .One of them is for implementing Song to
the Person and the other one is for implementing Person to Song. I mean one hash table keeps the
information of the song names liked by person and the other one keeps the information of who listens
the same songs.I used a string array for hash tables. I implemented names to the index by checking
hashCodes of the names or songs.My collusion solving method was if the index is not null increment the
hash value by 1 and take it’s modulation by size of array . If it’s not empty again do the same calculation
again and find a index which is null. But there is a little bit problem for finding that index again. Because I
can not reach the index just by looking it’s hashCode because it’s already changed , it’s not there
anymore.To finding that person i needed to define a search function .Beside I used search function for
almost every command .So there is no problem for implementing songs and person names now.
For ‘I’ command creates a person . This is the simplest one. Take the name , find it’s hashCode
and write it to available index.
For ‘L’ command chains song to the person. First i need to check if the person was created
before . If the person haven’t created before warn the user.I used search function also here.
For ‘E’ command breaks the chain within person and that song. This is also has a warning if the
person hasn’t created before and the song hasn’t liked before by that person.And also it has to be erased
by song liked by same person hash.
For ‘D’ command the user will be deleted from person hash and song hash. Find the person and
make it null from hash table. Also go the the song hash and find the all person names and delete it from
song chains.
For ‘M’ command i spend a lot of time . This was the hardest command i believe . I need to check
both song hash and person hash in this line. I used search function here again. First i need to find the
person and liked songs. I need to compare theese songs step by step. Take the first song and go to song
hash because it keeps the people names who listens that song. I used an another temporary array keeps
how many matches includes.For example in the first ” Show must go on “ liked by three person and
increment the each person counter.Go to another song liked by user and again increment all person
counters. So after searching all songs count array keeps the numbers of matches.
For ’R’ command i used the algorithm similar to Match algoritm.I wanted to recommand the
songs from possible frends of user.As i mentioned it’s similar to Match algorithm but this time I keep the
information of the song which doesn’t match.
In addition to my report I want to explain one more thing. I wasn’t so clue about how the user
give the commands .In my code you can implement your all commands from text and console. There will 
be no problem and it’s not seperated . I mean you can write your command just like inclueded in text
file. You can add a person , print a person or print a match result from console for new results.
YUNUS EMRE KÜTÜK
 48712647380
