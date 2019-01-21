package ex2_3;

public class StackWithoutList {

    private Object[] stackOfObjects;
    private int lengthOfStack = 0;
    private BlackList blackList;

    public StackWithoutList(int lenght, BlackList blackList) {
        if (lenght > 0) {
            stackOfObjects = new Object[lenght];
        } else {
            stackOfObjects = new Object[10];
        }
        this.blackList = blackList;
    }

    public StackWithoutList(BlackList blackList) {
        this.blackList = blackList;
        stackOfObjects = new Object[10];
    }

    public StackWithoutList() {
    }

    public int getLengthOfStack() {
        return lengthOfStack;
    }

    public BlackList getBlackList() {
        return blackList;
    }

    public void setBlackList(BlackList blackList) {
        this.blackList = blackList;
    }

    private void increaseList() {
        int n = stackOfObjects.length;
        if (n == 1) {
            n = 2;
        } else {
            n *= 1.5;
        }
        Object[] tempStack = new Object[n];
        System.arraycopy(stackOfObjects, 0, tempStack, 0, stackOfObjects.length);
        stackOfObjects = tempStack;
    }

    public void push(Object object) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException("This object is null.");
        }
        if (blackList.isClassAlreadyInTheList(object.getClass())) {
            System.out.println("This object can not add to stack.");
        }
        else {
            if (lengthOfStack >= stackOfObjects.length) {
                increaseList();
            }
            stackOfObjects[lengthOfStack] = object;
            lengthOfStack++;
        }
    }

    public void clear() {
        for (int i = 0; i < lengthOfStack; i++) {
            stackOfObjects[i] = null;
        }
    }

    public Object peek(){
        if (lengthOfStack == 0) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stackOfObjects[lengthOfStack - 1];
    }

    public Object pop() {
        if (lengthOfStack == 0) {
            System.out.println("Stack is empty!");
            return null;
        }
        Object temp = stackOfObjects[lengthOfStack - 1];
        stackOfObjects[lengthOfStack - 1] = null;
        lengthOfStack--;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < lengthOfStack;i++){
            sb.append(i + 1).append(": ").append(stackOfObjects[i]).append(System.lineSeparator());
        }
        return sb.toString();
    }

}