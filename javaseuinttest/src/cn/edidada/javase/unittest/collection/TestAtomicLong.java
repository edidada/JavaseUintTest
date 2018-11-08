package cn.edidada.javase.unittest.collection;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import junit.framework.Assert;

import org.junit.Test;

public class TestAtomicLong {

	@Test
	public void testAtomicLong(){
		final AtomicLong mAtomicLong = new AtomicLong();
		Assert.assertEquals(mAtomicLong.intValue(), 0);
		mAtomicLong.set(0);
		Assert.assertEquals(mAtomicLong.intValue(), 0);
		
		mAtomicLong.set(12l);
		Assert.assertEquals(mAtomicLong.intValue(), 12);
		mAtomicLong.set(0);
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		Future<Boolean> future = newFixedThreadPool.submit(new Callable<Boolean>(){

			@Override
			public Boolean call() throws Exception {
				mAtomicLong.getAndIncrement();
				return true;
			}
			
		});
		Future<Boolean> futureAgain = newFixedThreadPool.submit(new Callable<Boolean>(){
			
			@Override
			public Boolean call() throws Exception {
				mAtomicLong.getAndIncrement();
				return true;
			}
			
		});
		boolean flag = true;
		while(flag){
			if(futureAgain.isDone() &&future.isDone()){
				flag = false;
				Assert.assertEquals(mAtomicLong.intValue(), 2);
			}
		}
		mAtomicLong.set(0);
		
		mAtomicLong.get();
	}
}
