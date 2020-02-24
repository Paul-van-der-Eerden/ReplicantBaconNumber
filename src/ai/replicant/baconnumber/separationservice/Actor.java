package ai.replicant.baconnumber.separationservice;

import java.util.HashSet;

public class Actor {
    // Private member variables
    private String name;
    private HashSet<Actor> relationships;
    private int id;

    // Constructor
    public Actor(String name, int id) {
        this.name = name;
        this.id = id;
        this.relationships = new HashSet<Actor>();
    }

    // Public methods
    public String getName() {
        return name;
    }

    public HashSet<Actor> getRelationships() {
        return relationships;
    }

    public int getId() {
        return id;
    }

    public void addRelationship(Actor actor) {
        relationships.add(actor);
    }

}
