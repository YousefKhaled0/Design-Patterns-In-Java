package objectNull;

public class NullLog implements Log {

    private int recordCount = 0;
    private int recordCountLimit = recordCount + 1;

    @Override
    public int getRecordLimit() {
        return recordCountLimit;
    }

    @Override
    public int getRecordCount() {
        recordCountLimit++;
        return recordCount++;
    }

    @Override
    public void logInfo(String message) {

    }

}
