package state.machine;

class CombinationLock {
    private int[] combination;
    private String password;
    private StringBuilder enteredSoFar = new StringBuilder("");
    public String status = "LOCKED";

    public CombinationLock(int[] combination) {
        this.combination = combination;
        StringBuilder sb = new StringBuilder("");
        for (int i : combination) {
            sb.append(i);
        }
        password = sb.toString();
    }

    public void enterDigit(int digit) {
        enteredSoFar.append(digit);
        System.out.println(enteredSoFar.toString());
        if (enteredSoFar.toString().equals(password)) status = "OPEN";
    }

    public static void main(String[] args) {
        CombinationLock combinationLock = new CombinationLock(new int[]{1, 2, 3, 4});
        combinationLock.enterDigit(1);
        System.out.println(combinationLock.status);
        combinationLock.enterDigit(2);
        System.out.println(combinationLock.status);
        combinationLock.enterDigit(3);
        System.out.println(combinationLock.status);
        combinationLock.enterDigit(4);
        System.out.println(combinationLock.status);
    }
}