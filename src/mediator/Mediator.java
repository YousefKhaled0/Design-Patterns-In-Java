package mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    private List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant p) {
        participants.add(p);
    }

    public void publish(int n) {
        participants
                .forEach(participant -> participant.setValue(participant.getValue() + n));
    }

    public static void main(String[] args) {
        Mediator m = new Mediator();
        Participant p1 = new Participant(m);
        Participant p2 = new Participant(m);
        Participant p3 = new Participant(m);


        p1.say(10);
        System.out.println(p1.getValue());
        System.out.println(p2.getValue());
        System.out.println(p3.getValue());

        p2.say(20);
        System.out.println(p1.getValue());
        System.out.println(p2.getValue());
        System.out.println(p3.getValue());

        p3.say(30);
        System.out.println(p1.getValue());
        System.out.println(p2.getValue());
        System.out.println(p3.getValue());


    }
}
