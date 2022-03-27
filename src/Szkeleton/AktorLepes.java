package Szkeleton;

public class AktorLepes implements ILepes{

    /**
     * @author Golyha Tamas
     * v virologus atlep egyik szomszedos mezore amit a jatekos valaszt ki
     * @param v Virologus
     */
    @Override
    public void Lepes(Virologus v) {
        System.out.println("Aktorlepes hívodott");
        Mezo kivalasztottMezo= v.mezo.szomszedok.get(2);
        
        if(v.mezo.szomszedok.contains(kivalasztottMezo)){
            v.move(kivalasztottMezo);
        }
    }
}
