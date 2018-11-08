package cn.edidada.javase.unittest;

import static org.junit.Assert.assertEquals;

import java.util.Hashtable;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class IntegerTest {

	public TreeMap<String,String> mTreeMap;
	
	@Before
	public void setUp(){
		mTreeMap.put("1", "2");
	}
	
	@Test
   public void testPrintMessage() {   
      assertEquals(new Integer(1).intValue(),1);
   }
	
	
}
