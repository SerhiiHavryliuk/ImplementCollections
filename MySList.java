package sergik;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public interface MySList extends Iterable<Integer>
{
	public void clear();
	public void print();
	public int  size();
	public void init(int[] ar);
	public int[] toArray();
	
	public void addStart(int val); 
	public void addEnd(int val) ;	
	public void addPos(int valIndex, int val) ;
	public void delStart() ;
	public void delPos(int val);
	public void delEnd();	
	public int getMax(); 
	public int getMin() ;
	public void setPos(int posIndex, int val);
	public int getPos(int val);
	
	public int[] bubbleSort();
	public  void insertionSort();
	public  void selectionSort ();
	public  void qSort(int l ,int r);
	public  void ShellSort();
	public  void heapSort();
	public int[] mergeSort(int array[]);
	
	public void writeCSV(String fileName) throws FileNotFoundException;
	public void readCSV(String fileName) throws IOException;
	
	void writeXML(String fileName) throws FileNotFoundException;
	void readXML() throws FileNotFoundException;
	Iterator<Integer> iterator();	
}