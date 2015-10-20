package AEXBanner;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class AEXBanner extends Application {
    public static final int width = 1000;
    public static final int height = 100;
    public static final int ticks = 20000000;
    
    private Text text;
    private double length;
    private double position;
    private BannerController bannerController;
    private AnimationTimer animationTimer;
    
    @Override
    public void start(Stage stage)
    {
        bannerController = new BannerController(this);
        
        Font font = new Font("Arial", height);
        text = new Text();
        text.setFont(font);
        text.setFill(Color.BLACK);
        
        Pane root = new Pane();
        root.getChildren().add(text);
        Scene scene = new Scene(root, length, length);
        
        stage.setTitle("AEX banner");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
        
        animationTimer = new AnimationTimer()
        {
            private long prevUpdate;
            
            @Override
            public void handle(long now)
            {
                long lag = now - prevUpdate;
                
                if(lag >= ticks)
                {
                    text.relocate(position, 0);
                    prevUpdate = now;
                }
            }
            
            @Override
            public void start()
            {
                prevUpdate = System.nanoTime();
                position = width;
                text.relocate(position, 0);
                setKoersen("nothing to displaly");
                super.start();
            }
        };
        
        animationTimer.start();
    }
    
    /**
    * 
    * @param koersen
    */
    public void setKoersen(String koersen) {
        text.setText(koersen);
        length = text.getLayoutBounds().getWidth();
    }
    
    @Override
    public void stop()
    {
        animationTimer.stop();
        bannerController.stop();
    }
}