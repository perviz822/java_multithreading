package main

import "fmt"

func loops() {
	for i := 1; i < 10; i++ {
		fmt.Print(i)
	}

}

func printer() {
	fmt.Print("started counting")
	defer loops()
	fmt.Print("finished")
}
