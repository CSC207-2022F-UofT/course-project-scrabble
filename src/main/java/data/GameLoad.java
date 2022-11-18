package data;

import java.io.File;

public interface GameLoad {
    final static File filename = new File("src/main/java/data/data.ser");
    public Object[] loadGame();
}
