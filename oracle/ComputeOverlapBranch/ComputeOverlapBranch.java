class ComputeOverlapBranch {
    //@ requires Integer.MIN_VALUE <= (ax2 - ax1) * (ay2 - ay1) && (ax2 - ax1) * (ay2 - ay1) <= Integer.MAX_VALUE;
    //@ requires Integer.MIN_VALUE <= (bx2 - bx1) * (by2 - by1) && (bx2 - bx1) * (by2 - by1) <= Integer.MAX_VALUE;
    //@ requires Integer.MIN_VALUE <= (ax2<bx2?ax2:bx2) - (ax1>bx1?ax1:bx1) && (ax2<bx2?ax2:bx2) - (ax1>bx1?ax1:bx1) <= Integer.MAX_VALUE;
    //@ requires Integer.MIN_VALUE <= (ay2<by2?ay2:by2) - (ay1>by1?ay1:by1) && (ay2<by2?ay2:by2) - (ay1>by1?ay1:by1) <= Integer.MAX_VALUE;
    //@ ensures \result == (((ax2<bx2?ax2:bx2) - (ax1>bx1?ax1:bx1)) > 0 ? ((ax2<bx2?ax2:bx2) - (ax1>bx1?ax1:bx1)) : 0) * (((ay2<by2?ay2:by2) - (ay1>by1?ay1:by1)) > 0 ? ((ay2<by2?ay2:by2) - (ay1>by1?ay1:by1)) : 0);
    public int computeOverlapArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int minX2 = bx2;
        if(ax2 < bx2) {
            minX2 = ax2;
        }
        int maxX1 = bx1;
        if(ax1 > bx1) {
            maxX1 = ax1;
        }
        int minY2 = by2;
        if(ay2 < by2) {
            minY2 = ay2;
        }
        int maxY1 = by1;
        if(ay1 > by1) {
            maxY1 = ay1;
        }
        int overlapWidth = minX2 - maxX1;
        int overlapHeight = minY2 - maxY1;
        if(overlapWidth < 0) {
            overlapWidth = 0;
        }
        if(overlapHeight < 0) {
            overlapHeight = 0;
        }
        int overlapArea = overlapHeight * overlapWidth;
        return overlapArea;
    }
}
