package Szkeleton;



public class StunLépés implements  ILépés {
    @Override
    public void Lépés(Virologus v) {
        System.out.println("Stun lépés hívódott");
        v.move(v.mező);

 }
}
