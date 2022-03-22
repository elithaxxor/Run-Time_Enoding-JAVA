import java.util.*;

public class validate_array_subSequence_asy {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence){
        int arrayIdx = 0;
        int seqIdx = 0;
        while (arrayIdx < array.size() && seqIdx < sequence.size()){
            if (array.get(arrayIdx).equals(sequence.get(seqIdx))){
                System.out.println("checking indexes");
                seqIdx++;
            }
                arrayIdx++;
        }
        return false;
    }
}
