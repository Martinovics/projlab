package Szkeleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {
    public static Nullagens n;
    public static VitusLepes vitusLepes;
    public static AktorLepes aktorLepes;
    public static StunLepes stunLepes;

    public static ArrayList<Steppable> steppables;
    public static ArrayList<Mezo> mezok;
    /**
     * Jatekban levo genek szama.
     */
    private static int NoGen;



    public static void start(){ }
    private static void Kilpes(){
        System.exit(0);
    }
    public static Nullagens ReturnN(){
        return n;
    }
    public static VitusLepes getVitusLepes(){
        return vitusLepes;
    }
    public static AktorLepes getAktorLepes(){
        return aktorLepes;
    }
    public static StunLepes getStunLepes(){
        return stunLepes;
    }
    public static void Kovetkezo(){

        //return steppables.get();
    }
    public static void AddSteppable(Steppable s){}
    public static void RemoveSteppable(Steppable s){}
    public static void end(Virologus v){
        System.out.println("Vege: "+ v + "gyozott");
    }

    private static void Virologus_mezore_lep(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        Mezo m2 = new Mezo();
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.move(m2);
    }
    private static void Virologus_egy_ovohelyre_lep(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        ovohely m2 = new ovohely();
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.move(m2);
    }
    private static void Virologus_egy_labor_mezore_lep(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        Labor m2 = new Labor();
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.move(m2);
    }
    private static void Virologus_egy_raktar_mezore_lep(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        Raktar m2 = new Raktar();
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.move(m2);
    }
    private static void Stun_lepes(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.setLepesBehaviour(Game.getStunLepes());
        v.Step();
    }
    private static void Vitus_Lepes_mezo(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        Mezo m2 = new Mezo();
        m1.szomszedok.add(m2);
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.setLepesBehaviour(Game.getVitusLepes());
        v.Step();
    }
    private static void Vitus_Lepes_labor(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        Labor m2 = new Labor();
        m1.szomszedok.add(m2);
        m1.AcceptViro(v);
        v.PutOnMezo(m1);
        v.setLepesBehaviour(Game.getVitusLepes());
        v.Step();
    }
    private static void Vitus_Lepes_ovohely(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        ovohely m2 = new ovohely();
        m1.szomszedok.add(m2);
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.setLepesBehaviour(Game.getVitusLepes());
        v.Step();
    }
    private static void Vitus_Lepes_raktar(){
        Virologus v = new Virologus();
        Mezo m1 = new Mezo();
        Raktar m2 = new Raktar();
        m1.szomszedok.add(m2);
        v.PutOnMezo(m1);
        m1.AcceptViro(v);
        v.setLepesBehaviour(Game.getVitusLepes());
        v.Step();
    }
    private static void Nukleotid_felvetel_raktarbol(){
        Virologus v = new Virologus();
        Raktar r = new Raktar();
        Nukleotid n = new Nukleotid();
        v.PutOnMezo(r);
        r.AddAnyag(n);
        v.CuccFelvetel();
    }
    private static void Aminosav_felvetel_raktarbol(){
        Virologus v = new Virologus();
        Raktar r = new Raktar();
        Aminosav n = new Aminosav();
        v.PutOnMezo(r);
        r.AddAnyag(n);
        v.CuccFelvetel();
    }
    private static void Nukleotid_rablas_masik_virologustol(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Nukleotid c = new Nukleotid();
        v2.AnyagMegkapas(c);
        v1.TargyElvetel(v2,c);
    }
    private static void Aminosav_rablas_masik_virologustol(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Aminosav c = new Aminosav();
        v2.AnyagMegkapas(c);
        v1.TargyElvetel(v2,c);
    }
    private static void Vedokopeny_felvetel_ovohelyrol(){
        Virologus v = new Virologus();
        ovohely o = new ovohely();
        Kopeny i = new Kopeny();
        v.PutOnMezo(o);
        v.CuccFelvetel();
    }
    private static void Zsak_felvetel_ovohelyrol(){
        Virologus v = new Virologus();
        ovohely o = new ovohely();
        Zsak i = new Zsak();
        v.PutOnMezo(o);
        v.CuccFelvetel();
    }
    private static void Kesztyu_felvetel_ovohelyrol(){
        Virologus v = new Virologus();
        ovohely o = new ovohely();
        Kesztyu i = new Kesztyu();
        v.PutOnMezo(o);
        v.CuccFelvetel();
    }
    private static void Vedokopeny_rablas_virologustol(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Kopeny c = new Kopeny();
        v2.TargyMegkapas(c);
        v1.TargyElvetel(v2,c);
    }
    private static void Zsak_rablas_virologustol(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Zsak c = new Zsak();
        v2.TargyMegkapas(c);
        v1.TargyElvetel(v2,c);
    }
    private static void Kesztyu_rablas_virologustol(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Kesztyu c = new Kesztyu();
        v2.TargyMegkapas(c);
        v1.TargyElvetel(v2,c);
    }
    private static void Virologus_masik_virologust_beken_benoto_agenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Stun s = new Stun();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v2.TargyMegkapas(vk);
        v2.TargyMegkapas(k);
        v2.TargyMegkapas(zs);
        v2.BuffMegkapas(vt);
        v2.BuffMegkapas(st);
        v2.BuffMegkapas(ei);
        v2.BuffMegkapas(ve);
        v1.agensKenes(v2,s);
    }
    private static void Virologus_masik_virologust_beken_vitustanc_agenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        VitusTanc s = new VitusTanc();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v2.TargyMegkapas(vk);
        v2.TargyMegkapas(k);
        v2.TargyMegkapas(zs);
        v2.BuffMegkapas(vt);
        v2.BuffMegkapas(st);
        v2.BuffMegkapas(ei);
        v2.BuffMegkapas(ve);
        v1.agensKenes(v2,s);
    }
    private static void Virologus_masik_virologust_beken_vedo_agenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Vedoagens s = new Vedoagens();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v2.TargyMegkapas(vk);
        v2.TargyMegkapas(k);
        v2.TargyMegkapas(zs);
        v2.BuffMegkapas(vt);
        v2.BuffMegkapas(st);
        v2.BuffMegkapas(ei);
        v2.BuffMegkapas(ve);
        v1.agensKenes(v2,s);
    }
    private static void Virologus_masik_virologust_beken_emlektorlo_agenssel(){
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Emlekezettorles s = new Emlekezettorles();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v2.TargyMegkapas(vk);
        v2.TargyMegkapas(k);
        v2.TargyMegkapas(zs);
        v2.BuffMegkapas(vt);
        v2.BuffMegkapas(st);
        v2.BuffMegkapas(ei);
        v2.BuffMegkapas(ve);
        v1.agensKenes(v2,s);
    }
    private static void Virologus_bekeni_magat_benoto_agenssel(){
        Virologus v1 = new Virologus();
        Stun s = new Stun();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v1.TargyMegkapas(vk);
        v1.TargyMegkapas(k);
        v1.TargyMegkapas(zs);
        v1.BuffMegkapas(vt);
        v1.BuffMegkapas(st);
        v1.BuffMegkapas(ei);
        v1.BuffMegkapas(ve);
        v1.agensKenes(v1,s);
    }
    private static void A_virologus_bekeni_magat_vitustanc_agenssel(){
        Virologus v1 = new Virologus();
        VitusTanc s = new VitusTanc();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v1.TargyMegkapas(vk);
        v1.TargyMegkapas(k);
        v1.TargyMegkapas(zs);
        v1.BuffMegkapas(vt);
        v1.BuffMegkapas(st);
        v1.BuffMegkapas(ei);
        v1.BuffMegkapas(ve);
        v1.agensKenes(v1,s);
    }
    private static void A_virologus_bekeni_magat_vedo_agenssel(){
        Virologus v1 = new Virologus();
        Vedoagens s = new Vedoagens();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v1.TargyMegkapas(vk);
        v1.TargyMegkapas(k);
        v1.TargyMegkapas(zs);
        v1.BuffMegkapas(vt);
        v1.BuffMegkapas(st);
        v1.BuffMegkapas(ei);
        v1.BuffMegkapas(ve);
        v1.agensKenes(v1,s);
    }
    private static void Virologus_bekeni_magat_emlektorlo_agenssel(){
        Virologus v1 = new Virologus();
        Emlekezettorles s = new Emlekezettorles();
        v1.agensMegkapas(s);
        Kopeny vk = new Kopeny();
        Kesztyu k = new Kesztyu();
        Zsak zs = new Zsak();
        VitusTanc vt = new VitusTanc();
        Stun st = new Stun();
        Emlekezettorles ei = new Emlekezettorles();
        Vedoagens ve = new Vedoagens();
        v1.TargyMegkapas(vk);
        v1.TargyMegkapas(k);
        v1.TargyMegkapas(zs);
        v1.BuffMegkapas(vt);
        v1.BuffMegkapas(st);
        v1.BuffMegkapas(ei);
        v1.BuffMegkapas(ve);
        v1.agensKenes(v1,s);
    }
    private static void Kesztyu_visszadob_benotoagens(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyu k = new Kesztyu();
        Stun s = new Stun();
        v2.TargyMegkapas(k);
        v1.agensKenes(v2,s);
    }
    private static void Kesztyu_visszadob_vedoagens(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyu k = new Kesztyu();
        Vedoagens s = new Vedoagens();
        v2.TargyMegkapas(k);
        v1.agensKenes(v2,s);
    }
    private static void Kesztyu_visszadob_Vitustanc(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyu k = new Kesztyu();
        VitusTanc s = new VitusTanc();
        v2.TargyMegkapas(k);
        v1.agensKenes(v2,s);
    }
    private static void Kesztyu_visszadob_emlektorlot(){
        Virologus v2 = new Virologus();
        Virologus v1 = new Virologus();
        Kesztyu k = new Kesztyu();
        Emlekezettorles s = new Emlekezettorles();
        v2.TargyMegkapas(k);
        v1.agensKenes(v2,s);
    }
    private static void Benoto_agens_keszotes(){
        Virologus v = new Virologus();
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        Stun s = new Stun();
        v.GenMegkapas(s);
        v.agensEloallit(s);

    }
    private static void Vitustanc_keszotes(){
        Virologus v = new Virologus();
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        VitusTanc s = new VitusTanc();
        v.GenMegkapas(s);
        v.agensEloallit(s);
    }
    private static void Vedo_agens_keszotes(){
        Virologus v = new Virologus();
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        Vedoagens s = new Vedoagens();
        v.GenMegkapas(s);
        v.agensEloallit(s);
    }
    private static void Emlektorlo_agens_keszotes(){
        Virologus v = new Virologus();
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Nukleotid());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        v.AnyagMegkapas(new Aminosav());
        Emlekezettorles s = new Emlekezettorles();
        v.GenMegkapas(s);
        v.agensEloallit(s);
    }
    private static void Jatek_megnyerese(){
        Virologus v = new Virologus();
        NoGen = 1;
        v.GenMegkapas(new Stun());
        v.EndRound();
        if(v.kodok.size() == NoGen){
            end(v);
        }
        //Ezt kitalalni
    }
    private static void Benoto_kod_tanulas(){
        Stun a = new Stun();
        Labor l = new Labor();
        l.AddKod(a);
        Virologus v = new Virologus();
        v.PutOnMezo(l);
        v.CuccFelvetel();
    }
    private static void Vitustanc_kod_tanulas(){
        VitusTanc a = new VitusTanc();
        Labor l = new Labor();
        l.AddKod(a);
        Virologus v = new Virologus();
        v.PutOnMezo(l);
        v.CuccFelvetel();
    }
    private static void Vedo_kod_tanulas(){
        Vedoagens a = new Vedoagens();
        Labor l = new Labor();
        l.AddKod(a);
        Virologus v = new Virologus();
        v.PutOnMezo(l);
        v.CuccFelvetel();
    }
    private static void Emlektorlo_kod_tanulas(){
        Emlekezettorles a = new Emlekezettorles();
        Labor l = new Labor();
        l.AddKod(a);
        Virologus v = new Virologus();
        v.PutOnMezo(l);
        v.CuccFelvetel();
    }
    public static void main(String args[]) {
        n = new Nullagens();
        vitusLepes = new VitusLepes();
        aktorLepes = new AktorLepes();
        stunLepes = new StunLepes();
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
                    Virologus_mezore_lep();
                    break;
                case "vol":
                    Virologus_egy_ovohelyre_lep();
                    break;
                case "vll":
                    Virologus_egy_labor_mezore_lep();
                    break;
                case "vrl":
                    Virologus_egy_raktar_mezore_lep();
                    break;
                case "sl":
                    Stun_lepes();
                    break;
                case "vtm":
                    Vitus_Lepes_mezo();
                    break;
                case "vtl":
                    Vitus_Lepes_labor();
                    break;
                case "vto":
                    Vitus_Lepes_ovohely();
                    break;
                case "vtr":
                    Vitus_Lepes_raktar();
                    break;
                case "nf":
                    Nukleotid_felvetel_raktarbol();
                    break;
                case "af":
                    Aminosav_felvetel_raktarbol();
                    break;
                case "nr":
                    Nukleotid_rablas_masik_virologustol();
                    break;
                case "ar":
                    Aminosav_rablas_masik_virologustol();
                    break;
                case "vfo":
                    Vedokopeny_felvetel_ovohelyrol();
                    break;
                case "zfo":
                    Zsak_felvetel_ovohelyrol();
                    break;
                case "kfo":
                    Kesztyu_felvetel_ovohelyrol();
                    break;
                case "vr":
                    Vedokopeny_rablas_virologustol();
                    break;
                case "zr":
                    Zsak_rablas_virologustol();
                    break;
                case "kr":
                    Kesztyu_rablas_virologustol();
                    break;
                case "beken benito":
                    Virologus_masik_virologust_beken_benoto_agenssel();
                    break;
                case "beken vitus":
                    Virologus_masik_virologust_beken_vitustanc_agenssel();
                    break;
                case "beken vedo":
                    Virologus_masik_virologust_beken_vedo_agenssel();
                    break;
                case "beken emlek":
                    Virologus_masik_virologust_beken_emlektorlo_agenssel();
                    break;
                case "beken benito magat":
                    Virologus_bekeni_magat_benoto_agenssel();
                    break;
                case "beken vitus magat":
                    A_virologus_bekeni_magat_vitustanc_agenssel();
                    break;
                case "beken vedo magat":
                    A_virologus_bekeni_magat_vedo_agenssel();
                    break;
                case "beken emlek magat":
                    Virologus_bekeni_magat_emlektorlo_agenssel();
                    break;
                case "vissza benito":
                    Kesztyu_visszadob_benotoagens();
                    break;
                case "vissza vedo":
                    Kesztyu_visszadob_vedoagens();
                    break;
                case "vissza vitus":
                    Kesztyu_visszadob_Vitustanc();
                    break;
                case "vissza emlek":
                    Kesztyu_visszadob_emlektorlot();
                    break;
                case "benito keszites":
                    Benoto_agens_keszotes();
                    break;
                case "vitus keszites":
                    Vitustanc_keszotes();
                    break;
                case "vedo keszites":
                    Vedo_agens_keszotes();
                    break;
                case "emlek keszites":
                    Emlektorlo_agens_keszotes();
                    break;
                case "win":
                    Jatek_megnyerese();
                    break;
                case "benito tanul":
                    Benoto_kod_tanulas();
                    break;
                case "vitus tanul":
                    Vitustanc_kod_tanulas();
                    break;
                case "vedo tanul":
                    Vedo_kod_tanulas();
                    break;
                case "emlek tanul":
                    Emlektorlo_kod_tanulas();
                    break;
                default:
                    break;
            }
        }
    }
}
