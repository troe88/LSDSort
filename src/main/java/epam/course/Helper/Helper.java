package epam.course.Helper;

public class Helper {
	static boolean flag = true;

	public static void print(String mark, long time, int length) {
		System.out.println(mark + " " + time + " " + length);
	}

	public static void print(String mark, long time_lsd, long time_sys,
			int length) {
		//String[] temp = mark.split(" ");
		String[] temp1 = mark.split(".LSD.");

		//String m = temp[0];
		String n = temp1[1];

		if (flag) {
			System.out.printf("%-10s  %-20s   %-10s   %-17s  %-24s \n", "##",
					"Test name", "LSD time(ms)", "Arr.sort time(ms)", "length");
			System.out
					.println("##-------------------------------------------------------------------------");
			flag = false;
		}
		System.out.printf("%-7s  %-27s   %-12d   %-12d  %-12d", "##", n, time_lsd, time_sys, length);
		System.out.println();
	}
}
