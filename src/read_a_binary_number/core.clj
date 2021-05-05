(ns read-a-binary-number.core
  (:use clojure.repl))

(= 0     (solution2 "0"))

(= 7     (solution2 "111"))

(= 8     (solution2 "1000"))

(= 9     (solution2 "1001"))

(= 255   (solution2 "11111111"))

(= 1365  (solution2 "10101010101"))

(= 65535 (solution2 "1111111111111111"))

(def solution1
  (fn [n]
    (apply + (map * (reverse (map read-string (map str n))) (take (count n) (iterate #(* 2 %) 1))))))

(def solution2
  #(read-string (str "2r" %)))