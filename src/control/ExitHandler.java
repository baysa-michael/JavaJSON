package control;

import view.ExitView;

import java.util.HashMap;

public class ExitHandler implements Handler{
    public void execute(HashMap<String, Object> data) {
        // Change the continue program identifier to false
        data.replace("continueProgram", false);

        // Display exit message to user
        ExitView newExit = new ExitView();
        newExit.display();
    }
}
