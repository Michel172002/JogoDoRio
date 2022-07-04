import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Lado1 l1 = new Lado1(IniciarJogo());
        Lado2 l2 = new Lado2();

        int escolha = 0;
        while (escolha != 4){
            Tela(l1.personagens, l2.personagens);
            System.out.println(
                    "Escolha as Opções: " +
                    "\n[ 1 ] - Mover do lado 1 para o lado 2" +
                    "\n[ 2 ] - Mover do lado 2 para o lado 1" +
                    "\n[ 3 ] - Regras" +
                            "\n[ 4 ] - Sair");
            escolha = input.nextInt();
            switch (escolha){
                case 1:
                    System.out.println("Você quer passar 2 personagem ou 1 para o lado 2?");
                    int quantPers = input.nextInt();
                    if (quantPers == 2){
                        System.out.println("Digite o numero do primeiro personagem ");
                        int id1 = input.nextInt();
                        System.out.println("Digite o numero do segundo personagem ");
                        int id2 = input.nextInt();
                        if (Verificar(1, quantPers, id1, id2, l1, l2)){
                            l1.mover(true, id1, id2, l1, l2);
                        }else {
                            System.out.println("Não foi possivel mover");
                        }
                    }else if (quantPers == 1){
                        System.out.println("Digite o numero do personagem ");
                        int id1 = input.nextInt();
                        l1.mover(false, id1, -1, l1, l2);
//                        Verificar(l1, l2);
                    }
                    break;

                case 2:
                    System.out.println("Você quer passar 2 personagem ou 1 para o lado 1?");
                    quantPers = input.nextInt();
                    if (quantPers == 2){
                        System.out.println("Digite o numero do primeiro personagem ");
                        int id1 = input.nextInt();
                        System.out.println("Digite o numero do segundo personagem ");
                        int id2 = input.nextInt();
                        l2.mover(true, id1, id2, l1, l2);
//                        Verificar(l1, l2);
                    }else if (quantPers == 1){
                        System.out.println("Digite o numero do personagem ");
                        int id1 = input.nextInt();
                        l2.mover(false, id1, -1, l1, l2);
                    }
                    break;

                case 3:
                    Regras();
                    break;

                case 4:
                    System.out.println("Saindo!");
                    break;

                default:
                    System.out.println("Opção Errada!");
            }
        }



    }

    public static void Tela(ArrayList<Personagem> lado1, ArrayList<Personagem> lado2) {
        System.out.println("+--------------JOGO DO RIO----------------+");

        int size1 = lado1.size();
        int size2 = lado2.size();

        if (lado1.isEmpty()) {
            int i = 0;
            for(Personagem p2 : lado2) {
                System.out.println("|                 | . ¨ |" + i + " - " + p2.getNome() + "           |");
            }
            System.out.println("+-----------------------------------------+");
        } else if (lado2.isEmpty()) {
            int i = 0;
            for(Personagem p1 : lado1) {
                System.out.println("| " + i + " - " + p1.getNome() + "   | . ¨ |                 |");
                i++;
            }
            System.out.println("+-----------------------------------------+");
        }else if (size1 > size2) {
            for (int i = 0; i < 8; i++) {
                if (i < size2) {
                    System.out.println("| " + i + " - " + lado1.get(i).getNome() + "   | . ¨ |  " + i + " - " + lado2.get(i).getNome() + "         |");
                } else if(i < size1){
                    System.out.println("| " + i + lado1.get(i).getNome() + "   | . ¨ |                 |");
                }
            }
            System.out.println("+-----------------------------------------+");
        }
        else if (size1 < size2) {
            for (int i = 0; i < 8; i++) {
                if (i < size1) {
                    System.out.println("| " + i + " - " + lado1.get(i).getNome() + "   | . ¨ |  " + i + " - " + lado2.get(i).getNome() + "         |");
                } else if(i < size2){
                    System.out.println("|                 | . ¨ | " + i + lado2.get(i).getNome() + "           |");
                }
            }
            System.out.println("+-----------------------------------------+");
        }else{
            for (int i = 0; i < 4; i++) {
                System.out.println("| " + i + " - " + lado1.get(i).getNome() + "| . ¨ |  " + i + " - " + lado2.get(i).getNome() + "         |");
            }
            System.out.println("+-----------------------------------------+");
        }
    }

    public static void Regras(){
        System.out.println(
                "REGRAS:\n" +
                "a) A jangada só pode carregar duas pessoas por vez;\n" +
                "b) Somente o pai, a mãe e o policial sabem manobrar a jangada;\n" +
                "c) Os filhos não podem ficar com a mãe na ausência do pai em nenhuma das margens do rio;\n" +
                "d) Os filhos não podem ser transportados pela mãe;\n" +
                "e) As filhas não podem ficar com o pai na ausência da mãe em nenhuma das margens do rio;\n" +
                "f) As filhas não podem ser transportadas pelo pai;\n" +
                "g) A prisioneira não pode ficar com os membros da família na ausência do policial.\n"
                );
    }


    public static Boolean Verificar(int lado, int quant, int id1, int id2, Lado1 lado1, Lado2 lado2){
        Personagem p1 = new Personagem(0, "pai      ");
        Personagem p2 = new Personagem(1, "mae      ");
        Personagem p3 = new Personagem(2, "policial ");
        Personagem p4 = new Personagem(3, "ladrao   ");
        Personagem p5 = new Personagem(4, "filho1   ");
        Personagem p6 = new Personagem(5, "filho2   ");
        Personagem p7 = new Personagem(6, "filha1   ");
        Personagem p8 = new Personagem(7, "filha2   ");


        Lado1 l1Aux = lado1;
        Lado2 l2Aux = lado2;
        int id1Aux = 0;
        int id2Aux = 0;
        if(lado == 1){
            id1Aux = lado1.personagens.get(id1).getId();
            id2Aux = lado1.personagens.get(id2).getId();
            if(quant == 2){
                l1Aux.mover(true, id1, id2, l1Aux, l2Aux);
            }else if (quant == 1){
                l1Aux.mover(false, id1, -1, l1Aux, l2Aux);
            }
        }else if (lado == 2){
            id1Aux = lado2.personagens.get(id1).getId();
            id2Aux = lado2.personagens.get(id2).getId();
        }





        if ((id1Aux == p1.getId() && id2Aux == p7.getId()) || (id1Aux == p1.getId() && id2Aux == p8.getId()) || (id2Aux == p1.getId() && id1Aux == p7.getId()) || (id2Aux == p1.getId() && id1Aux == p8.getId())){
            System.out.println("O pai não pode transportar as filhas");
            return false;
        }else if ((id1Aux == p2.getId() && id2Aux == p5.getId()) || (id1Aux == p2.getId() && id2Aux == p6.getId()) || (id2Aux == p2.getId() && id1Aux == p5.getId()) || (id2Aux == p2.getId() && id1Aux == p6.getId())){
            System.out.println("A mãe não pode transportar os filhos");
            return false;
        }else if ((l1Aux.Contem(p3) && l2Aux.Contem(p4)) || (l1Aux.Contem(p4) && l2Aux.Contem(p3))){
            System.out.println("Policial não está no mesmo lado do ladrao");
            return false;
        }else if ((l1Aux.Contem(p1) && l1Aux.Contem(p7) && l1Aux.Contem(p8) && l2Aux.Contem(p2)) || (l2Aux.Contem(p1) && l2Aux.Contem(p7) && l2Aux.Contem(p8) && l1Aux.Contem(p2)) ) {
            System.out.println("Mae nao esta com as filha");
            return false;
        }else if ((l2Aux.Contem(p1) && lado1.Contem(p5) && lado1.Contem(p6) && lado1.Contem(p2)) || (l1Aux.Contem(p1) && l2Aux.Contem(p5) && l2Aux.Contem(p6) && l2Aux.Contem(p2)) ) {
            System.out.println("Pai nao esta com as filho");
            return false;
        }
        return true;
    }

    public static ArrayList<Personagem> IniciarJogo(){
        ArrayList<Personagem> lista = new ArrayList<>();
        Personagem p = new Personagem(0, "pai      ");
        lista.add(p);
        p = new Personagem(1, "mae      ");
        lista.add(p);
        p = new Personagem(2, "policial ");
        lista.add(p);
        p = new Personagem(3, "ladrao   ");
        lista.add(p);
        p = new Personagem(4, "filho1   ");
        lista.add(p);
        p = new Personagem(5, "filho2   ");
        lista.add(p);
        p = new Personagem(6, "filha1   ");
        lista.add(p);
        p = new Personagem(7, "filha2   ");
        lista.add(p);

        return lista;
    }
}
