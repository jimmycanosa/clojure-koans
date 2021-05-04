(ns group-sequence.core
  (:use clojure.repl))

(comment (= (solution1 #(> % 5) [1 3 6 8])
            {false [1 3], true [6 8]}))

(comment (= (solution1 #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
            {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))

(comment (= (solution1 count [[1] [1 2] [3] [1 2 3] [2 3]])
            {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}))

(comment (def solution1
           (fn [f coll]
             (loop [coll (for [a coll] [(f a) a])
                    result {}]
               (let [c (first coll)
                     k (first c)
                     v (last c)]
                 (if (seq coll)
                   (recur (next coll)
                          (if (contains? result k)
                            (update-in result [k] conj v)
                            (assoc result k [v])))
                   result))))))

(comment (def solution2 (fn [f coll]
                          (into {}
                                (let [ks (set (map f coll))]
                                  (for [k ks]
                                    [k (vec (filter #(= k (f %)) coll))]))))))

(comment (def solution3 #(reduce
                          (fn [m x] (assoc m (% x) (conj (m (% x) []) x)))
                          {} %2)))