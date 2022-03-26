package Szkeleton;

public class Game {
    public static NullÁgens n;
    public static VitusLépés vitusLépés;
    public static AktorLépés aktorLépés;
    public static StunLépés stunLépés;

    public static void main(String args[]){
        n = new NullÁgens();
        vitusLépés = new VitusLépés();
        aktorLépés = new AktorLépés();
        stunLépés = new StunLépés()
        ;

    }

    public static void start(){}
    public static NullÁgens ReturnN(){
        return n;
    }
    public static VitusLépés getVitusLépés(){
        return vitusLépés;
    }
    public static AktorLépés getAktorLépés(){
        return aktorLépés;
    }
    public static StunLépés getStunLépés(){
        return stunLépés;
    }
    public static void Következő(){}
    public static void AddSteppable(Steppable s){}
    public static void RemoveSteppable(Steppable s){}
    public static void end(){}
}
