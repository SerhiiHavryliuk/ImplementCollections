package sergik;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import sergik.MyLList.MyIterator;
import sergik.MyLList.Node;

public class MyLList2 implements MySList
{
	//Node root = null; // ссылка на начало листа
	int len = 0; // размер листа
	Node front = null; // указывает нп начало списка
	Node rear = null;// указывает нп конец списка

	class Node
	{
		Node next;
		Node prev;
		int data;
		public Node(int val)
		{
			this.data = val;
		}
	}

	//@Override
	public void clear()
	{
		front = null;
		rear= null;
		len = 0;
	}

	public void init(int[] ar)
	{

		for (int i = ar.length-1; i >= 0; i--) 
		{
			addStart(ar[i]);			
		}
	}

	public int[] toArray()
	{
		int[] tmp = new int[size()];
		Node pp = front;
		int i = 0;
		while (pp != null) 
		{
			tmp[i++] = pp.data;
			pp = pp.next;
		}
		return tmp;
	}

	private void checkElementIndex(int posIndex) 
	{	          	 
		if (posIndex>len || posIndex < 0)
			throw new ArrayIndexOutOfBoundsException();
	}
	private void check_len() 
	{	          	 
		if (len  == 0)
			throw new ArrayIndexOutOfBoundsException();
	}

	///////////////////////////////////////////////////////
	////// size
	//////////////////////////////////////////////////////
	public int size()
	{
		return len;
	}

	///////////////////////////////////////////////////////
	////// print
	//////////////////////////////////////////////////////
	public void print()
	{
		Node tmp = front;
		while(tmp!=null)
		{
			System.out.print(tmp.data + ", ");
			tmp = tmp.next;
		}
	}
	///////////////////////////////////////////////////////
	////// addStart
	//////////////////////////////////////////////////////
	public void addStart(int val)
	{
		Node p = new Node(val);
		if(front == null)
		{
			front = p;
			rear = p;
		}
		else
		{
			p.next = front;
			//front.prev = p;
			front = p;
		}
		len++;
	}

	///////////////////////////////////////////////////////
	////// addEnd
	//////////////////////////////////////////////////////
	public void addEnd(int val)
	{
		Node p = new Node(val);
		if(rear == null)
		{
			front = p;
			rear = p;
		}
		else
		{
			Node tmp = rear;
			while(tmp.next != null)
			{
				tmp = tmp.next;
			}
			rear = tmp;
			tmp.next = p;
			p.prev = rear;
			rear = p;
		}
		len++;

	}

	///////////////////////////////////////////////////////
	////// addPos
	//////////////////////////////////////////////////////
	public void addPos(int posIndex, int val)
	{
		checkElementIndex(posIndex);
		Node p = new Node(val);
		Node tmp = front;
		int i = 0;

		if(posIndex == 0)
		{
			addStart(val);
		}
		else
		{										
			while(tmp.next != null)
			{
				tmp = tmp.next;
				i++;
				if(i == posIndex-1)break;
			}			
			//			tmp = p;
			//			p.next = tmp.next;

			p.next = tmp.next;
			tmp.next = p;			
		}
		len++;
	}

	///////////////////////////////////////////////////////
	////// delStart
	//////////////////////////////////////////////////////
	public void delStart()
	{
		check_len();
		Node tmp = front;
		front = tmp.next;
		tmp = null;
		len--;
		//		if(front == null) // реализация Вадима
		//		{
		//			tmp.prev = null;
		//			tmp = null;
		//
		//		}
	}

	///////////////////////////////////////////////////////
	////// delEnd
	//////////////////////////////////////////////////////
	public void delEnd()
	{
		check_len();
		Node tmp = front;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			if(tmp.next.next == null)
			{
				rear = tmp.prev;
				tmp.next = null;
			}
		}
		len--;
	}
	///////////////////////////////////////////////////////
	////// delPos
	//////////////////////////////////////////////////////
	public void delPos(int posIndex)
	{
		checkElementIndex(posIndex);
		check_len();
		Node tmp =  front;
		int i = 0;
		if(posIndex == 0)
		{
			delStart();
		}
		else
		{										
			while(tmp.next != null)
			{
				tmp = tmp.next;
				tmp.next.prev = tmp;
				i++;
				if(i == posIndex-1)break;
			}				
			tmp.next = tmp.next.next;
			tmp = null;								
		}
		len--;
	}

	///////////////////////////////////////////////////////
	////// getMax
	//////////////////////////////////////////////////////
	public int getMax()
	{		
		check_len();
		Node tmp = front;
		int dataMax = tmp.data;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			if(tmp.data > dataMax)
			{
				dataMax = tmp.data;
			}
		}		
		return dataMax;
	}

	///////////////////////////////////////////////////////
	////// getMin
	//////////////////////////////////////////////////////
	public int getMin()
	{		
		check_len();
		Node tmp = front;
		int dataMin = tmp.data;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			if(tmp.data < dataMin)
			{
				dataMin = tmp.data;
			}
		}		
		return dataMin;
	}

	///////////////////////////////////////////////////////
	//////setPos
	//////////////////////////////////////////////////////
	public void setPos(int posIndex, int  val)
	{
		checkElementIndex(posIndex);
		Node p = new Node(val);
		Node tmp = front;
		int i = 0;
		while(tmp != null)
		{
			tmp = tmp.next;
			i++;
			if(i == posIndex-1)
			{
				p.next = tmp.next.next;
				tmp.next = p;
				p.prev = tmp.next;
			}
		}
	}

	///////////////////////////////////////////////////////
	//////setPos
	//////////////////////////////////////////////////////
	public int getPos(int posIndex)
	{		
		checkElementIndex(posIndex);
		int res  = 0;
		Node tmp = front;
		int i = 0;
		while(tmp != null)
		{
			tmp = tmp.next;
			i++;
			if(i == posIndex)
			{				
				res = tmp.data;
			}
		}
		return res;
	}

	@Override
	public int[] bubbleSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertionSort() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionSort() {
		// TODO Auto-generated method stub

	}

	@Override
	public void qSort(int l, int r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ShellSort() {
		// TODO Auto-generated method stub

	}

	@Override
	public void heapSort() {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] mergeSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeCSV(String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readCSV(String fileName) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeXML(String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readXML() throws FileNotFoundException {
		// TODO Auto-generated method stub

	}


	/////////////////////////////////////////////////
	////////  iterator
	/////////////////////////////////////////////////
	public Iterator<Integer> iterator() 
	{
		MyIterator tmp = new MyIterator(front, len);
		return tmp;
	}
	public class MyIterator implements Iterator<Integer>
	{
		//private int[] array = null;
		//private Node tmp = null;
		private int pos = 0;
		private int limit = 0;
		public MyIterator(Node root, int len)
		{
			//tmp = root;							
			limit = len;
		}
		@Override
		public boolean hasNext() 
		{			
			return pos < limit;
		}

		@Override
		public Integer next() 
		{
			int res = 0;
			int i = 0;
			if(pos >= limit)
				throw new NoSuchElementException();
			//return array[start + pos++];
			//pos++;
			//arrayRoot = arrayRoot.next;

			Node tmp = front;
			while(tmp != null)
			{
				if(i == pos)
				{						
					res = tmp.data;
				}
				tmp = tmp.next;
				i++;
			}
			pos++;
			return res;

		}
		@Override
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}	
	}

}