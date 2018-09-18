;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Classwork (9-19-2017)|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;Making the MyMax function for 3 numbers
;Original MyMax function and midpoint function
(define (midpoint A B) (/(+ A B)2))
(define (myMax A B)
  (+ 
   (/
    (abs (- A B))
    2
   )
   (midpoint A B)
  )
)
;MyMax of 3
(define (myMaxOf3 a b c) (myMax a (myMax b c)))

;if x is a multiple of y
(define (isMultipleOf x y) (= 0 (remainder x y)))

;myMax with an "if" statement
(define (myMaxIf A B)
  (if (> (- A B)(- B A)) (-(+ A A)A) (-(+ B B)B))
)
