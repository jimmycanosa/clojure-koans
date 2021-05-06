(ns indexing-sequences.core)

(= (solution3 [:a :b :c])
   [[:a 0] [:b 1] [:c 2]])

(= (solution3 [0 1 3])
   '((0 0) (1 1) (3 2)))

(= (solution3 [[:foo] {:bar :baz}])
   [[[:foo] 0] [{:bar :baz} 1]])

(def solution1
  (fn [coll] (map #(conj [] % %2) coll (range (count coll)))))

(def solution2
  #(map list % (range)))

(def solution3
  #(map vector % (range)))