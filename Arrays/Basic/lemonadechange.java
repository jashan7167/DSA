class Solution {
    public boolean lemonadeChange(int[] bills) {
        // first thing keep track of the bills
        int fivedollarbills = 0;
        int tendollarbills = 0;
        int twentydollarbills = 0;

        for (int a : bills) {
            if (a == 5) {
                fivedollarbills++;
            } else if (a == 10) {
                if (fivedollarbills == 0) {
                    return false;
                } else {
                    fivedollarbills--;
                    tendollarbills++;
                }
            } else if (a == 20) {

                if (tendollarbills == 0 && fivedollarbills >= 3) {
                    fivedollarbills -= 3;
                } else if (tendollarbills > 0 && fivedollarbills > 0) {
                    tendollarbills--;
                    fivedollarbills--;
                } else {
                    return false;
                }
                twentydollarbills++;
            }
        }

        return true;

    }
}
