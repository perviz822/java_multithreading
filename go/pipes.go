package main

import (
	"fmt"
	"sync"
	"time"
)

func pipes_main() {
	var wg sync.WaitGroup
	pipe := make(chan string, 5)
	wg.Add(1)
	go func() {
		for i := 0; i < 15; i++ {
			time.Sleep(time.Millisecond * 500)
			pipe <- fmt.Sprintf("message  %d ", i)
			fmt.Printf("message %d sent"+"\n", i)
		}
		defer wg.Done()
		close(pipe)
	}()
	wg.Add(1)
	go func() {

		for {
			msg, ok := <-pipe
			time.Sleep(time.Millisecond * 500)
			fmt.Println(msg + " " + "received")
			if !ok {
				break
			}
		}
		defer wg.Done()

	}()

	wg.Wait()
}
