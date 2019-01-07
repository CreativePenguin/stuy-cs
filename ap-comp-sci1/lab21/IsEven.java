public class IsEven implements PredicateFunction {

    @Override
    public boolean evaluate(int input) {
        return input % 2 == 0;
    }

}
