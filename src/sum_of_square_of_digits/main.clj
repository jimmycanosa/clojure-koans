(ns sum-of-square-of-digits)

(= 8 (f2 (range 10)))

(= 19 (f2 (range 30)))

(= 50 (f2 (range 100)))

(= 50 (f2 (range 1000)))

(def f1
  (fn [coll]
    (count
     (filter
      #(< % ((fn f
               ([n] (if (< n 10) (* n n) (f (quot n 10) (* (mod n 10) (mod n 10)))))
               ([m n] (if (zero? m) n (recur (quot m 10) (+ n (* (mod m 10) (mod m 10)))))))
             %)) coll))))

(def f2
  #(reduce + (for [n % :when (< n (reduce + (for [c (str n)] (* (- (int c) 48) (- (int c) 48)))))] 1)))
