public class PrintPattern {
    public static void main(String[] args) {
        String input = "we are good programmers";
        
        String[] words = input.split(" ");
        
        StringBuilder reversedInput = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedInput.append(words[i]);
            if (i > 0) {
                reversedInput.append(" ");
            }
        }
        
        System.out.println(reversedInput.toString());
    }
}

