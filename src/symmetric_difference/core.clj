(ns symmetric-difference.core
  (:use clojure.repl))

(comment (= (solution1 #{1 2 3 4 5 6} #{1 3 5 7})
            #{2 4 6 7}))

(comment (= (solution1 #{:a :b :c} #{})
            #{:a :b :c}))

(comment (= (solution1 #{} #{4 5 6})
            #{4 5 6}))

(comment (= (solution1 #{[1 2] [2 3]} #{[2 3] [3 4]})
            #{[1 2] [3 4]}))

(def solution1
  (fn [a b]
    (set (filter #(nil? (b (a %))) (into a b)))))

(def solution2
  (fn [a b] (into (set (remove b a)) (remove a b))))