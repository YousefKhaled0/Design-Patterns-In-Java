package chain;

public class QueryEvent {
    private Statistic statistic;
    private Integer result = 0;

    public QueryEvent(Statistic statistic) {
        this.statistic = statistic;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
