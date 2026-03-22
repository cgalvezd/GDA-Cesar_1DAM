package resolFlashGo;

public class Main {
	public static void main(String[] args) {
		Paquete paquete = new Paquete("Paquete1", 12.5, 15.5, Categoria.ELECTRONICA, Prioridad.URGENTE, false);
		Paquete paquete2 = new Paquete("Paquete2", 13.5, 12.5, Categoria.ALIMENTACION, Prioridad.NORMAL, true);
		Paquete paquete3 = new Paquete("Paquete3", 4.5, 2.5, Categoria.DOCUMENTACION, Prioridad.URGENTE, false);

		Moto moto = new Moto(50, 60);
		Furgoneta furgoneta = new Furgoneta(150, 36);

		moto.cargar(paquete);
		moto.cargar(paquete2);
		moto.cargar(paquete3);
		System.out.println();
		furgoneta.cargar(paquete);
		furgoneta.cargar(paquete2);
		furgoneta.cargar(paquete3);
		System.out.println("\n=== COSTES ===");
		System.out.println("Coste moto: "+moto.calcularCoste()+"€");
		System.out.println("Coste furgoneta: "+furgoneta.calcularCoste()+"€");

		

	}

}
