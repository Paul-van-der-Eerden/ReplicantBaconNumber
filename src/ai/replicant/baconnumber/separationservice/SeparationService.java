package ai.replicant.baconnumber.separationservice;

import ai.replicant.baconnumber.dataservice.DataService;

import java.util.*;

public class SeparationService {

    private static SeparationService separationService = null;

    // Member variables
    private final int KEVINBACON_ID = 4724; // This is not dynamic so if IDs are ever regenerated this could break.
    private DataService ds;
    HashMap<Integer, Actor> actors;

    private SeparationService() {
        ds = DataService.getDataService();
        actors = new HashMap<>();
    }

    public static SeparationService getInstance() {
        if (separationService == null) {
            separationService = new SeparationService();
        }
        separationService.initialize();
        return separationService;
    }

    private void initialize() {
        List<List<String>> movies = ds.getMovieRecords();
        for (List<String> cast : movies) {
            for (int i = 0; i < cast.size()-1; i++) {
                String[] castInfo = cast.get(i).split(",");
                int castID = Integer.valueOf(castInfo[0]);
                String castName = castInfo[1];
                if (!actors.containsKey(castID)) {
                    actors.put(castID,new Actor(castName, castID));
                }
                for (int j = i+1; j < cast.size(); j++) {
                    String[] castInfo2 = cast.get(j).split(",");
                    int castID2 = Integer.valueOf(castInfo2[0]);
                    String castName2 = castInfo2[1];
                    if (!actors.containsKey(castID2)) {
                        actors.put(castID2,new Actor(castName2, castID2));
                    }
                    actors.get(castID).addRelationship(actors.get(castID2));
                    actors.get(castID2).addRelationship(actors.get(castID));
                }
            }
        }
    }

    public int getBaconNumber(int source) {
        return getDegreesOfSeparation(source, KEVINBACON_ID);
    }

    // Breadth-First search
    public int getDegreesOfSeparation(int source, int target) {
        HashSet<Actor> pendingSearches;
        Actor sourceActor = actors.get(source);
        Actor targetActor = actors.get(target);
        int depth = 0;

        if ((sourceActor != null) && (targetActor != null)) {
            if (source == target) {
                return 0;
            }
            pendingSearches = (HashSet<Actor>) sourceActor.getRelationships().clone();
            for (int i = 0; i < pendingSearches.size(); i++) {
                depth++;
                if (!pendingSearches.contains(targetActor)) {
                    // add the next level of searches
                    HashSet<Actor> additionalSearches = new HashSet<>();
                    for (Actor actor : pendingSearches) {
                        additionalSearches.addAll((HashSet<Actor>) actor.getRelationships().clone());
                    }
                    pendingSearches.addAll(additionalSearches);
                } else {
                    return depth;
                }
            }
        } else {
            // TODO: make this string a resource
            throw new NoSuchElementException("One of the specified actors could not be found.");
        }

        // Negative value represents no link between actors
        return -1;
    }

}
