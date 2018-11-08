package cn.edidada.javase.unittest.collection;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.LongAdder;

import junit.framework.Assert;

import org.junit.Test;

public class TestLongAdder {

	@Test
	public void testLongAdder(){
		final LongAdder mLongAdder = new LongAdder();
		Assert.assertEquals(mLongAdder.intValue(), 0);
		mLongAdder.reset();
		Assert.assertEquals(mLongAdder.intValue(), 0);
		
		mLongAdder.add(12l);
		Assert.assertEquals(mLongAdder.intValue(), 12);
		mLongAdder.reset();
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		Future<Boolean> future = newFixedThreadPool.submit(new Callable<Boolean>(){

			@Override
			public Boolean call() throws Exception {
				mLongAdder.increment();
				return true;
			}
			
		});
		Future<Boolean> futureAgain = newFixedThreadPool.submit(new Callable<Boolean>(){
			
			@Override
			public Boolean call() throws Exception {
				mLongAdder.increment();
				return true;
			}
			
		});
		boolean flag = true;
		while(flag){
			if(futureAgain.isDone() &&future.isDone()){
				flag = false;
				Assert.assertEquals(mLongAdder.intValue(), 2);
			}
		}
		mLongAdder.reset();

		mLongAdder.sum();
	}
}
