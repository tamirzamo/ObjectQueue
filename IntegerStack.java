package hw8;

public class IntegerStack extends ObjectStack
{
int n;
	public IntegerStack(int n) {
		super(n);
		this.n=n;
	}

	public void push(Object element) throws StackFullException
	{
		try{
		if( element instanceof Integer)
		{
        if (top == myStack.length) throw new StackFullException("Stack's  is overflow");
        myStack = new Object[n];	
        top++;
        size++;
        myStack[top] = element;
		}
		else  throw new InputMismatchException("The element is not Intger");
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
		catch(StackFullException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println(this.toString());
		System.out.println(this.toString());
	}	
	
	public String toString()
	{
		String temp="(";
	     for (int i=0;i < top+1; i++) 
	     {
	         temp = temp + myStack[i].toString();
	        		 if(i < top)temp+= ",";
	     }
	     temp+= ")";
	     return temp;
	}
	
}
