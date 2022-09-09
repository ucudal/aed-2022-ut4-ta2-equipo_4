
public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    public int insertarCont(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return -1; //al ser raíz, no necesita invocar al método recursivo, lo inserta directamente
        } else {
            int[] cont = {0};
            return raiz.insertarCont(unElemento, cont);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    public int buscarCont(Comparable unaEtiqueta) {
        if (raiz == null) {
            return -1;
        } else {
            int[] cont = {0};
            return raiz.buscarCont(unaEtiqueta, cont);
        }
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.preOrden();
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.inOrden();
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.postOrden();
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
