class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long both = Math.min(need1, need2);
        long cost = both * Math.min(costBoth, cost1 + cost2);
        need1 -= both;
        need2 -= both;
        cost += (long) need1 * Math.min(cost1, costBoth);
        cost += (long) need2 * Math.min(cost2, costBoth);

        return cost;
    }
}