import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Test test = new Test();
		int[] array = {1,5,2,1,10};
		test.print(array, 6);
		test.rotate("My", -2);
	}
	
	public void print(int[] array, int input) {
		int above = 0, below = 0;
		for(int num: array) {
			if(num > input) {
				above ++;
			}
			if(num < input) {
				below ++;
			}
		}
		System.out.println("Result for exercise 1:");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("above: " + String.valueOf(above) + ", " + "below: " + String.valueOf(below));
		System.out.println("---------------------------------------------------------------------\n");
	}
	
	public String rotate(String input, int overFlow) {
		System.out.println("Result for exercise 2:");
		System.out.println("---------------------------------------------------------------------");
		String output;
		if(input.length() == 0) {
			System.out.println("Input string is empty, return empty string");
			output = "";
		}
		else if(overFlow < 0) {
			System.out.println("Negtive number detected, choose option:\n"
					+ "Press Y to Rotate in opposite direction\n"
					+ "Press any other key to terminate this execution");
			Scanner keyboard = new Scanner(System.in);
			String Userinput = keyboard.next();
			keyboard.close();
			if(Userinput.compareTo("Y") == 0) {
				output =  shiftingString(input, overFlow);
			}
			else {
				System.out.println("Rotation number is negative, process is terminated.");
				output = input;
			}
		}
		else {
			output = shiftingString(input, overFlow);
		}
		System.out.println("---------------------------------------------------------------------\n");
		return output;
	}

	private String shiftingString(String input, int overFlow) {
		String overFlowed = "";
		if(overFlow > 0) {
			overFlow = overFlow % input.length();
			for(int i = input.length() - 1; input.length() - i <= overFlow; i --) {
				char character = input.charAt(i);
				String temp = overFlowed;
				overFlowed = Character.toString(character);
				overFlowed += temp;
			}
			String result = overFlowed + input.substring(0, input.length() - overFlow);
			System.out.println(result);
			return result;
		}
		else if(overFlow < 0) {
			overFlow = Math.abs(overFlow);
			overFlow = overFlow % input.length();
			for(int i = 0; i < overFlow; i ++) {
				char character = input.charAt(i);
				overFlowed += Character.toString(character);
			}
			String result = input.substring(overFlow, input.length()) + overFlowed;
			System.out.println(result);
			return result;
		}
		else {
			System.out.println(input);
			return input;
		}
	}
}