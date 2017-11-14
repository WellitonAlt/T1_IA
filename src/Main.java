import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by etoal on 03/11/2017.
 */
public class Main {
    private JButton btnResolver;
    private JPanel panelMain;
    private JLabel lbl00;
    private JLabel lbl01;
    private JLabel lbl02;
    private JLabel lbl03;
    private JLabel lbl04;
    private JLabel lbl05;
    private JLabel lbl06;
    private JLabel lbl07;
    private JLabel lbl08;
    private JPanel pNumeros;
    private JLabel lbl10;
    private JLabel lbl20;
    private JLabel lbl30;
    private JLabel lbl40;
    private JLabel lbl50;
    private JLabel lbl60;
    private JLabel lbl70;
    private JLabel lbl80;
    private JLabel lbl11;
    private JLabel lbl12;
    private JLabel lbl21;
    private JLabel lbl22;
    private JLabel lbl31;
    private JLabel lbl32;
    private JLabel lbl33;
    private JLabel lbl34;
    private JLabel lbl35;
    private JLabel lbl36;
    private JLabel lbl37;
    private JLabel lbl38;
    private JLabel lbl13;
    private JLabel lbl14;
    private JLabel lbl15;
    private JLabel lbl16;
    private JLabel lbl17;
    private JLabel lbl18;
    private JLabel lbl23;
    private JLabel lbl24;
    private JLabel lbl26;
    private JLabel lbl27;
    private JLabel lbl28;
    private JLabel lbl25;
    private JLabel lbl41;
    private JLabel lbl42;
    private JLabel lbl43;
    private JLabel lbl44;
    private JLabel lbl45;
    private JLabel lbl46;
    private JLabel lbl47;
    private JLabel lbl48;
    private JLabel lbl51;
    private JLabel lbl52;
    private JLabel lbl53;
    private JLabel lbl54;
    private JLabel lbl55;
    private JLabel lbl56;
    private JLabel lbl57;
    private JLabel lbl58;
    private JLabel lbl61;
    private JLabel lbl62;
    private JLabel lbl63;
    private JLabel lbl64;
    private JLabel lbl65;
    private JLabel lbl66;
    private JLabel lbl67;
    private JLabel lbl68;
    private JLabel lbl71;
    private JLabel lbl72;
    private JLabel lbl73;
    private JLabel lbl74;
    private JLabel lbl75;
    private JLabel lbl76;
    private JLabel lbl77;
    private JLabel lbl78;
    private JLabel lbl81;
    private JLabel lbl82;
    private JLabel lbl83;
    private JLabel lbl84;
    private JLabel lbl85;
    private JLabel lbl86;
    private JLabel lbl87;
    private JLabel lbl88;
    private JTextField txtCaminho;
    private JButton btnCarregar;
    private JProgressBar pBar;
    private JButton btnProcurar;
    private JSlider slider;
    private JButton BtnParar;
    private JLabel lblDelay;
    private JPanel pBotoes;
    private JPanel pAtraso;
    private JPanel pCaminho;
    private JPanel pOpcoes;
    private JRadioButton rbnBusca;
    private JRadioButton rbnFirst;
    private JLabel lblTempo;
    private ButtonGroup btnRadio = new javax.swing.ButtonGroup();
    private JLabel lblImagem;

    public String caminho;
    public Map<String, JLabel> map = new HashMap<String, JLabel>();
    Sudoku sudoku = new Sudoku(map);
    Pilha pilha = new Pilha();
    BuscaProfundidade buscaProfundidade;
    BestFirst bestFirst;

    //Cria o mapa de Jlabels
    public void CarregaMapa() {
        map.put("lbl00", lbl00);
        map.put("lbl01", lbl01);
        map.put("lbl02", lbl02);
        map.put("lbl03", lbl03);
        map.put("lbl04", lbl04);
        map.put("lbl05", lbl05);
        map.put("lbl06", lbl06);
        map.put("lbl07", lbl07);
        map.put("lbl08", lbl08);

        map.put("lbl10", lbl10);
        map.put("lbl11", lbl11);
        map.put("lbl12", lbl12);
        map.put("lbl13", lbl13);
        map.put("lbl14", lbl14);
        map.put("lbl15", lbl15);
        map.put("lbl16", lbl16);
        map.put("lbl17", lbl17);
        map.put("lbl18", lbl18);

        map.put("lbl20", lbl20);
        map.put("lbl21", lbl21);
        map.put("lbl22", lbl22);
        map.put("lbl23", lbl23);
        map.put("lbl24", lbl24);
        map.put("lbl25", lbl25);
        map.put("lbl26", lbl26);
        map.put("lbl27", lbl27);
        map.put("lbl28", lbl28);

        map.put("lbl30", lbl30);
        map.put("lbl31", lbl31);
        map.put("lbl32", lbl32);
        map.put("lbl33", lbl33);
        map.put("lbl34", lbl34);
        map.put("lbl35", lbl35);
        map.put("lbl36", lbl36);
        map.put("lbl37", lbl37);
        map.put("lbl38", lbl38);

        map.put("lbl40", lbl40);
        map.put("lbl41", lbl41);
        map.put("lbl42", lbl42);
        map.put("lbl43", lbl43);
        map.put("lbl44", lbl44);
        map.put("lbl45", lbl45);
        map.put("lbl46", lbl46);
        map.put("lbl47", lbl47);
        map.put("lbl48", lbl48);

        map.put("lbl50", lbl50);
        map.put("lbl51", lbl51);
        map.put("lbl52", lbl52);
        map.put("lbl53", lbl53);
        map.put("lbl54", lbl54);
        map.put("lbl55", lbl55);
        map.put("lbl56", lbl56);
        map.put("lbl57", lbl57);
        map.put("lbl58", lbl58);

        map.put("lbl60", lbl60);
        map.put("lbl61", lbl61);
        map.put("lbl62", lbl62);
        map.put("lbl63", lbl63);
        map.put("lbl64", lbl64);
        map.put("lbl65", lbl65);
        map.put("lbl66", lbl66);
        map.put("lbl67", lbl67);
        map.put("lbl68", lbl68);

        map.put("lbl70", lbl70);
        map.put("lbl71", lbl71);
        map.put("lbl72", lbl72);
        map.put("lbl73", lbl73);
        map.put("lbl74", lbl74);
        map.put("lbl75", lbl75);
        map.put("lbl76", lbl76);
        map.put("lbl77", lbl77);
        map.put("lbl78", lbl78);

        map.put("lbl80", lbl80);
        map.put("lbl81", lbl81);
        map.put("lbl82", lbl82);
        map.put("lbl83", lbl83);
        map.put("lbl84", lbl84);
        map.put("lbl85", lbl85);
        map.put("lbl86", lbl86);
        map.put("lbl87", lbl87);
        map.put("lbl88", lbl88);


    }

    //main
    public Main() {
        btnRadio.add(rbnBusca);
        btnRadio.add(rbnFirst);

        //Ação click do Botão Carrega
        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Label = "lbl";

                caminho = txtCaminho.getText(); //Pega o conteudo do TextBox Caminho
                sudoku.IniciaMatriz(caminho); //Tenta iniciar a Matriz
                CarregaMapa(); //Cria o Mapa de Jlabels

                if (sudoku.getIniciado()) { //Se matriz iniciada
                    sudoku.ImprimeInicial(); //Imprime a Matriz
                    btnResolver.setEnabled(true);
                }

                pBar.setValue(0); //Altera o valor do Progress Bar para 0
                pBar.setString("0%"); //Altera o valor do texto do Progress Bar para 0%

            }
        });

        //Ação click do Botão Resolve
        btnResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sudoku.getIniciado()) { //Se matriz iniciada
                    if (rbnBusca.isSelected()) {
                        buscaProfundidade = new BuscaProfundidade(map, pilha, sudoku, pBar, slider, lblTempo); //Constroi a buscaProfundidade
                        buscaProfundidade.start(); //Dá inicio a Thread de buscaProfundidade
                    }else{
                        bestFirst = new BestFirst(map, pilha, sudoku, pBar, slider, lblTempo);
                        bestFirst.start();
                    }
                    btnCarregar.setEnabled(false);
                    btnProcurar.setEnabled(false);
                    btnResolver.setEnabled(false);
                    BtnParar.setEnabled(true);
                }
                else //Senão Mensagem de erro
                    JOptionPane.showMessageDialog(null, "Sudoku Não Iniciado!!!");
            }
        });

        //Ação click do Botão Pocura
        btnProcurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JFileChooser fileChooser = new JFileChooser(); //Inicia o JFileChooser
               String Caminho;
               String[] Extensao;

                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){ //Abre o JFileChooser
                    java.io.File file = fileChooser.getSelectedFile(); //Recebe o Arquivo seleciona
                    Caminho = file.getAbsolutePath(); //Pega o Caminho do Arquivo
                    Extensao = Caminho.split("\\."); //Pega a extensão do arquivo
                    if (Extensao[1].equals("txt")) { //Se .txt
                        txtCaminho.setText(Caminho); //Coloca do valor do TextBox Caminho
                        btnCarregar.setEnabled(true);
                    }
                    else //Senão erro de extensão não suportada
                        JOptionPane.showMessageDialog(null, "Extensão não Suportado");
                }
            }
        });
        BtnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] matriz = sudoku.getMatriz();
                if(!txtCaminho.getText().equals(""))
                    btnCarregar.setEnabled(true);
                btnProcurar.setEnabled(true);
                btnResolver.setEnabled(false);
                BtnParar.setEnabled(false);

                if(rbnBusca.isSelected())
                    buscaProfundidade.stop();

                if(rbnFirst.isSelected())
                    bestFirst.stop();

                sudoku.ResetMatriz();
                sudoku.ImprimeInicial();

                lblTempo.setText("Backtracking: 0");
                pBar.setValue(0);
                pBar.setString("0%");
                slider.setValue(160);

            }
        });
    }

    public static void main(String[] args) {
         //Inicia o form
        JFrame frame = new JFrame("Sudoku");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,700);
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        lblImagem = new JLabel(new ImageIcon("Matriz.png"));
    }
}
