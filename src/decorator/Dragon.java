package decorator;

public class Dragon {
    private Bird bird;
    private Lizard lizard;

    public Dragon() {
        bird = new Bird();
        lizard = new Lizard();
    }

    public void setAge(int age) {
        bird.setAge(age);
        lizard.setAge(age);
    }

    public String fly() {
        return bird.fly();
    }

    public String crawl() {
        return lizard.crawl();
    }

    public static void main(String[] args) {
        Dragon d = new Dragon();
        d.setAge(5);
        System.out.println(d.fly());
        System.out.println(d.crawl());
    }
}