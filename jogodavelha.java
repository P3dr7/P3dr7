import java.util.Scanner;

/**
 *
 * @author Igor
 */
public class jogodavelha {

    public static void main(String[] args) {  
    //criacao do campo
        campo[][] velha = new campo[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
              velha[i][j] = new campo();
            }
        }
        //indicar se o jogo ta rodando 
        boolean game = true;
        //Simbolo da vez, comecando o jogo com X
        char simboloAtual = 'X';
        //
        int cont = 0;
        int vitoria = 0;
        Scanner scan = new Scanner(System.in);

        iniciarJogo(velha);
        while (game) {
            
            desenhaJogo(velha); 
            vitoria = verificarvencedor(velha,vitoria);
            switch (vitoria) {
                case 1: 
                        System.out.printf("Jogador X venceu. \n");
                        game = false;
                        break;
               case 2: 
                        System.out.printf("Jogador O venceu. \n");
                        game = false;
                        break;
                case 3: 
                        System.out.printf("Empate \n");
                        game = false;
                        break; 
                default:{
                    
                }
            }
            try {
                if (verificarJogada(velha, jogar(scan, simboloAtual), simboloAtual)) {
                    if (simboloAtual == 'X') {
                        simboloAtual = 'O';
                    } else {
                        simboloAtual = 'X';
                    }
                }
            } catch (Exception e) {
                System.out.printf("Erro");
            }
        }
        System.out.println("Fim do jogo");
    }

    public static void desenhaJogo(campo[][] velha) {
        limparTela();
        System.out.println("   0    1    2");
        System.out.printf("0   %c | %c | %c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("1   %c | %c | %c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("2   %c | %c | %c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());       
    }

    public static void limparTela() {
        for (int cont = 0; cont < 200; cont++) {
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scan, char simboloAtual) {
        int p[] = new int[2];
        System.out.printf("%s %c%n", "Quem joga: ", simboloAtual);
        System.out.print("Informe a linha: ");
        p[0] = scan.nextInt();
        System.out.print("Informe a coluna: ");
        p[1] = scan.nextInt();
        return p;
        
    }

    public static boolean verificarJogada(campo[][] velha, int p[], char simboloAtual) {
        if (velha[p[0]][p[1]].getSimbolo() ==' '){
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }
    }

    public static void iniciarJogo(campo[][] velha) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                velha[1][c] = new campo();
            }
        }
    }
    public static int verificarvencedor(campo[][]velha, int vitoria) {
       for (int cont = 0; cont < 9; cont++) {
            
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
             if((velha[0][0].getSimbolo() == 'X' && velha[0][1].getSimbolo() == 'X' && velha[0][2].getSimbolo() == 'X')
             || (velha[1][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[1][2].getSimbolo() == 'X')
             || (velha[2][0].getSimbolo() == 'X' && velha[2][1].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X')
             || (velha[1][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[1][2].getSimbolo() == 'X')
             || (velha[0][0].getSimbolo() == 'X' && velha[0][1].getSimbolo() == 'X' && velha[0][2].getSimbolo() == 'X')
             || (velha[2][0].getSimbolo() == 'X' && velha[2][1].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X')
             || (velha[0][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X')
             || (velha[0][2].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][0].getSimbolo() == 'X'))
             {              
                 return 1;           
           } else if((velha[0][0].getSimbolo() == 'O' && velha[0][1].getSimbolo() == 'O' && velha[0][2].getSimbolo() == 'O')
             || (velha[1][0].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[1][2].getSimbolo() == 'O')
             || (velha[2][0].getSimbolo() == 'O' && velha[2][1].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O')
             || (velha[1][0].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[1][2].getSimbolo() == 'O')
             || (velha[0][0].getSimbolo() == 'O' && velha[0][1].getSimbolo() == 'O' && velha[0][2].getSimbolo() == 'O')
             || (velha[2][0].getSimbolo() == 'O' && velha[2][1].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O')
             || (velha[0][0].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O')
             || (velha[0][2].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][0].getSimbolo() == 'O')){
               return 2;
           }else if(cont >= 9){
               
               return 3;
           }
            
        }
       }      
    }
        return 0;
   }
 
}

