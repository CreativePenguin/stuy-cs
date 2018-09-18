;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Homework 5|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;Finding the sum of two squares
(define (sumOfSquares a b)
  (+
   (*
    a
    a
   )
   (*
    b
    b
   )
  )
)
(sumOfSquares 3 4)
(sumOfSquares 1 2)
(sumOfSquares 1 3)

;Finding how many parameters each function can take
;Absolute Value
(abs -1)
(abs -33)
(abs 125)
;(abs -1 33) This one creates an error
;Conclusion, it can only take one parameter
;Maximum
(max 19 39 43 1 9001)
(max 3)
(max 2354 4856 21 54)
(max 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 1)
(max -1 1 1 1 1 11 1 1 11 1 1 1 1 1 1 1 1 1 1 1 1 11 11 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 11 1 1 1 1 1 1 1 )
;Rounding
(round 10.3)
(round 1)
(round -1.312847128)
(round 12)
(round 5.21856)
(round 1.5);When it is x.5, then scheme will round to the nearest even number so that there is no skew