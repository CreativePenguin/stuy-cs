;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Homework 3|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;A fahrenheit to celsius converter
(define (ctof f) (/(* 5 (- f 32)) 9))
(ctof 32)
(ctof 212)
(ctof 72)