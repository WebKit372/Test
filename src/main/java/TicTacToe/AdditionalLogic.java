package TicTacToe;

public class AdditionalLogic {

    public static <P> boolean arrayCheck(P[] array, int size, Every<P> action){
        for(int i = 0; i < size; i++){
            if(!action.execute(array[i])){
                return false;
            }
        }
        return true;
    }
}
