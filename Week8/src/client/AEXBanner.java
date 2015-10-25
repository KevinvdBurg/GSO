package client;

import java.rmi.RemoteException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */

public class AEXBanner extends Application {

    public static final int width = 1000;
    public static final int height = 100;
    public static final int nanoTicks = 20000000; 
    // FRAME_RATE = 1000000000/NANO_TICKS = 50;

    private Text text;
    private double textLength;
    private double textPosition;
    private BannerController banner;
    private AnimationTimer animationTimer;

    @Override
    public void start(Stage primaryStage) {

        try {
            banner = new BannerController(this);
        }
        catch(RemoteException ex) {
            setKoersen("Could not create banner");
        }
        Font font = new Font("Arial", height);
        text = new Text();
        text.setFont(font);
        text.setFill(Color.YELLOW);

        Pane root = new Pane();
        root.setStyle("-fx-background-color: black;");
        root.getChildren().add(text);
        Scene scene = new Scene(root, width, height);
        
        primaryStage.setTitle("AEX banner");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront();

        // Start animation: text moves from right to left
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {
                long lag = now - prevUpdate;
                if (lag >= nanoTicks) {
                    // calculate new location of text
                    textPosition -= 10;
                    
                    if((text.getLayoutBounds().getWidth() + textPosition) < 0)
                    {
                        textPosition = width;   
                    }
                    
                    text.relocate(textPosition,0);
                    prevUpdate = now;
                }
            }
            @Override
            public void start() {
                prevUpdate = System.nanoTime();
                textPosition = width;
                text.relocate(textPosition, 0);
                setKoersen("Nothing to display");
                super.start();
            }
        };
        
        animationTimer.start();
    }

    public void setKoersen(String koersen) {
        text.setText(koersen);
        textLength = text.getLayoutBounds().getWidth();
    }

    @Override
    public void stop() {
        animationTimer.stop();
        banner.stop();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
