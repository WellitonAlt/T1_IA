import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;


public class BuscaProfundidade extends Thread{
    private Map<String, JLabel> map;
    private JProgressBar pBar;
    private JSlider slider;
    private JLabel lblTempo;
    private Pilha pilha;
    private Sudoku sudoku;
    private int back;

    //Contrutor padrão
    public BuscaProfundidade(Map map, Pilha pilha, Sudoku sudoku, JProgressBar pBar, JSlider slider, JLabel lblTempo){
        this.map = map;
        this.pilha = pilha;
        this.sudoku = sudoku;
        this.pBar = pBar;
        this.slider = slider;
        this.lblTempo = lblTempo;
        this.back = 0;
    }

    public void setBack(){this.back++;}
    public int getBack(){return this.back;}

    public void run(){
        //long tempoInicio = System.currentTimeMillis();
        Resolve(sudoku,0,0);
        //lblTempo.setText(Long.toString((System.currentTimeMillis()-tempoInicio)));
    }


     /*Varifica(), Verifica se um numero é solução para a posição I e J
    *Entrada: Posição I, J da matriz e o numero de teste.
    *Saida: Verdadeiro para valido senão Falso.
    */
    public boolean Verifica(int i, int j, int valor) {
        int[][] matriz = sudoku.getMatriz();
        int iQ = (i/3)*3; //Linha inicial do quadrante
        int jQ = (j/3)*3; //Coluna inicial do quadrante

        //Verifica na linha
        for (int k = 0; k < 9; k++)
            if (valor == matriz[i][k])
                return false; //Existe na linha

        //Verifica na coluna
        for (int k = 0; k < 9; k++)
            if (valor == matriz[k][j])
                return false; //Existe na coluna

        //Verifica no quadrante
        for (int k = 0; k < 3; k++)
            for (int h = 0; h < 3; h++)
                if (valor == matriz[iQ+k][jQ+h])
                    return false; //Existe no quadrante

        return true; //É uma posivel solução
    }

    /*MontaConj(), Monta o conjunto de pociveis soluções da posição I e J
    *Entrada: Posição I, J da matriz.
    *Saida: Conjunto das posiveis soluções de da posição I e J.
    */
    public ArrayList<Integer> MontaConj(int i, int j){
        ArrayList<Integer> conj = new ArrayList<Integer>();

        //Para todos os numero do dominio
        for(int k = 9; k > 0; k--)
            if (Verifica(i,j,k)) //Se é solução
                conj.add(k); //Adiciona no conjunto

        return conj;
    }

    /*CriaNo(), Cria os nós da arvore.
    *Entrada: Posição I e J da matriz.
    *Saida: Retorna true se foi criado algum nó e false caso contrario.
    */
    public boolean CriaNo(int i, int j){
        ArrayList<Integer> conj;
        No no;
        int[][] matriz = sudoku.getMatriz();
        boolean ctrl = false;

        //Se for um campo fixo
        if (matriz[i][j] > 0){
            no = new No(i,j,matriz[i][j], 0); //Cria o Nó
            no.setFixo(); //Fixo = true
            pilha.Push(no); //Coloca na pilha
            ctrl = true; //Nó Criado
        }else { //Senão
            conj = MontaConj(i, j); //Cria o conjunto de posiveis soluções
            //Collections.reverse(conj);
            for (int k = 0; k < conj.size(); k++) { //Para cada solução
                    no = new No(i, j, conj.get(k), 0); //Cria o Nó
                    pilha.Push(no); //Coloca na pilha
            }
            ctrl = true; //Nó Criado
        }
        return ctrl;
    }

    /*AtualizaBarra(), Atualiza o valor do ProgressBar.
    *Entrada: Posição I e J da matriz e um  valor de controle.
    *Saida: Atualiza o valor do ProgressBar.
    */
    public void AtualizaBarra(int i, int j, int valor){
        if(valor == 0) { //Se for subida na arvore
            pBar.setForeground(Color.red);
            setBack(); //Adiciona um no numero de backtrackings
            lblTempo.setText("Backtracking: "+ Integer.toString(getBack())); //Atualiza o Label de backtrackings
        }//Altera a cor do Jlabel para vermelho
        else //Senão
            pBar.setForeground(Color.green); //Altera a cor do Jlabel para verde

        pBar.setValue((j+1)+(i*9)); //Altera o valor
        pBar.setString(String.valueOf(((pBar.getValue()*100)/81))+"%"); //Altera a porcentagem
    }

    /*AtualizaMatriz(), Atualiza o valor da Matriz e atualiza os JLabels.
    *Entrada: Posição I e J da matriz.
    *Saida: Imprime na JLabel o valor alterado do Sudoku.
    */
    public void AtualizaMatriz(int i, int j, int valor) {
        String Label = "lbl";
        int[][] matriz = sudoku.getMatriz();

        matriz[i][j] = valor; //Coloca o valor na matriz
        AtualizaBarra(i, j, valor); //Atualiza ProgreesBar

        JLabel jLabel = map.get(Label + i + j); //Pega o JLabel correspondente
        Color c = jLabel.getForeground(); //Pega a cor do JLabel
        jLabel.setForeground(Color.red); //Altera a cor do Jlabel para vermelho
        jLabel.setText(String.valueOf(matriz[i][j])); //Atualiza o JLabel
        try {sleep(slider.getValue());} catch (InterruptedException e){} //Espera um tempo de acordo com o Slider
        jLabel.setForeground(c); //Volta a cor original do JLabel
    }

    /*Resolve(), Metodo recursivo que andar na arvores de solução.
    *Entrada: Posição I e J da matriz e o sodoku.
    *Saida: Sudoku resolvido.
    */
     public boolean Resolve(Sudoku sudoku, int i, int j){
             No no;
             int[][] matriz = sudoku.getMatriz();

             //Cria os nós
             if (!CriaNo(i, j)) { //Se for Conjunto sem solução
                 no = pilha.Topo(); //Pega o Topo da fila
                 if (!no.getFixo()) //Se não for um numero fixo
                     AtualizaMatriz(no.getI(), no.getJ(), 0);
                 pilha.Pop(); //Retira da Fila
                 return false; //Sobe na Arvore
             }

             //Se existir elementos na pilha
             while (pilha.Vazio() != true) {
                 no = pilha.Topo(); //Pega o Topo da fila
                 if (no.getVisitado()) { //Se for um nó já visitado
                     if (!no.getFixo()) //Se não for um numero fixo
                         AtualizaMatriz(no.getI(), no.getJ(), 0);
                     pilha.Pop(); //Retira da Fila
                     return false; //Sobe na Arvore
                 }
                 no.setVisitado(); //Seta visitado como True
                 AtualizaMatriz(no.getI(), no.getJ(), no.getValor());

                 i = no.getI(); //Pega a Posição do nó atual
                 j = no.getJ();

                 //Acha a posição do nó abaixo
                 if (j == 8) {
                     j = 0;
                     i++;
                 } else
                     j++;

                 //Se chegou no final
                 if (i == 9)
                     return true;

                 //Desce na arvore
                 if (Resolve(sudoku, i, j)) {
                     return true; //Achou solução
                 }

             }
             return true; //Achou solução
    }
}
