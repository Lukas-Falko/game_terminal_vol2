import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class app {

    public static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException { //odpala program
        
        Inputs in = new Inputs();
        Dane dane = new Dane();
        Funkcje funkcje = new Funkcje();
        
        //wstepne ładowanie
        funkcje.Random(dane); 
        funkcje.randomHexFunc(dane);
        funkcje.odpowiedzFunc(dane);
        funkcje.login(dane, in);
        
        //menu
        funkcje.powitalny();
        do{

            funkcje.Main_menu(in, dane);

            switch (in.input){

            case "1":{ //fallout
                
                do{

                    funkcje.wypiszMenu(in, dane);

                    dane.attempts = dane.attempts - 1;

                }while(dane.attempts > 0 && !in.input.equals("stop") );

                System.out.println("");
                System.out.println("Zakończono rundę. Powrót do menu...");
                dane.attempts = dane.attempts + 4;
                break;
            }

            case "2":{ //ustawienia

                do{
                    
                    funkcje.menu_ustawien(in);

                    System.out.print("Wybierz opcję: ");
                    in.input_s = s.next();

                    switch(in.input_s){
                        case "1":{

                            do{
                                System.out.println("----Wybierz poziom trudnosci----");
                                System.out.println("aktualny poziom: " + dane.aktualny);
                                System.out.println("");
                                System.out.println("1 - latwy");
                                System.out.println("2 - sredni ");
                                System.out.println("3 - trudny");
                                System.out.println("0 - wyjscie");
                                System.out.println("");
                                System.out.println("");
                                System.out.println("Wpisz: ");

                                in.input_a = s.next();

                                

                                if(in.input_a.equals("1") ){
                                    dane.poziom = 1;
                                    dane.aktualny = "latwy";
                                }if(in.input_a.equals("2")){
                                   dane.poziom = 2;       
                                   dane.aktualny = "sredni";
                                }if( in.input_a.equals("3")){
                                    dane.poziom = 3;
                                    dane.aktualny = "trudny";
                                }

                            }while(!in.input_a.equals("0"));
                            break;
                            
                        }
                    }

                }while(!in.input_s.equals("0"));
            }

        }


        }while(!in.input.equals("0"));

    }


    static class Funkcje{ // klasa z funkcjami

        void login(Dane dane, Inputs in){ //pierwsze gui do logowania

            do{
                System.out.println("Witaj w systemie logowania");
                System.out.println("");
                System.out.println("1 - logowanie");
                System.out.println("2 - Rejestracja");
                System.out.println("");
                System.out.print("Wpisz cos: ");
                String x = s.next();

                switch (x){

                    case "1":{ //logowanie

                        do{
                            System.out.print("Wpisz login: ");
                            in.input_b = s.next();
                            String temp_login = in.input_b;
                            if(in.input_b.equals("0")){
                                break;
                            }

                            System.out.print("Wpisz haslo: ");
                            in.input_b = s.next();
                            String temp_haslo = in.input_b;

                            if(temp_login.equals(dane.login) && temp_haslo.equals(dane.haslo)){
                                dane.haslo_h = true; 
                                dane.login_h = true;

                                System.out.println("");
                                System.out.println("Witamy !");
                                System.out.println("");
                                break;

                            }else{
                                System.out.println("");
                                System.out.println("");
                                System.out.println("Wpisz login i haslo ponowanie");
                                System.out.println("");
                                System.out.println("");
                            }
                        }while(!in.input_b.equals("0"));
                       break; 
                    }

                    case "2":{ // rejestracja
                        
                        System.out.println("Testowa funkcja");
                        break;
                    }
                }

            }while(dane.login_h == false && dane.haslo_h == false );
            
        }
        
        void Main_menu(Inputs inputs, Dane dane){ //menu glowne porgramu 1/graj 2/ustawienia ..itp
                    
                    
                    // wyświetlenie menu głównego
                    System.out.println("");
                    System.out.println("");
                    System.out.println("*FALLOUT*");
                    System.out.println("");
                    System.out.println("Witaj: " + dane.login);
                    System.out.println("");
                    System.out.println("===== MENU GŁÓWNE =====");
                    System.out.println("1 - Graj");
                    System.out.println("2 - Ustawienia");
                    System.out.println("3 - Informacje");
                    System.out.println("0 - Wyjście");
                    


                    System.out.print("Wybierz opcję: ");
                    
                    inputs.input = s.next();

        }

        void menu_ustawien(Inputs inputs){ // menu glowne usawein trudnosci ..itp
            System.out.println("");
            System.out.println("");
            System.out.println("===== MENU USTAWIEŃ =====");
            System.out.println("");
            System.out.println("1 - zmien poziom trudnosci");
            System.out.println("0 - Powrót do menu głównego");
            System.out.println("");

            
        }

        void Random(Dane dane){ // funkcja do wypelniania tablicy randomowymi slowami do gry fallowut 

            Random r = new Random();

            for(int a = 0; a < dane.tabRandomSlowo.length; a++){
                dane.tabRandomSlowo[a] = dane.bankSlowEasy[r.nextInt(dane.bankSlowEasy.length)];
            }
        }

        void wypiszMenu(Inputs in, Dane dane){ // funcka wypisawnia menu w grze fallout


            
   
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("________________________________________________________");
            System.out.println("");
            System.out.println("ROBOCO INDUSTRIES (TM) TERMLINK PROTOCOL");
            System.out.println("!!! WARNING: LOCKOUT IMMINENT !!!");
            System.out.println("");
            System.out.println("" + dane.attempts + " ATTEMPT(S) LEFT:");
            System.out.println("");
            System.out.println("Poprawna odp: " + dane.good_ans);

            System.out.println("");
            System.out.println("Wspolne: " + dane.wspolne);
            
            for(int i = 0; i<20; i+=2){
                System.out.println(dane.RandomHex[i] + dane.tabRandomSlowo[i]+ "   " + dane.RandomHex[i + 1] + dane.tabRandomSlowo[i + 1]);

            }
  
            System.out.println("");
            System.out.println("Wpisz odp: ");
            in.input = s.next();
            
            if(in.input.equals(dane.good_ans)){
                dane.attempts = dane.attempts - 10;
            }else{
                        
                char[] input = in.input.toCharArray(); //tablica ze słowem z inputu
                char[] odp = dane.good_ans.toCharArray(); // tablica z poprawną odpowiedzią

                for(int i = 0; i<odp.length; i++){
                    
                }
         
            }  
        }

        void randomHexFunc(Dane dane){ // random hex number cos w tylu 0x%04X

            Random r = new Random();
            

            for(int i = 0; i<dane.RandomHex.length; i++){
                int value = r.nextInt(400 - 100 + 1);
                dane.RandomHex[i] = String.format("0x%04X",value);
                
            }
        }

        void wyborTrudnosci(Inputs inputs){ // gui wyboru trudnosci 
            
            
            
            for(int i=0; i<5; i++){
                System.out.println("");
            }
            System.out.println("______________________________________________");
            for(int i=0; i<3; i++){
                System.out.println("");
            }
            System.out.println("1 - Latwy");
            System.out.println("2 - Sredni");
            System.out.println("3 - Trudny");
            System.out.println("");
            System.out.print("Wpisz liczbe jako poziom trudnosci: "); 
            
            inputs.input = s.next();




        }

        void odpowiedzFunc(Dane dane){ // losowanie odpowiedzi z bazy

            Random r = new Random();

            dane.good_ans = dane.tabRandomSlowo[r.nextInt(dane.tabRandomSlowo.length)];
        }

        void powitalny() throws InterruptedException { // naimacja ładwoania "krecenie sie spin me / " 
            String[] spinner = {"|", "/", "-", "\\"};
            int delay = 200;

            System.out.print("Ladowanie ");

            for (int i = 0; i < 20; i++) {
                System.out.print(spinner[i % spinner.length]);
                Thread.sleep(delay);
                System.out.print("\b");
            }

            System.out.println("Gotowe!");
            System.out.println("");
            System.out.println("");

        }
    }


    static class Inputs { // zmienne inputow

        String input_b ="";

        String input_a ="";
        
        String input_s = "";

        String input = "";
    }


    static class Dane {  

        static List<User> users = new ArrayList<>();

        int wspolne = 0;

        String aktualny = "latwy";

        int poziom = 1;

        String login = "Falko";

        String haslo = "123";

        String good_ans ="";

        int attempts = 4;

        boolean login_h = false;
        boolean haslo_h = false;

        int y = 0;

        public String tabRandomSlowo[] = new String[30];
        
        public String RandomHex[] = new String[30];

        public String bankSlowEasy[] = {
            "kernel", "matrix", "system", "vector", "table",
            "transf", "algor", "interf", "proto", "netwrk",
            "firewl", "databs", "gatewy", "compil",
            "runtim", "packge", "librar", "framew",
            "thread", "proces", "endpnt", "funct",
            "variab", "instnc", "object", "class",
            "inher", "constr", "param", "operat",
            "point", "buffer", "regist", "cache",
            "fsys", "clustr", "replic", "backup",
            "monitr", "adapt", "router", "switch",
            "ethrnt", "wifi", "virtua", "contain",
            "deploy", "encrypt", "hash", "token",
            "sessio", "latenc", "bandwd", "thrupt",
            "storag", "archiv", "metada", "chksum",
            "excep", "iterat", "recurs", "syntax"
        };
    }
     
}