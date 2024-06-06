package main

import pb "github.com/dbacilio88/protoc-buffer/golang/proto"
import "fmt"

func doPerson() *pb.Person{
    return &pb.Person{
        Name: "David",
        Age: 20,
    }
}

func doComplex() *pb.Complex{
    return &pb.Complex{
        Name: &pb.Dummy{Id:1,Name:"David"},
        List: []*pb.Dummy{
            {Id:1,Name:"Jose"},
            {Id:1,Name:"Adriano"},
            {Id:1,Name:"Ruben"},
            {Id:1,Name:"Silvia"},
            {Id:1,Name:"Erick"},
            {Id:1,Name:"Dario"},
        },
    }
}


func doEnumerations() *pb.Enumerations{
    return &pb.Enumerations{
        Color:pb.Colors_COLORS_RED,
    }
}


func main(){
    fmt.Println("Hola")
    fmt.Println(doPerson())
    fmt.Println(doComplex())
    fmt.Println(doEnumerations())
}
