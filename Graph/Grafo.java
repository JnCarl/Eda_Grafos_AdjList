
import java.util.LinkedList;

public class Grafo<E> {

    int numVertex;
    Vertex[] List;

    public Grafo(int mx) {
        List = new Vertex[mx];
        numVertex = 0;
    }

    public Grafo() {
    }

    public Vertex[] vertices() {
        return List;
    }

    public LinkedList listaAdyc(int v) throws Exception {
        if (v < 0 || v >= numVertex) {
            throw new Exception("Vértice fuera de rango");
        }
        return List[v].lad;
    }

    public int numVertex(E data) {
        Vertex v = new Vertex(data);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVertex) && !encontrado;) {
            encontrado = List[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }
        return (i < numVertex) ? i : -1;
    }

    public void addVertex(E data) {
        boolean existe = numVertex(data) >= 0;
        if (!existe) {
            Vertex v = new Vertex(data);
            v.asigVert(numVertex);
            List[numVertex++] = v;
        }
    }

    boolean adyacente(E a, E b) throws Exception {
        int v1, v2;
        v1 = numVertex(a);
        v2 = numVertex(b);
        if (v1 < 0 || v2 < 0) {
            throw new Exception("El vértice no existe");
        }
        if (List[v1].lad.contains(new Edge(v2))) {
            return true;
        } else {
            return false;
        }
    }

    boolean adyacente(int v1, int v2) throws Exception {
        if (List[v1].lad.contains(new Edge(v2))) {
            return true;
        } else {
            return false;
        }
    }

    public void newEdge(E a, E b) throws Exception {
        if (!adyacente(a, b)) {
            int v1 = numVertex(a);
            int v2 = numVertex(b);
            if (v1 < 0 || v2 < 0) {
                throw new Exception("El vértice no existe");
            }
            Edge ab = new Edge(v2);
            List[v1].lad.addFirst(ab);
        }
    }

    public void removeEdge(E a, E b) throws Exception {
        int v1 = numVertex(a);
        int v2 = numVertex(b);
        if (v1 < 0 || v2 < 0) {
            throw new Exception("El vértice no existe");
        }
        Edge ab = new Edge(v2);
        List[v1].lad.remove(ab);
    }

}
