package sergik;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MySListTest 
{

	@Parameters
	public static Collection regExValues() 
	{
		return Arrays.asList(new Object[][] 
				{{new MyAlist1()},{new MyAlist2()},{new MyLList()},{new MyLList2()} });
	}

	MySList lst = null;

	public MySListTest( MySList arg )
	{
		lst = arg;
	}

	@Before
	public void setUp()
	{
		lst.clear();

	}
	
	//=======================================
	//  size
	//=======================================	
	@Test
	public void testSize_0() 
	{

		assertEquals(0, lst.size());
	}

	@Test
	public void testSize_1()
	{

		int[] ini = {10};
		lst.init(ini);
		assertEquals(1, lst.size());
	}

	@Test
	public void testSize_2()
	{

		int[] ini = {10,20};
		lst.init(ini);
		assertEquals(2, lst.size());
	}

	@Test
	public void testSize_n()
	{

		int[] ini = {10,20,30,58,89,63,70};
		lst.init(ini);
		assertEquals(7, lst.size());
	}
	
	//=======================================
	//  addStart
	//=======================================
	@Test
	public void testAddStart_0() 
	{

		lst.addStart(10);
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}

	@Test
	public void testAddStart_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.addStart(20);
		assertEquals(2, lst.size());
		int[] exp = {20,10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddStart_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		lst.addStart(30);
		assertEquals(3, lst.size());
		int[] exp = {30,10,20};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddStart_n() 
	{

		int[] ini = {10,20,40,58,89,63,70};
		lst.init(ini);
		lst.addStart(30);
		assertEquals(8, lst.size());
		int[] exp = {30,10,20,40,58,89,63,70};
		assertArrayEquals(exp, lst.toArray());
	}
	//=======================================
	//  AddEnd
	//=======================================	
	@Test
	public void testAddEnd_0() 
	{

		lst.addEnd(10);
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddEnd_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.addEnd(20);
		assertEquals(2, lst.size());
		int[] exp = {10,20};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddEnd_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		lst.addEnd(30);
		assertEquals(3, lst.size());
		int[] exp = {10,20,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddEnd_n() 
	{

		int[] ini = {10,20,30,58,89,63};
		lst.init(ini);
		lst.addEnd(70);
		assertEquals(7, lst.size());
		int[] exp = {10,20,30,58,89,63,70};
		assertArrayEquals(exp, lst.toArray());
	}

	//=======================================
	//  addPos
	//=======================================

	@Test
	public void testaddPos_0() 
	{

		lst.addPos(0,99);
		assertEquals(1, lst.size());
		int[] exp = {99};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testaddPos_1() 
	{

		int[] ini = {30};
		lst.init(ini);
		lst.addPos(0,99);
		assertEquals(2, lst.size());
		int[] exp = {99,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testaddPos_2() 
	{

		int[] ini = {30,40};
		lst.init(ini);
		lst.addPos(1,99);
		assertEquals(3, lst.size());
		int[] exp = {30,99,40};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testaddPos_n() 
	{

		int[] ini = {40,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.addPos(2,99);
		assertEquals(9, lst.size());
		int[] exp = {40,10,99,20,30,58,89,63,70};
		assertArrayEquals(exp, lst.toArray());
	}
	//=======================================
	//  delStart
	//=======================================
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testdelStart_0() 
	{

		lst.delStart();
	}
	@Test
	public void testdelStart_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.delStart();
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testdelStart_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		lst.delStart();
		assertEquals(1, lst.size());
		int[] exp = {20};
		assertArrayEquals(exp, lst.toArray());
	}

	@Test
	public void testdelStart_n() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.delStart();
		assertEquals(7, lst.size());
		int[] exp = {10,20,30,58,89,63,70};
		assertArrayEquals(exp, lst.toArray());
	}
	//=======================================
	//  delEnd
	//=======================================
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testdelEnd_0() 
	{

		lst.delEnd();
	}
	@Test
	public void testdelEnd_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.delEnd();
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testdelEnd_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		lst.delEnd();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}

	@Test
	public void testdelEnd_n() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.delEnd();
		assertEquals(7, lst.size());
		int[] exp = {30,10,20,30,58,89,63};
		assertArrayEquals(exp, lst.toArray());
	}
	//=======================================
	//  delPos
	//=======================================
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testdelPos_0() 
	{

		lst.delPos(0);
	}
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testdelPos_0n() 
	{

		lst.delPos(6);
	}
	@Test
	public void testdelPos_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.delPos(0);
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testdelPos_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		lst.delPos(1);
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testdelPos_n() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.delPos(4);
		assertEquals(7, lst.size());
		int[] exp = {30,10,20,30,89,63,70};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testdelPos_nn() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.delPos(10);
	}
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testdelPos_val_menshe_0() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.delPos(-10);
	}
	//=======================================
	//  getMax
	//=======================================
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testgetMax_0() 
	{

		lst.getMax();
	}
	@Test
	public void testgetMax_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.getMax();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testgetMax_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		assertEquals(20, lst.getMax());
	}

	@Test
	public void testgetMax_n() 
	{

		int[] ini = {30,10,20,58,89,63,70};
		lst.init(ini);
		assertEquals(89, lst.getMax());
	}
	//=======================================
	//  getMin
	//=======================================
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testgetMin_0() 
	{

		lst.getMin();
	}
	@Test
	public void testgetMin_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.getMin();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testgetMin_2() 
	{

		int[] ini = {20,10};
		lst.init(ini);
		assertEquals(10, lst.getMin());
	}

	@Test
	public void testgetMin_n() 
	{

		int[] ini = {30,80,20,58,89,63,10};
		lst.init(ini);
		assertEquals(10, lst.getMin());
	}

	//=======================================
	//  setPos
	//=======================================
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testsetPos_0() 
	{

		lst.setPos(0,55);
	}
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testsetPos_0n() 
	{

		lst.setPos(5,55);
	}
	@Test
	public void testSetPos_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.setPos(0,35);
		assertEquals(1, lst.size());
		int[] exp = {35};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testSetPos_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		lst.setPos(1,25);
		assertEquals(2, lst.size());
		int[] exp = {10,25};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testSetPos_n() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.setPos(4,99);
	}
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetPos_nn() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.setPos(15,99);
	}
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetPos_posIndex_menshe_0() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		lst.setPos(-1,99);
	}
	//=======================================
	//  getPos
	//=======================================
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testgetPos_0() 
	{

		lst.getPos(0);
	}	
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void testgetPos_0n() 
	{

		lst.getPos(10);
	}	
	@Test
	public void testGetPos_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		int res =lst.getPos(10);
		assertEquals(0, res);
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());

	}
	@Test
	public void testGetPos_2() 
	{

		int[] ini = {10,20};
		lst.init(ini);
		int res = lst.getPos(20);
		assertEquals(1, res);
		System.out.println(res);
		assertEquals(2, lst.size());
		int[] exp = {10,20};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testGetPos_n() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		int res = lst.getPos(20);
		assertEquals(2, res);
		assertEquals(8, lst.size());
		int[] exp = {30,10,20,30,58,89,63,70};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetPos_nn() 
	{

		int[] ini = {30,10,20,30,58,89,63,70};
		lst.init(ini);
		int res = lst.getPos(99);
		assertEquals(11, res);

	}

	//=======================================
	//  BubbleSort
	//=======================================
	@Test
	public void TestBubbleSort_0() 
	{

		lst.bubbleSort();
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestBubbleSort_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.bubbleSort();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestBubbleSort_2() 
	{

		int[] ini = {30,10};
		lst.init(ini);
		lst.bubbleSort();
		assertEquals(2, lst.size());
		int[] exp = {10,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestBubbleSort_n() 
	{

		int[] ini = {30,10,20,30,58,-89,63,70};
		lst.init(ini);
		lst.bubbleSort();
		assertEquals(8, lst.size());
		int[] exp = {-89,10,20,30,30,58,63,70};
		assertArrayEquals(exp, lst.toArray());
	}

	//=======================================
	//  InsertionSort
	//=======================================
	@Test
	public void TestInsertionSort_0() 
	{

		lst.insertionSort();
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestInsertionSort_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.insertionSort();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestInsertionSort_2() 
	{

		int[] ini = {30,10};
		lst.init(ini);
		lst.insertionSort();
		assertEquals(2, lst.size());
		int[] exp = {10,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestInsertionSort_n() 
	{

		int[] ini = {30,10,20,30,58,-89,63,70};
		lst.init(ini);
		lst.insertionSort();
		assertEquals(8, lst.size());
		int[] exp = {-89,10,20,30,30,58,63,70};
		assertArrayEquals(exp, lst.toArray());
	}

	//=======================================
	//  SelectionSort
	//=======================================
	@Test
	public void TestSelectionSort_0() 
	{

		lst.selectionSort();
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestSelectionSort_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.selectionSort();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestSelectionSort_2() 
	{

		int[] ini = {30,10};
		lst.init(ini);
		lst.selectionSort();
		assertEquals(2, lst.size());
		int[] exp = {10,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void TestSelectionSort_n() 
	{

		int[] ini = {30,10,20,30,58,-89,63,70};
		lst.init(ini);
		lst.selectionSort();
		assertEquals(8, lst.size());
		int[] exp = {-89,10,20,30,30,58,63,70};
		assertArrayEquals(exp, lst.toArray());
	}

	//=======================================
	//  qSort
	//=======================================
	@Test
	public void qSort_0() 
	{

		lst.qSort(0,0);
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void qSort_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.qSort(0,0);
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void qSort_2() 
	{

		int[] ini = {30,10};
		lst.init(ini);
		lst.qSort(0,1);
		assertEquals(2, lst.size());
		int[] exp = {10,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void qSort_n() 
	{

		int[] ini = {30,10,20,30,58,-89,63,70};
		lst.init(ini);
		lst.qSort(0,7);
		assertEquals(8, lst.size());
		int[] exp = {-89,10,20,30,30,58,63,70};
		assertArrayEquals(exp, lst.toArray());
	}

	//=======================================
	//  ShellSort
	//=======================================
	@Test
	public void ShellSort_0() 
	{

		lst.ShellSort();
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void ShellSort_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.ShellSort();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void ShellSort_2() 
	{

		int[] ini = {30,10};
		lst.init(ini);
		lst.ShellSort();
		assertEquals(2, lst.size());
		int[] exp = {10,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void ShellSort_n() 
	{

		int[] ini = {30,10,20,30,58,-89,63,70};
		lst.init(ini);
		lst.ShellSort();
		assertEquals(8, lst.size());
		int[] exp = {-89,10,20,30,30,58,63,70};
		assertArrayEquals(exp, lst.toArray());
	}

	//=======================================
	//  HeapSort
	//=======================================
	@Test
	public void HeapSort_0() 
	{

		lst.heapSort();
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void HeapSort_1() 
	{

		int[] ini = {10};
		lst.init(ini);
		lst.heapSort();
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void HeapSort_2() 
	{

		int[] ini = {30,10};
		lst.init(ini);
		lst.heapSort();
		assertEquals(2, lst.size());
		int[] exp = {10,30};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void HeapSort_n() 
	{

		int[] ini = {30,10,20,30,58,-89,63,70};
		lst.init(ini);
		lst.heapSort();
		assertEquals(8, lst.size());
		int[] exp = {-89,10,20,30,30,58,63,70};
		assertArrayEquals(exp, lst.toArray());
	}

	//=======================================
	//  iterstor
	//=======================================
	@Test 
	public void test_Iterator_0() 
	{

		int[] ar = {};
		int [] arCopy = new int [ar.length];
		int i = 0;
		lst.init(ar);
		Iterator<Integer> it = lst.iterator();
		while( it.hasNext() )
		{
			arCopy[i] = it.next();
			i++;
		}
		assertEquals(0, lst.size());
		assertArrayEquals(ar, arCopy);
	}
	
	@Test 
	public void test_Iterator_1() 
	{

		int[] ar = {123};
		int [] arCopy = new int [ar.length];
		int i = 0;
		lst.init(ar);
		Iterator<Integer> it = lst.iterator();
		while( it.hasNext() )
		{
			arCopy[i] = it.next();
			i++;
		}
		assertEquals(1, lst.size());
		assertArrayEquals(ar, arCopy);
	}
	
	@Test 
	public void test_Iterator_2() 
	{

		int[] ar = {123,111};
		int [] arCopy = new int [ar.length];
		int i = 0;
		lst.init(ar);
		Iterator<Integer> it = lst.iterator();
		while( it.hasNext() )
		{
			arCopy[i] = it.next();
			i++;
		}
		assertEquals(2, lst.size());
		assertArrayEquals(ar, arCopy);
	}
	
	@Test 
	public void test_Iterator_n() 
	{

		int[] ar = {123,111,222,333,444};
		int [] arCopy = new int [ar.length];
		int i = 0;
		lst.init(ar);
		for( Integer it : lst )
		{
			arCopy[i++] = it;
		}
		assertEquals(5, lst.size());
		assertArrayEquals(ar, arCopy);
	}

}
