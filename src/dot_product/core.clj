(ns temp.temp
  (:use clojure.repl))

(= 0 (solution [0 1 0] [1 0 0]))

(= 3 (solution [1 1 1] [1 1 1]))

(= 32 (solution [1 2 3] [4 5 6]))

(= 256 (solution [2 5 6] [100 10 1]))

(def solution
  #(apply + (map * % %2)))