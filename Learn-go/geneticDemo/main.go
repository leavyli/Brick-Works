package main

import "fmt"

type Slice[T int | float32 | float64] []T

func main() {
	//var a Slice[int] = []int{1, 2, 3}
	var a Slice[float32] = []int{1, 2, 3}
	fmt.Printf("Type Name:%T", a)

}
