# install:

go install google.golang.org/protobuf/cmd/protoc-gen-go@latest
protoc -Iproto --go_opt=module=protoc.go/protoc-go --go_out=. proto/*.proto

go install google.golang.org/protobuf/cmd/protoc-gen-go@latest

protoc -Iproto --go_opt=module=protoc.go/protoc-go --go_out=. proto/*.proto

## https://appmaster.io/es/blog/gestion-de-dependencias-de-los-modulos-go

```gotemplate
package main

import pb "github.com/dbacilio88/protoc-buffer/golang"

func main(){
fmt.Println("Hola mundo")

}
```
