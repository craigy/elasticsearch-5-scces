(set-env!
  :source-paths #{"src"}
  :dependencies
  '[[org.clojure/clojure "1.9.0-alpha7"]])

(require 'example.spec
         '[example.core :as core])

(deftask run []
  (with-pass-thru _
    (core/configure ["-server" "foo" "-verbose" true "-user" "joe"])))

