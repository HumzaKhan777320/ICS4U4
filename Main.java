package ICS4U4;

public class Main{

	public static void main(String[] args){

		//Create an array of people:
		Person[] people = new Person[] {
				new Person("Adam", 15),
				new Person("Becky", 26),
				new Person("Carter", 5),
				new Person("Davis", 42),
				new Person("Everly", 16),
				new Person("Francis", 18),
				new Person("Grant", 27)
		};

		//Sort the people by age using QuickSort or MergeSort
		quickSort(people);
		mergeSort(people);

		//Show the list of people
		display(people);
	}

	//quick sort an array of people by age
	public static void quickSort(Person[] people)
	{
		quickSort(people, 0, people.length-1);
	}

	//This is the actual recursive part of the quickSort
	//It sorts the part of the array from startIndex to endIndex (inclusive)
	private static void quickSort(Person[] people, int startIndex, int endIndex)
	{
		//BASE CASE:  If the length of the array is 1 or less, it's already sorted
		if (startIndex >= endIndex){//checking to see that the start index isnt bigger than the end index
		//indicating the sorting is done
            return;//returning nothing as it is a void function but ending the function all the same
        }
		//RECURSIVE STEP:
		//Choose a pivot
		int pvt_location = (startIndex+endIndex)/2;//calulating the index of the pivot in the people array
        int pvtAge = people[pvt_location].age;//storing the age value of the pivot in int variable pvtAge
		//Move all values less than the pivot to the left of the pivot, and values more
		//than the pivot to the right
		int left = startIndex;//storing the startIndex in int variable left to be incremented to move through the array
		int right = endIndex;//storing the endIndex in int variable right to be reduced to move through the array

		while(left<=right){//going through the array while left is still on the left side of the array
		//and right on right
            while(people[left].age<pvtAge){//moving left along the array untill an age bigger than
			//the pivot is found
                left++;//adding to left along the way to move forward
        	}
			while(people[right].age>pvtAge){//moving right along the array untill an age smaller than
			//the pivot is found
				right--;//subtracting from right along the way to move backwards
			}
            if(left<=right){//checking that left is still less than right
				//swapping the 2 people out of order
                Person temp = people[left];
                people[left] = people[right];
                people[right] = temp;
                left++;//adding to left as there could be more people on the left side 
				//who should be on the right
				right--;//subtracting from right as there could be more people on the right side 
				//who should be on the left
            }
        }
		//quickSort the values left of the pivot (recursive)
		quickSort(people,startIndex,right);
		//quickSort the values right of the pivot (recursive)
		quickSort(people,left,endIndex);
	}

	//output all of the people in the array; show their name and age
	public static void display(Person[] people)
	{
		for(int i=0; i<people.length; i++){
			System.out.println(people[i].name + " - Age: " + people[i].age);
		}
	}

	
	//You can also use MergeSort if you wish:
	public static void mergeSort(Person[] people)
	{
		mergeSort(people, 0, people.length-1);
	}
	
	//This is the actual recursive part of the mergeSort
	private static void mergeSort(Person[] people, int startIndex, int endIndex)
	{
		//BASE CASE:  If the length of the array is 1 or less, it's already sorted
		if (startIndex >= endIndex){//checking to see that the start index isnt bigger than the end index
		//indicating the sorting is done
            return;//returning nothing as it is a void function but ending the function all the same
        }
		//RECURSIVE STEP:
		//Find the midpoint of this part of the array
		 int mid = (startIndex+endIndex)/2;//calculating the middle of the array
		//mergeSort the left half (recursive)
		mergeSort(people,startIndex,mid);
		//mergeSort the right half (recursive)
		mergeSort(people,mid+1,endIndex);//strarting with mid+1 as to not have duplicates of the midth index
		//merge the two halves together
		merge(people, startIndex, endIndex);
		//Done!
	}
	
	//Merge together two sorted
	private static void merge(Person[] people, int startIndex, int endIndex)
	{
		//Create a temporary array, with enough space to hold everything from startIndex to
		//endIndex
		Person[] tempArray = new Person[endIndex-startIndex+1];//calculating space based on start and end index
		//Walk through the two halves of this section of the array, always copying the smaller
		//value into our temporary array
		
		int mid = (startIndex+endIndex)/2;//calculating the middle of the array and storing in mid
		int left = startIndex;//creating an int variable left for going through the left side of the array
		int right = mid+1;//creating an int variable right for going through the right side of the array
		int index=0;//creating an int variable index for tracking the index to copy to in the temporary array

		while(left<=mid && right<=endIndex){//declaring a while loop that runs while there are values in both 
		//sides of the array
			if(people[left].age <= people[right].age){//checking to see if the current index on the left side
			//has a smaller age than the right
				tempArray[index]=people[left];//copying the left index to the tempArray array
				index++;//adding to index as the curent index has been filled
				left++;//incrementing left as the left index has been copied
			} else{
				tempArray[index]=people[right];//copying the right index to the tempArray array
				index++;//adding to index as the curent index has been filled
				right++;//incrementing right as the right index has been copied
			}
    	}

		//Copying the remaning parts of the left half to the tempArray array
		while(left<=mid){//going through anything left in the left side of the array
			tempArray[index] = people[left];//copying the left index to tempArray
			index++;//adding to index as the curent index has been filled
			left++;//incrementing left as the left index has been copied
		}
		//Copying the remaning parts of the right half to the tempArray array
		while(right<=endIndex){//going through anything left in the right side of the array
			tempArray[index] = people[right];//copying the right index to the tempArray array
			index++;//adding to index as the curent index has been filled
			right++;//incrementing right as the right index has been copied
		}
		//Finally, copy the contents of the temporary array back into the main array
		for(int i=0;i<tempArray.length;i++){//declaing a for loop that runs through tempArray
        	people[startIndex+i] = tempArray[i];//copying every index of the temparray to the people array after the startIndex
    }
	}
}
