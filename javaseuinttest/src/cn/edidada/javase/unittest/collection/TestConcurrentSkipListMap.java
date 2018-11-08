package cn.edidada.javase.unittest.collection;

import java.util.concurrent.ConcurrentSkipListMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestConcurrentSkipListMap {
	
	ConcurrentSkipListMap<String,String> mConcurrentSkipListMap;
	
	@Before
	public void setUp(){
		mConcurrentSkipListMap = new ConcurrentSkipListMap<String,String>();
		mConcurrentSkipListMap.put("1", "2");
		mConcurrentSkipListMap.put("2", "1");
	}

	@Test
	public void testMap(){
		Assert.assertNotNull(mConcurrentSkipListMap);
		Assert.assertNotNull(mConcurrentSkipListMap.get("2"));
		Assert.assertEquals(mConcurrentSkipListMap.get("2"),"1");
	}

}
