package ai.replicant.baconnumber;

import ai.replicant.baconnumber.separationservice.SeparationService;

public class Main {

    public static void main(String[] args) {
	    SeparationService ss = SeparationService.getInstance();
        System.out.println(ss.getBaconNumber(4724)); // Kevin Bacon
        System.out.println(ss.getBaconNumber(388)); // Jim Broadbent
        System.out.println(ss.getBaconNumber(382)); // Bob Hoskins
        System.out.println(ss.getBaconNumber(31)); // Tom Hanks
    }
}
