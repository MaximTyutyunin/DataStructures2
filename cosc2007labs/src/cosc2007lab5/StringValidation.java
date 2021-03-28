package cosc2007lab5;

public class StringValidation extends Object {

	public static void main(String[] args) {

		System.out.println(validate("ab"));
	}

	private static boolean validate(String s) {

		int leftPartPointer = 0;

		int rightPartPointer = s.length() - 1;

		return validate(s, leftPartPointer, rightPartPointer);

	}

	private static boolean validate(String s, int lpp, int rpp) {

		if (lpp == rpp && s.charAt(rpp) == 'c')
			return true;

		if (s.charAt(lpp) == 'a' && s.charAt(rpp) == 'b') {

			return validate(s, lpp + 1, rpp - 1);

		} else {

			return false;
			

		}
	}
}
