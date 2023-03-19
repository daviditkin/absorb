(ns absorb.core
  (:require
   [reagent.core :as reagent]
   [reagent.dom :as dom]
   ))


(defn game-board []
  (let [board (reagent/atom (vec (repeat 10 (vec (repeat 10 nil)))))
        selected-square (reagent/atom nil)
        move-piece! (fn [from-row from-col to-row to-col]
                      (let [from-val (get-in @board [from-row from-col])
                            to-val (get-in @board [to-row to-col])]
                        (when (and from-val (not to-val))
                          (swap! board #(assoc-in % [to-row to-col] from-val))
                          (swap! board #(assoc-in % [from-row from-col] nil))
                          (reset! selected-square nil))))]
    (fn []
      [:div
       [:h1 "My Game"]
       [:table
        (for [row (range 10)]
          [:tbody {:key row}
           [:tr {:key row}
            (for [col (range 10)]
              (let [square (get-in @board [row col])
                    selected? (= [@selected-square] [row col])
                    click-handler #(reset! selected-square [row col])]
                [:td {:key [row col] :class (str "square " (when selected? "selected"))
                      :onClick click-handler}
                 (when square
                   [:div {:class "game-piece"} square])]))]])]])))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars

(defonce app-state
  (reagent/atom {:count 0}))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn green-button [txt]
  (let []
    (fn [txt]
      [:button.green txt])))

(defn page [ratom]
  [:div
   [green-button "Green Button"]
   [:div "Hello, World!"]])



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (dom/render [page app-state]
                  (.getElementById js/document "app")))

(defn init! []
  (dom/render [game-board] (.getElementById js/document "app")))


(defn ^:export main []
  (dev-setup)
  (init!))

