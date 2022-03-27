package Szkeleton;

public class AktorLépés implements ILépés{

    @Override
    public void Lépés(Virologus v) {
        System.out.println("Aktorlépés hívódott");
        Mező kiválasztottMező= v.mező.szomszédok.get(2);
        
        if(v.mező.szomszédok.contains(kiválasztottMező)){
            v.move(kiválasztottMező);
        }
        
    }
}
