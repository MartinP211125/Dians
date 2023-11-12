import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
public class PipeAndFilter {
    public static void main(String[] args) throws IOException {
        List<String> links = new ArrayList<String>(Arrays.asList(
                "https://www.openstreetmap.org/api/0.6/map?bbox=22.00319,41.43546,22.00637,41.43686",
                "https://www.openstreetmap.org/api/0.6/map?bbox=22.09008,41.49366,22.09326,41.49507",
                "https://www.openstreetmap.org/api/0.6/map?bbox=21.93260,41.57984,21.93896,41.58264",
                "https://www.openstreetmap.org/api/0.6/map?bbox=20.87554,41.18418,20.87872,41.18559",
                "https://www.openstreetmap.org/api/0.6/map?bbox=21.42946,41.99490,21.43264,41.99630",
                "https://www.openstreetmap.org/api/0.6/map?bbox=22.22467,41.40984,22.22785,41.41124",
                "https://www.openstreetmap.org/api/0.6/map?bbox=21.73940,41.77707,21.74258,41.77847",
                "https://www.openstreetmap.org/api/0.6/map?bbox=22.03265,41.51713,22.03583,41.51853",
                "https://www.openstreetmap.org/api/0.6/map?bbox=21.48884,42.00718,21.49202,42.00858",
                "https://www.openstreetmap.org/api/0.6/map?bbox=21.47485,41.96173,21.47803,41.96313"
                ));

        List<List<String>> DataBase = new ArrayList<>();

        for (int j = 0; j < links.size(); j++) {

            URL obj = new URL(links.get(j));
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            List<String> tags = new ArrayList<>();
            String inputLine = null, resultFilter = null;
            while ((inputLine = br.readLine()) != null) {


                if (GetSpecificTags.getTags(inputLine) != null) {
                    tags.add(GetSpecificTags.getTags(inputLine));
                }
            }
            DataBase.add(DataFilter.removeUselessData(tags, j));
        }
        CSV.Create(DataBase);
    }
}