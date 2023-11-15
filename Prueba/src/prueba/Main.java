package prueba;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Persona> lista = new ArrayList<Persona>();
		int x = 1;
		System.out.println("Dame los datos de 3 personas:");
		
		while (x < 4) {
			Persona p1 = new Persona();
			System.out.println("DNI de la persona " + x + ":");
			p1.setDni(scanner.nextLine());
			System.out.println("Nombre de la persona " + x + ":");
			p1.setNombre(scanner.nextLine());
			lista.add(x - 1, p1);
			x++;
		}
		
		for (int a = 0; a < 3; a++) {
			System.out.println("Datos de la persona " + (a + 1) + ": " + lista.get(a));
		}
			
		scanner.close();
	}
}


