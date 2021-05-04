(ns cartesian-product.core
  (:require [clojure.repl :refer :all]))

(comment (= (solution #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
            #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
              ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
              ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))

(comment (= (solution #{1 2 3} #{4 5})
            #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))

(comment (= 300 (count (solution (into #{} (range 10))
                             (into #{} (range 30))))))

(comment (def solution
           (fn [seta setb]
             (set (for [x seta
                        y setb]
                    [x y])))))