(ns infix-calculator)

(= 7  (f3 2 + 5))

(= 42 (f3 38 + 48 - 2 / 2))

(= 8  (f3 10 / 2 - 1 * 2))

(= 72 (f3 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))

(def f1
  (fn [& c]
    (loop [r (first c) c (next c)]
      (if (seq c) (recur ((first c) r (second c)) (next (next c))) r))))

(defn f2
  ([n] n)
  ([a o b & c] (apply f2 (o a b) c)))

(def f3
  (fn [a o b & c]
    (if c
      (apply f3 (o a b) c)
      (o a b))))