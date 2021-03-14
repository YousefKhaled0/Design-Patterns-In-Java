package proxy.practice;

class ResponsiblePerson {

    private Person person;

    public ResponsiblePerson(Person person) {
        this.person = person;
    }

    public String drink() {
        if (person.getAge() < 18) {
            return "Can't Drink too young!";
        }
        return person.drink();
    }

    public String drive() {
        if (person.getAge() < 16) {
            return "Can't Drive too young!";
        }
        return person.drive();
    }

    public String drinkAndDrive() {
        return "dead";
    }
}