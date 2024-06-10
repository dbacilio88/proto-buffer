package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"

	"google.golang.org/protobuf/encoding/protojson"
	"google.golang.org/protobuf/proto"
)

func toJson(pb proto.Message) string {
	out, err := protojson.Marshal(pb)
	if err != nil {
		log.Fatalln("No se puede convertir a JSON", err)
		return ""
	}

	return string(out)
}

func fromJson(in string, pb proto.Message) {

	if err := protojson.Unmarshal([]byte(in), pb); err != nil {
		log.Fatalln("No se puede Unmarshal from json", err)
		return
	}
}

func writeToFile(fname string, pb proto.Message) {
	out, err := proto.Marshal(pb)

	if err != nil {
		log.Fatalln("No se puede serializar to bytes", err)
		return
	}

	if err = os.WriteFile(fname, out, 0644); err != nil {
		log.Fatalln("No se puede escribir el archivo", err)
		return
	}

	fmt.Println("La data se escribio correctamente!")
}

func readFromFile(fname string, pb proto.Message) {

	in, err := ioutil.ReadFile(fname)
	if err != nil {
		log.Fatalln("No se puede leer el archivo", err)
		return
	}

	if err = proto.Unmarshal(in, pb); err != nil {
		log.Fatalln("No se puede Unmarshal", err)
		return
	}

	fmt.Println(pb)
}
