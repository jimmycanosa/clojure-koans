(ns reverse-interleave.main)

(declare f1)

(= (f4 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

(= (f4 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

(= (f4 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

(def f1
  (fn [coll n]
    (loop [acc []
           c (partition n coll)]
      (if (first c)
        (recur (conj acc (map first c))
               (map next c))
        acc))))

(def f2
  (fn [coll n] (map (fn [ndx] (take-nth n (drop ndx coll))) (range n))))

(def f3
  #(for [i (range %2)] (take-nth %2 (drop i %))))

(def f4
  (fn [col n]
    (->> (partition n col)
         (apply map #(apply list %&)))))

(def f5
  #(apply map list (partition %2 %)))
