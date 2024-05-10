public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b);

        // код не работает т.к. b = 0, а деление на 0 невозможно
        // Требуется проверка на b != 0

        if (c == 0 && b == 0) {
            System.out.println("Деление на 0 невозможно");
        } else {
            calc.println.accept(c);
        }

        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener listener2 = System.out::println;
        Worker worker = new Worker(listener, listener2);
        worker.start();
    }
}
