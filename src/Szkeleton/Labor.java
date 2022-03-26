package Szkeleton;

import java.util.*;






public class Labor extends Mező {


    private Ágens kód;




    public Labor() {
        this.kód = new NullÁgens();  // majd a game később létrehoz egy normális ágenst az add-al
    }




    public void AddKód(Ágens agens) {  // hozzáad egy random kódot
        this.kód = agens;
    }




}
