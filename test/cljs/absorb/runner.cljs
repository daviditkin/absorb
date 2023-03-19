(ns absorb.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [absorb.core-test]))

(doo-tests 'absorb.core-test)
