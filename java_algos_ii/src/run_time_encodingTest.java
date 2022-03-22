import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

// Unit Testing--> test small pieces of code
public class run_time_encodingTest {
    @Test
    public void test1(){
        final run_time_encoding run_time_encoding = new run_time_encoding();
        final String testData = "asdfasdfasdfaaasdf";
        final String encoded_data = run_time_encoding.encode(testData);
        final String decoded_data = run_time_encoding.decode(testData);

        assertEquals(testData, decoded_data);
        printResults(testData, encoded_data);
    }
    private static void printResults( final String testData, String encoded_data){

        double calc_start = 1.0;
        double encoded_len = encoded_data.length();
        double test_len = testData.length();
        final double data_saved = calc_start / (encoded_len / test_len) *100 ;
        System.out.println("[TEST DATA] --> "+testData);
        System.out.println("[ENCODED_DATA] --> " +encoded_data);
        System.out.println("[DATA_SAVED] --> " +data_saved + "%");
    }
}
