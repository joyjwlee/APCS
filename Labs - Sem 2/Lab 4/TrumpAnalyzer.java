import java.util.*;
import java.io.*;

public class TrumpAnalyzer {
    static ArrayList<String> wordList;
    static String all = "";

    public static void go() {
        visuals();
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds); }
        catch( InterruptedException ex ) {}
    }

    public static void countdown(){
        for(int i = 3; i > 0; i-- ) {
            System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\t" + i);
            sleep(1000);
            System.out.print('\u000C');
        }
    }

    public static void visuals(){
        countdown();

        new Sound("Intro");
        sleep(1000);
        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\tÏƒÎ·Ñ” Ï�Ñ”Ñ�Ñ•ÏƒÎ·...");
        sleep(4800);
        System.out.print('\u000C');

        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\tÎµÎ¹ÎµvÎµÎ· Ò¯ÎµÎ±Ñ�s...");
        sleep(4800);
        System.out.print('\u000C');

        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\tð�Ÿ›ð�Ÿ™,ð�Ÿ ð�Ÿ˜ð�Ÿ¡ ð�“‡ð�’¶ð�“Œ ð�“£ð�“Œð�‘’ð�‘’ð�“‰ð�“ˆ...");
        sleep(4800);
        System.out.print('\u000C');

        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\tð�•‹â„�ð�”¼ ð�”»ð�•†â„•ð�”¸ð�•ƒð�”» ð�•‹â„�ð�•Œð�•„â„™ ð�•‹ð�•Žð�”¼ð�”¼ð�•‹ ð�”¸â„•ð�”¸ð�•ƒð�•�ð�•Šð�•€ð�•Š");
        sleep(2300);
        System.out.println("\n\n\n\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â¡¿â ¿â ›â ‹â ‰â¡‰â£‰â¡›â£›â ¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¿â£¿â¡¿â ‹â �â „â „â „â „â „â¢€â£¸â£¿â£¿â¡¿â ¿â¡¯â¢™â ¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¿â¡¿â „â „â „â „â „â¡€â¡€â „â¢€â£€â£‰â£‰â£‰â �â �â£¶â£¶â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¿â¡‡â „â „â „â „â �â£¿â£¿â£€â ˆâ ¿â¢Ÿâ¡›â ›â£¿â ›â ›â£¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¿â¡†â „â „â „â „â „â ˆâ �â °â£„â£´â¡¬â¢µâ£´â£¿â£¤â£½â£¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¿â¡‡â „â¢€â¢„â¡€â „â „â „â „â¡‰â »â£¿â¡¿â �â ˜â ›â¡¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â¡¿â ƒâ „â „â ˆâ »â „â „â „â „â¢˜â£§â£€â ¾â ¿â ¶â ¦â¢³â£¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¶â£¤â¡€â¢€â¡€â „â „â „â „â „â „â »â¢£â£¶â¡’â ¶â¢¤â¢¾â£¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â¡¿â Ÿâ ‹â „â¢˜â£¿â£¦â¡€â „â „â „â „â „â ‰â ›â »â »â ºâ£¼â£¿â Ÿâ ‹â ›â ¿â£¿â£¿");
        System.out.println("\t\t\t\tâ ‹â ‰â �â „â „â „â „â „â „â¢»â£¿â£¿â£¶â£„â¡€â „â „â „â „â¢€â£¤â£¾â£¿â£¿â¡€â „â „â „â „â¢¹");
        System.out.println("\t\t\t\tâ „â „â „â „â „â „â „â „â „â „â¢»â£¿â£¿â£¿â£·â¡¤â „â °â¡†â „â „â ˆâ ‰â ›â ¿â¢¦â£€â¡€â¡€â „");
        System.out.println("\t\t\t\tâ „â „â „â „â „â „â „â „â „â „â ˆâ¢¿â£¿â Ÿâ¡‹â „â „â „â¢£â „â „â „â „â „â „â „â ˆâ ¹â£¿â£€");
        System.out.println("\t\t\t\tâ£¿â£¿â£¿â£¿â£¿â£¶â£¤â¡€â¢€â¡€â „â „â „â „â „â „â »â¢£â£¶â¡’â ¶â¢¤â¢¾â£¿â£¿â£¿â£¿â£¿â£¿â£¿");
        System.out.println("\t\t\t\tâ „â „â „â „â „â „â „â „â „â „â „â „â ¹â£¿â£¿â¡‡â „â „â ¸â£¿â¡„â „â ˆâ �â „â „â „â „â „â£¿");
        System.out.println("\t\t\t\tâ „â „â „â „â „â „â „â „â „â „â „â „â „â¢»â£¿â¡‡â „â „â „â¢¹â£§â „â „â „â „â „â „â „â „â ˜");
        System.out.println("\t\t\t\t               \"ï½ƒï½ˆï½‰ï½Žï½�\"");
        sleep(2000);
        System.out.print('\u000C');

        new Sound("Rap");
        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\tBEGIN!");
        sleep(500);
        
        sleep(3500);
    }
}