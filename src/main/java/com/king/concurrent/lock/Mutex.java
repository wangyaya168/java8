package com.king.concurrent.lock;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock,Serializable{

	private static class Sync extends AbstractQueuedSynchronizer{
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
		public boolean tryAcquire(int acquires) {
			assert acquires == 1;
			if (compareAndSetState(0,1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		protected boolean tryRelease(int releases) {
			assert releases == 1;
			if (getState() == 0) {
				setExclusiveOwnerThread(null);
				setState(0);
				return true;
			}
			return false;
		}
		Condition newCondition() {
			return new ConditionObject();
		}
		private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
			s.defaultReadObject();
			setState(0);
		}
	}
	
	private final Sync sync = new Sync();
	//使用同步器的模板方法实现自己的同步语义
	@Override
	public void lock() {
		sync.acquire(1);
		
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
		
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
		 return sync.tryAcquireNanos(1, unit.toNanos(timeout));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

	public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }
}
