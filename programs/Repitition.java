
import static java.lang.System.out;

public class Repitition {
	
	/*
	 *   |     *
	 *   |    ***
	 *   |   *****
	 *   |  *******
	 *   | *********
	 *   |***********
	 *        ***
	 *        ***
	 *        ***
	 */
	
	private Repitition() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<5; j++) out.print("#");
			out.println();
		}
		out.println("------");
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) out.print("*");
			out.println();
		}
		out.println("------");
		for(int i=0; i<5; i++) {
			for(int l=0; l<(4-i); l++) out.print(" ");
			for(int j=0; j<=i; j++) out.print("*");
			out.println();
		}
		out.println("------");
		for(int i=0; i<9; i++) {
			if(i<6) {
				for(int j=0; j<(5-i); j++) out.print(" ");
				for(int j=0; j<=i*2; j++) out.print("*");
			} else out.print("    ***");
			out.println();
		}
		out.println("------");
		for(int i=10; i<=0; i--) out.print(i + " ");
	}
	
	public static void main(String[] args) {
		new Repitition();
	}

}
