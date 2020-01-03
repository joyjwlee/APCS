public class Quine
{
  public static void main(String[] args)
  {
    char q = 34;      // Char for quotations
    String[] j1IsGod = {    // Array of string of source code
    "public class Quine",
    "{",
    "  public static void main(String[] args)",
    "  {",
    "    char q = 34;      // Char for quotations",
    "    String[] j1IsGod = {    // Array of string of source code",
    "    ",
    "    };",
    "    for(int i = 0; i < 6; i++)            // First loop",
    "        System.out.println(j1IsGod[i]);",
    "    for(int i = 0; i < j1IsGod.length; i++)    // Prints all in array",
    "        System.out.println(j1IsGod[6] + q + j1IsGod[i] + q + ',');",
    "    for(int i = 7; i < j1IsGod.length; i++)    // Prints itself xD",
    "        System.out.println(j1IsGod[i]);",
    "  }",
    "}",
    };
    for(int i = 0; i < 6; i++)           // First loop
        System.out.println(j1IsGod[i]);
    for(int i = 0; i < j1IsGod.length; i++)    // Prints all in array
        System.out.println(j1IsGod[6] + q + j1IsGod[i] + q + ',');
    for(int i = 7; i < j1IsGod.length; i++)    // Prints itself xD
        System.out.println(j1IsGod[i]);
  }
}