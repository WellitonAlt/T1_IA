import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Sudoku {
    private int matriz[][];
    private boolean iniciada;
    private boolean atualizada;
    private Map<String, JLabel> map;

    //Construtor Padrão
    public Sudoku(Map map) {
        this.matriz = new int[9][9];
        this.iniciada = false;
        this.map = map;
    }
    //Sets e Gets
    public boolean getIniciado() {
        return this.iniciada;
    }
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    public int[][] getMatriz() {
        return this.matriz;
    }


    public void ResetMatriz(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = 0; //Zera a Matriz
            }
        }
    }


    /*ErroFormato(), Verifica o conteudo do Txt.
    *Entrada: Linha do arquivo de Texto.
    *Saida: Se houver erro retorna uma matriz limpa.
    */
    public boolean ErroFormato(String linha){
        String Label = "lbl";
        //Se houver mais de 9 carateres e não for no formato [0..9][0..9][0..9][0..9][0..9][0..9][0..9][0..9]
        if((linha.length() > 9) || (!linha.matches("[\\d][\\d][\\d][\\d][\\d][\\d][\\d][\\d][\\d]"))) {
            JOptionPane.showMessageDialog(null, "Arquivo Formatado de Maneira Errada!!!");
            ResetMatriz();
            return true; //Encontrou erro
        }
        return false;
    }

    /*IniciaMatriz(), Inicia o sudoku.
    *Entrada: Caminho do arquivo.
    *Saida: matriz iniciada e Jlabels atualizados.
    */
    public void IniciaMatriz(String caminho) {
        String linha;
        int j = 0;

        //Tenta Abrir o Arquivo
        try {
            FileReader arq = new FileReader(caminho); //Le o arquivo
            BufferedReader lerArq = new BufferedReader(arq);
            linha = lerArq.readLine(); //Pega a primeira Linha

            while (linha != null) {
                if(ErroFormato(linha)) //Se houver erro
                    return; //aborta
                for (int i = 0; i < 9; i++)
                    matriz[j][i] = Character.getNumericValue(linha.charAt(i)); //Atualiza a Matriz
                linha = lerArq.readLine(); //Lê a proxima linha
                j++;
            }
            arq.close(); //Fecha o Arquivo
            iniciada = true; //Matriz iniciada
            //Mensagem de Sucesso
            JOptionPane.showMessageDialog(null, "Arquivo Carregado Com Sucesso!!!");
        } catch (IOException e) {
            //Mensagem de erro de abertura de arquivo
            JOptionPane.showMessageDialog(null, "Erro na Abertura do Arquivo!!!" + e.getMessage());
        }
    }

    /*ImprimeIncial(), Imprime a Matriz inicial.
    *Saida: Jlabels atualizados.
    */
    public void ImprimeInicial() {
        String Label = "lbl";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JLabel jLabel = map.get(Label + i + j); //Pega o JLabel correspondente
                if (matriz[i][j] > 0) //Se for um numero fixo
                    jLabel.setForeground(Color.BLUE); //Altera a cor do Jlabel para Azul
                else
                    jLabel.setForeground(Color.BLACK);
                jLabel.setText(String.valueOf(matriz[i][j])); //Atualiza o JLabel
            }
        }
    }
}
