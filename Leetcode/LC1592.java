class Solution {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') spaceCount++;
        }

        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        StringBuilder result = new StringBuilder();

        if (wordCount == 1) {
            result.append(words[0]);
            while (spaceCount-- > 0) result.append(' ');
            return result.toString();
        }

        int spaceBetween = spaceCount / (wordCount - 1);
        int spaceRemainder = spaceCount % (wordCount - 1);

        for (int i = 0; i < wordCount; i++) {
            result.append(words[i]);
            if (i != wordCount - 1) {
                for (int j = 0; j < spaceBetween; j++) result.append(' ');
            }
        }

        for (int i = 0; i < spaceRemainder; i++) result.append(' ');

        return result.toString();
    }
}
