;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Classwork (9-20-2017)|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;Check for pythagorean triples assuming so that c is the longest side
(define (sq a) (* a a))
(define (pythCheck a b c) (=(+ (sq a) (sq b)) (sq c)))

;Check for pythagorean triples without assuming c is the longest side
(define (ohGeez a b c)
  (or
   (pythCheck a b c)
   (pythCheck b a c)
   (pythCheck c b a)
  )
)

;(negative numbers -> pos) (zero -> -1) (pos num-> 2*num)
(define (gee x)
  (if
   (= x 0)
   (- 0 1)
   (if
    (> 0 x)
    (* x -1)
    (if
     (< 0 x)
     (* x 2)
     "boop"
    )
   )
  )
)

;Teaching the computer about the horrors of modern society
(define (calcGrade n)
  (if
   (> n 100)
   "nerd"
   (if
    (> n 90)
    "pass"
    (if
     (> n 70)
     "fail"
     (if
      (< n 0)
      "change planets, also how?"
      (if 
       (<= n 70)
       "disown"
       "Learn to write code"
      )
     )
    )
   )
  )
)