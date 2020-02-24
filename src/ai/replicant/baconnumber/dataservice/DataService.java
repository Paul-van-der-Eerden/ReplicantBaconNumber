package ai.replicant.baconnumber.dataservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataService {

    private static DataService dataService = null;

    // Private member variables
    private final String FILENAME = "credits2.csv";
    private List<List<String>> movies;

    private DataService() {
        movies = new ArrayList<List<String>>();
    }

    public static DataService getDataService() {
        if (dataService == null) {
            dataService = new DataService();
        }
        dataService.readData();
        return dataService;
    }

    public List<List<String>> getMovieRecords() {
        return movies;
    }

    // read from file
    private void readData() {
        //System.out.println("Reading Data");
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource(FILENAME).getFile());

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //int counter = 1;
            String line = br.readLine();
            while( line != null ) {
                //System.out.println(counter++);
                String regex = "(.*?cast_id.*?'id': (\\d+).*?'name': '([^']*)'.*?)";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                if (m.find()) {
                    List<String> actors = new ArrayList<>();
                    do {
                        if (m.groupCount() == 3) {
                            actors.add(m.group(2) + "," + m.group(3));
                        }
                    } while (m.find());
                    movies.add(actors);
                }

                line = br.readLine();
            }
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // write to persistence layer (edits)
    // TODO: Implement this

    // read update file (new credits)
    // TODO: Implement this
}
