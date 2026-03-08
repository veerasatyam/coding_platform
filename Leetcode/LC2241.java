class ATM {
    int[] banknotesCount;
    public ATM() {
        banknotesCount = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++){
            this.banknotesCount[i]+=banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        int[] denominations = new int[]{20,50,100,200,500};
        int temp = amount;
        for(int i = 4;i>=0;i--){
           int required = temp/denominations[i];
           if(required>banknotesCount[i]){
               ans[i] = banknotesCount[i];
               banknotesCount[i] = 0;
               temp-=ans[i]*denominations[i];
           }
           else{
               ans[i] = required;
               banknotesCount[i]-=required;
               temp-=required*denominations[i];
           }
        }
        if(temp>0){
            for(int i=0;i<5;i++){
                banknotesCount[i]+=ans[i];
            }
            return new int[]{-1};
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
