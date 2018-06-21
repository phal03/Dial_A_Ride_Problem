package utilities;

public class SortRequest {

    private Request r;
    public void sort(Request[] req) {
        for (int i = 0; i < 20; i++) {
            for (int j = i + 1; j < 20; j++) {
                if (req[i].getEndTime() > req[j].getEndTime()) {
                    r = req[i];
                    req[i] = req[j];
                    req[j] = r;
                }
            }
        }
    }
}
