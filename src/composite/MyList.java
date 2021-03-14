package composite;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyList extends ArrayList<ValueContainer> {

    public MyList(ArrayList<? extends ValueContainer> c) {
        this.addAll(c);
    }

    public int sum() {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (ValueContainer valueContainer : this) {
            valueContainer.forEach(integer -> {
                atomicInteger.set(atomicInteger.addAndGet(integer));
            });
        }
        return atomicInteger.get();
    }

    public static void main(String[] args) {
        SingleValue singleValue = new SingleValue(10);
        ManyValues manyValues = new ManyValues();
        manyValues.add(20);
        manyValues.add(30);
        manyValues.add(40);
        manyValues.add(50);
        manyValues.add(22);
        ArrayList<ValueContainer> myValues = new ArrayList();
        myValues.add(singleValue);
        myValues.add(manyValues);
        MyList myList = new MyList(myValues);
        System.out.println(myList.sum());
    }

}
