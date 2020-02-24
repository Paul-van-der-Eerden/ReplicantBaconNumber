package ai.replicant.baconnumber.separationservice;

import org.junit.jupiter.api.Test;

class ActorTest {

    @Test
    void getName() {
        Actor a = new Actor("TEST", 1);
        assert a.getName()=="TEST";
    }

    @Test
    void getRelationships() {
        Actor a1 = new Actor("TEST1", 1);
        Actor a2 = new Actor("TEST2", 2);
        a1.addRelationship(a2);
        assert a1.getRelationships().contains(a2);
    }

    @Test
    void getId() {
        Actor a = new Actor("TEST", 1);
        assert a.getId()==1;
    }

    @Test
    void addRelationship() {
        Actor a1 = new Actor("TEST1", 1);
        Actor a2 = new Actor("TEST2", 2);
        a1.addRelationship(a2);
        assert a1.getRelationships().contains(a2);
    }
}