package sortcomparison;

import static java.lang.System.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicSorter us = new BasicSorter();
		String k[] = { "h", "S", "y", "t", "bob", "Hailin", "fd", "why", "are", "you", "like", "this", "come", "on",
				"like", "now", "please", "please", "please", "i", "SO", "much", "superior", "sdsd" };

		ArrayList<String> temp = new ArrayList<String>(Arrays.asList(k));
		ArrayList<String> temp1 = new ArrayList<String>(Arrays.asList(k));
		Collections.rotate(temp.subList(2, 6), -1);
		for (int i = 0; i <= 23; i++) {
			out.print(temp.get(i) + " ");
		}
		out.println();
		us.mergeSort(temp, 0, 24);
		;
		String a = "a";
		out.println(a.compareTo("b"));
		for (int i = 0; i <= 23; i++) {
			out.print(temp.get(i) + " ");
		}
		out.println();
		us.quickSort(temp1, 0, 24);
		;
		for (int i = 0; i <= 23; i++) {
			out.print(temp1.get(i) + " ");
		}
	}

}
