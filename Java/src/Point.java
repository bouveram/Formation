
public class Point {
	
	public int x,y;
	
	public void deplacer(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void afficher() {
		System.out.println("("+x+","+y+")");
	}
}
