/*
StringBuilder()
Constructs a string builder with no characters in it and an initial capacity of 16 characters.
StringBuilder(CharSequence seq)
Constructs a string builder that contains the same characters as the specified CharSequence.
StringBuilder(int capacity)
Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument.
StringBuilder(String str)
Constructs a string builder initialized to the contents of the specified string.
 */

import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class run_time_encoding{

    public String encode(final String source){
        System.out.println("[+]--> Encoding "+ source );
        System.out.println("[+]--> Len "+ source.length());
        final StringBuilder string = new StringBuilder();
        System.out.println("[+]--> Test String Empty? "+ string.isEmpty());

        for(int i= 0; i < source.length(); i++ ){
            int run = 1;
            while(i+1 < source.length() && source.charAt(i) == source.charAt(i+1)){
                i++;
                run++;
                if (run == source.length()){
                    break;
                }
            }
            // appends the val first, then pos
            string.append(source.charAt(i));
            string.append(i);

        };

        System.out.println("[+]--> Encoded "+ string);
        System.out.println("[+]--> Len "+ string.length());
        return string.toString();
    }

    public String decode(final String encodedStr){
        final StringBuilder string = new StringBuilder();
        final Pattern pattern = Pattern.compile("([\\d]+)([^\\d]+)");//REGEX
        final Matcher matcher = pattern.matcher(encodedStr);
        while (matcher.find()){
            string.append(String.join("", Collections.nCopies(Integer.parseInt(matcher.group(1)), matcher.group(2))));
        }
        System.out.println("[+]--> Decoded " + string);
        return string.toString();
    }

    public static void main (String[] args){
       // int a = Integer.parseInt(args[2]);
        Scanner scanner = new Scanner(System.in);
        System.out.println("[!]--> Enter The String to Encode:  ");
        String toEncode = scanner.nextLine();

        final run_time_encoding run = new run_time_encoding();
        String encoding_results = run.encode(toEncode);
        String decoding_results = run.decode(encoding_results);

        double calc_start = 1.00;
        double toEncode_len = toEncode.length();
        double encoded_len = encoding_results.length();
        double decoded_len = decoding_results.length();

        final double data_saved = calc_start / (encoded_len / toEncode_len) * 100 ;
        System.out.println("[TEST DATA] --> "+ toEncode);
        System.out.println("[+] Encoding Results--> " + encoding_results);
        System.out.println("[+] Decoding Results--> " + decoding_results);
        System.out.println("[DATA_SAVED] --> " + data_saved + "%");

    }
}
