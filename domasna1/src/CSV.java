import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CSV {
    public static void Create(List<List<String>> Data) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\Martin\\IdeaProjects\\untitled5sd\\output.txt")));
        writer.write("ID, Name, Address, Phone, website, Opening Hours\n");

        try {
            for (List<String> set : Data) {
                for (String line : set) {
                    writer.write(line + " ");
                }
                writer.write( "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

}