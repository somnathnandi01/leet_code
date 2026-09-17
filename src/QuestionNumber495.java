class QuestionNumber495 {

public int findPoisonedDuration(int[] timeSeries, int duration) {
    // Find the total seconds of getting damage
    // starting_time * duration = how long it works
    int total = timeSeries.length * duration;

    // getting first time to use it as reference for first iteration
    int t = timeSeries[0];

    // loop through all time stamps
    for (int i = 1; i < timeSeries.length; i++) {

        // getting next_time when it got damage
        int next_t = timeSeries[i];

        // formula is to check if starting_time + duration_of_damage > next_reset_time
        // or not if it is greater then that we will cut those seconds from duration
        // otherwise continue
        // it inclusive so we are not going to remove a extra from it
        // e.g. [1,2], duration=2
        // 1+2(duration) > 2(next_t) 
        // 1,2 here cut = 2-1 = 1 
        // so only 1(cut) is valid other timestamps are invalid
        // it makes 2(duration)-1(cut) = 1 invalid from total timestamp
        // so total - 1(invalids)
        if (t + duration > next_t) {
            int cut = next_t-t;
            total = total - (duration - cut);
        }
        t = next_t;
    }

    return total;
}

    public static void main(String[] args) {
        
    }
}