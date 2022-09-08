package com.mycompany.jogo_da_velha;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Jogo_da_velha extends JFrame {

    JButton[] bt = new JButton[9];
    JButton novo = new JButton("Novo Jogo");
    JButton zerar = new JButton("Zerar Plcar");
    //Criacao de um placar
    JLabel placar = new JLabel("Placar");
    JLabel px = new JLabel("X 0");
    JLabel po = new JLabel("O 0");
    int PX = 0;
    int PO = 0;
    //fim da criacar do placar
    boolean xo = false;
    boolean[] click = new boolean[9];

    public Jogo_da_velha() {
        setVisible(true);
        //Titulo da Janela
        setTitle("jogo da velha");
        //Fechar quando apertar no X
        setDefaultCloseOperation(3);
        //Null para definir dps
        setLayout(null);
        //Tamanho da Janela
        setBounds(250, 250, 700, 500);
        //Botao para comecar um novo jogo 
        add(novo);
        //Botao para zerar o placar
        add(zerar);
        //Criacao do placar na janela 
        add(placar);
        add(px);
        add(po);
        placar.setBounds(425,50,100,30);
        px.setBounds(400,75,100,30);
        po.setBounds(450,75,100,30);
        //Zerar o placar
        zerar.setBounds(410,130,140,30);
        //Comecar o jogo Dnv
        novo.setBounds(410,180,140,30);
        novo.addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });
        zerar.addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                PO=0;
                PX=0;
                atualizar();
            }
        });
        //viriavel para contar 
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bt[cont] = new JButton();
                //Adicioanr os Botoes 
                add(bt[cont]);
                //Definiir a posicao do botao 
                bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
                //Fonte do Botao
                bt[cont].setFont(new Font("Arial", Font.BOLD, 40));
                //Contador para nao ficar criando infinito
                cont++;
            }
        }
        //Definir Valor de cada
        for (int i = 0; i < 9; i++) {
            click[i] = false;
        }
        
        //Acoes dos Botoes
        bt[0].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[0] == false) {
                    click[0] = true;
                    mudar(bt[0]);
                }
            }
        });
        //Nao trocar o valor do botao 1
        bt[1].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[1] == false) {
                    click[1] = true;
                    mudar(bt[1]);
                }
            }
        });
        //Nao trocar o valor do botao 2
        bt[2].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[2] == false) {
                    click[2] = true;
                    mudar(bt[2]);
                }
            }
        });
        //Nao trocar o valor do botao 3
        bt[3].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[3] == false) {
                    click[3] = true;
                    mudar(bt[3]);
                }
            }
        });
        //Nao trocar o valor do botao 4
        bt[4].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[4] == false) {
                    click[4] = true;
                    mudar(bt[4]);
                }
            }
        });
        //Nao trocar o valor do botao 5
        bt[5].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[5] == false) {
                    click[5] = true;
                    mudar(bt[5]);
                }
            }
        });
        //Nao trocar o valor do botao 6
        bt[6].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[6] == false) {
                    click[6] = true;
                    mudar(bt[6]);
                }
            }
        });
        //Nao trocar o valor do botao 7
        bt[7].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[7] == false) {
                    click[7] = true;
                    mudar(bt[7]);
                }
            }
        });
        //Nao trocar o valor do botao 8
        bt[8].addActionListener(new java.awt.event.ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (click[8] == false) {
                    click[8] = true;
                    mudar(bt[8]);
                }
            }
        });

    }
    //para inverter os botoes 
     public void mudar(JButton btn) {
        if (xo) {
            btn.setText("O");
            xo = false;
        } else {
            btn.setText("X");
            xo = true;
            
        }
        ganhou();
    }
    //Para Limpar as pecas que foram apertadas
     public void limpar(){
        for (int i = 0; i < 9; i++) {
            bt[i].setText("");
            click[i] = false;
            //pra sempre comecar com x
            xo = false;
        }
    }
    //Para Atualizar o placar
    public void atualizar(){
        px.setText("X "+ PX);
        po.setText("O "+ PO);
    }
    //Para verificar os ganhadores 
    public void ganhou() {
        int cont = 0;
        for (int i = 0; i < 9; i++) {
            if (click[i] == true){
                cont++;
            }
        }
        //todas as opcoes possiveis para que x ganhe 
        if ((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X")
                || (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X")
                || (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X")
                || (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X")
                || (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X")
                || (bt[2].getText() == "X" && bt[4].getText() == "X" && bt[6].getText() == "X")) {
            //Exibir mensagem dentro do janela informando o ganhador 
            JOptionPane.showMessageDialog(null, "X ganhou");
            //Atualizar Placar
            PX++;
            atualizar();
            //Para limpar tudo 
            limpar();       
        }else if ( (bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O")
                || (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O")
                || (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O")
                || (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O")
                || (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O")
                || (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O") ) {          
            JOptionPane.showMessageDialog(null, "O ganhou");
            PO++;
            atualizar();
            limpar();     
    } else if(cont == 9){
           JOptionPane.showMessageDialog(null, "Empate"); 
           limpar();
        }
    }

    
      public static void main(String[] args){
           new Jogo_da_velha();
    }   
}
   
    

