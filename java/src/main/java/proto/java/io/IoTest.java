package proto.java.io;

import proto.java.PersonOuterClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IoTest
 * <p>
 * IoTest class.
 * <p>
 * ESTE COMPONENTE FUE CONSTRUIDO SIGUIENDO LOS ESTANDARES DE DESARROLLO Y EL PROCEDIMIENTO
 * DE DESARROLLO DE APLICACIONES DE NOVOPAYMENT Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * PROPIEDAD INTELECTUAL Y DERECHOS DE AUTOR.
 *
 * @author Novopayment Inc.
 * @author cbacilio@novopayment.com
 * @since 5/06/2024
 */
public class IoTest {

    private static void write(PersonOuterClass.Person person, String path) {

        try (FileOutputStream fos = new FileOutputStream(path)) {
            person.writeTo(fos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void read(String path) {

        try (FileInputStream fis = new FileInputStream(path)) {
            PersonOuterClass.Person person = PersonOuterClass.Person.parseFrom(fis);
            System.out.println(person);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
                .setName("Christian desde el texto")
                .build();
        final String path = "chrisatian.bin";
        write(person, path);
        read(path);
    }
}