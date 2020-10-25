import java.util.Arrays;

public class AnalyzeA {
  static char[] hindo = {'z','q','j','x','k','v','b','p','g','f',
                  'y','c','w','m','u','l','d','r','s','n',
                  'h','i','o','a','t','e'};
  static String inputText = FileIO.read("angoubun-shuffle.txt");
  public static void main(String args[]) {
    Decoding();
  }

  static int[] AlphabetCount(){
    int[] Count = {0,0,0,0,0,0,0,0,0,0,
                   0,0,0,0,0,0,0,0,0,0,
                   0,0,0,0,0,0};
    for(int i=0; i<inputText.length(); i++){
      char c = inputText.charAt(i);
      if ('a'<= c && c <= 'z'){
        int n = c - 'a';
        Count[n] = Count[n] + 1;
      }
    }
    return Count;
  }

  static char[] keyList(){
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j',
                       'k','l','m','n','o','p','q','r','s','t',
                       'u','v','w','x','y','z'};
    int count[];
    count = AlphabetCount();
    int[] numC = Arrays.copyOf(count,count.length);
    Arrays.sort(numC);
    char key[] = new char[alphabet.length];
    for(int i=0;i<count.length;i++){
      int index = -1;
      for(int j=0;j<count.length;j++){
        if(numC[i] == count[j]){
          index = j;
          break;
        }
      }
      key[i] = alphabet[index];
    }
    return key;
  }

  static void Decoding(){
    char key[] = keyList();
    for(int i=0; i<inputText.length(); i++){
      char c = inputText.charAt(i);
      if ('a'<= c && c <= 'z'){
        for(int j=0;j<key.length;j++){
          if(c == key[j]){
            c = hindo[j];
            break;
          }
        }
      }
      System.out.print(c);
    }
    System.out.println();
  }
}