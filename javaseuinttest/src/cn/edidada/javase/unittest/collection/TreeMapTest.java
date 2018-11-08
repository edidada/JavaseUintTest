package cn.edidada.javase.unittest.collection;

import java.util.TreeMap;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TreeMapTest {

	public TreeMap<Integer,Integer> mTreeMap;
	
	@Before
	public void setUp(){
		mTreeMap = new TreeMap<Integer,Integer>();
		int num = 10;
		for(int i = 20;i> num;i--){
			mTreeMap.put(Integer.valueOf(i),Integer.valueOf(1+i));
		}
	}

	@Test
	public void testTreeMap(){
		Assert.assertEquals(mTreeMap.get(new Integer(11)), new Integer(12));
		Assert.assertEquals(mTreeMap.firstKey().intValue(), 11);
	}

}
