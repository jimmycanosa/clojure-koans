(ns reimplement-iterate.core)

(= (take 5 (solution5 #(* 2 %) 1))
   [1 2 4 8 16])

(= (take 100 (solution5 inc 0))
   (take 100 (range)))

(= (take 9 (solution5 #(inc (mod % 3)) 1))
   (take 9 (cycle [1 2 3])))

(def solution1
  (fn fake-iteration [f n]
    (cons n (lazy-seq (fake-iteration f (f n))))))

(def solution2
  (fn it [f x] (lazy-cat [x] (it f (f x)))))

(def solution3
  #(reductions (fn [x _] (% x)) %2 (range)))

(def solution4
  (fn i [f x] (lazy-seq (cons x (i f (f x))))))

(def solution5
  (fn f [func fe] (lazy-seq (cons fe (f func (func fe))))))