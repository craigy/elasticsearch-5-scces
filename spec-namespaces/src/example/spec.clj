(ns example.spec
  (:require [clojure.spec :as s]
            [example.core :as core]))

(s/def ::core/config
  (s/* (s/cat :prop string?
              :val (s/alt :s string? :b boolean?))))

