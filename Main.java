import java.util.ArrayList;
import java.util.List;

// MEMENTO
class Memento {
    private String estado;

    public Memento(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
// ORIGINATOR
class Editor {
    private String texto;

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public Memento salvar() {
        return new Memento(texto);
    }

    public void restaurar(Memento memento) {
        this.texto = memento.getEstado();
    }
}

// CARETAKER
class Historico {
    private List<Memento> estados = new ArrayList<>();

    public void adicionar(Memento m) {
        estados.add(m);
    }

    public Memento get(int index) {
        return estados.get(index);
    }
}

// MAIN
public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Historico historico = new Historico();

        editor.setTexto("Versão 1");
        historico.adicionar(editor.salvar());

        editor.setTexto("Versão 2");
        historico.adicionar(editor.salvar());

        editor.setTexto("Versão 3");

        editor.restaurar(historico.get(0));

        System.out.println("Texto atual: " + editor.getTexto());
    }
}