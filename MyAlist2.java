package sergik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.StringTokenizer;

import sergik.MyAlist1.MyIterator;

public class MyAlist2 implements MySList
{
	int ar[] = new int[100];
	int start = 49;
	int end = 49;
	int index = 0;

	// конструктор(пустой)
	public MyAlist2() {}

	// конструктор
	public MyAlist2(int[] ar)
	{
		init(ar);
	}

	public void init(int[] ar)
	{
		for (int i = 0; i < ar.length; i++) 
		{
			this.ar[start+i] = ar[i];			
		}
		index = ar.length;
	}

	// копирование массива
	public int[] toArray()
	{
		int[] tmp = new int[index];
		for (int i = 0; i < index; i++) 
		{
			tmp[i] = this.ar[start+i];
		}
		return tmp;
	}

	@Override
	public void clear() 
	{
		index = 0;
	}

	//===========================================
	//addStart
	//===========================================

	public void addStart(int val) 
	{
		//System.out.println(start);
		if(index==0)
		{
			ar[start]=val;
			index++;
		}
		else
		{
			start--;
			ar[start] = val;

			index++;
			for (int i = 0; i < ar.length; i++) {
				//System.out.print(ar[i] + " "+i+"/");
			}
		}
	}
	//===========================================
	//addEnd
	//===========================================
	public void addEnd(int val) 
	{
		//System.out.println(start);
		if(index==0)
		{
			ar[start]=val;
			index++;
		}
		else
		{			
			ar[start+index] = val;			
			index++;
		}		
	}
	//===========================================
	//print
	//===========================================
	public void print()
	{
		for (int i = start; i < start+index; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}
	//===========================================
	//addPos
	//===========================================

	public void addPos(int valIndex, int val) 
	{			
		for (int i = start+index; i >= start+valIndex; i--)
		{
			if(i==start+valIndex)
			{
				ar[i] = val;
				index++;
			}
			else
			{
				ar[i] = ar[i-1];
			}
		}	
	}
	//===========================================
	//delStart
	//===========================================
	public void delStart() 
	{
		if (index==0)
			throw new ArrayIndexOutOfBoundsException();
		++ start;
		index--;
	}

	//===========================================
	//delEnd
	//===========================================
	public void delEnd() 
	{
		if (index==0)
			throw new ArrayIndexOutOfBoundsException();
		-- end;
		index--;
	}
	//===========================================
	//delPos
	//===========================================
	public void delPos(int val)
	{
		if (val>=index || index==0 ||  val<0)
			throw new ArrayIndexOutOfBoundsException();
		for (int i = start + val; i <= start+index; i++) 
		{
			ar[i] = ar[i+1];
		}
		index--;
		end--;
	}

	//===========================================
	//size
	//===========================================
	public int size() 
	{
		return index;		
	}

	//===========================================
	//getMax
	//===========================================
	public int getMax() 
	{
		if (index==0)
			throw new ArrayIndexOutOfBoundsException();
		int max = ar[0];
		for (int i = start; i <= start + index; i++) 
		{
			if(ar[i] > max)
			{
				max = ar[i];
			}	
		}
		return max;
	}

	//===========================================
	//getMin
	//===========================================
	public int getMin() 
	{
		if (index==0)
			throw new ArrayIndexOutOfBoundsException();
		int min = ar[start];
		for (int i = start; i < start + index; i++) 
		{
			if (ar[i] < min) 
			{
				min = ar[i];
			}
		}
		return min;
	}

	//===========================================
	//setPos
	//===========================================
	public void setPos(int posIndex, int val)
	{
		if (index==0 || posIndex>index || posIndex<0)
			throw new ArrayIndexOutOfBoundsException();
		ar[posIndex + start]=val;
	}

	//===========================================
	//getPos
	//===========================================
	public int getPos(int val)
	{
		if (index==0)
			throw new ArrayIndexOutOfBoundsException();
		int res = 0;
		int res1 = 0;
		for (int i = start; i < start + index; i++)

		{
			if (ar[i]==val)
			{
				res = i;
				if (res==0)
					res1++;
			}
		}
		if (res1==res)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return res - start;
	}

	//===========================================
	//BubbleSort сортировка пузырьком
	//===========================================
	public int[] bubbleSort() 
	{
		int t;
		//алгоритм пузырьковой сортировки
		for (int a = start; a < start + index; a++) 
		{
			for (int b = (start + index)-1; b > a; b--) 
			{
				if (ar[b - 1] > ar[b]) 
				{
					t = ar[b - 1];
					ar[b - 1] = ar[b];
					ar[b] = t;
				}
			}
		}
		return ar;
	}
	//===========================================
	//InsertionSort  сортировки вставками
	//===========================================

	public  void insertionSort() 
	{
		int t;
		int i, j;
		for (i = start; i < index + start; i++) 
		{
			t = ar[i];
			for (j = i - 1; j >= 1 && ar[j] > t; j--)
				ar[j + 1] = ar[j];

			ar[j + 1] = t;
		}
	}
	//===========================================
	//SelectionSort  сортировки выбором
	//===========================================
	public  void selectionSort ()
	{
		int min, temp;

		for (int i = start; i < index + start; i++)
		{
			min = i;
			for (int scan = i+1; scan < index + start; scan++)
				if (ar[scan] < ar[min])
					min = scan;

			// Swap the values
			temp = ar[min];
			ar[min] = ar[i];
			ar[i] = temp;
		}
	}
	//===========================================
	//qSort  быстра€ сортировка
	//===========================================

	public  void qSort(int l ,int r) 
	{
		int i = l;
		int j = r;
		Random rand = new Random();
		int x = ar[l + rand.nextInt(r - l + 1)];
		while (i <= j) 
		{
			while (ar[i+ start] < x) 
			{
				i++;
			}
			while (ar[j] > x) 
			{
				j--;
			}
			if (i <= j) 
			{
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
				i++;
				j--;
			}
		}
		if (l<j)
		{
			qSort( l, j);
		}
		if(i<r)
		{
			qSort(i, r);
		}
	}

	//===========================================
	//ShellSort сортировка Ўелла
	//===========================================

	public  void ShellSort() 
	{
		int step = index / 2;//инициализируем шаг.
		while (step > 0)//пока шаг не 0
		{
			for (int i = start; i < (index+ start - step); i++)
			{
				int j = i;
				//будем идти начина€ с i-го элемента
				while (j >= 0 && ar[j] > ar[j + step])
					//пока не пришли к началу массива
					//и пока рассматриваемый элемент больше
					//чем элемент наход€щийс€ на рассто€нии шага
				{
					//мен€ем их местами
					int temp = ar[j];
					ar[j] = ar[j + step];
					ar[j + step] = temp;
					j--; 
				}
			}
			step = step / 2;//уменьшаем шаг
		}    
	}

	//===========================================
	//HeapSort сортировка кучей
	//===========================================

	public  void heapify(int[] ar, int size, int pos) 
	{    
		while (2 * pos + 1 < size) 
		{                       							//ѕроцедура нормализации 
			int t = 2 * pos + 1;                           //подкучи в куче с  
			//головой в pos
			if (2 * pos + 2 < size && ar[2 * pos + 1] < ar[2 * pos + 2])
			{
				t = 2 * pos + 2;
			}
			if (ar[pos] < ar[t]) 
			{
				swap(ar, pos, t);
				pos = t;
			} 
			else 
			{
				break;
			}
		}
	}


	public  int[] heapMake(int[] ar) 
	{  										//ѕостроение кучи из массива при 
		int n = index;                    //помощи функции heapify  
		for (int i = n - 1; i >= 0; i--) 
		{
			heapify(ar, n, i);
		}
		return ar;
	}

	public  void heapSort() 
	{ 								//—обственно сама сортировка
		int n = index;
		heapMake(ar);
		while (n > 0) {
			swap(ar, 0, n - 1);
			n--;
			heapify(ar, n, 0);
		}

	}

	private void swap(int[] ar, int i, int j)
	{          											//ћен€ет местами 
		int temp = ar[i];                                //элементы с   
		ar[i] = ar[j];                                   //индексами i и j
		ar[j] = temp;                                    //в массиве array
	}
	//===========================================
	//mergeSort сортировка сли€нием
	//===========================================
	public int[] mergeSort(int array[])	
	{		
		if(array.length > 1)
		{
			int elementsInA1 = array.length / 2;			
			int elementsInA2 = array.length - elementsInA1;			
			int arr1[] = new int[elementsInA1];
			int arr2[] = new int[elementsInA2];			
			for(int i = 0; i < elementsInA1; i++)
			{
				arr1[i] = array[i];		
			}
			for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
			{
				arr2[i - elementsInA1] = array[i];		
			}
			arr1 = mergeSort(arr1);
			arr2 = mergeSort(arr2);
			int i = 0, j = 0, k = 0;

			while(arr1.length != j && arr2.length != k)
			{
				if(arr1[j] < arr2[k])
				{
					array[i] = arr1[j];
					i++;
					j++;
				}				
				else
				{					
					array[i] = arr2[k];					
					i++;					
					k++;
				}
			}			
			while(arr1.length != j)
			{
				array[i] = arr1[j];
				i++;
				j++;
			}
			while(arr2.length != k)
			{
				array[i] = arr2[k];
				i++;
				k++;
			}
		}
		return array;
	}
	//===========================================
	//запись и чтение файла CSV
	//===========================================

	@Override
	public void writeCSV(String fileName) throws FileNotFoundException 
	{
		File ff = new File(fileName);
		PrintWriter out = new PrintWriter(ff);
		out.print( this.toCSV() );
		out.close();
	}
	@Override
	public void readCSV(String fileName) throws IOException 
	{
		File ff = new File(fileName);
		BufferedReader in = new BufferedReader(new FileReader(ff));
		String str = in.readLine();
		in.close();
		fromCSV(str);
	}

	private String toCSV() 
	{
		String str = "";
		for (int i = start; i <start + index; i++) 
		{
			str += ar[i] + ",";
		}
		return str;
	}
	private void fromCSV( String str) 
	{
		this.clear();
		StringTokenizer stt = new StringTokenizer(str, ",");
		while(stt.hasMoreTokens())
		{
			this.addEnd(Integer.parseInt(stt.nextToken()));
		}
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
		MyIterator tmp = new MyIterator(ar, index);
		return tmp;
	}
	public class MyIterator implements Iterator<Integer>
	{
		private int[] array = null;
		private int pos = 0;
		private int limit = 0;
		public MyIterator(int[] arr, int index)
		{
			array = arr;
			limit = index;
		}
		@Override
		public boolean hasNext() 
		{
			return pos < limit;
		}

		@Override
		public Integer next() 
		{
			if(pos >= limit)
				throw new NoSuchElementException();
			return array[start + pos++];
		}
		@Override
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}	
	}
	
}