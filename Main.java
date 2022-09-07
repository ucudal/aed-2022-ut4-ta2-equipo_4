package ut5.ta2;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TArbolBB arbol = new TArbolBB();
		 String[] lineas = ManejadorArchivosGenerico.leerArchivo("c:\\claves3.txt");
		 for (String l : lineas) {
			 IElementoAB elem = new TElementoAB(Integer.parseInt(l), null);
			 arbol.insertar(elem);
		 }
		 
		 System.out.println("Altura : " + arbol.obtenerAltura());
		 System.out.println("Tamaño : " + arbol.obtenerTamanio());
		 System.out.println("Hojas : " + arbol.obtenerCantidadHojas());
		 System.out.println("Nivel (11988) : " + arbol.obtenerNivel(11988));
		 Integer[] contador = new Integer[1];
		 contador[0] = new Integer(0);
		 System.out.println("Clave (10635) : " + arbol.buscar(10635, contador));
		 System.out.println(contador[0]);
		 contador = new Integer[1];
		 contador[0] = new Integer(0);
		 System.out.println("Clave (9637) : " + arbol.buscar(9637, contador));
		 System.out.println(contador[0]);
		 
		 //System.out.println(arbol.preOrden());
		 
	}

}
