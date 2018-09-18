;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Classwork (9-28-2017)|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
(define (sortaSum a b)
  (if
   (and (>= 19 (+ a b)) (<= 10 (+ a b)))
   20
   (+ a b)
  )
)

(define (inOrderEqual a b c equalOK)
  (if
   equalOK
   (and (>= c b) (>= b a))
   (and (> c b) (> b a))
  )
)