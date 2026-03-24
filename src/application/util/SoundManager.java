package application.util;

import javafx.scene.media.AudioClip;

public class SoundManager {
    private boolean enabled = true;

    private AudioClip moveSound = new AudioClip(getClass().getResource("/sounds/move.mp3").toExternalForm());

    public void playMove() { if(enabled) moveSound.play(); }
    public void toggle() { enabled = !enabled; System.out.println("Sons " + (enabled ? "activés" : "désactivés")); }
}