// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ScrabbleTest {
   public ScrabbleTest() {
   }

   public static void main(String[] var0) {
      if (var0.length == 0) {
         System.out.println("Please provide a specific test to run: isWordInDictionary, wordScore, createHand, playHand, playHandWithMockInput, or playGameWithMockInput.");
      } else {
         switch (var0[0]) {
            case "isWordInDictionary":
               testIsWordInDictionary();
               break;
            case "wordScore":
               testWordScore();
               break;
            case "createHand":
               testCreateHand();
               break;
            case "playHand":
               testPlayHand();
               break;
            case "playHandWithMockInput":
               testPlayHandWithMockInput();
               break;
            case "playGameWithMockInput":
               testPlayGameWithMockInput();
               break;
            default:
               System.out.println("Unknown test: " + var0[0]);
         }

      }
   }

   private static void testIsWordInDictionary() {
      System.out.println("\nTesting isWordInDictionary():");
      if (Scrabble.NUM_OF_WORDS == 0) {
         Scrabble.init();
      }

      try {
         System.out.println("'' -> " + Scrabble.isWordInDictionary("") + " (expected: false)");
         System.out.println("'CAT' -> " + Scrabble.isWordInDictionary("CAT") + " (expected: false)");
         System.out.println("'xyz123' -> " + Scrabble.isWordInDictionary("xyz123") + " (expected: false)");
         System.out.println("'qwxz' -> " + Scrabble.isWordInDictionary("qwxz") + " (expected: false)");
      } catch (Exception var1) {
         System.err.println("Error during test execution: " + var1.getMessage());
         var1.printStackTrace();
      }

   }

   private static void testWordScore() {
      System.out.println("\nTesting wordScore():");
      System.out.println("'cat' -> " + Scrabble.wordScore("cat") + " (expected: 15)");
      System.out.println("'dog' -> " + Scrabble.wordScore("dog") + " (expected: 15)");
      System.out.println("'quiz' -> " + Scrabble.wordScore("quiz") + " (expected: 88)");
      String var0 = "friendship";
      System.out.println("'" + var0 + "' -> " + Scrabble.wordScore(var0) + " (expected: 240)");
      System.out.println("'running' -> " + Scrabble.wordScore("running") + " (expected: 1056)");
      System.out.println("'' -> " + Scrabble.wordScore("") + " (expected: 0)");
      System.out.println("'a' -> " + Scrabble.wordScore("a") + " (expected: 1)");
   }

   private static void testCreateHand() {
      System.out.println("\nTesting createHand():");

      for(int var0 = 0; var0 < 3; ++var0) {
         String var1 = Scrabble.createHand();
         System.out.println("\nHand " + (var0 + 1) + ":");
         PrintStream var10000 = System.out;
         int var10001 = var1.length();
         var10000.println("Length: " + var10001 + " (expected: " + Scrabble.HAND_SIZE + ")");
         System.out.println("Contains 'a': " + var1.contains("a") + " (expected: true)");
         System.out.println("Contains 'e': " + var1.contains("e") + " (expected: true)");
         boolean var2 = var1.chars().allMatch((var0x) -> {
            return var0x >= 97 && var0x <= 122;
         });
         System.out.println("All lowercase letters: " + var2 + " (expected: true)");
         boolean var3 = var1.matches("[a-z]+");
         System.out.println("Valid Scrabble letters: " + var3 + " (expected: true)");
      }

   }

   private static void testPlayHand() {
      System.out.println("\nTesting playHand():");
      if (Scrabble.NUM_OF_WORDS == 0) {
         Scrabble.init();
      }

      String var0 = ".\n";
      ByteArrayInputStream var1 = new ByteArrayInputStream(var0.getBytes());
      InputStream var2 = System.in;
      System.setIn(var1);

      try {
         Scrabble.playHand("test");
         System.out.println("playHand() method exists and accepts String parameter");
         String var3 = "cat";
         MyString.spacedString(var3);
         MyString.subsetOf("cat", var3);
         MyString.remove(var3, "cat");
         Scrabble.isWordInDictionary("cat");
         Scrabble.wordScore("cat");
         System.out.println("All required helper methods are implemented");
      } catch (Exception var7) {
         System.out.println("Error in test: " + var7.getMessage());
      } finally {
         System.setIn(var2);
      }

   }

   private static void testPlayHandWithMockInput() {
      System.out.println("\nTesting playHand with mock input (hand: aretiin):");
      Scrabble.init();
      String var0 = "train\ninvalid1\ninvalid2\n.\n";
      ByteArrayInputStream var1 = new ByteArrayInputStream(var0.getBytes());
      InputStream var2 = System.in;
      PrintStream var3 = System.out;
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      System.setIn(var1);
      System.setOut(new PrintStream(var4));

      try {
         Scrabble.playHand("aretiin");
         String var5 = var4.toString();
         System.setOut(var3);
         System.out.println("Expected sequence of plays:");
         System.out.println("1. 'train' -> score: 25");
         System.out.println("\nActual output:");
         System.out.println(var5);
         boolean var6 = var5.contains("train");
         System.out.println("\nTest passed: " + var6);
      } finally {
         System.setIn(var2);
         System.setOut(var3);
      }

   }

   private static void testPlayGameWithMockInput() {
      System.out.println("\nTesting playGame exists:");
      String var0 = "e\n";
      ByteArrayInputStream var1 = new ByteArrayInputStream(var0.getBytes());
      InputStream var2 = System.in;

      try {
         System.setIn(var1);
         Scrabble.playGame();
         System.out.println("playGame() method exists and can be called");
      } catch (Exception var7) {
         System.out.println("Error: playGame() method is not properly implemented");
         var7.printStackTrace();
      } finally {
         System.setIn(var2);
      }

   }
}
