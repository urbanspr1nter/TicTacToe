public enum MarkerType {
    NONE(0),
    CROSS(1),
    CIRCLE(2);

    private int val;

    MarkerType(int val) {
        this.val = val;
    }

    public String toString() {
        if(this.val == 0) {
            return "NONE";
        }
        else if(this.val == 1) {
            return "CROSS";

        }
        else if(this.val == 2) {
            return "CIRCLE";
        }
        return "NONE";
    }
};

