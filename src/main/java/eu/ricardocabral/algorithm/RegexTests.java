package eu.ricardocabral.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTests {


  public static final String EXAMPLE_TEST = "This is my small example "
    + "string which I'm going to " + "use for pattern matching.";

 /* public static void main(String[] args) {
    System.out.println(EXAMPLE_TEST.matches("\\w.*"));
    String[] splitString = (EXAMPLE_TEST.split("\\s+"));
    System.out.println(splitString.length);// should be 14
    for (String string : splitString) {
      System.out.println(string);
    }
    // replace all whitespace with tabs
    System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
  }*/

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\\w+");
    // in case you would like to ignore case sensitivity,
    // you could use this statement:
    // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
    // check all occurance
    while (matcher.find()) {
      System.out.print("Start index: " + matcher.start());
      System.out.print(" End index: " + matcher.end() + " ");
      System.out.println(matcher.group());
    }
    // now create a new pattern and matcher to replace whitespace with tabs
    Pattern replace = Pattern.compile("\\s+");
    Matcher matcher2 = replace.matcher(EXAMPLE_TEST);


      pattern = Pattern.compile( "(\\d{1,2})\\/(\\d{1,2})\\/(\\d{4})" );
      matcher = pattern.matcher("12/02/1975");

    while (matcher.find()) {
      System.out.print("Start index: " + matcher.start());
      System.out.print(" End index: " + matcher.end() + " ");
      System.out.println(matcher.group());
      System.out.println(matcher.toMatchResult().group(0));
      System.out.println(matcher.toMatchResult().group(1));
      System.out.println(matcher.toMatchResult().group(2));
      System.out.println(matcher.toMatchResult().group(3));
    }
  }
}
