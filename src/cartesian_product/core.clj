(ns cartesian-product.core)

(comment (def this
           (fn [seta setb]
             (set (for [x seta
                        y setb]
                    [x y])))))

(comment (= (this #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
            #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
              ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
              ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))

(comment (= (this #{1 2 3} #{4 5})
            #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))

(comment (= 300 (count (this (into #{} (range 10))
                             (into #{} (range 30))))))