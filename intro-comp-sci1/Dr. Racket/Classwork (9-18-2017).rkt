;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Classwork (9-18-2017)|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;Midpoint Function (1 diemnsional figure)
(define (midpoint A B) (/(+ A B)2))
(midpoint 1 3)
(midpoint -1 1)
(midpoint 1.5 2.5)

;Challenge Problem (my max function)
(define (myMax A B)
  (+ 
   (/
    (abs (- A B))
    2
   )
   (midpoint A B)
  )
)
;What you're doing is first finding the midpoint, then finding the difference between the two values. Then add 1/2 the distance to the midpoint.

;Finding if a number is positive
(define (isPositive x) (> x 0)
