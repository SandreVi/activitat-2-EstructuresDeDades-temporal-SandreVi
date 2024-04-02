package cat.urv.deim;

public class LlistaNoOrdenada<E extends Comparable<E>> extends LlistaAbstracta<E> {

    public LlistaNoOrdenada() {
        super();
    }

    @Override
    public void inserir(E e) {
        if (numElements == elements.length) augmentarCapacitat();

        elements[numElements] = e;
        numElements++;
    }

}
