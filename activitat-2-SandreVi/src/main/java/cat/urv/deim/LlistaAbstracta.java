package cat.urv.deim;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.PosicioForaRang;

public class LlistaAbstracta<E extends Comparable<E>> implements ILlistaGenerica<E> {

    public Object[] elements;
    public int numElements;
    public final int tamanyInicial = 101;

    public LlistaAbstracta() {
        this.elements = new Object[tamanyInicial];
        this.elements[0] = null;
        this.numElements = 1;
    }

    public void augmentarCapacitat() {
        Object[] auxiliar = new Object[elements.length + 100]; //augmentem la capacitat en 100 elements

        for (int pos = 0; pos < numElements; pos++) auxiliar[pos] = elements[pos]; //copiem el contingut de la llista

        elements = auxiliar; //sobreescrivim la nostra llista
        auxiliar = null; //alliberem espai en memòria buidant la llista auxiliar
    }

    @Override
    public void inserir(E e){}

    @Override
    public void esborrar(E e) throws ElementNoTrobat {
        try {
            for (int pos = buscar(e); pos < numElements(); pos++) elements[pos] = elements[pos + 1];

            elements[numElements()] = null;
            numElements--;
        } catch (ElementNoTrobat eNoTrobat) {
            throw new ElementNoTrobat();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E consultar(int pos) throws PosicioForaRang {
        pos++;
        if (pos < 1 || pos > numElements) throw new PosicioForaRang();

        return (E) elements[pos];
    }

    @Override
    public int buscar(E e) throws ElementNoTrobat {
        int pos = 1;

        while (pos <= numElements()) {
            if (elements[pos].equals(e)) return pos;
            else pos++;
        }

        throw new ElementNoTrobat();
    }

    @Override
    public boolean existeix(E e) {
        try {
            buscar(e);
            return true;
        } catch (ElementNoTrobat eNoTrobat) {
            return false;
        }
    }

    @Override
    public boolean esBuida() {
        if (numElements() == 0) return true;
        else return false;
    }

    @Override
    public int numElements() {
        return numElements - 1;
    }

    @Override
    public Object[] elements() {
        return elements;
    }
}
