;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Classwork (9-27-2017)|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;Making the quadratic formula
;Making the discriminant
(define (disc a b c)
  (-
   (* b b)
   (* 4 a c)
  )
)
;Making the actual formula now
(define (quadSolve a b c sign)
  (if
   (= sign 0)
   "Please make sign either positive or negative"
   (if
    (> sign 0)
    (/
     (+
      (* -1 b)
      (sqrt (disc a b c))
     )
     (* 2 a)
    )
    (/
     (-
      (* -1 b)
      (sqrt(disc a b c))
     )
     (* 2 a)
    )
   )
  )
)

;Recursive Functions, will be used second semester
;All recursive cases must get closer to base cases
;What this does is add together a bunch of numbers. Use the step function to go through it
(define (sumall n)
  (if (<= n 1)
      1 ;this is when to stop, base example
      (+ n (sumall (- n 1)))))  ;n must get closer to stopping
      ;this gets closer to 1, so it will always terminate.