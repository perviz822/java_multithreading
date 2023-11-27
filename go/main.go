package main

import (
	"fmt"
	"time"
)

func main() {
	//go f1()
	//f2()
	// main_channels()
	pipes_main()
	//time.Sleep(time.Millisecond * 100)

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
