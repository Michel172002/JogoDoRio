import java.util.ArrayList;

public class Lado2 implements Lado{
    ArrayList<Personagem> personagens = new ArrayList<>();

    @Override
    public void mover (Boolean opcao, int id1, int id2, Lado1 lista1, Lado2 lista2){
        if (opcao) {
            Personagem p = new Personagem(lista2.personagens.get(id1).getId(), lista2.personagens.get(id1).getNome());
            Personagem p2 = new Personagem(lista2.personagens.get(id2).getId(), lista2.personagens.get(id2).getNome());
            if (p.podePilotar() || p2.podePilotar()) {
                lista1.personagens.add(p);
                lista1.personagens.add(p2);
                if(id1 < id2) {
                    lista2.personagens.remove(lista2.personagens.get(id1));
                    lista2.personagens.remove(lista2.personagens.get(id2 - 1));
                }else {
                    lista2.personagens.remove(lista2.personagens.get(id1));
                    lista2.personagens.remove(lista2.personagens.get(id2));
                }
            }else {
                System.out.println("Ninguem Pode Pilotar!");
            }
        }else {
            Personagem p = new Personagem(lista2.personagens.get(id1).getId(), lista2.personagens.get(id1).getNome());
            if (p.podePilotar()) {
                lista1.personagens.add(p);
                lista2.personagens.remove(lista2.personagens.get(id1));
            }else {
                System.out.println("Ninguem Pode Pilotar!");
            }
        }
    }

}