/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Usuario
 */
public class Music implements Runnable{
    
    private File audioFile;
    private Clip audioClip;
            
    public Music(String audioFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioFile = new File(audioFilePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);
    }
    
    @Override
    public void run() {
        getAudioClip().start();
    }
    
    public void stopMusic() {
        
    }

    /**
     * @return the audioClip
     */
    public Clip getAudioClip() {
        return audioClip;
    }
    
    
}
