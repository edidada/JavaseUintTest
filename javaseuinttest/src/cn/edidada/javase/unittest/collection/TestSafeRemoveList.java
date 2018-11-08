package cn.edidada.javase.unittest.collection;

import java.util.HashMap;

import org.junit.Test;

public class TestSafeRemoveList {

	@Test
	public void safeRemove(){
		HashMap mHashMap = new HashMap<String,String>();
		int num = 50;
		for(int i=0;i < num;i++){
			mHashMap.put(new Integer(i).toString(),new Integer(i).toString());
		}
		
	}
	
}
