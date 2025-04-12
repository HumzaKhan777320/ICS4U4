package prodcode1;

/*
 * This class represents the new style of product code,
 * with no lower-case letters and all of the integers
 * added together at the end
 */

public class ProductCodeV2 extends ProductCode {

	//Constructor - Create a new-style product code from a
	//String.  Validate it, and if it's an old-style code,
	//convert it to the new style
	public ProductCodeV2(String code) throws Exception
	{
		super(code);
		
		//Convert to the new style
		myCode = convertCode(myCode);
	}
	
	//This method converts old-style codes to new-style codes
	//Note that because of the codes are defined, if the
	//code is already in the new style it won't change
	private String convertCode(String oldCode)
	{
		//Variable for the final converted code
		String newCode = "";
		
		//Variable to store numbers that we find in the product code, in String form
		String numString = "";
		
		//Variable for the sum of integers
		int sum = 0;
		
		//This variable keeps track of whether or not we're currently processing a number
		boolean isNumber = false;
		
		//TO DO:  Complete this section
		
		//Loop through all of the characters in the old code
		for (int i = 0; i < oldCode.length(); i++)
		{
			//Get the next character
			char nextChar = oldCode.charAt(i);
			
			//If we see a '-'
			if (nextChar == '-')
			{
				//If we were already processing a number, finish it (for example "54-73"
				if (isNumber)
				{
					//Convert the numString to an integer, and add it to the sum
					sum += Integer.parseInt(numString);
				}
			
				//Start a new number
				isNumber = true;
				numString = "-";
			}
			
			//If we see a digit
			else if(Character.isDigit(nextChar)){//checking if nextChar is a digit through the isDigit method
				if(isNumber){//If we were already processing a number,
					numString += nextChar;//add this digit to the numString
				}//closing if statment
				//Otherwise, start a new number
				else{//declaring else statment
					numString = "" + nextChar;//adding nextChar to the number after emptying
				}//closing else statment
				isNumber=true;//setting isNumber to true after checking for isNumber as not to
				//interfear with the check
			} else{//declaring else statment
				isNumber=false;//setting isNumber to false as we are now not processing a number
			}

			//If we were processing a number and we've finished (the character is not a number, or we're
			//at the end of the String, or we've hit a negative sign), then stop processing the number,
			//convert to an integer and add to the sum
			if(!numString.isEmpty() && (!isNumber || i==oldCode.length()-1)){//checking if we are not processing a 
			//number or ar at the end of the code and if numString is not empty as we cannot add an empty string to the sum
				sum+=Integer.parseInt(numString);
				//adding the current value of numString to sum
				numString="";
				//emptying numString as the value has been added to the sum
			}//closing if statment

			//If the character is an uppercase letter, add it to the new code
			if(Character.isUpperCase(nextChar)){//checking if nextChar is uppercase through isUpperCase method
			newCode = newCode+nextChar;//adding the nextChar to the new code
			}//closing if statment
		}//closing for loop
		
		//Append the sum to the end of the new code
		newCode=newCode+sum;
		//Return the new code
		return newCode;
		
	}
}
