package chain;

import java.util.function.Consumer;

public class Observer {

    private Consumer<QueryEvent> attackHandler;
    private Consumer<QueryEvent> defenceHandler;


    public void setAttackHandler(Consumer<QueryEvent> attackHandler) {
        this.attackHandler = attackHandler;
    }

    public void setDefenceHandler(Consumer<QueryEvent> defenceHandler) {
        this.defenceHandler = defenceHandler;
    }

    public void fire(QueryEvent queryEvent) {
        if (queryEvent.getStatistic().equals(Statistic.ATTACK)) {
            attackHandler.accept(queryEvent);
        } else defenceHandler.accept(queryEvent);
    }
}
