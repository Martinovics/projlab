package Szkeleton;


public class VitusLepes implements  ILepes{
    /**
     * @author Golyha Tamás
     * v virologus átlep egyik szomszedos mezojere amit a játekos nem tud kiválasztani
     * @param v Virologus
     */
    @Override
    public void Lepes(Virologus v) {
        System.out.println("Vituslepes hivodott");
        int hossz = v.mezo.szomszedok.size();
        int randomMezoSzama= 0;
        v.move(v.mezo.szomszedok.get(randomMezoSzama));
    }
}
