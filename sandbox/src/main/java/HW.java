public class HW {

	public static void main(String[] args) {

		hello("Mir");
		hello("Mir");
		hello("Mir");

		double l = 10;
		System.out.println("Объем куба с ребром "+ l + " = " + area(l));
	}
 	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");
	}
	public static double area(double l) {
		return l * l * l
		;
	}

}