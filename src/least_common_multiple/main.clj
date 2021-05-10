(ns least-common-multiple.main)

(== (f1 2 3) 6)

(== (f1 5 3 7) 105)

(== (f1 1/3 2/5) 2)

(== (f1 3/4 1/6) 3/2)

(== (f1 7 5/7 2 3/5) 210)

(def f1
  (fn [& coll]
    (reduce (fn [a b] ;; this part is lcm as a whole
              (/ (* a b)
                 (loop [a a b b] ;; this loop part is gcd
                   (if (zero? b)
                     a
                     (recur b (mod a b)))))) ;; end of lcm
            coll)))

(comment
  (defn gcd [a b]
    (if (zero? b) a (recur b (mod a b)))) ;; implicit loop is the fn

  (defn lcm [a b]
    (/ (* a b) (gcd a b))))
