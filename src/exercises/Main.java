package exercises;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //String Class Obj
        Class<String> stringClass = String.class;

        //Map Class
        Map<String, Integer> map = new HashMap<>();
        Class<? extends Map> mapClass = map.getClass();

        //Sub class
        Class<?> subClass = Class.forName("exercises.Main$sqaure");

        //print
        //printClassInfo(stringClass,mapClass,subClass);
        printClassInfo(Collection.class, boolean.class, int[] [].class, Color.class);
    }

    private static void printClassInfo(Class<?> ... classes){
        for (Class<?> cl: classes){
            System.out.println(String.format("class name : %s, class package name : %s",cl.getSimpleName(),cl.getPackage()));
            Class<?>[] c = cl.getInterfaces();
            for (Class<?> implementedInterfaces: c) {
                System.out.println(String.format("interface name : %s",implementedInterfaces.getSimpleName()));
            }
            System.out.println("Is array : "+cl.isArray());
            System.out.println("Is interface : "+cl.isInterface());
            System.out.println("Is primitive : "+cl.isPrimitive());
            System.out.println("Is enum : "+cl.isEnum());
            System.out.println("Is anonymous : "+cl.isAnonymousClass());
            System.out.println();
            System.out.println();
        }
    }

    private static class sqaure implements Drawable{

        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }
    private static interface Drawable{
        int getNumberOfCorners();
    }

    private enum Color{
        RED,
        GREEN,
        BLUE
    }
}
