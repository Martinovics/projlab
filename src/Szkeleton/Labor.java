package Szkeleton;

public class Labor extends Mezo {
    private agens kod;

    public Labor() {
        System.out.println(this + " letrejott");
        this.kod = new Nullagens();  // majd a game kesobb letrehoz egy normalis agenst az AddKod-al
    }

    /*
    * Hozzaadja a mezohoz a megadott agenst
    *
    * @param a agens, amit hozza szeretnenk adni a mezohoz
    * @return void
    */
    public void AddKod(agens agens) {  // hozzaad egy random kodot
        System.out.println(this + "atadta a kodot");
        this.kod = agens;
    }

    @Override
    public void Cuccatadas(Virologus v) {
        System.out.println("Labor atadta a kodot.");
        kod.Kodatadas(v);
    }

    @Override
    public void Felfedez(Virologus v) {
        super.Felfedez(v);
    }

    @Override
    public String toString() {
        return "Labor";
    }
}