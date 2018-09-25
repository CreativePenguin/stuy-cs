;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Homework 6|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;Absolute Value
(define (my-abs a)
  (if
   (<= a 0)
   (* -1 a)
   (+ a 0)
  )
)

;Finding the max of 2 numbers
(define (max2 a b)
  (if
   (> a b)
   (+ a 0)
   (+ b 0)
  )
)

;Finding the max of 3 numbers
(define (max3 a b c)
  (max2 a (max2 c b))
)

;Two-part Function
(define (two x)
  (if
   (<= x 3)
   (+ 12 0)
   (if
    (> x 3)
    (* x 4)
    (+ 9000 0)
   )
  )
)

;Three-part Function
(define (three w)
  (if 
   (< w 0) 
   (+ -1 0) 
   (if 
    (<= w 4)
    (+ 3.5 0)
    (if
     (>= 0 w)
     (+ 3.5 0)
     (+ 7 0)
    )
   )
  )
)