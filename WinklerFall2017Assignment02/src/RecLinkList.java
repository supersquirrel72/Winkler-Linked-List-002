/******************************************************
***  Class Name: RecLinkList
***  Class Author: Gabriel Winkler
******************************************************
*** Purpose of the class: This class will take input from the first text box
*** of the GUI and compare it to the Linked List with random integers.
******************************************************
*** Date: September 19th, 2017
******************************************************
*** List of changes with dates:
*** September 19th: Write the RecLinkList class
***               - Fix imports and add comments.
*                 - Test for errors.
******************************************************
*** Look at this!
*** I cannibalized project 1 and made it work in a simple manner. Like Svart
*** suggested, use working code when you can!
*******************************************************/
/**
 * @author Gabriel
 */
public class RecLinkList 
{
    private MyLinkList groot;
    private int countUp;
    private int countDown;


/******************************************************
***  Method name: sortedLink
***  Method Author: Gabriel Winkler
******************************************************
*** This method inputs a link into the link list while sorting it
*** at the same time. It also calls the find() method, which verifies
*** that the user's number has not been entered already(the important part).
*** Method Inputs: integer value from the first text field.
*** Return value: returns either 1 or -1, which are not used.
*** The return values are based on whether a number has already been entered 
*** into the list, even though they don't matter for this project.
******************************************************
*** Date: September 19th, 2017
******************************************************
*** Cool stuff: This class also sorts the list, but you'll never see it...
*****************************************************/

    public int sortedLink(int myValue)
    {
        MyLinkList temp= new MyLinkList();
        temp.value = myValue;
        MyLinkList previous = null;  
        MyLinkList current = groot;
        countUp = 0;
        
        if(search(myValue) == 1)  //This adds a link if value has not already been entered
        {    
            while(current != null && myValue > current.value) // or myValue > current 
            {                     
                previous = current;
                current = (MyLinkList) current.nextLL;   // go to next item
                countUp++;
            }
            if(previous==null)
                groot = temp;                             
        
            else 
                previous.nextLL = temp;      
        
            temp.nextLL = current;  
            
            return 1;
        }        
        else
        {
            return -1;
        }
    }
    
/******************************************************
***  Method name: search
***  Method author: Gabriel Winkler
******************************************************
*** This method searches to see if a number is already in the list 
*** Method Inputs: integer from user
*** Return value: returns -1 if number is found or 1 if number is not found
******************************************************
*** Date: September 19th, 2017
******************************************************/

    public int search(int number)      // find link with given number 
    {                           
        MyLinkList current = groot;    
        
        if(groot != null)    //only runs if list is not empty
        {
            while(current.value != number) 
            { 
                if(current.nextLL == null)
                    return 1;
                else 
                    current = (MyLinkList) current.nextLL;
            } 
            return -1;
        }
        else return 1;
    }
}
