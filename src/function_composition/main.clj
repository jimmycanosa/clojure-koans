(ns function-composition.main)

(declare f1)

(= [3 2 1] ((f6 rest reverse) [1 2 3 4]))

(= 5 ((f6 (partial + 3) second) [1 2 3 4]))

(= true ((f6 zero? #(mod % 8) +) 3 5 7 9))

(= "HELLO" ((f6 #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

(defn f1
  ([f g] (fn ([& args] (f (apply g args)))))
  ([f g & fs] (reduce f1 (list* f g fs))))

(def f2
  (fn fx
    ([f g] (fn ([& args] (f (apply g args)))))
    ([f g & fs] (reduce fx (list* f g fs)))))

(def f3
  (fn cmp [f & gs]
    (if gs
      #(f (apply (apply cmp gs) (conj %& %)))
      f)))

(def f4
  (fn c [a & r] (if r #(a (apply (apply c r) %&)) a)))

(def f5
  (fn [& fs]
    (fn [& args]
      (first (reduce #(list (apply %2 %1)) args (reverse fs))))))

(def f6
  (fn
    ([f g] #(f (apply g %&)))
    ([f g h] #(f (g (apply h %&))))))