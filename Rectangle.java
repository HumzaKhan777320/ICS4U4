/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: CLASSWORK - Rectangle Intersection
03/30/2025
*/


public class Rectangle {

	//Fields for the location and size of the rectangle
	
	//Top-left corner of the rectangle is at (x, y)
	private int x;
	private int y;
	private int width;
	private int height;
	
	//Constructor
	public Rectangle(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	
	/**
	 * Find the intersection of two Rectangles
	 * 
	 * Returns a new Rectangle, representing the region of intersection
	 * of two Rectangles.  Note that the area of the returned rectangle may be 0
	 * 
	 * @param r1  The first Rectangle
	 * @param r2  The second Rectangle
	 * @return    The region of intersection.  May have an area of zero, but will never by null.
	 */
	public static Rectangle intersect(Rectangle r1, Rectangle r2)
	{
		/*
		 * If two rectangles intersect, then the intersection is always a rectangle.
		 * The left side of the intersection is the same as the left side of one of the rectangles (whichever is further right)
		 * The right side is the same as the right side of the one of the rectangles (whichever is further left)
		 */
		
		//Find the left, right, top and bottom boundaries of the region of intersection
		int left = Math.max(r1.getLeft(), r2.getLeft());
		int right = Math.min(r1.getRight(), r2.getRight());
		/*
		 * YOU NEED TO COMPLETE THE FOLLOWING TO GET THIS TO WORK
		 */
		
		//Do the same for the top and bottom of the intersecting region
		int top = Math.max(r1.getTop(), r2.getTop());//Calculating the top coordinate/side of the new rectangle by
		//finding the maximum of the top edges of r1 and r2 since the y-coordinate increases as it goes down 
		int bottom = Math.min(r1.getBottom(), r2.getBottom());//Calculating the bottom coordinate/side of the new 
		//rectangle by finding the minimum of the bottom edges of r1 and r2 
		//since the y-coordinate decreases as it goes up 

		//Calculate the width and height of the new Rectangle
		int width=right-left;//calculating the width by subtracting left form right as
		//the width is the diference between the right most and left most sides and since
		//the x coordinates get bigger to the right right is bigger than left
		int height=bottom-top;//calculating the height by subtracting top form bottom as
		//the height is the diference between the top most and bottom most sides and since
		//the y coordinates get bigger to the bottom bottom is bigger than top

		//Make sure the width and height are not negative (if they are, make them zero)
		if (width < 0) {//checking if the width is less than 0
        	width = 0;//setting the width to 0 to avoid a negative area
    	}//closing if statment
		if (height < 0) {//checking if the height is less than 0
			height = 0;//setting the height to 0 to avoid a negative area
		}//colsing if statment

		//Return the new Rectangle
		return new Rectangle (left,top,width,height); //CHANGE THIS; right now it always returns an empty Rectangle
		//returning a new rectangle object of the intersect rectangle with (left,top) as
		//the top left point and the width and height as their respective values to 
		//calculate the area of the intersect rectangle through the area method
	}
	
	//usually I would use a method similar to the one you used for this problem
	//but when presented with the challenge of an alternate solution I came
	//up with a brute force method that goes through the r1 rectangle and checks
	//if each point is also present in the r2 rectangle and increments a counter
	//variable acordingly
	public static int brute_force(Rectangle r1, Rectangle r2){
		int counter=0;
		for (int i = r1.getLeft(); i < r1.getRight(); i++) {
		//goes through r1 from left to right
            for (int j = r1.getTop(); j < r1.getBottom(); j++) {
			//goes through r1 from top to bottom
                if (i >= r2.getLeft() && i < r2.getRight() && j >= r2.getTop() && j < r2.getBottom()) {
				// Check if the point is also within `other` rectangle
                    counter++;
                }
            }
        }
		return counter;
	}
	//to impliment my solution in the given main file I simply replaced the inter.area() part of the 
	//print statment with Rectangle.brute_force(r1,r2) here r1 and r2 can be rect1-rect6 and it produces
	//the desired output for all 3 cases. 


	/**
	 * Calculate the area of the Rectangle.
	 * 
	 * This method returns the area of this rectangle object.
	 * 
	 * @return The area of this Rectangle
	 */
	public int area()
	{
		return this.width*this.height;
	}
	


	
	//Get the value of x 
	public int geX()
	{
		return this.x;
	}

	//Get the value of y
	public int getY()
	{
		return this.y;
	}
	
	//Get the width of the rectangle
	public int getWidth()
	{
		return this.width;
	}
	
	//Get the height of the rectangle
	public int getHeight()
	{
		return this.height;
	}

	//Get the x-coordinate of the left side of the rectangle
	public int getLeft()
	{
		return this.x;
	}
	
	//Get the x-coordinate of the right side of the rectangle
	public int getRight()
	{
		return this.x + this.width;
	}
	
	//Get the y-coordinate of the top of the rectangle
	public int getTop()
	{
		return this.y;
	}
	
	//Get the y-coordinate of the bottom of the rectangle
	public int getBottom()
	{
		return this.y + this.height;
	}

}
