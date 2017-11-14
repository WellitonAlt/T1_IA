/**
 * Created by etoal on 03/11/2017.
 */
public class No {
    int i, j, valor, peso;
    boolean visitado, fixo;

    //Contrutor padrão
    public No(int i, int j, int valor, int peso){
        this.i = i;
        this.j = j;
        this.valor = valor;
        this.peso = peso;
        this.visitado = false;
        this.fixo = false;
    }
    //Sets e Gets

    public int getI(){ return this.i; }
    public int getJ(){ return this.j; }
    public int getValor(){ return this.valor; }
    public boolean getVisitado(){ return this.visitado; }
    public void setVisitado(){ this.visitado = true; }
    public boolean getFixo(){ return this.fixo; }
    public void setFixo(){ this.fixo = true; }
    public void setPeso() {this.peso = peso;}
    public int getPeso() {return this.peso;}

}
