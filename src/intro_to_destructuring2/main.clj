(ns intro-to-destructuring2.main)

(= 3
   (let [[f c] [+ (range 3)]] (apply f c))
   (let [[[f c] b] [[+ 1] 2]] (f c b))
   (let [[f c] [inc 2]] (f c)))

