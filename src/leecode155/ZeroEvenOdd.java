package leecode155;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

	private AtomicBoolean zero = new AtomicBoolean(true);
	private AtomicBoolean even = new AtomicBoolean(false);
	private AtomicBoolean odd = new AtomicBoolean(false);
	private int n;

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		int i = 0;
		while (i <n) {
			if (zero.get()) {
				printNumber.accept(0);
				i++;
				if (i % 2 == 1) {
					even.set(true);
				} else {
					odd.set(true);
				}
				
				zero.set(false);
			}
		}

	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		int i = 2;
		while (i <= n) {
			if (odd.get()) {
				printNumber.accept(i);
				odd.set(false);
				i = i + 2;
//				if (i > n)
//					break;
				zero.set(true);
			}
		}

	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		int i = 1;
		while (i <= n) {
			if (even.get()) {
				printNumber.accept(i);
				even.set(false);
				i= i+2;
//				if (i > n)
//					break;
				zero.set(true);
			}
		}
	}

	public static void main(String[] args) {
		ZeroEvenOdd z = new ZeroEvenOdd(100);
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
