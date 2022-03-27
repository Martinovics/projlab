package Szkeleton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static NullÁgens n;
    public static VitusLépés vitusLépés;
    public static AktorLépés aktorLépés;
    public static StunLépés stunLépés;
    /**
     * Játékban lévő gének száma.
     */
    private static int NoGén;



    public static void start(){ }
    private static void Kilpés(){
        System.exit(0);
    }
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
    public static void Következő(){

    }
    public static void AddSteppable(Steppable s){}
    public static void RemoveSteppable(Steppable s){}
    public static void end(){}

    private static void Virológus_mezőre_lép(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Mező m2 = new Mező();
        v.move(m2);
    }
    private static void Virológus_egy_óvóhelyre_lép(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Óvóhely m2 = new Óvóhely();
        v.move(m2);
    }
    private static void Virológus_egy_labor_mezőre_lép(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Labor m2 = new Labor();
        v.move(m2);
    }
    private static void Virológus_egy_raktár_mezőre_lép(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Raktár m2 = new Raktár();
        v.move(m2);
    }
    private static void Stun_lépés(){
        Virologus v = new Virologus();
        v.setLépésBehaviour(Game.getStunLépés());
        v.Step();
    }
    private static void Vitus_Lépés_mező(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Mező m2 = new Mező();
        v.setLépésBehaviour(Game.getVitusLépés());
        v.Step();
    }
    private static void Vitus_Lépés_labor(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Labor m2 = new Labor();
        v.setLépésBehaviour(Game.getVitusLépés());
        v.Step();
    }
    private static void Vitus_Lépés_óvóhely(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Óvóhely m2 = new Óvóhely();
        v.setLépésBehaviour(Game.getVitusLépés());
        v.Step();
    }
    private static void Vitus_Lépés_raktár(){
        Virologus v = new Virologus();
        Mező m1 = new Mező();
        Raktár m2 = new Raktár();
        v.setLépésBehaviour(Game.getVitusLépés());
        v.Step();
    }
    private static void Nukleotid_felvétel_raktárból(){
        Virologus v = new Virologus();
        Raktár r = new Raktár();
        Nukleotid n = new Nukleotid();
        r.AddAnyag(n);
        v.CuccFelvétel();
    }
    private static void Aminosav_felvétel_raktárból(){
        Virologus v = new Virologus();
        Raktár r = new Raktár();
        Aminosav n = new Aminosav();
        r.AddAnyag(n);
        v.CuccFelvétel();
    }
    private static void Nukleotid_rablás_másik_virológustól(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Nukleotid c = new Nukleotid();
        v1.TárgyElvétel(v2,c);
    }
    private static void Aminosav_rablás_másik_virológustól(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Aminosav c = new Aminosav();
        v1.TárgyElvétel(v2,c);
    }
    private static void Védőköpeny_felvétel_óvóhelyről(){
        Virologus v = new Virologus();
        Óvóhely o = new Óvóhely();
        Köpeny i = new Köpeny();
        v.CuccFelvétel();
    }
    private static void Zsák_felvétel_óvóhelyről(){
        Virologus v = new Virologus();
        Óvóhely o = new Óvóhely();
        Zsák i = new Zsák();
        v.CuccFelvétel();
    }
    private static void Kesztyű_felvétel_óvóhelyről(){
        Virologus v = new Virologus();
        Óvóhely o = new Óvóhely();
        Kesztyű i = new Kesztyű();
        v.CuccFelvétel();
    }
    private static void Védőköpeny_rablás_virológustól(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Köpeny c = new Köpeny();
        v1.TárgyElvétel(v2,c);
    }
    private static void Zsák_rablás_virológustól(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Zsák c = new Zsák();
        v1.TárgyElvétel(v2,c);
    }
    private static void Kesztyű_rablás_virológustól(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Kesztyű c = new Kesztyű();
        v1.TárgyElvétel(v2,c);
    }
    private static void Virológus_másik_virológust_beken_bénító_ágenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Stun s = new Stun();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v2.TárgyMegkapás(vk);
        v2.TárgyMegkapás(k);
        v2.TárgyMegkapás(zs);
        v2.BuffMegkapás(vt);
        v2.BuffMegkapás(st);
        v2.BuffMegkapás(ei);
        v2.BuffMegkapás(vé);
        v1.ÁgensKenés(v2,s);
    }
    private static void Virológus_másik_virológust_beken_vitustánc_ágenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        VitusTánc s = new VitusTánc();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v2.TárgyMegkapás(vk);
        v2.TárgyMegkapás(k);
        v2.TárgyMegkapás(zs);
        v2.BuffMegkapás(vt);
        v2.BuffMegkapás(st);
        v2.BuffMegkapás(ei);
        v2.BuffMegkapás(vé);
        v1.ÁgensKenés(v2,s);
    }
    private static void Virológus_másik_virológust_beken_védő_ágenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        VédőÁgens s = new VédőÁgens();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v2.TárgyMegkapás(vk);
        v2.TárgyMegkapás(k);
        v2.TárgyMegkapás(zs);
        v2.BuffMegkapás(vt);
        v2.BuffMegkapás(st);
        v2.BuffMegkapás(ei);
        v2.BuffMegkapás(vé);
        v1.ÁgensKenés(v2,s);
    }
    private static void Virológus_másik_virológust_beken_emléktörlő_ágenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Emlékezettörlés s = new Emlékezettörlés();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v2.TárgyMegkapás(vk);
        v2.TárgyMegkapás(k);
        v2.TárgyMegkapás(zs);
        v2.BuffMegkapás(vt);
        v2.BuffMegkapás(st);
        v2.BuffMegkapás(ei);
        v2.BuffMegkapás(vé);
        v1.ÁgensKenés(v2,s);
    }
    private static void Virológus_bekeni_magát_bénító_ágenssel(){
        Virologus v1 = new Virologus();
        Stun s = new Stun();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v1.TárgyMegkapás(vk);
        v1.TárgyMegkapás(k);
        v1.TárgyMegkapás(zs);
        v1.BuffMegkapás(vt);
        v1.BuffMegkapás(st);
        v1.BuffMegkapás(ei);
        v1.BuffMegkapás(vé);
        v1.ÁgensKenés(v1,s);
    }
    private static void A_virológus_bekeni_magát_vitustánc_ágenssel(){
        Virologus v1 = new Virologus();
        VitusTánc s = new VitusTánc();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v1.TárgyMegkapás(vk);
        v1.TárgyMegkapás(k);
        v1.TárgyMegkapás(zs);
        v1.BuffMegkapás(vt);
        v1.BuffMegkapás(st);
        v1.BuffMegkapás(ei);
        v1.BuffMegkapás(vé);
        v1.ÁgensKenés(v1,s);
    }
    private static void A_virológus_bekeni_magát_védő_ágenssel(){
        Virologus v1 = new Virologus();
        VédőÁgens s = new VédőÁgens();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v1.TárgyMegkapás(vk);
        v1.TárgyMegkapás(k);
        v1.TárgyMegkapás(zs);
        v1.BuffMegkapás(vt);
        v1.BuffMegkapás(st);
        v1.BuffMegkapás(ei);
        v1.BuffMegkapás(vé);
        v1.ÁgensKenés(v1,s);
    }
    private static void Virológus_bekeni_magát_emléktörlő_ágenssel(){
        Virologus v1 = new Virologus();
        Emlékezettörlés s = new Emlékezettörlés();
        v1.ÁgensMegkapás(s);
        Köpeny vk = new Köpeny();
        Kesztyű k = new Kesztyű();
        Zsák zs = new Zsák();
        VitusTánc vt = new VitusTánc();
        Stun st = new Stun();
        Emlékezettörlés ei = new Emlékezettörlés();
        VédőÁgens vé = new VédőÁgens();
        v1.TárgyMegkapás(vk);
        v1.TárgyMegkapás(k);
        v1.TárgyMegkapás(zs);
        v1.BuffMegkapás(vt);
        v1.BuffMegkapás(st);
        v1.BuffMegkapás(ei);
        v1.BuffMegkapás(vé);
        v1.ÁgensKenés(v1,s);
    }
    private static void Kesztyű_visszadob_bénítóÁgens(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyű k = new Kesztyű();
        Stun s = new Stun();
        v2.TárgyMegkapás(k);
        v1.Bekenődés(v2,s);
    }
    private static void Kesztyű_visszadob_védőÁgens(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyű k = new Kesztyű();
        VédőÁgens s = new VédőÁgens();
        v2.TárgyMegkapás(k);
        v1.Bekenődés(v2,s);
    }
    private static void Kesztyű_visszadob_Vitustánc(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyű k = new Kesztyű();
        VitusTánc s = new VitusTánc();
        v2.TárgyMegkapás(k);
        v1.Bekenődés(v2,s);
    }
    private static void Kesztyű_visszadob_emléktörlőt(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyű k = new Kesztyű();
        Emlékezettörlés s = new Emlékezettörlés();
        v2.TárgyMegkapás(k);
        v1.Bekenődés(v2,s);
    }
    private static void Bénító_ágens_készítés(){
        Virologus v = new Virologus();
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        Stun s = new Stun();
        v.GénMegkapás(s);
        v.ÁgensElőállít(s);
    }
    private static void Vitustánc_készítés(){
        Virologus v = new Virologus();
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        VitusTánc s = new VitusTánc();
        v.GénMegkapás(s);
        v.ÁgensElőállít(s);
    }
    private static void Védő_ágens_készítés(){
        Virologus v = new Virologus();
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        VédőÁgens s = new VédőÁgens();
        v.GénMegkapás(s);
        v.ÁgensElőállít(s);
    }
    private static void Emléktörlő_ágens_készítés(){
        Virologus v = new Virologus();
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Nukleotid());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        v.AnyagMegkapás(new Aminosav());
        Emlékezettörlés s = new Emlékezettörlés();
        v.GénMegkapás(s);
        v.ÁgensElőállít(s);
    }
    private static void Játék_megnyerése(){
        Virologus v = new Virologus();
        NoGén = 1;
        v.GénMegkapás(new Stun());
        v.EndRound();
        if(v.kódok.size() == NoGén){
            end();
        }
        //Ezt kitalálni
    }
    private static void Bénító_kód_tanulás(){
        Stun a = new Stun();
        Labor l = new Labor();
        Virologus v = new Virologus();
        v.CuccFelvétel();
    }
    private static void Vitustánc_kód_tanulás(){
        VitusTánc a = new VitusTánc();
        Labor l = new Labor();
        Virologus v = new Virologus();
        v.CuccFelvétel();
    }
    private static void Védő_kód_tanulás(){
        VédőÁgens a = new VédőÁgens();
        Labor l = new Labor();
        Virologus v = new Virologus();
        v.CuccFelvétel();
    }
    private static void Emléktörlő_kód_tanulás(){
        Emlékezettörlés a = new Emlékezettörlés();
        Labor l = new Labor();
        Virologus v = new Virologus();
        v.CuccFelvétel();
    }
    public static void main(String args[]) {
        n = new NullÁgens();
        vitusLépés = new VitusLépés();
        aktorLépés = new AktorLépés();
        stunLépés = new StunLépés();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            String line = null;
            try {
                line = br.readLine();
            } catch (Exception e) {
            }
            if (line == null) break;
            switch (line) {
                case "vml":
                    Virológus_mezőre_lép();
                    break;
                case "vol":
                    Virológus_egy_óvóhelyre_lép();
                    break;
                case "vll":
                    Virológus_egy_labor_mezőre_lép();
                    break;
                case "vrl":
                    Virológus_egy_raktár_mezőre_lép();
                    break;
                case "sl":
                    Stun_lépés();
                    break;
                case "vtm":
                    Vitus_Lépés_mező();
                    break;
                case "vtl":
                    Vitus_Lépés_labor();
                    break;
                case "vto":
                    Vitus_Lépés_óvóhely();
                    break;
                case "vtr":
                    Vitus_Lépés_raktár();
                    break;
                case "nf":
                    Nukleotid_felvétel_raktárból();
                    break;
                case "af":
                    Aminosav_felvétel_raktárból();
                    break;
                case "nr":
                    Nukleotid_rablás_másik_virológustól();
                    break;
                case "ar":
                    Aminosav_rablás_másik_virológustól();
                    break;
                case "vfo":
                    Védőköpeny_felvétel_óvóhelyről();
                    break;
                case "zfo":
                    Zsák_felvétel_óvóhelyről();
                    break;
                case "kfo":
                    Kesztyű_felvétel_óvóhelyről();
                    break;
                case "vr":
                    Védőköpeny_rablás_virológustól();
                    break;
                case "zr":
                    Zsák_rablás_virológustól();
                    break;
                case "kr":
                    Kesztyű_rablás_virológustól();
                    break;
                case "beken bénító":
                    Virológus_másik_virológust_beken_bénító_ágenssel();
                    break;
                case "beken vitus":
                    Virológus_másik_virológust_beken_vitustánc_ágenssel();
                    break;
                case "beken védő":
                    Virológus_másik_virológust_beken_védő_ágenssel();
                    break;
                case "beken emlék":
                    Virológus_másik_virológust_beken_emléktörlő_ágenssel();
                    break;
                case "beken bénító magát":
                    Virológus_bekeni_magát_bénító_ágenssel();
                    break;
                case "beken vitus magát":
                    A_virológus_bekeni_magát_vitustánc_ágenssel();
                    break;
                case "beken védő magát":
                    A_virológus_bekeni_magát_védő_ágenssel();
                    break;
                case "beken emlék magát":
                    Virológus_bekeni_magát_emléktörlő_ágenssel();
                    break;
                case "vissza bénító":
                    Kesztyű_visszadob_bénítóÁgens();
                    break;
                case "vissza védő":
                    Kesztyű_visszadob_védőÁgens();
                    break;
                case "vissza vitus":
                    Kesztyű_visszadob_Vitustánc();
                    break;
                case "vissza emlék":
                    Kesztyű_visszadob_emléktörlőt();
                    break;
                case "bénító készítés":
                    Bénító_ágens_készítés();
                    break;
                case "vitus készítés":
                    Vitustánc_készítés();
                    break;
                case "védő készítés":
                    Védő_ágens_készítés();
                    break;
                case "emlék készítés":
                    Emléktörlő_ágens_készítés();
                    break;
                case "win":
                    Játék_megnyerése();
                    break;
                case "bénító tanul":
                    Bénító_kód_tanulás();
                    break;
                case "vitus tanul":
                    Vitustánc_kód_tanulás();
                    break;
                case "védő tanul":
                    Védő_kód_tanulás();
                    break;
                case "emlék tanul":
                    Emléktörlő_kód_tanulás();
                    break;
                default:
                    break;
            }
        }
    }
}
