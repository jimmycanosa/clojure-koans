(ns rotate-sequence)

(= (f2 2 [1 2 3 4 5]) '(3 4 5 1 2))

(= (f2 -2 [1 2 3 4 5]) '(4 5 1 2 3))

(= (f2 6 [1 2 3 4 5]) '(2 3 4 5 1))

(= (f2 1 '(:a :b :c)) '(:b :c :a))

(= (f2 -4 '(:a :b :c)) '(:c :a :b))

(def f1
  #(concat (drop (mod % (count %2)) %2) (take (mod % (count %2)) %2)))

(def f2
  #(let [c (count %2)] (take c (drop (mod % c) (cycle %2)))))

(def f3
  #(let [n (mod %1 (count %2))]
     (concat (drop n %2) (take n %2))))
