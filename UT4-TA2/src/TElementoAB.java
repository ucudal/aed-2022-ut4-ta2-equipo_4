
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return this;
        } else {
            if (unaEtiqueta.toString().length() < etiqueta.toString().length()
                    || (unaEtiqueta.toString().length() == etiqueta.toString().length()
                    && unaEtiqueta.compareTo(etiqueta) < 0)) {
                if (hijoIzq != null) {
                    return hijoIzq.buscar(unaEtiqueta);
                } else {
                    return null;
                }
            } else {
                if (hijoDer != null) {
                    return hijoDer.buscar(unaEtiqueta);
                } else {
                    return null;
                }
            }
        }
    }

    public int buscarCont(Comparable unaEtiqueta, int[] cont) {
        cont[0]++;
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return cont[0];
        } else {
            if (unaEtiqueta.toString().length() < etiqueta.toString().length()
                    || (unaEtiqueta.toString().length() == etiqueta.toString().length()
                    && unaEtiqueta.compareTo(etiqueta) < 0)) {
                if (hijoIzq != null) {
                    return hijoIzq.buscarCont(unaEtiqueta, cont);
                } else {
                    cont[0] = -1;
                    return cont[0];
                }
            } else {
                if (hijoDer != null) {
                    return hijoDer.buscarCont(unaEtiqueta, cont);
                } else {
                    cont[0] = -1;
                    return cont[0];
                }
            }
        }
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (etiqueta.compareTo(elemento.getEtiqueta()) == 0) {
            return false;
        }
        if (elemento.getEtiqueta().toString().length() < etiqueta.toString().length()
                || (elemento.getEtiqueta().toString().length() == etiqueta.toString().length()
                && elemento.getEtiqueta().compareTo(etiqueta) < 0)) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return hijoDer.insertar(elemento);
            }
        }
    }

    public int insertarCont(TElementoAB<T> elemento, int[] cont) {
        cont[0]++;
        if (etiqueta.compareTo(elemento.getEtiqueta()) == 0) {
            cont[0] = 0;
            return cont[0];
        }
        if (elemento.getEtiqueta().toString().length() < etiqueta.toString().length()
                || (elemento.getEtiqueta().toString().length() == etiqueta.toString().length()
                && elemento.getEtiqueta().compareTo(etiqueta) < 0)) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return cont[0];
            } else {
                return hijoIzq.insertarCont(elemento, cont);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
                return cont[0];
            } else {
                return hijoDer.insertarCont(elemento, cont);
            }
        }
    }

    @Override
    public String preOrden() {
        String preOrdenString = "";
        preOrdenString += etiqueta + "-";
        if (hijoIzq != null) {
            preOrdenString += hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            preOrdenString += hijoDer.preOrden();
        }
        return preOrdenString;
    }

    @Override
    public String inOrden() {
        String inOrdenString = "";
        if (hijoIzq != null) {
            inOrdenString += hijoIzq.inOrden();
        }
        inOrdenString += etiqueta + "-";
        if (hijoDer != null) {
            inOrdenString += hijoDer.inOrden();
        }
        return inOrdenString;
    }

    @Override
    public String postOrden() {
        String postOrdenString = "";
        if (hijoIzq != null) {
            postOrdenString += hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            postOrdenString += hijoDer.postOrden();
        }
        postOrdenString += etiqueta + "-";
        return postOrdenString;
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
