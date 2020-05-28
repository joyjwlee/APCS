import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class Sound extends JFrame {
    private Clip clip;

    public Sound(String n) {
        try {
            URL url;
            clip = AudioSystem.getClip();
            if (n == "Clack") {
                url = this.getClass().getClassLoader().getResource("Clack.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip.open(audioIn);
                clip.start();
                clip.loop(0);
            }

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopSong() {
        clip.stop();
    }
}