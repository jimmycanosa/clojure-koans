(ns count-occurrences.main)

(declare f1)

(= (f3 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})

(= (f3 [:b :a :b :a :b]) {:a 2, :b 3})

(= (f3 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})

(def f1
  (fn [coll]
    (let [gp (group-by identity coll)]
      (zipmap (keys gp) (map #(count (second %)) gp)))))

(def f2
  #(into {} (for [[k v] (group-by identity %)] [k (count v)])))

(def f3
  (fn [coll]
    (reduce #(assoc % %2 (+ 1 (% %2 0))) {} coll)))
