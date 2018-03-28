(ns fractalfx.view
  (:gen-class
    :name fractalfx.view.controller
    :prefix view-
    :methods [[loadFxml [] javafx.scene.Parent]])
  (:import (javafx.scene.Parent))
  (:use [fractalfx.jfx]))

(defn lookup-fxid [root fxid]
  (.lookup root fxid))

(defn view-loadFXML [this]
  "Load the FXML and create a view for display in a parent"
  (let [root (fx-load-fxml "fractalfxWindow.fxml")
        clear-button (lookup-fxid root "#clearButton")
        echo-text (lookup-fxid root "#echoTextField")
        edit-text (lookup-fxid root "#textField")]
    (fx-action clear-button
               (do
                 (.setText echo-text "")
                 (.setText edit-text "")))
    (fx-add-text-listener (.textProperty edit-text)
                          (.setText echo-text
                                    (.getText edit-text)))
    root))