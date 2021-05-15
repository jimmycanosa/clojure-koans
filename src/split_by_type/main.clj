(ns split-by-type.main)

(declare f1)

(= (set (f2 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set (f2 [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set (f2 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})

(def f1 #(vals (group-by class %)))

(def f2 #(vals (group-by type %)))