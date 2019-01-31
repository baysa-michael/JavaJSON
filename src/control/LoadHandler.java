package control;

import com.google.gson.Gson;
import model.UserCalendar;
import view.LoadView;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class LoadHandler implements Handler{
    public void execute(HashMap<String, Object> data) {
        // Create container variables for JSON file
        Gson gsonCalendar = new Gson();
        String calendarString = null;
        UserCalendar loadedCalendar;

        // Prompt the user for a filename
        LoadView newLoad = new LoadView();
        String filename = newLoad.getFilename();

        // Retrieve the calendar
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filename));

            // Read a single line JSON file
            calendarString = new String(encoded, "UTF-8");
        } catch (Exception e) {
            System.out.println("File Load Failed:\n" + e.getMessage());
            e.printStackTrace();
        }

        // Extract the calendar from the JSON data
        loadedCalendar = gsonCalendar.fromJson(calendarString, UserCalendar.class);

        // Replace the old calendar with the new calendar
        data.replace("calendar", loadedCalendar);

        // Inform the user of success
        newLoad.display("New Calendar Successfully Loaded");
    }
}
