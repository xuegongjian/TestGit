package leecode155;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode679 {
	public boolean judgePoint24(int[] nums) {
		if (nums.length != 4) {
			return false;
		}
		for (int first = 0; first < 4; first++) {
			for (int second = 0; second < 4; second++) {
				if (first == second) {
					continue;
				}
				for (int i = 0; i < 6; i++) {
					double tmpValue1 = doProcess(i, (double) nums[first], (double) nums[second]);
					if (tmpValue1 == -10000) {
						continue;
					}
					for (int third = 0; third < 4; third++) {
						if (first == third || second == third) {
							continue;
						}
						for (int j = 0; j < 6; j++) {
							double tmpValue2 = doProcess(j, tmpValue1, (double) nums[third]);
							if (tmpValue2 == -10000) {
								continue;
							}
							for (int fourth = 0; fourth < 4; fourth++) {
								if (first == fourth || second == fourth || third == fourth) {
									continue;
								}

								for (int k = 0; k < 6; k++) {
									double tmpValue3 = doProcess(k, (double) nums[third], (double) nums[fourth]);

									double result = doProcess(k, tmpValue2, (double) nums[fourth]);
									if (result < 24.000001 && result > 23.99999) {
										return true;
									}

									if (doOtherProcess(tmpValue1, tmpValue3)) {
										return true;
									}
								}
							}
						}
					}

				}
			}
		}
		return false;
	}

	private boolean doOtherProcess(double a, double b) {
		for (int op = 0; op < 6; op++) {
			if (op == 0) {
				double result = a + b;
				if (result < 24.000001 && result > 23.99999) {
					return true;
				}
			}
			if (op == 1) {
				double result = a - b;
				if (result < 24.000001 && result > 23.99999) {
					return true;
				}
			}
			if (op == 2) {
				double result = b - a;
				if (result < 24.000001 && result > 23.99999) {
					return true;
				}
			}
			if (op == 3) {
				double result = a * b;
				if (result < 24.000001 && result > 23.99999) {
					return true;
				}
			}
			if (op == 4) {
				if (b == 0) {
					continue;
				}
				double result = a / b;
				if (result < 24.000001 && result > 23.99999) {
					return true;
				}
			}
			if (op == 5) {
				if (a == 0) {
					continue;
				}
				double result = b / a;
				if (result < 24.000001 && result > 23.99999) {
					return true;
				}
			}
		}
		return false;
	}

	private double doProcess(int op, double a, double b) {
		if (op == 0) {
			return a + b;
		}
		if (op == 1) {
			return a - b;
		}
		if (op == 2) {
			return b - a;
		}
		if (op == 3) {
			return a * b;
		}
		if (op == 4) {
			if (b == 0) {
				return -10000;
			}
			return a / b;
		}
		if (op == 5) {
			if (a == 0) {
				return -10000;
			}
			return b / a;
		}
		return 1;
	}

	public static void main(String[] s) {

		System.out.println(new Leecode679().judgePoint24(new int[] { 1, 2, 1, 9 }));

	}
}
