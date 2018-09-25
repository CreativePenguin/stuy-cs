;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Homework 8|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;Calculating if a year is leap year or not
(define (leapYear year)
  (if
   (= (remainder year 100) 0)
   (if
    (= (remainder year 400) 0)
    #t
    #f
   )
   (if
    (= (remainder year 4) 0)
    #t
    #f
   )
  )
)
;(leapYear 1400)
;(leapYear 2000)
;(leapYear 1984)
;(leapYear 2049)
;Calculating Leap Year Without Conditionals
(define (leapYearShort year)
  (or
   (and
    (= (remainder year 100) 0)
    (= (remainder year 400) 0)
   )
   (and
    (> (remainder year 100) 0)
    (= (remainder year 4)   0)
   )
  )
)
;(leapYearShort 1400)
;(leapYearShort 2000)
;(leapYearShort 1984)
;(leapYearShort 2049)

;Military Time
(define (24hrtime hr ampm)
  (cond
    ( (or (< 1 ampm) (> 0 ampm)) "Slow down, there's what now? Seriously, our system is dumb and unnecessarily complex, but, not that dumb")
    (          (> hr 12)         "You wish, but unfortunately, no, there are still only 24 hours in a day")
    (          (< hr 1)          "Please make the number higher than 0, this homework is hard enough already")
    ( (and (= hr 12) (= ampm 0)) 0 )
    ( (and (= hr 12) (= ampm 1)) 12)
    (          (= ampm 0)        hr)
    (          (= ampm 1)        (+ 12 hr) )
   )
)
;(24hrtime 0 1)
;(24hrtime 12 0)
;(24hrtime 12 1)
;(24hrtime 13 1)
;(24hrtime 1  92348109)
;(24hrtime 10 0)
;(24hrtime 11 1)
;Military Time Using Math
(define (24hrtimeShort hr ampm)
  (+
   (* ampm 12)
   (remainder hr 12)
  )
)
;(24hrtimeShort 12 1)
;(24hrtimeShort 12 0)
;(24hrtimeShort 11 1)
;(24hrtimeShort 10 0)