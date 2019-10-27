build: main.o linkedlist.o
	gcc -g -o prog main.o linkedlist.o
main.o: main.c linkedlist.h
	gcc -g -c main.c
linkedlist.o: linkedlist.h linkedlist.c
	gcc -g -c linkedlist.c
run:
	./prog
clean:
	rm main.o linkedlist.o prog
