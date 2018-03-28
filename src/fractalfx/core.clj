(ns fractalfx.core
  (:gen-class :extends javafx.application.Application)
  (:import (javafx.application Application)
           (fractalfx.view controller))
  (:use [fractalfx.jfx]
        [fractalfx.view]
        [pyro.printer :as printer]))

(printer/swap-stacktrace-engine!)

(defn -main [& args]
  (Application/launch fractalfx.core args))

(defn -start [this stage]
  (fx-window stage (controller) "JavaFXML with Clojure"))