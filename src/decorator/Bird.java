package decorator;

class Bird
{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}