package proto.java;

import proto.java.enumeration.EnumerationOuterClass;
import proto.java.maps.Maps;
import proto.java.result.ResultOuterClass;

import java.util.Arrays;
import java.util.Map;

public class Main {


    private static DummyOuterClass.Dummy newDummy(int id, String name) {
        return DummyOuterClass.Dummy.newBuilder()
                .setId(id)
                .setName(name)
                .build();
    }

    private static Maps.IdWraper idWraper(int id) {
        return Maps.IdWraper.newBuilder()
                .setId(id)
                .build();
    }

    public static void main(String[] args) {

        EnumerationOuterClass.Enumeration enumeration = EnumerationOuterClass.Enumeration.newBuilder()
                .setColor(EnumerationOuterClass.Colors.COLORS_GREEN)
                .setColorValue(2)
                .build();
        System.out.println(enumeration);


        System.out.println("Hello world!");
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
                .setId(1)
                .setName("Christian")
                .setIsSimple(true)
                .addNumber(1)
                .addNumber(2)
                .addNumber(3)
                .addNumber(4)
                .addAllNumber(Arrays.asList(1, 2, 3, 4, 5))
                .build();
        System.out.println("hasName "+ person.getName());

        System.out.println(person);

        DummyOuterClass.Complex complex = DummyOuterClass.Complex.newBuilder()
                .setDummy(newDummy(1, "one Dummy"))
                .addAllDummies(
                        Arrays.asList(
                                newDummy(2, "two Dummy"),
                                newDummy(3, "third Dummy"),
                                newDummy(4, "fourth Dummy")))
                .build();

        System.out.println(complex);

        Maps.MapExample mapExample = Maps.MapExample.newBuilder()
                .putMap("test1", idWraper(1))
                .putMap("test2", idWraper(2))
                .putAllMap(Map.of("test3",idWraper(3)))
                .build();

        System.out.println(mapExample);

        ResultOuterClass.Result result = ResultOuterClass.Result.newBuilder()
                .setMessage("Test message")
                .build();
        System.out.println(result);
        System.out.println(result.hasMessage());
        ResultOuterClass.Result result2 = ResultOuterClass.Result.newBuilder(result)
                .setId(1)
                .build();
        System.out.println(result2);
        System.out.println(result2.hasMessage());
    }


}