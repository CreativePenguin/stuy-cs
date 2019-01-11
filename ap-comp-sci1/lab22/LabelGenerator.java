
public class LabelGenerator {

    private final String[] FIGS = {
        "Figure 0", "Figure 1", "Figure 2", "Figure 3",
        "Figure 4", "Figure 5", "Figure 6"
    };
    private final String[] POSS = {
        "P0", "P1", "P2", "P3", "P4"
    };

    private final labelType type;
    private int index;

    public LabelGenerator(labelType type, int index) {
        this.type = type;
        this.index = index;
    }

    public String nextLabel() {
        switch(type) {
        case FIG:
            index++;
            return FIGS[index - 1];
        case POS:
            index++;
            return POSS[index - 1];
        default:
            throw new RuntimeException("enums are hard");
        }
    }

}
