// alternative for String.format() is  res.add(h + ":" + (m < 10 ? "0" + m : m));
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int min=0;min<60;min++){
                if(count(h)+count(min)==turnedOn){
                    res.add(String.format("%d:%02d",h,min));
                }
            }
        }
        return res;
    }
    private int count(int n){
        int res = 0;
        while(n>0){
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}

// you can also use Integer.bitCount() to count the number of 1s in the binary representation of a number, which is more concise and efficient.

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int min=0;min<60;min++){
                if(Integer.bitCount(h)+Integer.bitCount(min)==turnedOn){
                    res.add(String.format("%d:%02d",h,min));
                }
            }
        }
        return res;
    }
}



// using backtracking
// mapper for hours and minutes 0-3 for hours, 4-9 for minutes
class Solution {
    List<String> res;
    public List<String> readBinaryWatch(int turnedOn){
        res = new ArrayList<>();
        backtrack(turnedOn,0,0,0);
        return res;
    }
    private void backtrack(int leds, int index, int hour, int minute){
        if(hour>11 || minute>59) return;
        if(leds == 0){
            res.add(String.format("%d:%02d",hour,minute));
            return;
        }
        for(int i=index;i<10;i++){
            if(i<4){
                backtrack(leds-1,i+1,hour+(1<<i),minute);
            } else {
                backtrack(leds-1,i+1,hour,minute+(1<<(i-4)));
            }
        }
    }
}