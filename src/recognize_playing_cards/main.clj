(ns recognize-playing-cards.main)

(= {:suit :diamond :rank 10} (f3 "DQ"))

(= {:suit :heart :rank 3} (f3 "H5"))

(= {:suit :club :rank 12} (f3 "CA"))

(= (range 13) (map (comp :rank f3 str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA]))

(def f1
  (let [suit (zipmap ["S" "H" "D" "C"] [:spade :heart :diamond :club])
        rank (conj (into [] (range 2 10)) "T" "J" "Q" "K" "A")]
    (into {} (for [s (keys suit) r (range 13)] {(str s (rank r)) {:suit (suit s) :rank r}}))))

(def f2 #(zipmap [:suit :rank]
                 (map (zipmap "SHDC23456789TJQKA"
                              `(:spade :heart :diamond :club ~@(range)))
                      %)))

(def f3
  (fn [c] {:suit ({\H :heart
                   \C :club
                   \S :spade
                   \D :diamond} (first c))
           :rank ((zipmap "23456789TJQKA" (range)) (second c))}))
