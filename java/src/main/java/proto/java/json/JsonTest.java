package proto.java.json;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import proto.java.DummyOuterClass;

/**
 * JsonTest
 * <p>
 * JsonTest class.
 * <p>
 * ESTE COMPONENTE FUE CONSTRUIDO SIGUIENDO LOS ESTANDARES DE DESARROLLO Y EL PROCEDIMIENTO
 * DE DESARROLLO DE APLICACIONES DE NOVOPAYMENT Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * PROPIEDAD INTELECTUAL Y DERECHOS DE AUTOR.
 *
 * @author Novopayment Inc.
 * @author cbacilio@novopayment.com
 * @since 5/06/2024
 */
public class JsonTest {
    private static String toJson(DummyOuterClass.Dummy dummy) throws InvalidProtocolBufferException {
        return JsonFormat.printer()
                //.includingDefaultValueFields()
                //.omittingInsignificantWhitespace()
                .print(dummy);
    }

    private static DummyOuterClass.Dummy fromJson(String json) throws InvalidProtocolBufferException {
        DummyOuterClass.Dummy.Builder dummy = DummyOuterClass.Dummy.newBuilder();
        JsonFormat.parser().merge(json, dummy);
        return dummy.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DummyOuterClass.Dummy dummy = DummyOuterClass.Dummy.newBuilder()
                .setId(1)
                .setName("Christian")
                .build();

        String json = toJson(dummy);
        System.out.println(json);
        System.out.println(fromJson(json));
    }
}