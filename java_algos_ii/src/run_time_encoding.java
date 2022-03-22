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
        final StringBuilder string1 = new StringBuilder();
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
            string1.append(i - source.charAt(i));
            string1.append(i);

        };

        System.out.println("[+]--> Encoded [1]"+ string);
        System.out.println("[+]--> Encoded [2]"+ string1);
        System.out.println("[+]--> Len "+ string.length());
        return string.toString();
    }
    public String runLengthEncoding(String string) {
        final StringBuilder running_string = new StringBuilder();
        int running_len = 1;

        for (int i = 1; i < string.length(); i++){
            char val = string.charAt(i);
            char running_val = string.charAt(i-1);

            if ((val == running_val && running_len == 9)){
                running_string.append(Integer.toString(running_len));
                running_string.append(running_val);
                running_len = 0;


            }
            running_len+=1;
        }
        running_string.append(Integer.toString(running_len));
        running_string.append(string.charAt(string.length() - 1));

        return running_string.toString();
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
        double toEncode_len2 = toEncode.length();
        double encoded_len = encoding_results.length();

        final double data_saved = calc_start / (encoded_len * toEncode_len) * 100 ;
        System.out.println("[TEST DATA] --> "+ toEncode);
        System.out.println("[+] Encoding[01] Results--> " + encoding_results);
        System.out.println("[+] Decoding Results--> " + decoding_results);
        System.out.println("[DATA_SAVED]-[ALGO-1] --> " + data_saved + "%\n\n");

        String encoding_resuults01 = run.runLengthEncoding(toEncode);
        double encoded_len2 = encoding_resuults01.length();
        final double data_saved2 = calc_start / (encoded_len2 * toEncode_len) * 100 ;
        int n = 50;
        String str = "x";
        String X = new String(new char[n]).replace("\0", str);
        System.out.println(X);
        System.out.println("[+] Encoding[02] Results--> " + encoding_resuults01);
        System.out.println("[DATA_SAVED]-[ALGO-2] --> " + data_saved2 + "%");

    }
}
