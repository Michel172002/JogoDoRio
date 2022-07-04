import java.util.ArrayList;

public class Lado1 implements Lado{
    ArrayList<Personagem> personagens = new ArrayList<Personagem>();

    public Lado1(ArrayList<Personagem> lista){
        this.personagens = lista;
    }

    @Override
    public void mover(Boolean opcao, int id1, int id2, Lado1 lista1, Lado2 lista2){
        if (opcao) {
            Personagem p = new Personagem(lista1.personagens.get(id1).getId(), lista1.personagens.get(id1).getNome());
            Personagem p2 = new Personagem(lista1.personagens.get(id2).getId(), lista1.personagens.get(id2).getNome());
            if (p.podePilotar() || p2.podePilotar()) {
                lista2.personagens.add(p);
                lista2.personagens.add(p2);
                if(id1 < id2) {
                    lista1.personagens.remove(lista1.personagens.get(id1));
                    lista1.personagens.remove(lista1.personagens.get(id2 - 1));
                }else {
                    lista1.personagens.remove(lista1.personagens.get(id1));
                    lista1.personagens.remove(lista1.personagens.get(id2));
                }
            }else {
                System.out.println("Ninguem Pode Pilotar!");
            }
        }else {
            Personagem p = new Personagem(lista1.personagens.get(id1).getId(), lista1.personagens.get(id1).getNome());
            if (p.podePilotar()) {
                lista2.personagens.add(p);
                lista1.personagens.remove(lista1.personagens.get(id1));
            }else {
                System.out.println("Ninguem Pode Pilotar!");
            }
        }
    }

    public Boolean Contem(Personagem p){
        for(Personagem t : personagens){
            if(t.getId() == p.getId()){
                return true;
            }
        }
        return false;
    }
}
