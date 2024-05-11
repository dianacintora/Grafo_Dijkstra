import java.util.Scanner;

public class Dijkstra {
	public int distancia[] = new int[10];
	public int costo[][] = new int[10][10];

	public void calcular(int n, int s) {
		int bandera[] = new int[n + 1];
		int i, posMin = 1, k, c, minimo;

		for (i = 1; i <= n; i++) {
			bandera[i] = 0;
			this.distancia[i] = this.costo[s][i];
		}
		c = 2;
		while (c <= n) {
			minimo = 99;
			for (k = 1; k <= n; k++) {
				if (this.distancia[k] < minimo && bandera[k] != 1) {
					minimo = this.distancia[k];
					posMin = k;
				}
			}
			bandera[posMin] = 1;
			c++;
			for (k = 1; k <= n; k++) {
				if (this.distancia[posMin] + this.costo[posMin][k] < this.distancia[k] && bandera[k] != 1)
					this.distancia[k] = this.distancia[posMin] + this.costo[posMin][k];
			}
		}
	}

	public static void main(String args[]) {
		int nodos, origen, i, j;
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese el numero de nodos: ");
		nodos = in.nextInt();
		Dijkstra d = new Dijkstra();
		System.out.println("Ingrese los pesos de la matriz de costos: ");
		for (i = 1; i <= nodos; i++)
			for (j = 1; j <= nodos; j++) {
				d.costo[i][j] = in.nextInt();
				if (d.costo[i][j] == 0)
					d.costo[i][j] = 999;
			}
		System.out.println("Ingrese el vertice de origen: ");
		origen = in.nextInt();

		d.calcular(nodos, origen);
		System.out.println("Los caminos más cortos desde el origen " + origen + " a todos los otros vertices son: ");
		for (i = 1; i <= nodos; i++)
			if (i != origen)
				System.out.println("Origen: " + origen + " Destino: " + i + " Costo minimo: " + d.distancia[i]);
	}
}
