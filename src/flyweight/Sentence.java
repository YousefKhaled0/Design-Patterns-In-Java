package flyweight;

import java.util.HashMap;

class Sentence {
    private String[] text;
    private HashMap<Integer, WordToken> wordTokens;

    public Sentence(String plainText) {
        plainText.trim();
        text = plainText.split("\\s");
        wordTokens = new HashMap<>();
    }

    public WordToken getWord(int index) {
        WordToken wordToken = new WordToken();
        wordTokens.put(index, wordToken);
        return wordToken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            if (wordTokens.get(i) != null && wordTokens.get(i).isCapitalize())
                sb.append(text[i].toUpperCase() + " ");
            else sb.append(text[i] + " ");
        }
        return sb.toString();
    }

    private class WordToken {
        private boolean capitalize;

        public boolean isCapitalize() {
            return capitalize;
        }

        public void setCapitalize(boolean capitalize) {
            this.capitalize = capitalize;
        }
    }

    public static void main(String[] args) {
        Sentence sentence = new Sentence("Hello World");
        sentence.getWord(0).setCapitalize(true);
        sentence.getWord(1).setCapitalize(true);
        System.out.println(sentence.toString());
    }
}