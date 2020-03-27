package leecode155;

import java.util.ArrayDeque;
import java.util.LinkedList;

import javafx.util.Pair;

public class Leecode994 {
	public boolean canMeasureWater(int x, int y, int z) {
		if(z >y) return false;
		if(z%x==0) return true;
		
		int i = 1;
		while(i<=y && ((long)x*i + z) % (long)y != 0){
			i++;
		}
		return i<y;
    }

	public static void main(String[] s) {
		System.out.println(new Leecode994().canMeasureWater(104597
				,104623,
				123));

	}
}
