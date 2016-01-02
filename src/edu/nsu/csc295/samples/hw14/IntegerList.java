package edu.nsu.csc295.samples.hw14;

// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create and fill
// a list of integers.
//          
// ****************************************************************

public class IntegerList
{
    int[] list; //values in the list
    int numElements; //number of elements actually in the list

    //-------------------------------------------------------
    //create a list of the given size
    //-------------------------------------------------------
    public IntegerList(int size)
    {
	list = new int[size];
    }


    //-------------------------------------------------------
    //fill array with integers between 1 and 100, inclusive
    //-------------------------------------------------------
    public void randomize()
    {
	for (int i=0; i<list.length; i++)
	    list[i] = (int)(Math.random() * 100) + 1;
	numElements = list.length;
    }


    //-------------------------------------------------------
    //print array elements with indices
    //-------------------------------------------------------
    public void print()
    {
	for (int i=0; i < numElements; i++)
	    System.out.println(i + ":\t" + list[i]);
    }


    //--------------------------------------------------------------
    // Doubles the size of the list.
    //--------------------------------------------------------------
    private void increaseSize()
    {
	int[] temp = new int[list.length * 2];

	for (int i = 0; i < list.length; i++)
	    temp[i] = list[i];

	list = temp;
    }

    //--------------------------------------------------------------
    // Adds an element to the list.  If the array is full its size
    // is doubled first.
    //--------------------------------------------------------------
    public void addElement(int newVal)
    {
	if (numElements == list.length)
	    increaseSize();
	list[numElements] = newVal;
	numElements++;
    }

    //---------------------------------------------------------------
    // Removes the first occurrence of newVal from the list.
    //---------------------------------------------------------------
    public void removeFirst(int newVal)
    {
	// find the first instance of the element
	boolean found = false;
	int location = 0;
	while (location < list.length && !found)
	    if (list[location] == newVal)
		found = true;
	    else
		location++;


	if (found)
	    {
		//move all elements after location up one spot
		for (int i = location; i < numElements-1; i++)
		    list[i] = list[i+1];
		numElements--;
	    }
    }

    //-------------------------------------------------------------
    //  Removes all occurrences of newVal from the list.
    //-------------------------------------------------------------
    public void removeAll(int newVal)
    {
	int i = 0; 
	while (i < numElements)
	    {
		if (list[i] == newVal)
		    {
			for (int j = i; j < numElements-1; j++)
			    list[j] = list[j+1];
			numElements--;
		    }
		else
		    i++;
	    }
    }
}

