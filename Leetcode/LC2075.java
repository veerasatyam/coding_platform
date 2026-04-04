class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int size = encodedText.length();
        int m = size / rows;
        int n = rows;
        char[][] matrix = new char[n][m];
        for(int i = 0;i<size;i++){
            int row = i / m;
            int col = i % m;
            matrix[row][col] = encodedText.charAt(i);

        }
        Stack<Character> s = new Stack<>();
        for(int i = 0;i<m;i++){
            int x = 0,y=i;
            while(x < n && y < m){
                s.push(matrix[x][y]);
                x++;
                y++;
            }
        }
        while(!s.isEmpty() && s.peek() == ' '){
            s.pop();
        }
        StringBuilder str = new StringBuilder();
        while(!s.isEmpty()) str.append(s.pop());
        return str.reverse().toString();
    }
}


// in the above solution we are using stack to remove the extra spaces in the end of the dectypted string 
// we can also use inbuilt method to remove them using stripTrailing() which onlly removes the last white spaces;
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1)
            return encodedText;

        int len = encodedText.length();

        if(len == 0)
            return encodedText;

        int cols = (int) Math.ceil( (double) len/rows);

        char[][] matrix = new char[rows][cols];
        char[] encodedArr = encodedText.toCharArray();
        int e=0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                matrix[i][j] = encodedArr[e++];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;

            while (r < rows && c < cols) {
                sb.append(matrix[r][c]);
                r++;
                c++;
            }
        }

        return sb.toString().stripTrailing();
    }
}


// space optimisation

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;
        int len = encodedText.length();
        if (len == 0) return encodedText;
        int cols = (int) Math.ceil((double) len / rows);
        StringBuilder sb = new StringBuilder();
        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;
            while (r < rows && c < len) {
                sb.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }
        return sb.toString().stripTrailing();
    }
}