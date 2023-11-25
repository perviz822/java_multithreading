package main

import (
	"fmt"
	"time"
)

func main_channels() {
	var c chan string = make(chan string)
	go ping(c)
	go pong(c)
	var input string
	fmt.Scanln(&input)

}

func ping(c chan string) {
	for {
		msg := <-c  //receives
		c <- "ping" //sends
		fmt.Println(msg + " ")
		time.Sleep(1000 * time.Millisecond)

	}
}

func pong(c chan string) {
	for {
		c <- "pong" //sends
		msg := <-c  //receives
		fmt.Println(msg)
		time.Sleep(1000 * time.Millisecond)
	}

}
