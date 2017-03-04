import java.util.List;

/**
 * Created by Banty on 3/4/2017.
 */
public class ReduceOperations {

    public int addUsingReduce(List<Integer>numbers){
        return numbers.stream()
                .reduce(0,(total,num) -> total + num);
    }

    public int getEvenNumberSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0,(sum,num) -> sum +num);
    }

    public int getMaximum(List<Integer> numbers){
        return numbers.stream()
                .reduce(0,(max,num) -> Integer.max(num,max));
    }


}
