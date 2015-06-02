package sergik;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;


import sergik.MyAlist2.MyIterator;

public class MyLList implements MySList
{	
	class Node
	{
		Node next;
		int data;
		public Node(int val)
		{			
			this.data = val;
		}
	}

	Node root = null; // ссылка на начало листа
	int len = 0; // размер листа

	@Override
	public void clear()
	{
		root = null;
		len=0;
	}
	@Override
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
		Node pp = root;
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
		Node tmp = root;
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
		p.next = root;
		root = p;
		len++;
	}

	///////////////////////////////////////////////////////
	////// addEnd
	//////////////////////////////////////////////////////
	public void addEnd(int val)
	{
		Node p = new Node(val);
		if(root == null)
		{
			root = p;
		}
		else
		{
			Node tmp = root;
			while(tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.next = p;
		}
		len++;
	}
	///////////////////////////////////////////////////////
	//////addPos
	//////////////////////////////////////////////////////
	public void addPos(int posIndex, int val)
	{
		checkElementIndex(posIndex);
		if(posIndex == 0)
		{
			addStart(val);
		}
		else
		{
			Node tmp = root;
			int i = 0;
			while(tmp.next != null)
			{
				tmp = tmp.next;
				i++;
				if(i==posIndex-1) break;
			}
			Node p = new Node(val);
			p.next = tmp.next;
			tmp.next = p;
			len++;
		}
	}
	///////////////////////////////////////////////////////
	//////delStart
	//////////////////////////////////////////////////////
	public void delStart()
	{
		check_len();
		Node tmp = root;
		root = tmp.next;
		len--;
	}

	///////////////////////////////////////////////////////
	//////delEnd
	//////////////////////////////////////////////////////
	public void delEnd()
	{
		Node tmp = root;

		while(tmp!=null)
		{

			if(tmp.next.next==null)
			{
				//System.out.println("null");
				tmp.next = null;
			}
			tmp = tmp.next;
			len--;
		}	
	}

	///////////////////////////////////////////////////////
	//////delPos
	//////////////////////////////////////////////////////
	public void delPos(int posIndex)
	{
		checkElementIndex(posIndex);
		check_len();
		Node tmp = root;
		int i = 0;
		while(tmp != null)
		{
			if(i == posIndex-1)
			{
				tmp.next = tmp.next.next;
			}
			tmp = tmp.next;
			i++;
		}
		len--;
	}
	///////////////////////////////////////////////////////
	//////getMax
	//////////////////////////////////////////////////////
	public int getMax()
	{
		check_len();
		Node tmp = root;
		int dataMax= tmp.data;
		while(tmp != null)
		{
			if(tmp.data > dataMax)
			{
				dataMax = tmp.data;
			}

			tmp = tmp.next;
		}
		return dataMax;
	}

	///////////////////////////////////////////////////////
	//////getMin
	//////////////////////////////////////////////////////
	public int getMin()
	{
		check_len();
		Node tmp = root;
		int dataMin= tmp.data;
		while(tmp != null)
		{
			if(tmp.data < dataMin)
			{
				dataMin = tmp.data;
			}
			tmp = tmp.next;
		}
		return dataMin;
	}

	///////////////////////////////////////////////////////
	//////setPos
	//////////////////////////////////////////////////////
	public void setPos(int posIndex, int  val)
	{
		checkElementIndex(posIndex);
		check_len();
		int i = 0;
		Node tmp = root;
		Node p = new Node(val);
		if(len == 1)
		{
			tmp = p;
			tmp.next = null;
		}
		else
		{

			while(tmp != null)
			{
				if(i == posIndex-1)
				{						
					p.next = tmp.next;
					tmp.next = p;
				}
				tmp = tmp.next;
				i++;
			}
		}
	}

	///////////////////////////////////////////////////////
	//////getPos
	//////////////////////////////////////////////////////
	public int getPos(int posIndex)
	{
		checkElementIndex(posIndex);
		check_len();
		int res = 0;
		int i = 0;
		Node tmp = root;
		while(tmp != null)
		{
			if(i == posIndex)
			{						
				res = tmp.data;
			}
			tmp = tmp.next;
			i++;
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
	////////  iteratorLList1
	/////////////////////////////////////////////////
	public Iterator<Integer> iterator() 
	{
		MyIterator tmp = new MyIterator(root);
		return tmp;
	}
	public class MyIterator implements Iterator<Integer>
	{
		private Node tmp = null;
	
		public MyIterator(Node root)
		{
			tmp = root;							
		}
		@Override
		public boolean hasNext() 
		{			
			return tmp != null;
		}

		@Override
		public Integer next() 
		{
			Integer val = tmp.data;
			tmp = tmp.next;
			return val;
		}
		@Override
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}	
	}

}
