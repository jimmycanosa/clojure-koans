(ns pascals-trapezoid.main)

(= (second (f4 [2 3 2])) [2 5 5 2])

(= (take 5 (f4 [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])

(= (take 2 (f4 [3 1 2])) [[3 1 2] [3 4 3 2]])

(= (take 100 (f4 [2 4 2])) (rest (take 101 (f4 [2 2]))))

(def f1
  (fn [coll]
    (let [c (map bigint coll)]
      (iterate (fn [coll] (for [c (partition-all 2 1 (cons 0 coll))] (apply + c))) c))))

(def f2
  (fn [coll] (iterate #(map + `(0 ~@%) `(~@% 0)) coll)))

(def f3
  (fn trapezoid [xs]
    (lazy-seq
     (cons xs (trapezoid (mapv +' (conj xs 0) (cons 0 xs)))))))

(def f4
  (fn [coll]
    (iterate (fn [x] (map (partial + 0N) (concat x [0]) (concat [0] x))) coll)))
