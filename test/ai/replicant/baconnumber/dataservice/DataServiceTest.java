package ai.replicant.baconnumber.dataservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceTest {

    // USING credits2.csv (a small subset of data)
    @Test
    void getMovieRecords() {
        DataService ds = DataService.getDataService();
        assertEquals(ds.getMovieRecords().size(),7);
    }
}