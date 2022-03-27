package Szkeleton;

public class VitusLépés implements  ILépés{

    @Override
    public void Lépés(Virologus v) {
        System.out.println("Vituslépés hívódott");
        int hossz = v.mező.szomszédok.size();
        int randomMezoSzama= hossz%7;
        v.move(v.mező.szomszédok.get(randomMezoSzama));


    }
}
