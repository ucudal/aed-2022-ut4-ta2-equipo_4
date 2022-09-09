
/**
 *
 * @author ernesto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //como no habia un archivo claves.txt, usamos en su lugar claves1.txt
        String[] clavesA = ManejadorArchivosGenerico.leerArchivo("src\\claves1.txt");
        String[] archivoAEscribirA = new String[clavesA.length];
        TArbolBB arbol = new TArbolBB();
        int resultadoContInsertar;
        for (int i = 0; i < clavesA.length; i++) {
            TElementoAB elemento = new TElementoAB(clavesA[i], null);
            resultadoContInsertar = arbol.insertarCont(elemento);
            archivoAEscribirA[i] = elemento.getEtiqueta() + ", " + resultadoContInsertar;
        }

        System.out.println("Recorrido en preorden: " + arbol.preOrden());
        System.out.println("Recorrido en postorden: " + arbol.postOrden());
        System.out.println("Recorrido en inorden: " + arbol.inOrden()); //aqui se evidencia que el metodo de insertar funciona correctamente, ya que queda ordenado
        /*IMPORTANTE: a la hora de hacer compareTo dentro de insertar nos enfrentamos al problema de que compara caracter a
        caracter, por lo que vimos necesario NO SOLO hacer el compareTo, sino que además verficiar que los largos
        de las etiquetas también respeten el orden. Si no aplicabamos la verificación 1778 aparecía antes en el
        inorden que 192, ya que 17 < 19*/ 
        ManejadorArchivosGenerico.escribirArchivo("src\\subequipoA.txt", archivoAEscribirA);
        
        //usamos las claves en clavesPrueba.txt para buscarlas en el árbol que creó el subequipoA
        String[] clavesB = ManejadorArchivosGenerico.leerArchivo("src\\clavesPrueba.txt");
        String[] archivoAEscribirB = new String[clavesB.length];
        int resultadoContBuscar;
        for (int i = 0; i < clavesB.length; i++) {
            resultadoContBuscar = arbol.buscarCont(clavesB[i]);
            archivoAEscribirB[i] = clavesB[i] + ", " + resultadoContBuscar;
        }
        /*IMPORTANTE: tuvimos el mismo problema en el compareTo de buscar, así que le hicimos la misma verificación*/
        ManejadorArchivosGenerico.escribirArchivo("src\\subequipoB.txt", archivoAEscribirB);
    }
}
