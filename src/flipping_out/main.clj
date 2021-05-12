(ns flipping-out.main)

(= 3 ((f2 nth) 2 [1 2 3 4 5]))

(= true ((f2 >) 7 8))

(= 4 ((f2 quot) 2 8))

(= [1 2 3] ((f2 take) [1 2 3 4 5] 3))

(defn f1 [f]
  #(f %2 %))

(def f2
  #(fn [a b] (% b a)))