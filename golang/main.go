package main

import (
	"fmt"
	"reflect"

	pb "github.com/dbacilio88/protoc-buffer/golang/proto"
	"google.golang.org/protobuf/proto"
)

func doPerson() *pb.Person {
	return &pb.Person{
		Name: "David",
		Age:  20,
	}
}

func doComplex() *pb.Complex {
	return &pb.Complex{
		Name: &pb.Dummy{Id: 1, Name: "David"},
		List: []*pb.Dummy{
			{Id: 1, Name: "Jose"},
			{Id: 1, Name: "Adriano"},
			{Id: 1, Name: "Ruben"},
			{Id: 1, Name: "Silvia"},
			{Id: 1, Name: "Erick"},
			{Id: 1, Name: "Dario"},
		},
	}
}

func doEnumerations() *pb.Enumerations {
	return &pb.Enumerations{
		Color: pb.Colors_COLORS_RED,
	}
}

func doFile(p proto.Message) {
	path := "simple.bin"
	writeToFile(path, p)
	message := &pb.Complex{}
	readFromFile(path, message)
	fmt.Println(message)
}

func doToJson(p proto.Message) string {
	jsonString := toJson(p)
	fmt.Println(jsonString)
	return jsonString
}

func doFromJson(jsonString string, t reflect.Type) proto.Message {
	message := reflect.New(t).Interface().(proto.Message)
	fromJson(jsonString, message)
	return message
}

func main() {
	fmt.Println("Hola")
	fmt.Println(doPerson())
	fmt.Println(doComplex())
	fmt.Println(doEnumerations())
	doFile(doComplex())
	jsonString := doToJson(doPerson())
	message := doFromJson(jsonString, reflect.TypeOf(pb.Person{}))
	fmt.Println(message)
}
