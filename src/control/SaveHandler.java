package control;

import com.google.gson.Gson;
import view.SaveView;

import java.io.*;
import java.util.HashMap;

public class SaveHandler implements Handler{
    public void execute(HashMap<String, Object> data) {
        // Prompt the user for a filename
        SaveView newSave = new SaveView();
        String filename = newSave.getFilename();

        // Create a new GSON object
        Gson curentCalendar = new Gson();

        // Turn the calendar into a JSON string
        String jsonOutput = curentCalendar.toJson(data.get("calendar"));

        // Display the JSON string
        // newSave.display("JSON Output:  " + jsonOutput);

        // Open
        try (FileOutputStream newFile = new FileOutputStream(filename);
             OutputStreamWriter codedFile = new OutputStreamWriter(newFile, "UTF-8");
             BufferedWriter outputFile = new BufferedWriter(codedFile);) {
            // Write File to Output
            outputFile.write(jsonOutput);

            newSave.display("Calendar Successfully Saved to " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found:\n" + e.getMessage() + "\n");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File Save Failed:\n" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("File Save Failed:\n" + e.getMessage());
        }
    }
}
