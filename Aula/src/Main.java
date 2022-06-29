import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Lado1 l1 = new Lado1(IniciarJogo());
        Lado2 l2 = new Lado2();


        int escolha = 0;
        while (escolha != 5){
            Tela(l1.personagens, l2.personagens);
            System.out.println(
                    "Escolha as Opções: " +
                    "\n[ 1 ] - Mover do lado 1 para o lado 2" +
                    "\n[ 2 ] - Mover do lado 2 para o lado 1" +
                    "\n[ 3 ] - Exibir L1" +
                            "\n[ 4 ] - Exibir l2" +
                            "\n[ 5 ] - Sair");
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
                        l1.mover(true, id1, id2, l1, l2);
                    }else {
                        System.out.println("Digite o numero do personagem ");
                        int id1 = input.nextInt();
                        l1.mover(false, id1, -1, l1, l2);
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
                    }else {
                        System.out.println("Digite o numero do personagem ");
                        int id1 = input.nextInt();
                        l2.mover(false, id1, -1, l1, l2);
                    }
                    break;

                case 5:
                    System.out.println("Saindo!");
                    escolha = 5;
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
