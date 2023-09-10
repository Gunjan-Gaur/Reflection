package exercises;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorExample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        printConstructor(Person.class);
        printConstructor(Address.class);
        Person person = (Person) createInstanceOfConstructor(Person.class);
        Person person2 = (Person) createInstanceOfConstructor(Person.class,45,"Riya");
        //Person person3 = (Person) createInstanceOfConstructor(Person.class,45,"Riya","Delhi");
        System.out.println(person);
        System.out.println(person2);
        //System.out.println(person3);

        Address address =(Address) createInstanceOfConstructor(Address.class,"Hudson Lane",987);
        Person person3 = (Person) createInstanceOfConstructor(Person.class,45,"Riya",address);
        System.out.println(person3);
    }

    public static <T> Object createInstanceOfConstructor(Class<T> clazz, Object ...args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> con: clazz.getDeclaredConstructors()) {
            if(args.length == con.getParameterTypes().length){
                return (T)con.newInstance(args);
            }
        }
        System.out.println("Constructor not found");
        return null;
    }

    public static void printConstructor(Class<?> classes) throws NoSuchMethodException {
        Constructor<?>[] con = classes.getDeclaredConstructors();
        System.out.println(String.format("class %s has %s desclared constructors", classes.getSimpleName(), con.length));

        for (Constructor<?> constructor: con) {
            Class<?>[] parameterizedType = constructor.getParameterTypes();
            List<String> parameterLists = Arrays.stream(parameterizedType).map(type -> type.getSimpleName()).collect(Collectors.toList());
            System.out.println(parameterLists);
        }
        System.out.println();
        System.out.println();
    }
    public static class Person{
        private int age;
        private String name;
        private Address address;

        public Person(int age) {
            this.age = age;
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Person() {
            this.name = "Gunjan";
            this.age = 5;
            this.address = null ;
        }

        public Person(int age, String name, Address address) {
            this.age = age;
            this.name = name;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public static class Address{
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}
