package Szkeleton;

public class AktorLépés implements ILépés{

    /**
     * @author Golyha Tamás
     * v virológus átlép egyik szomszédos mezőre amit a játékos választ ki
     * @param v Virologus
     */
    @Override
    public void Lépés(Virologus v) {
        System.out.println("Aktorlépés hívódott");
        Mező kiválasztottMező= v.mező.szomszédok.get(2);
        
        if(v.mező.szomszédok.contains(kiválasztottMező)){
            v.move(kiválasztottMező);
        }
    }
}
