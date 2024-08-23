package apocalypse.fandomcraft.main;

import java.util.*;
import java.io.*;

public class DataFile
{
    private static String fileWorldData;
    private static String line;
    List<String> listWorldData;
    
    public DataFile() {
        this.listWorldData = new ArrayList<String>();
    }
    
    public static void writeToFile(final String file, final String content) {
        try {
            final FileWriter writer = new FileWriter(file);
            final BufferedWriter buf = new BufferedWriter(writer);
            buf.write(content);
            writer.close();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }
    
    public static void readFromFile(final String file, final String content) {
        try {
            final FileReader reader = new FileReader(file);
            final BufferedReader buf = new BufferedReader(reader);
            while ((DataFile.line = buf.readLine()) != null) {
                Tools.println(DataFile.line);
            }
            reader.close();
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
        catch (IOException error2) {
            error2.printStackTrace();
        }
    }
    
    static {
        DataFile.fileWorldData = "world.fc";
    }
}
