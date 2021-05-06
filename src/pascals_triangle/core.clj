(ns pascals-traingle.core)

(= (solution1 1) [1])

(= (map solution1 (range 1 6))
   [[1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]])

(= (solution1 11)
   [1 10 45 120 210 252 210 120 45 10 1])

(def solution1
  (fn [n] (last
           (take n (iterate
                    (fn [coll]
                      (as-> coll c
                        (conj c 0)
                        (partition 2 1 c)
                        (map #(+ (first %) (second %)) c)
                        (into [1] c)))
                    [1])))))

(def solution2
  (fn [n]
    (last
     (take n (iterate
              (fn next-row [v] (vec (map + (apply conj [0] v) (conj v 0))))
              [1])))))

(def solution3
  (fn p [x]
    (if (= x 1)
      [1]
      `[1 ~@(map + (p (- x 1)) (next (p (- x 1)))) 1])))

(def solution4
  (fn [n]
    (loop [n n res [1]]
      (if (= n 1) res
          (recur (dec n) (map + (concat [0] res) (concat res [0])))))))

(def solution5
  (fn [i]
    (reduce
     #(conj %1 (* (last %1) (/ (- i %2) %2)))
     [1] (range 1 i))))