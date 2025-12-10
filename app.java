
import java.util.Random;
import java.util.Scanner;

public class app {

    public static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException {
        
        Inputs in = new Inputs();
        Dane dane = new Dane();
        Funkcje funkcje = new Funkcje();
        
        //wstepne ladowanie
        funkcje.Random(dane); 
        funkcje.randomHexFunc(dane);
        funkcje.odpowiedzFunc(dane);
        //funkcje.login(dane);
        
        //menu
        //funkcje.powitalny();
        
        do{

            
            funkcje.Main_menu(in);

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

            case "3":{ // informacje
                break;
            }
            case "4":{
                
            }
            case "5":{
                
            }

        }


        }while(!in.input.equals("0"));

    }

    static class Funkcje{

        void login(Dane dane){

            do{
                System.out.print("Wpisz login: ");
                String temp_login = s.next();
                System.out.print("Wpisz Haslo: ");
                String temp_haslo = s.next();

                if(temp_login.equals(dane.login) && temp_haslo.equals(dane.login)){
                    dane.attempts2 = true; 

                    System.out.println("");
                    System.out.println("Witamy !");
                    System.out.println("");

                }else{
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Wpisz login i haslo ponowanie");
                    System.out.println("");
                    System.out.println("");
                }

                

            }while(dane.attempts2 == false);
            
        }

        void menu_ustawien(Inputs inputs){
            System.out.println("");
            System.out.println("");
            System.out.println("===== MENU USTAWIEŃ =====");
            System.out.println("");
            System.out.println("1 - zmien poziom trudnosci");
            System.out.println("0 - Powrót do menu głównego");
            System.out.println("");

            
        }

        void Main_menu(Inputs inputs){
            
            
            // wyświetlenie menu głównego
            System.out.println("*FALLOUT*");
            System.out.println("");
            System.out.println("");
            System.out.println("===== MENU GŁÓWNE =====");
            System.out.println("1 - Graj");
            System.out.println("2 - Ustawienia");
            System.out.println("3 - Informacje");
            System.out.println("0 - Wyjście");
            


            System.out.print("Wybierz opcję: ");
            
            inputs.input = s.next();

        }
 
        void Random(Dane dane){

            Random r = new Random();

            for(int a = 0; a < dane.tabRandomSlowo.length; a++){
                dane.tabRandomSlowo[a] = dane.bankSlowEasy[r.nextInt(dane.bankSlowEasy.length)];
            }
        }

        void wypiszMenu(Inputs in, Dane dane){
   
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
            
            for(int i = 0; i<20; i+=2){
                System.out.println(dane.RandomHex[i] + dane.tabRandomSlowo[i]+ "   " + dane.RandomHex[i + 1] + dane.tabRandomSlowo[i + 1]);

            }

            
            
            System.out.println("");
            System.out.println("Wpisz odp: ");

            in.input = s.next();
            
        }

        void randomHexFunc(Dane dane){

            Random r = new Random();
            

            for(int i = 0; i<dane.RandomHex.length; i++){
                int value = r.nextInt(400 - 100 + 1);
                dane.RandomHex[i] = String.format("0x%04X",value);
                
            }
        }

        void wyborTrudnosci(Inputs inputs){
            
            
            
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

        void odpowiedzFunc(Dane dane){

            Random r = new Random();

            dane.good_ans = dane.tabRandomSlowo[r.nextInt(dane.tabRandomSlowo.length)];
        }

        void powitalny() throws InterruptedException {
            String[] spinner = {"|", "/", "-", "\\"};
            int delay = 200;

            System.out.print("Ladowanie ");

            for (int i = 0; i < 20; i++) {
                System.out.print(spinner[i % spinner.length]);
                Thread.sleep(delay);
                System.out.print("\b");
            }

            System.out.println("Gotowe!");

        }
    }

    static class Inputs {

        String input_a ="";
        
        String input_s = "";

        String input = "";
    }

    static class Dane {

        String aktualny = "latwy";

        int poziom = 1;

        String login = "lukasz";

        String haslo = "haslo";

        String good_ans ="";

        int attempts = 4;

        boolean attempts2 = false;

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
    
    static class Login{

    }

    
}