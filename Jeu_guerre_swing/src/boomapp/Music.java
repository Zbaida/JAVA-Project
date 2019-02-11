/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boomapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author hemic
 */
public class Music {
    
    static String musica;
    
    
    Music(String msc) 
    {       
        
   musica=msc;
}
    
    
    public static void play() 
    {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
        try
        {InputStream test = new FileInputStream(musica);
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
      }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
   
}
    
}
