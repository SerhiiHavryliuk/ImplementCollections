package sergik;

import java.io.IOException;

public class ControlList 
{
	public static void main(String[] args) throws IOException 
	{
		MyAlist2 lst1 = new MyAlist2();
		lst1.addStart(6);
		lst1.addStart(5);
		lst1.addStart(4);
		lst1.addStart(3);
		lst1.addStart(2);
		lst1.addStart(1);
		lst1.addEnd(7);
		lst1.addStart(10);
		lst1.writeCSV("D:\\ff.csv");
		
		MyAlist2 ll = new MyAlist2();
		ll.readCSV("D:\\ff.csv");
		ll.print();
		
		lst1.writeXML("D:\\ffxml.xml");
		lst1.print();
		
//--------------------------------------------	
		MyLList2 lst = new MyLList2();
		lst.addStart(6);
		lst.addStart(5);
		lst.addStart(4);
		lst.addStart(3);
		lst.addStart(2);
		lst.addStart(1);
		
		lst.print();
		System.out.println();
		
		lst.addEnd(10);
		lst.print();
		System.out.println();
		
		lst.addPos(2, 99);
		lst.delStart();
		lst.print();
		System.out.println();
		
		lst.delEnd();
		lst.print();
	System.out.println();
	
	lst.delPos(2);
	lst.print();
	System.out.println();
	
	System.out.println(lst.getMax());
	System.out.println(lst.getMin());
	lst.print();
	System.out.println();
		
	System.out.println(lst.getPos(1));
	System.out.println(lst.size());
	
	lst.setPos(2, 55);
	lst.print();
	System.out.println();
	
	System.out.println(lst.size());

	
//		MyLList2 lst = new MyLList2();
//		int[] ar = {123, 111, 222, 333, 444, 555, 11, 56, 78};
//		lst.init(ar);
//		//lst.print();
//		Iterator<Integer> it = lst.iterator();
//		while( it.hasNext() )
//		{
//			int tmp = it.next();
//			System.out.print(tmp + ",");
//		}
//		System.out.println();
//		
//		int[] tt = new int[lst.size()];
//		int i = 0;
//		for(Integer tmp : lst)
//		{
//			tt[i++] = tmp; 
//			System.out.print(tmp + ",");
//		}
		
		
	}
}
