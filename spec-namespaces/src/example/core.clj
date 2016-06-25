(ns example.core
  (:require [clojure.spec :as s]))

(defn- set-config [prop val]
  (println "set" prop val))

(defn configure [input]
  (let [parsed (s/conform ::config input)]
    (if (= parsed ::s/invalid)
      (throw (ex-info "Invalid input" (s/explain-data ::config input)))
      (doseq [{prop :prop [_ val] :val} parsed]
        (set-config (subs prop 1) val)))))

