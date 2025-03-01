class Solution {
    static List<Long> jugglerSequence(long n) {
        List<Long> sequence = new ArrayList<>();
        generateSequence(n, sequence);
        return sequence;
    }

    private static void generateSequence(long n, List<Long> sequence) {
        sequence.add(n);
        if (n == 1) return;
        
        long next = (n % 2 == 0) ? (long) Math.floor(Math.sqrt(n)) 
                                 : (long) Math.floor(Math.pow(n, 1.5));
        generateSequence(next, sequence);
    }