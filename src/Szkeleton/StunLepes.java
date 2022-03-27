package Szkeleton;


public class StunLepes implements  ILepes {
    /**
     * @author Golyha Tamás
     * v virologus saját mezojen marad, mert benitva van
     * @param v Virologus
     */
    @Override
    public void Lepes(Virologus v) {
        System.out.println("Stun lepes hivodott");
        v.move(v.mezo);

 }
}
