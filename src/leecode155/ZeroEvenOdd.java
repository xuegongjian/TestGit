package leecode155;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

	private Semaphore zero = new Semaphore(1);
	private Semaphore even = new Semaphore(1);
	private Semaphore odd = new Semaphore(1);
	private int n;

	public ZeroEvenOdd(int n) {
		this.n = n;
		try {
			even.acquire();
			odd.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		int i = 0;
		while (i < n) {
			zero.acquire();
			printNumber.accept(0);
			i++;
			if (i % 2 == 1) {
				even.release();
			} else {
				odd.release();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		int i = 2;
		while (i <= n) {
			odd.acquire();
			printNumber.accept(i);
			i = i + 2;
			zero.release();
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		int i = 1;
		while (i <= n) {
			even.acquire();
			printNumber.accept(i);
			i = i + 2;
			zero.release();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ZeroEvenOdd z = new ZeroEvenOdd(10);
		final IntConsumer printNumber = (b) -> System.out.print(b);

		new Thread(() -> {
			try {
				z.zero(printNumber);
			} catch (InterruptedException e) {
			}
		}).start();

		new Thread(() -> {
			try {
				z.even(printNumber);
			} catch (InterruptedException e) {
			}
		}).start();

		new Thread(() -> {
			try {
				z.odd(printNumber);
			} catch (InterruptedException e) {
			}
		}).start();

	}

}
