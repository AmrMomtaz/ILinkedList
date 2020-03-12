package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

public class SingleLinkedList implements ILinkedList
{
	node head;
	static class node
	{
		Object value;
		node next;
		
		node(Object x){
			value = x;
			next=null;
		}
	}
	
	public void add(int index, Object element)
	{
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
	}

	public void add(Object element) {
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
	}

	public Object get(int index) {
		int i;
		node search=head;
			for(i=0;i<index;i++) {
				search=search.next;
			}
		return search.value;
	}

	public void set(int index, Object element) {
		int i;
		node loop = head;
		for(i=0; i< index ;i++) {
			loop=loop.next;
		}
		loop.value = element;
		
	}

	public void clear() {
		head = null;
		
	}

	public boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;
	}

	public void remove(int index) {
		int i;
		if(index==0) {
			head=head.next;
		}
		else {
		node delete = head;
		for(i=0;i<index-1;i++) {
			delete=delete.next;
		}
		delete.next=delete.next.next;
		}
	}

	public int size() {
		int count=0;
		node counter = head;
		while(counter!=null) {
			count++;
			counter=counter.next;
		}
		return count;
	}

	public ILinkedList sublist(int fromIndex, int toIndex) {
		//NOT DONE YET 
		return null;
	}

	public boolean contains(Object o) 
	{
		node search = head;
		while(search!=null) {
			if(search.value == o)
				return true;
			search = search.next;
		}
		return false;
	}
	public static void main(String[] args) {
		SingleLinkedList f= new SingleLinkedList();
		f.add(1);
		f.add(2);
		f.add(5);
		f.remove(2);
		f.add('h');
		System.out.print("[");
		for(int i=0; i<2;i++) {
			System.out.print(f.get(i)+" ,");
		}
		System.out.print(f.get(2)+"]");
	}
}