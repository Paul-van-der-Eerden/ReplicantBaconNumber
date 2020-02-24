package ai.replicant.baconnumber.separationservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparationServiceTest {

    // USING credits2.csv (a small subset of data)
    @Test
    void getBaconNumber() {
        SeparationService ss = SeparationService.getInstance();
        assertEquals(0, ss.getBaconNumber(4724)); // Kevin Bacon
        assertEquals(2, ss.getBaconNumber(388)); // Jim Broadbent
        assertEquals(1, ss.getBaconNumber(382)); // Bob Hoskins
        assertEquals(-1, ss.getBaconNumber(31)); // Tom Hanks
    }

    @Test
    void getDegreesOfSeparation() {
        SeparationService ss = SeparationService.getInstance();
        assertEquals(1, ss.getDegreesOfSeparation(388,382)); // Jim Broadbent, Bob Hoskins
        assertEquals(0, ss.getDegreesOfSeparation(382,382)); // Bob Hoskins, Bob Hoskins
        assertEquals(-1, ss.getDegreesOfSeparation(382,31)); // Bob Hoskins, Tom Hanks
    }
}