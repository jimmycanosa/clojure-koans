(ns partition-a-sequence.main)

(declare f1)

(= (f2 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))

(= (f2 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))

(= (f2 3 (range 8)) '((0 1 2) (3 4 5)))

(cons 1 (cons 2 (cons 3 nil)))

(drop 3 (range 9))

(def f1
  (fn f [n coll]
    (cons (take n coll) (if (>= (count coll) (* 2 n))
                          (f n (drop n coll))
                          nil))))

(def f2
  (fn part [n coll]
    (if (<= n (count coll))
      (cons (take n coll)
            (part n (drop n coll))))))
