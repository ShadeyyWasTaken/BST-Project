package helpers;

import java.util.ArrayList;

/**
 * The Sorts class, which provides sorts the data from the array before creating the balancing tree
 *
 */

public class Sorts<E extends Comparable<E>> {


    /**
     *
     *
     * The Bubble Sort Algorithm that is used to sort the data
     *
     * @param dataToSort the data that is being sorted
     */

    public void BSort3(ArrayList<E> dataToSort){
        for(int outer = 0; outer < dataToSort.size() - 1; outer++){
            for(int inner = 0; inner < dataToSort.size() - 1; inner++){
                if(dataToSort.get(inner).compareTo(dataToSort.get(inner+1))>0){
                    E temp = dataToSort.get(inner);
                    dataToSort.set(inner,dataToSort.get(inner + 1) );
                    dataToSort.set(inner+1,temp );
                }
            }
        }
    }
}

