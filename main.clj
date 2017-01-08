(println
  (let [readSplit (fn [] (clojure.string/split (read-line) #" "))
        line1 (readLineSplit)
        line2 (readLineSplit)
        N (Integer/parseInt (first line1))
        K (Integer/parseInt (last line1))
        A (map #(Integer/parseInt %) line2)]
    (loop [a A
           n N
           result 0]
      (if (= 0 n)
        result
        (let [head (first a)
              maxK (+ head K)
              minK (- head K)
              tail (rest a)]
          (recur
            tail
            (dec n)
            (reduce
              (fn [result i]
                (cond
                  (= i maxK) (+ result 1)
                  (= i minK) (+ result 1)
                  :else result))
              result
              tail)))))))

      
