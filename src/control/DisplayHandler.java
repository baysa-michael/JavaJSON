package control;

import view.DisplayView;

import java.util.HashMap;

public class DisplayHandler implements Handler{
    public void execute(HashMap<String, Object> data) {
        // Create New Display View
        DisplayView newDisplay = new DisplayView();
        newDisplay.display(data.get("calendar"));
    }
}
