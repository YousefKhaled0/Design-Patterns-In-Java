package decorator;

class Lizard
{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}
