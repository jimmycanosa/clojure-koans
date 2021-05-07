(ns reimplement-map.main)

(= [3 4 5 6 7]
   (f3 inc [2 3 4 5 6]))

(= (repeat 10 nil)
   (f3 (fn [_] nil) (range 10)))

(= [1000000 1000001]
   (->> (f3 inc (range))
        (drop (dec 1000000))
        (take 2)))

(def f1
  (fn m [f coll]
    (when (seq coll)
      (lazy-seq (cons (f (first coll)) (m f (rest coll)))))))

(def f2
  (fn l [f [a & m]]
    (lazy-seq (cons (f a) (if m (l f m))))))

(def f3
  (fn mymap [f coll]
    (if (empty? coll)
      '()
      (lazy-cat (list (f (first coll))) (mymap f (rest coll))))))

(def f4 
  (fn m [f [h & t]]
    (lazy-seq
     (when h
       (cons (f h) (m f t))))))
