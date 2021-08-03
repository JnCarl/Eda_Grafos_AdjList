import java.util.LinkedList;

public class Vertex<E> {

    private E data;
    int numVertice;
    LinkedList<Object> lad;

    public Vertex(E data) {
        this.data = data;
        numVertice = -1;
        lad = new LinkedList();
    }

    public boolean equals(Object o) {
        Vertex dos = (Vertex) o;
        return data.equals(dos.data);
    }

    public void asigVert(int n) {
        numVertice = n;
    }

    public E nomVertice() {
        return this.data;
    }

    public String toString() {
        return this.data + " (" + numVertice + ")";
    }

}

