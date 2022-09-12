/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pedro
 */
public class campo {
     //representar x, o ou vazio 
    private char simbolo;
        public campo(){
            //iniciar com vazio 
            this.simbolo=' ';
        
        }
            //pegar o simbolo
            public char getSimbolo(){
                return this.simbolo;
            }
            //se tiver vazio recebe o valor simbolo
            public void setSimbolo(char simbolo){
                if(this.simbolo ==' '){
                    this.simbolo = simbolo;
                    
                }else{
                    System.out.println("Campo ja usado");
                }
            }
    }