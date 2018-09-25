;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Homework 7|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;Checks to see if a number is between two other numbers
(define (isBetween a b n)
  (if
   (or
    (= a b)
    (= b n)
    (= a n)
   )
   #f
   (if
    (< a b)
    (< b n)
    (if
     (> a b)
     (> b n)
     #f
    )
   )
  )
)

;I don't know what to call what we're doing here
(define (xor a b)
  (and
   (not
    (and a b)
   )
   (or a b)
  )
)

;Wake-up alarm. Also, can "isVacation" be changed to "isBreak" less to type
(define (alarmTime day isVacation)
  (if
   (not isVacation)
   (if
    (or (= day 0) (= day 6))
    10
    7
   )
   (if
    (or (= day 0) (= day 6))
    12
    10
   )
  )
)

;When teachers procrastinate
(define (gradeFix n)
  (if
   (>= n 90)
   n
   (if
    (> n 86)
    88
    (if
     (> n 82)
     85
     50
    )
   )
  )
)