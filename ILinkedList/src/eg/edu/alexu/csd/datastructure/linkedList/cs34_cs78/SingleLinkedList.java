package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

public class SingleLinkedList implements ILinkedList
{
	node head;
	int size;
	static class node
	{
		Object value;
		node next;
		
		node(Object x)
		{
			value = x;
			next=null;
		}
	}
	
	public void add(int index, Object element)
	{
		if (index>size)throw new IllegalArgumentException("The index is out of bounds");
			int i;
			node insert = new node(element);
			node loop   = head;
			if(index==0) 
			{
				node temp = head;
				head = insert;
				insert.next=temp;
			}
			else 
			{
				for(i=0; i< index-1 ;i++) 
				{
					loop=loop.next;
				}
				node temp = loop.next;
				loop.next = insert;
				insert.next = temp;
			}
			size++;
	}

	public void add(Object element) 
	{
		node newNode = new node(element);
		if(head==null) {
			head = newNode;
		}
		else {
			node last = head;
			while(last.next!=null) {
				last=last.next;
			}
			last.next= newNode;
		}
		size++;
	}

	public Object get(int index) 
	{
		if (index>size)throw new IllegalArgumentException("The index is out of bounds");
		int i;
		node search=head;
		for(i=0;i<index;i++) 
		{
			search=search.next;
		}
		return search.value;
	}

	public void set(int index, Object element)
	{
		if (index>size)throw new IllegalArgumentException("The index is out of bounds");
		int i;
		node loop = head;
		for(i=0; i< index ;i++) {
			loop=loop.next;
		}
		loop.value = element;
	}

	public void clear() 
	{
		head = null;
		size = 0;
	}

	public boolean isEmpty() 
	{
		return (head==null);
	}

	public void remove(int index) 
	{
		if (index>size)throw new IllegalArgumentException("The index is out of bounds");
		int i;
		if(index==0) 
		{
			head=head.next;
		}
		else 
		{
			node delete = head;
			for(i=0;i<index-1;i++) 
			{
				delete=delete.next;
			}
			delete.next=delete.next.next;
		}
		size--;
	}

	public int size() 
	{
		return size;
	}

	public SingleLinkedList sublist(int fromIndex, int toIndex) 
	{
		if (toIndex >=size)throw new IllegalArgumentException("The index is out of bounds");
		SingleLinkedList sub = new SingleLinkedList();
		for (int i = fromIndex ; i <=toIndex;i++)
		{
			Object element = this.get(i);
			sub.add(element);
		}
		return sub;
	}

	public boolean contains(Object o) 
	{
		node search = head;
		while(search!=null) 
		{
			if(search.value == o)
				return true;
			search = search.next;
		}
		return false;
	}
}