
public class Edge<E> {

    private E destino;
    double peso;

    public Edge(E d) {
        this.destino = d;
    }

    public Edge(E d, double p) {
        this(d);
        peso = p;
    }

    public E getDestino() {
        return destino;
    }

    public boolean equals(Object n) {
        Edge a = (Edge) n;
        return destino == a.destino;
    }
}

