(ns find-distinct-items.main)

(declare f1)

(= (f3 [1 2 1 3 1 2 4]) [1 2 3 4])

(= (f3 [:a :a :b :b :c :c]) [:a :b :c])

(= (f3 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))

(= (f3 (range 50)) (range 50))

(defn f1 [coll]
  (loop [[f & c] coll
         res []]
    (if f
      (recur c (if (.contains res f) res (conj res f)))
      res)))

;; f2 (another solution) clever way of using reduce
reduce #(if ((set %) %2) % (conj % %2)) []

;; f3 (very similar to f2)
(def f3
  (fn [s]
    (reduce #(if ((set %1) %2) %1 (conj %1 %2)) [] s)))
