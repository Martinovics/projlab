package Szkeleton;

public class MainTest {

    public static void main(String []args){
        System.out.println("mezo accept teszt");

        Raktár m1 = new Raktár();
        Labor m2 = new Labor();
        Óvóhely m3 = new Óvóhely();

        m1.szomszédok.add(m2);
        m1.szomszédok.add(m3);

        Virologus v1 = new Virologus();

        m1.AcceptViro(v1);

        m2.szomszédok.add(m1);
        m2.AcceptViro(v1);


        System.out.println("Add, cuccatad");
        m1.CuccÁtadás(v1);
        m1.AddAnyag(new Aminosav());
        m1.CuccÁtadás(v1);

        System.out.println("addkód");
        m2.AddKód(new Stun());

    }

}
