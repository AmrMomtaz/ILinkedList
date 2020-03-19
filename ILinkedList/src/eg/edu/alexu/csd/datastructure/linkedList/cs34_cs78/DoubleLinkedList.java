package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

public class DoubleLinkedList implements ILinkedList
{
	private class DNode
	{
		Object element;
		DNode next , prev;
		private DNode(Object e, DNode p , DNode n)
		{
			element = e;
			next = n;
			prev = p;
		}
		Object get_element() { return element;}
		DNode get_prev() {return prev;}
		DNode get_next() {return next;}
		void set_element(Object e) {element = e;}
		void set_previous (DNode new_prev) {prev = new_prev;}
		void set_next (DNode new_next) {next = new_next;}
	}
	DNode header,trailer;
	int size;
	DoubleLinkedList ()
	{
		header = new DNode(null,null,null);
		trailer  = new DNode(null,header,null);
		header.set_next(trailer);
	}

	public void add(int index, Object element)
	{
		if (index == size)
		{
			add(element);
			return;
		}
		if (index>size)throw new IllegalArgumentException("The index is out of bounds");
		int i = 0;
		DNode w = header.get_next();
		while (i<=index&&w!=trailer)
		{
			if(index ==i)
			{
				DNode new_node = new DNode(element,w.get_prev(),w);
				w.get_prev().set_next(new_node);
				w.set_previous(new_node);
				size++;
				return;
			}
			i++;
			w = w.get_next();
		}
	}

	public void add(Object element)
	{
		DNode w = trailer.get_prev();
		DNode new_node = new DNode(element,w,trailer);
		w.set_next(new_node);
		trailer.set_previous(new_node);
		size++;
	}

	public Object get(int index)
	{
		if (index >=size)throw new IllegalArgumentException("The index is out of bounds");
		DNode w = header.get_next();
		for (int i = 0; i <size;i++)
		{
			if (i == index)return w.get_element();
			w = w.get_next();
		}
		return null;
	}

	public void set(int index, Object element)
	{
		if (index >=size)throw new IllegalArgumentException("The index is out of bounds");
		DNode w = header.get_next();
		for(int i = 0 ; i<=index ;i++)
		{
			if (i == index)	w.set_element(element);
			w = w.get_next();
		}
	}

	public void clear()
	{
		header.set_next(trailer);
		trailer.set_previous(header);
		size =0;
	}

	public boolean isEmpty()
	{
		return (header.next==trailer);
	}

	public void remove(int index)
	{
		if (index >=size)throw new IllegalArgumentException("The index is out of bounds");
		DNode w = header.get_next();
		for (int i = 0 ; i <= index ;i++)
		{
			if (i == index)
			{
				w.get_prev().set_next(w.get_next());
				w.get_next().set_previous(w.get_prev());
				w = new DNode(null,null,null);
				size--;
			}
			w = w.get_next();
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public DoubleLinkedList sublist(int fromIndex, int toIndex)
	{
		if (toIndex >=size)throw new IllegalArgumentException("The index is out of bounds");
		DoubleLinkedList sub = new DoubleLinkedList();
		for (int i = fromIndex ; i <=toIndex;i++)
		{
			Object element = this.get(i);
			sub.add(element);
		}
		return sub;
	}
	
	public boolean contains(Object o)
	{
		if (isEmpty())return false;
		for (int i = 0;i<size;i++)
		{
			Object ob = get(i);
			if(ob == o)return true;
		}
		return false;
	}
	
	public String DDebug()
	{
		String result = "[";
		for (int i = 0;i<size;i++)
		{
			result+=get(i).toString();
			if(i<size-1)result+=",";
		}
		result+="]";
		return result;
	}
}