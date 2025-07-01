package MainMenu;

import Components.Game;
import Components.MyFrame;

public class Menu {
    Game[] gamesArray;
    MyFrame frame;
    public Menu(Game[] gamesArray){
        this.gamesArray = gamesArray;
    }
    public void init(){
        this.frame = new MyFrame();

    }

}
