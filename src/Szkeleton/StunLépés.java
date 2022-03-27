package Szkeleton;

    /**
     * @author Golyha Tamás
     * v virológus saját mezőjén marad, mert bénítva van
     * @param v Virologus
     */

public class StunLépés implements  ILépés {
    @Override
    public void Lépés(Virologus v) {
        System.out.println("Stun lépés hívódott");
        v.move(v.mező);

 }
}
