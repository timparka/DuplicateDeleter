package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    @Override
    public T[] removeDuplicates(int maxNumberOfDuplications) { //example array [1,2,2,3,3,3] maxNumberOfDupiclications = 2;
        T[] resultArray = Arrays.stream(array) //streaming it just goes thru each element in array [1,2,2,3,3,3]
                .filter(item -> Arrays.stream(array) // item = 1 filters all values except [1]
                        .filter(element -> element.equals(item)) // when item = 2 || 3 number is not added because not true
                        .count() < maxNumberOfDuplications) //count = 1 maxNumberOfDuplications = 2 statement is true
                .toArray(size -> Arrays.copyOf(array, size)); //adds to new copy of array
        return resultArray;
    }

    @Override
    public T[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        T[] resultArray = Arrays.stream(array)
                .filter(item -> Arrays.stream(array)
                        .filter(element -> element.equals(item))
                        .count() != exactNumberOfDuplications)
                .toArray(size -> Arrays.copyOf(array, size));
        return resultArray;
    }
}
