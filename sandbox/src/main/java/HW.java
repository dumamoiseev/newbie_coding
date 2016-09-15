public class HW {

	public static void main(String[] args) {

		Point p1 = new Point();
		p1.x=0;
		p1.y=0;
		Point p2 = new Point();
		p2.x=0;
		p2.y=4;


		System.out.println("расстояние между точками" + " = " + distance(p1,p2));
	}


	public static double distance(Point p1,Point p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}
}




