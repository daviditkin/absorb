(ns absorb.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [absorb.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
