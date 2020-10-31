//Starting point for Program 2
//Birthday.java
//
import java.util.*;

//------------------------------------------------------------------------------
public class Birthday{
public static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May",
"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
public static final String[] days = { "Sunday", "Monday", "Tuesday",
"Wednesday", "Thursday", "Friday", "Saturday" };
public static final int[] startsOn = {3, 6, 0, 3, 5, 1, 3, 6, 2, 4, 0, 2, };
public static final int[] daysinMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


// The collection of data members stores the STATE of an object.
// Data members of a class are normally private.   Document each one.
private String month;   // 3-letter abbreviation for the month.
private int date;       // Will be 1..31
private String day;     // The day of the week.
private int monthNumber;
private int dayOfyear = 0;


//--------------------------------------------------------------------------
// Compute a new random value for the die.
// Postcondition: the return value is between 1 and faces.
Birthday( String m, int d){
    month = m;
    date = d;
    calculateDay();
}

//--------------------------------------------------------------------------
private void calculateDay() {
    int k, answer;
    for(k=0; k<12; ++k) {
        if ((months[k].toLowerCase()).equals(month.toLowerCase()))  break;
    }
    monthNumber = k;
    if (monthNumber == 12)
        System.out.println("Your month name was not a valid 3-letter abbreviation.");
    else {
        answer = (startsOn[k] + date -1)%7;
        day = days[answer];
    }
    calculateDayOfYear();
}

private void calculateDayOfYear() {
	for( int k=0; k <= monthNumber; ++k) {
		if(monthNumber == k) {
			
			dayOfyear = dayOfyear + date;
			break;
		}
		dayOfyear = dayOfyear + daysinMonth[k];
	}
}

//---------- A get function gives read-only access to a private data member.
public String getDay(){  return day;  }
public int getCalculateDayOfYear() { return dayOfyear; }

//--------------------------------------------------------------------------
// Define toString for every class.
// Return a string that reports the state of the class. Used for debugging.
public String toString(){
    return month +" " + date ;
}

//--------------------------------------------------------------------------
public static  void  main( String[] args ) {
    int date;
    String monthname;
    Scanner sc = new Scanner( System.in );

    System.out.println("\nBirthday Day Calculator, Welcome!");
    System.out.print ("Months are: ");
    for( String s : months) System.out.print( s+"  " );

    System.out.println("\n\nPlease enter your birth month and date:");
    monthname = sc.next();
    date = sc.nextInt();
    Birthday b = new Birthday (monthname, date);

    System.out.printf ( "Your %s birthday is on %s this year\n\n",
                       b.toString(), b.getDay() );
    System.out.printf("\t it is day %d of the year\n", b.getCalculateDayOfYear());
}
}


//---------------------------------------------------------------------------------
//OUTPUT
/*
Case 1

Birthday Day Calculator, Welcome!
Months are: Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec  

Please enter your birth month and date:
Jan 1
Your Jan 1 birthday is on Wednesday this year

	 it is day 1 of the year
------------------------------------------------------------------------
Case 2
 
Birthday Day Calculator, Welcome!
Months are: Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec  

Please enter your birth month and date:

Dec 31
Your Dec 31 birthday is on Thursday this year

	 it is day 365 of the year
--------------------------------------------------------------------------
Case 3

Birthday Day Calculator, Welcome!
Months are: Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec  

Please enter your birth month and date:
dec 10
Your dec 10 birthday is on Thursday this year

	 it is day 344 of the year
---------------------------------------------------------------------------
Case 4

Birthday Day Calculator, Welcome!
Months are: Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec  

Please enter your birth month and date:
Jan 11
Your Jan 11 birthday is on Saturday this year

	 it is day 11 of the year
---------------------------------------------------------------------------
Case 5

Birthday Day Calculator, Welcome!
Months are: Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec  

Please enter your birth month and date:
Feb 13
Your Feb 13 birthday is on Thursday this year

	 it is day 44 of the year

 */

