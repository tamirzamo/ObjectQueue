package hw8;

import java.util.ArrayList;



public class UndoIntegerStack extends IntegerStack
{
	ArrayList<UndoIntegerStack> history=new ArrayList<UndoIntegerStack>();
	public UndoIntegerStack(int n)
	{
		super(n);
		
	}

	public void push(Object element) throws StackFullException
	{
		try{
		if( element instanceof Integer)
		{
        if (top == myStack.length-1) throw new StackFullException("Stack's  is overflow");
        UndoIntegerStack temp=new UndoIntegerStack(n);
		temp.history=this.history;
		for(int i=0;i<this.myStack.length;i++)
		{
			temp.myStack[i]=this.myStack[i];
		}
		temp.n=this.n;
		temp.size=this.size;
		temp.top=this.top;
		history.add(temp);
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
	}	
	
	
	public Object pop()
	{
		if (top == -1)return null;
		UndoIntegerStack temp=new UndoIntegerStack(n);
		temp.history=this.history;
		for(int i=0;i<this.myStack.length;i++)
		{
			temp.myStack[i]=this.myStack[i];
		}
		temp.n=this.n;
		temp.size=this.size;
		temp.top=this.top;
		history.add(temp);
        top--;
		size--;
		System.out.println(this.toString());
		return myStack[top+1];
	}	
	
	
	public void undo()
	{
		UndoIntegerStack temp=new UndoIntegerStack(n);
		for(int i=history.size();i>0;i--)
		{
			if(this.top!=history.get(i-1).top)
				{
				temp=history.remove(i-1);
				break;
				}
		}

		this.history=temp.history;
		this.myStack=temp.myStack;
		this.n=temp.n;
		this.size=temp.size;
		this.top=temp.top;
		System.out.println(this.toString());
		
     
	}
	
}
