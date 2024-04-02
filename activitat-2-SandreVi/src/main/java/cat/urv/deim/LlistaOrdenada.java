package cat.urv.deim;

public class LlistaOrdenada<E extends Comparable<E>> extends LlistaAbstracta<E> {

    public LlistaOrdenada() {
        super();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void inserir(E e) {
        if (numElements == elements.length) augmentarCapacitat();

        int pos = 1;

        while (pos < numElements && ((E) elements[pos]).compareTo(e) < 0) pos++;

        for (int pos_aux = numElements; pos_aux > pos; pos_aux--) {
            elements[pos_aux] = elements[pos_aux - 1];
        }

        elements[pos] = e;
        numElements++;
    }
}
