;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Homework (9-18-2017)|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;Checking if a number is positive
(define (isPositive x) (> x 0))

;Checking if a number is even (code doesn't work for negative numbers)
(define (isEven x) (> 1 (remainder x 2)))

;Checking if a number is a teen (code doesn't work for larger numbers)
(define (isTeen x) (<= (- 19 x) 6))

;Checking if the sum of two numbers is a teen (code doesn't work for larger numbers)
(define (isTeenSum x y) (isTeen(+ x y)))