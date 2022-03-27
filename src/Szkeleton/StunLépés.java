package Szkeleton;


public class StunLépés implements  ILépés {
    /**
     * @author Golyha Tamás
     * v virológus saját mezőjén marad, mert bénítva van
     * @param v Virologus
     */
    @Override
    public void Lépés(Virologus v) {
        System.out.println("Stun lépés hívódott");
        v.move(v.mező);

 }
}
