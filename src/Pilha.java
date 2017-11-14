import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by etoal on 03/11/2017.
 */
public class Pilha {
    No no;
    List<No> nos = new LinkedList<No>();

    //Adicona na pilha
    public void Push(No no) { nos.add(no); }
    //Retira da pilha
    public No Pop() { return nos.remove(nos.size() - 1); }
    //Pega o Topo
    public No Topo() { return nos.get(nos.size() - 1); }
    //Retorna se está vazia ou não
    public boolean Vazio() {return nos.size() == 0; }
    //Imprime a Pilha
    public void ImprimePilha(){
        for(int i = 0; i < nos.size(); i++){
            no = nos.get(i);
            System.out.print(no.getValor() + ", ");
        }
        System.out.println();
    }


}
