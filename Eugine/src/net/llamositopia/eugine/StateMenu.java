package net.llamositopia.eugine;

import com.duckblade.eugine.api.Squishy;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StateMenu extends BasicGameState {
    public int getID() {
        return 0;
    }

    Image bg;
    Image play;
    Image quit;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bg = new Image("res/img/menu/background.png");
        play = new Image("res/img/menu/play.png");
        quit = new Image("res/img/menu/quit.png");
        for (Squishy c : Squishy.values()){
            System.out.println("Loaded " + c.getKey());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(bg, 0, 0);
        g.drawImage(play, gc.getWidth()/2-play.getWidth()/2, gc.getHeight()/2+play.getHeight()/2);
        g.drawImage(quit, gc.getWidth()/2-quit.getWidth()/2, gc.getHeight()/2+quit.getHeight()/2+gc.getHeight()/3);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_F11)){
            gc.setFullscreen(!gc.isFullscreen());
        }
        if (gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
            System.out.println("X: " + gc.getInput().getMouseX() + "\nY: " + gc.getInput().getMouseY());
            if (gc.getInput().getMouseX()>gc.getWidth()/2-play.getWidth()/2 && gc.getInput().getMouseX()<gc.getWidth()/2+play.getWidth()/2 && gc.getInput().getMouseY()>gc.getHeight()/2-play.getHeight()/2 && gc.getInput().getMouseY()>gc.getHeight()/2+play.getHeight()/2){
                sbg.enterState(2);
            }
            if (gc.getInput().getMouseX()>gc.getWidth()/2-quit.getWidth()/2 && gc.getInput().getMouseX()<gc.getWidth()/2+quit.getWidth()/2 && gc.getInput().getMouseY()>gc.getHeight()/2-quit.getHeight()/2+gc.getHeight()/3 && gc.getInput().getMouseY()>gc.getHeight()/2+quit.getHeight()/2+gc.getHeight()/3){
                gc.exit();
            }
        }
    }
}
