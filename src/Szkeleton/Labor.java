package Szkeleton;

public class Labor extends Mező {
    private Ágens kód;

    public Labor() {
        System.out.println(this + " létrejött");
        this.kód = new NullÁgens();  // majd a game később létrehoz egy normális ágenst az AddKód-al
    }

    /*
    * Hozzáadja a mezőhöz a megadott ágenst
    *
    * @param a Ágens, amit hozzá szeretnénk adni a mezőhöz
    * @return void
    */
    public void AddKód(Ágens agens) {  // hozzáad egy random kódot
        System.out.println(this + "átadta a kódot");
        this.kód = agens;
    }

    @Override
    public void CuccÁtadás(Virologus v) {
        System.out.println("Labor átadta a kódot.");
        kód.KódÁtadás(v);
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