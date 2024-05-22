package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
         String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
         //primeiro um for para selecionar os candidatos
         for (String candidato : candidatos){
             entrandoEmContato(candidato);
         }
    }



    /*
    * Case 4: O RH deverá realizar uma ligação, com no máximo 03 tentativas para cada candidato selecionado e caso o candidato
    *  atenda, deve-se imprimir:
        -"CONSEGUIMOS CONTATO COM _ [CANDIDATO]``` APÓS **_**[TENTATIVA]`** TENTATIVA(S)" ;**
        -Do contrário imprima: "NÃO CONSEGUIMOS CONTATO COM O _[CANDIDATO]_".*/
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
           atendeu = atender();
           continuarTentando = !atendeu;
           if(continuarTentando){
               tentativasRealizadas++;
           }else {
               System.out.println("CONTATO REALIZADO COM SUCESSO");
           }
        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "º " + "TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " +
                    tentativasRealizadas + " REALIZADA");

    }

    //método auxiliar
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    /*
    * Case 3: Agora é hora de imprimir a lista dos candidatos selecionados, para disponibilizar para o RH entrar em contato.*/
    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("o candidato de nº " + (indice + 1) + " é o " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação for each");
        for( String candidato : candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    /*
    * Case 2: Foi solicitado, que nosso sistema garanta que, diante das inúmeras candidaturas sejam selecionados apenas no máximo,
    *  5 candidatos para entrevista, onde o salário pretendido seja menor ou igual ao salário base.*/
    static void selecaoCandidatos() {

        // Array com a lista de candidatos
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }else {
                System.out.println("O candidato NÃO foi selecionado !!!");
            }
            candidatoAtual++;
        }
    }

    // Método que simula o valor pretendido
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }



    /*
    Case 1: Vamos imaginar que em um processo seletivo, existe o valor base salarial de R$ 2.000,00 e o salário pretentido pelo
    candidato. Vamos elaborar um controle de fluxo onde:
        -Se o valor salário base, for maior que valor salário pretentido, imprima : LIGAR PARA O CANDIDATO;
        -Senão, Se o valor salário base for igual ao valor salário pretentido, imprima : LIGAR PARA O CANDIDATO, COM CONTRA
        PROPOSTA;
        -Senão imprima: AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.
    * */
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
        }

    }
}
