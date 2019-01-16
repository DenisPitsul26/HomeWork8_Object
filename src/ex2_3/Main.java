package ex2_3;

public class Main {
    public static void main(String[] args) {

        Integer numberInt = 5;
        Long numberLong = 28L;
        Double numberDouble = 3.14;
        String word = "Hello";
        Object object = new Object();

        BlackList blackList = new BlackList();
        blackList.addClass(String.class);
        blackList.addClass(Long.class);

        Stack stack = new Stack(blackList);
        stack.addObject(numberInt);
        stack.addObject(numberDouble);
        stack.addObject(numberLong);
        stack.addObject(object);
        stack.addObject(word);

        System.out.println(stack.getAndDeleteObject().toString());
        System.out.println(stack.getObject().toString());

        System.out.println(stack);

    }
}
