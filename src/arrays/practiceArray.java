package arrays;

import java.lang.reflect.Array;

public class practiceArray {
    public static void main(String[] args) {
        int[] oneDimensional = {1,2};
        double[][] twoDimensional = {{1.9,2.9},{3.9,4.9},{5.7,8.9,0.9}};
        //inspectArrayObject(oneDimensional);
        //inspectArrayObject(twoDimensional);
        inspectArrayValues(oneDimensional);
        System.out.println();
        inspectArrayValues(twoDimensional);
    }

    public static void inspectArrayValues(Object arrayObject){
        int arrayLength = Array.getLength(arrayObject);
        System.out.print("[");
        for(int i=0; i<arrayLength; i++){
            Object element = Array.get(arrayObject,i);

            if(element.getClass().isArray()){
                inspectArrayValues(element);
            }
            else{
                System.out.print(element);
            }

            if(i != arrayLength-1)
                System.out.print(" , ");
        }
        System.out.print("]");
    }

    public static void inspectArrayObject(Object arrayObject) {
        Class<?> clazz = arrayObject.getClass();
        System.out.println(String.format("Is array : %s",clazz.isArray()));

        Class<?> arrayComponentType = clazz.getComponentType();
        System.out.println(String.format("This is an array of type: %s",arrayComponentType.getTypeName()));
    }
}
