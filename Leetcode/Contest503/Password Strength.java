class Solution {
    public int passwordStrength(String password) {
        boolean[] hasLower = new boolean[26];
        boolean[] hasUpper = new boolean[26];
        boolean[] hasDigit = new boolean[10];
        boolean[] hasSpecial = new boolean[4];
        int strength = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch) && !hasLower[ch - 'a']){
                strength++;
                hasLower[ch - 'a'] = true;
            } else if (Character.isUpperCase(ch) && !hasUpper[ch - 'A']){
                strength += 2;
                hasUpper[ch - 'A'] = true;
            } else if (Character.isDigit(ch) && !hasDigit[ch - '0']){
                strength += 3;
                hasDigit[ch - '0'] = true;
            } else {
                if (ch=='$' && !hasSpecial[0]){
                    hasSpecial[0] = true;
                    strength += 5;
                }else if (ch=='#' && !hasSpecial[1]){
                    hasSpecial[1] = true;
                    strength += 5;
                }else if (ch=='@' && !hasSpecial[2]){
                    hasSpecial[2] = true;
                    strength += 5;
                }else if (ch=='!' && !hasSpecial[3]){
                    hasSpecial[3] = true;
                    strength += 5;  
                }
            }
        }
        return strength;
    }
}