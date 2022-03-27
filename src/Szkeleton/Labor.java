package Szkeleton;






public class Labor extends Mező {


    private Ágens kód;




    public Labor() {
        this.kód = new NullÁgens();  // majd a game később létrehoz egy normális ágenst az AddKód-al
    }




    /*
    * Hozzáadja a mezőhöz a megadott ágenst
    *
    * @param a Ágens, amit hozzá szeretnénk adni a mezőhöz
    * @return void
    */
    public void AddKód(Ágens agens) {  // hozzáad egy random kódot
        this.kód = agens;
    }




}