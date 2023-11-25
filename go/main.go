package main

import (
	"fmt"
	"time"
)

func main() {
	loops()

	go f1()
	f2()

}

func f1() {
	for i := 0; i < 10; i++ {

		fmt.Println(i)
		time.Sleep(100 * time.Millisecond)

	}
}

func f2() {
	for i := 0; i < 10; i++ {

		fmt.Println(i)
		time.Sleep(100 * time.Millisecond)

	}
}
