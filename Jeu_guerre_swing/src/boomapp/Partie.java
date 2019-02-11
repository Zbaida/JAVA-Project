package boomapp;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Partie {
       static Spaceman spaceman;
       
       static ArrayList<Avion> liste_avions;
       static Thread game;
       static int score=0;
       static boolean gameOver=false;
       static int score_globale=0;
       static int timeleft=30;
       static int speed=60;
       static int objectif=4;
       static int level=0;
     
      public static void startPartie(final JLabel panel,int s,int t){
          
          score=0;
          level++;
         speed=s;
         timeleft=t;
           liste_avions=new ArrayList<Avion>();
          
           //on crée un thread dans lequel on lance les spaceccrafts pour battre l'enemie puahhahahahahaha
            game= new Thread(){
                public void run(){
                while(gameOver!=true){
                    //for(int i=0;i<4;i++){
                    try {
                         Avion avion = new Avion(panel,speed);
                        liste_avions.add(avion);
                         avion.start();
                        //Avion avion=(Avion) liste_avions.get(i);
                        //avion.start();
                        Thread.sleep((int)(Math.random()*(6000+1-2000) + 2000));
                         //Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                       // Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               }
            };

            game.start();
            spaceman = new Spaceman(panel);
       }
      //public static void clickEvenement()

}
